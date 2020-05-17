import boto3
import json

from app import app

from flask import jsonify
from flask import render_template
from flask import request

@app.route('/')
def index():
    return render_template("index.html")

@app.route("/sentiment", methods=["POST"])
def sentiment():
    text = request.form.get("input", 0, type=str)
    comprehend = boto3.client(service_name='comprehend', region_name='us-west-2')
    return jsonify(result=json.dumps(comprehend.detect_sentiment(Text=text, LanguageCode='en'), sort_keys=True, indent=4))

@app.route("/entity", methods=["POST"])
def entity():
    text = request.form.get("input2", 0, type=str)
    comprehend = boto3.client(service_name='comprehend', region_name='us-west-2')
    return jsonify(result=json.dumps(comprehend.detect_entities(Text=text, LanguageCode='en'), sort_keys=True, indent=4))