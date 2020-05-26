#Imports
import boto3 #Imported to use AWS methods for sentiment and entity analysis
import json
import re #Imported to preprocess text for personality type analysis
import nltk #Imported to preprocess text for personality type analysis
nltk.download('stopwords'), nltk.download('porter_test') #Downloaded to preprocess text for personality type analysis
import pandas as pd
from app import app
from flask import jsonify
from flask import render_template
from flask import request
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LogisticRegression #Imported for personality type analysis
from datetime import date #Imported to insert date for personality type analysis

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
    #Stemming words & removing stopwords
    stop_words = nltk.corpus.stopwords.words('english')
    ps = nltk.PorterStemmer()
    #Normalization - Removing whitespaces, making all text lowercase etc.
    z = re.sub("[^a-zA-Z]",  " ",  str(txt))
    z = re.sub(r'[^\w\d\s]', ' ', z)
    z = re.sub(r'\s+', ' ', z)
    z = re.sub(r'^\s+|\s+?$', '', z.lower())
    return ' '.join(ps.stem(term) 
        for term in z.split()
        if term not in set(stop_words)
    )

#More pre-processing, & create text classifier models
def prework(essays, big5, vectorizer):
    #Generate bigrams to ensure the model understands word order
    processed_essays = essays.apply(pre_process)
    X_ngrams = vectorizer.fit_transform(processed_essays)

    #Create the text classifier models using binary logisitic regression
    models = {}
    
    for item in big5:
        X_train, X_test, y_train, y_test = train_test_split(X_ngrams, item, test_size = 0.2, stratify = item)
        models[str(item.name)] = LogisticRegression()
        models[str(item.name)].fit(X_train, y_train)
    #Return text classifier models
    return models
###########
#Not called
def toBeClassified(text):
    return pd.DataFrame({'Date': date.today().strftime("%Y/%m/%d"), 'Text': text, 'Extraversion': [0], 'Neuroticism': [0], 'Agreeableness' : [0], 'Conscientiousness' : [0], 'Openness' : [0]})
    
#Not called
def arrayResults(big5, models, vectorizer, text):
    for i in range(len(big5)):
        arrayResults.append(assess(models[big5[i].name], vectorizer, text))
    return arrayResults
###########

#Assess the text entered
def assess(models, vectorizer, message):
    if models.predict(vectorizer.transform([pre_process(message)])):
        #Return True, i.e. the personality type is present above the average weighting
        return True
    else:
        #Return False, i.e. the personality type is present above the average weighting
        return False

#Write new text and analysis to csv
def writeToCsv(toBeClassified, fileName):
     toBeClassified.to_csv(fileName, mode='a', index=False, header=False)

#Validation 
def validateText(textArea):
    #Training data path assigned to a variable
    trainingDataFileName = "C:/Users/Grace/Documents/GitHub/NLP_Project/app/models/personalitytrainingmodel/essays.csv"
    #Blank text error message assigned to a variable
    blankTextError = "You must enter text to be analysed. Do not leave the text area blank."
    #Invalid text error message assigned to a variable
    invalidTextError = "You must enter text to be analysed. Do not only enter spaces, tabs, symbols and/or numbers."
    #Language code english assigned to a variable for use in AWS methods
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
        #If sentiment or entity analysis
        if (textArea == "inputSentiment") or (textArea == "inputEntity"):
            #Create a AWS Python boto client using the service comprehend in the region specified 
            comprehend = boto3.client(service_name='comprehend', region_name='us-west-2')
            #If sentiment analysis
            if (textArea == "inputSentiment"):
                #Run method awsSentimentAnalysis
                return awsSentimentAnalysis(text, comprehend, languageCode)
            #If entity analysis
            if (textArea == "inputEntity"):
                #Run method awsEntityAnalysis
                return awsEntityAnalysis(text, comprehend, languageCode)

        #If personality type analysis
        if (textArea == "inputPersonality"):
            #Create a data frame of the training data
            df = readTrainingData(trainingDataFileName)

            #Create the following variables relating to columns in the data frame created above
            essays = df['Text']
            Openness = df['Openness']
            Conscientiousness = df['Conscientiousness']
            Extraversion = df['Extraversion']
            Agreeableness = df['Agreeableness']
            Neuroticism = df['Neuroticism']

            #Make a list of the personality type variables created above
            big5 = [Openness, Conscientiousness, Extraversion, Agreeableness, Neuroticism]

            #Create a vectorizer
            vectorizer = TfidfVectorizer(ngram_range=(1,2))
            #Create the models to classify the text
            models = prework(essays, big5, vectorizer)
        
            #Create a data frame of the text to be classified
            #It contains today's date, the text input by the user, and 0 for each personality type 
            toBeClassified = pd.DataFrame({'Date': date.today().strftime("%Y/%m/%d"), 'Text': text, 'Extraversion': [0], 'Neuroticism': [0], 'Agreeableness' : [0], 'Conscientiousness' : [0], 'Openness' : [0]})
            
            #Create an array of the results for the text input's personality type gradings
            arrayResults = []
            #For the 5 personality types
            for i in range(len(big5)):
                #Append them to the arrayResults
                #Using the models to assess the text for its grading for each personality type
                arrayResults.append(assess(models[big5[i].name], vectorizer, text))
             
            y = 0 
            #For the 5 personality types
            for item in big5:
                #Append the results to be output in a format containing
                #the personality type name followed by the result
                toBeClassified[item.name] = arrayResults[y]
                arrayResults[y] = "\n" + item.name + ": " + str(arrayResults[y]) 
                y+=1
                    
            #Write the classified text and its personality type gradings to the csv file
            writeToCsv(toBeClassified, trainingDataFileName)
        
            #Return the results of each personality type for this text
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
    #Return the result of the validateText method run for the text area input
    return jsonify(result = validateText("inputSentiment"))

#The route to complete entity analysis on text
@app.route("/entity", methods=["POST"])
def entity():
    #Return the result of the validateText method run for the text area input
    return jsonify(result = validateText("inputEntity"))

#The route to complete personality type analysis on text
@app.route("/personality", methods=["POST"])
def personality():
    #Return the result of the validateText method run for the text area input
    return jsonify(result = validateText("inputPersonality"))