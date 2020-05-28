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
def awsSentimentAnalysis(text, comprehend, languageCode, introText, summaryResult, editLetter, presentingFullAnalysis):
    #Return sentiment analysis of the text using the AWS method detect_sentiment()
    analysis = json.dumps(comprehend.detect_sentiment(Text=text, LanguageCode=languageCode), sort_keys=True, indent=4)

    #If the text expresses positive sentiment, this will be stated in a summary sentence before the full analysis
    if (bool(re.search('POSITIVE', analysis)) == True): 
        summaryResult =  summaryResult + "POSITIVE sentiment.\r\nThis is ideal, so the sentiment of this letter doesn't need changed.\r\n\r\n" + presentingFullAnalysis
    #If the text expresses neautral sentiment, this will be stated in a summary sentence before the full analysis
    if (bool(re.search('NEUTRAL', analysis)) == True):
        summaryResult = summaryResult + "NEUTRAL sentiment.\r\n" + editLetter + presentingFullAnalysis
    #If the text expresses negative sentiment, this will be stated in a summary sentence before the full analysis
    if (bool(re.search('NEGATIVE', analysis)) == True):
        summaryResult = summaryResult + "NEGATIVE sentiment.\r\n" + editLetter + presentingFullAnalysis
    #If the text expresses mixed sentiment, this will be stated in a summary sentence before the full analysis
    if (bool(re.search('MIXED', analysis)) == True):
        summaryResult = summaryResult + "MIXED sentiment.\r\n" + editLetter + presentingFullAnalysis

    fullResult = introText + summaryResult + analysis

    return fullResult

#Entity Analysis
def awsEntityAnalysis(text, comprehend, languageCode, introText):
    #Return sentiment analysis of the text using the AWS method detect_entities()
    analysis = json.dumps(comprehend.detect_entities(Text=text, LanguageCode=languageCode), sort_keys=True, indent=4)
    result = introText + analysis
    return result

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
    #Text to be displayed before every analysis
    introText = "The analysis of the text entered is as follows - \r\n\r\n"

    #Text to display sentiment analysis summary of results
    summaryResult = "The text entered expresses "
    editLetter = "The letter should be edited to express POSITIVE sentiment to increase the conversion rate of patients turning up to appointments.\r\n\r\n"
    presentingFullAnalysis = "Here is the full analysis -\r\n\r\n"

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
                return awsSentimentAnalysis(text, comprehend, languageCode, introText, summaryResult, editLetter, presentingFullAnalysis)
            #If entity analysis
            if (textArea == "inputEntity"):
                #Run method awsEntityAnalysis
                return awsEntityAnalysis(text, comprehend, languageCode, introText)

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

            results = ""
            #Change the array to string form 
            for i in arrayResults:
                results = results + str(i)

            #If the text contains over the average amount of openness, this will be stated in a summary sentence before the full analysis
            if (bool(re.search('Openness: True', results)) == True): 
                summaryResult = "The text contains over the average amount of openness.\r\nIt should be edited to contain less of this personality type.\r\n\r\n"
            #If the text contains over the average amount of conscientiousness, this will be stated in a summary sentence before the full analysis
            if (bool(re.search('Conscientiousness: True', results)) == True):
                summaryResult = "The text contains over the average amount of conscientiousness.\r\nIt should be edited to contain less of this personality type.\r\n\r\n"
            #If the text contains over the average amount of extraversion, this will be stated in a summary sentence before the full analysis
            if (bool(re.search('Extraversion: True', results)) == True):
                summaryResult = "The text contains over the average amount of extraversion.\r\nIt should be edited to contain less of this personality type.\r\n\r\n"
            #If the text contains over the average amount of agreeableness, this will be stated in a summary sentence before the full analysis
            if (bool(re.search('Agreeableness: True', results)) == True): 
                summaryResult = "The text contains over the average amount of agreeableness.\r\nIt should be edited to contain less of this personality type.\r\n\r\n"
            #If the text contains over the average amount of neuroticism, this will be stated in a summary sentence before the full analysis
            if (bool(re.search('Neuroticism: True', results)) == True): 
                summaryResult = "The text contains over the average amount of neuroticism.\r\nIt should be edited to contain less of this personality type.\r\n\r\n"

            #Return the results of each personality type for this text
            return introText + summaryResult + results 

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