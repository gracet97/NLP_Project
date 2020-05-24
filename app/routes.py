import boto3 #Imported to use AWS methods
import json
import re
import nltk
import pandas as pd
from app import app
from flask import jsonify
from flask import render_template
from flask import request
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LogisticRegression
from datetime import date

#The route to the website main page - index.html
@app.route('/')
def index():
    #Return the index.html file
    return render_template("index.html")

#The route to complete sentiment analysis on text
@app.route("/sentiment", methods=["POST"])
def sentiment():
    #Save the text entered in the text area named inputSentiment to the variable named text
    text = request.form.get("inputSentiment", 0, type=str)
    
    #No text, or only tabs, spaces, symbols and/or numbers were entered
    if ((text == "") or (bool(re.search('[a-zA-Z]', text)) == False)):
        #Return an informative error message
        return(jsonify(result="You must enter text to be analysed for its sentiment. Do not leave the text area blank, or containing only symbols and/or numbers."))
    
    #Valid text was entered
    else:
        #Create a AWS Python boto client using the service comprehend in the region specified 
        comprehend = boto3.client(service_name='comprehend', region_name='us-west-2')
        #Return sentiment analysis of the text using the AWS method detect_sentiment()
        return jsonify(result=json.dumps(comprehend.detect_sentiment(Text=text, LanguageCode='en'), sort_keys=True, indent=4))

#The route to complete entity analysis on text
@app.route("/entity", methods=["POST"])
def entity():
    #Save the text entered in the text area named inputEntity to the variable named text
    text = request.form.get("inputEntity", 0, type=str)
    
    #No text, or only tabs, spaces, symbols and/or numbers were entered
    if ((text == "") or (bool(re.search('[a-zA-Z]', text)) == False)):
        #Return an informative error message
        return(jsonify(result="You must enter text to be analysed for its entities. Do not leave the text area blank, or containing only symbols and/or numbers."))
    
    #Valid text was entered
    else:
        #Create a AWS Python boto client using the service comprehend in the region specified
        comprehend = boto3.client(service_name='comprehend', region_name='us-west-2')
        #Return entity analysis of the text using the AWS method detect_entities()
        return jsonify(result=json.dumps(comprehend.detect_entities(Text=text, LanguageCode='en'), sort_keys=True, indent=4))


def pre_process(txt):
    nltk.download('stopwords'), nltk.download('porter_test')
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

def assess(models, vectorizer, message):
  if models.predict(vectorizer.transform([pre_process(message)])):
    return True
  else:
     return False

#The route to complete personality type analysis on text
@app.route("/personality", methods=["POST"])
def personality():
    #Save the text entered in the text area named inputPersonality to the variable named text
    text = request.form.get("inputPersonality", 0, type=str)

    #No text, or only tabs, spaces, symbols and/or numbers were entered
    if ((text == "") or (bool(re.search('[a-zA-Z]', text)) == False)):
        #Return an informative error message
        return(jsonify(result="You must enter text to be analysed for its personality. Do not leave the text area blank, or containing only symbols and/or numbers."))
    
    #Valid text was entered
    else:
        # CLASS ONE  
        df = pd.read_csv("C:/Users/Grace/Documents/GitHub/NLP_Project/app/models/personalitytrainingmodel/100essays.csv", sep=',', engine='python', header=0)
        
        # CLASS TWO 
        essays = df['Text']
        Extraversion = df['Extraversion']
        Neuroticism = df['Neuroticism']
        Agreeableness = df['Agreeableness']
        Conscientiousness = df['Conscientiousness']
        Openness = df['Openness']
        processed_essays = essays.apply(pre_process)
        vectorizer = TfidfVectorizer(ngram_range=(1,2))
        X_ngrams = vectorizer.fit_transform(processed_essays)
        big5 = [Extraversion, Neuroticism, Agreeableness, Conscientiousness, Openness]
        models = {}
        for item in big5:
            X_train, X_test, y_train, y_test = train_test_split(X_ngrams, item, test_size = 0.2, stratify = item)
            models[str(item.name)] = LogisticRegression()
            models[str(item.name)].fit(X_train, y_train)
    
        # CLASS THREE (CALL CLASS 3.1, CALL CLASS 3.2)
        toBeClassified = pd.DataFrame({'Date': date.today().strftime("%Y/%m/%d"), 'Text': text, 'Extraversion': [0], 'Neuroticism': [0], 'Agreeableness' : [0], 'Conscientiousness' : [0], 'Openness' : [0]})
        #CLASS 3.1
        arrayResults = for i in range(len(big5)):     arrayResults.append(assess(models[big5[i].name], vectorizer, text))
        # CLASS 3.2 - call toBeClassified as paramater
        y = 0 
        for item in big5:
            toBeClassified[item.name] = arrayResults[y]
            arrayResults[y] = "\n" + item.name + ": " + str(arrayResults[y]) 
            y+=1
                
        # CLASS FOUR 
        toBeClassified.to_csv('C:/Users/Grace/Documents/GitHub/NLP_Project/app/models/personalitytrainingmodel/100essays.csv', mode='a',  index=False, header=False)
    
        return(jsonify(result=arrayResults))  