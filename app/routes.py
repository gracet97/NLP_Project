import boto3
import json

import re

from app import app

from flask import jsonify
from flask import render_template
from flask import request

@app.route('/')
def index():
    return render_template("index.html")

@app.route("/sentiment", methods=["POST"])
def sentiment():
    text = request.form.get("inputSentiment", 0, type=str)

    if (text == ""):
    	#No text, or only symbols and/or numbers was entered
    	return(jsonify(result="You must enter text to be analysed for its personality. Do not leave the text area blank, or containing only symbols and/or numbers."))
    else:
    	comprehend = boto3.client(service_name='comprehend', region_name='us-west-2')
    	return jsonify(result=json.dumps(comprehend.detect_sentiment(Text=text, LanguageCode='en'), sort_keys=True, indent=4))

@app.route("/entity", methods=["POST"])
def entity():
    text = request.form.get("inputEntity", 0, type=str)
    if (text == ""):
    	#No text, or only symbols and/or numbers was entered
    	return(jsonify(result="You must enter text to be analysed for its personality. Do not leave the text area blank, or containing only symbols and/or numbers."))
    else:
    	comprehend = boto3.client(service_name='comprehend', region_name='us-west-2')
    	return jsonify(result=json.dumps(comprehend.detect_entities(Text=text, LanguageCode='en'), sort_keys=True, indent=4))

@app.route("/personality", methods=["POST"])
def personality():
    text = request.form.get("inputPersonality", 0, type=str)
    if ((text == "") or (bool(re.search('[a-zA-Z]', text)) == False)):
    	#No text, or only symbols and/or numbers was entered
    	return(jsonify(result="You must enter text to be analysed for its personality. Do not leave the text area blank, or containing only symbols and/or numbers."))
    else:
    	#ENTER
    	return(jsonify(result="Personality Type Analysis here."))