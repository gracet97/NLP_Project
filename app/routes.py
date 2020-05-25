#Imports
import boto3 #Imported to use AWS methods
import json
import re
import nltk 
nltk.download('stopwords'), nltk.download('porter_test')
import pandas as pd
from app import app
from flask import jsonify
from flask import render_template
from flask import request
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LogisticRegression
from datetime import date

#Sentiment Analysis
def awsSentimentAnalysis(text, comprehend, languageCode):
    #Return sentiment analysis of the text using the AWS method detect_sentiment()
    return json.dumps(comprehend.detect_sentiment(Text=text, LanguageCode=languageCode), sort_keys=True, indent=4)

#Entity Analysis
def awsEntityAnalysis(text, comprehend, languageCode):
    #Return sentiment analysis of the text using the AWS method detect_entities()
    return json.dumps(comprehend.detect_entities(Text=text, LanguageCode=languageCode), sort_keys=True, indent=4)

#Personality Type Analysis

#Read training data csv
def readTrainingData(trainingData):
    return pd.read_csv(trainingData, sep=',', engine='python', header=0, error_bad_lines=False)

#Pre-process text
def pre_process(txt):
    stop_words = nltk.corpus.stopwords.words('english')
    ps = nltk.PorterStemmer()
    z = re.sub("[^a-zA-Z]",  " ",  str(txt))
    z = re.sub(r'[^\w\d\s]', ' ', z)
    z = re.sub(r'\s+', ' ', z)
    z = re.sub(r'^\s+|\s+?$', '', z.lower())
    return ' '.join(ps.stem(term) 
        for term in z.split()
        if term not in set(stop_words)
    )

#
def prework(essays, big5, vectorizer):
    processed_essays = essays.apply(pre_process)
    X_ngrams = vectorizer.fit_transform(processed_essays)
    models = {}
    
    for item in big5:
        X_train, X_test, y_train, y_test = train_test_split(X_ngrams, item, test_size = 0.2, stratify = item)
        models[str(item.name)] = LogisticRegression()
        models[str(item.name)].fit(X_train, y_train)
    
    return models

#
def toBeClassified(text):
    return pd.DataFrame({'Date': date.today().strftime("%Y/%m/%d"), 'Text': text, 'Extraversion': [0], 'Neuroticism': [0], 'Agreeableness' : [0], 'Conscientiousness' : [0], 'Openness' : [0]})
    
#
def arrayResults(big5, models, vectorizer, text):
    for i in range(len(big5)):
        arrayResults.append(assess(models[big5[i].name], vectorizer, text))
    return arrayResults

#Assess the text entered
def assess(models, vectorizer, message):
  if models.predict(vectorizer.transform([pre_process(message)])):
    return True
  else:
     return False

#Write new text and analysis to csv
def writeToCsv(toBeClassified, fileName):
     toBeClassified.to_csv(fileName, mode='a',  index=False, header=False)

#Validation 
def validateText(textArea):
    #Training data path assigned to a variable
    trainingDataFileName = "C:/Users/Grace/Documents/GitHub/NLP_Project/app/models/personalitytrainingmodel/essays.csv"
    blankTextError = "You must enter text to be analysed. Do not leave the text area blank."
    invalidTextError = "You must enter text to be analysed. Do not only enter spaces, tabs, symbols and/or numbers."
    languageCode = 'en'

    #Save the text entered in the text area passed as a parameter to the variable named text
    text = request.form.get(textArea, 0, type=str)

    #No text was entered
    if (text == ""):
        #Return an informative error message
        return blankTextError
    
    #Only tabs, spaces, symbols and/or numbers were entered
    if (bool(re.search('[a-zA-Z]', text)) == False):
        #Return an informative error message
        return invalidTextError
    
    #Valid text was entered
    else:
        if (textArea == "inputSentiment") or (textArea == "inputEntity"):
        #Create a AWS Python boto client using the service comprehend in the region specified 
            comprehend = boto3.client(service_name='comprehend', region_name='us-west-2')
            if (textArea == "inputSentiment"):
                return awsSentimentAnalysis(text, comprehend, languageCode)
            if (textArea == "inputEntity"):
                return awsEntityAnalysis(text, comprehend, languageCode)

        if (textArea == "inputPersonality"):
            df = readTrainingData(trainingDataFileName)

            essays = df['Text']
            Openness = df['Openness']
            Conscientiousness = df['Conscientiousness']
            Extraversion = df['Extraversion']
            Agreeableness = df['Agreeableness']
            Neuroticism = df['Neuroticism']
            #big5 = [Extraversion, Neuroticism, Agreeableness, Conscientiousness, Openness]
            big5 = [Openness, Conscientiousness, Extraversion, Agreeableness, Neuroticism]
            vectorizer = TfidfVectorizer(ngram_range=(1,2))
    
            models = prework(essays, big5, vectorizer)
        
            #CLASS 
            toBeClassified = pd.DataFrame({'Date': date.today().strftime("%Y/%m/%d"), 'Text': text, 'Extraversion': [0], 'Neuroticism': [0], 'Agreeableness' : [0], 'Conscientiousness' : [0], 'Openness' : [0]})
            
            #CLASS
            arrayResults = []
            for i in range(len(big5)):
                arrayResults.append(assess(models[big5[i].name], vectorizer, text))
            
            #CLASS 3.2 
            y = 0 
            for item in big5:
                toBeClassified[item.name] = arrayResults[y]
                arrayResults[y] = "\n" + item.name + ": " + str(arrayResults[y]) 
                y+=1
                    
            writeToCsv(toBeClassified, trainingDataFileName)
        
            return arrayResults

#Routes

#The route to the website main page - index.html
@app.route('/')
def index():
    #Return the index.html file
    return render_template("index.html")

#Routes for each service 

#The route to complete sentiment analysis on text
@app.route("/sentiment", methods=["POST"])
def sentiment():
    return jsonify(result = validateText("inputSentiment"))

#The route to complete entity analysis on text
@app.route("/entity", methods=["POST"])
def entity():
    return jsonify(result = validateText("inputEntity"))

#The route to complete personality type analysis on text
@app.route("/personality", methods=["POST"])
def personality():
    return jsonify(result = validateText("inputPersonality"))