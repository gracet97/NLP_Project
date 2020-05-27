# NLP_Project

-------------

This project aims to apply natural language processing and machine learning to a medical appointment letter, to highlight its sentiment, entities, and personality types. 
This enables a healthcare professional to edit it accordingly. This is expected to increase the amount of people who turn up to medical appointments after reading the letter. 

Regarding sentiment analysis, it is assumed that a letter expressing positive sentiment will allow for an increase in conversion rate. 

Regarding entity analysis, it is assumed that a letter with clear entities such as the patient's name, and the date and location of the appointment, will allow for an increase in conversion rate. 

Regarding personality type analysis, it is assumed that a letter expressing the average level of each personality type will allow for an increase in conversion rate.

-------------

User Manual -

Here are instructions on how to set-up the project on your own machine. They were written from using various Windows machines, so may need adjusted slightly for use on other OS. 

1) Install Python
• Download and execute the latest Python installation package from https://www.python.org. 
• Choose the recommended installation options.
• Check the box for Add Python to PATH. This will adjust your System Environment Variables automatically so that Python can be launched from any command prompt.  [27]
• Open command line and type python to check it installed correctly.

2) Install pip 
• Download get-pip.py [28] to a folder on your computer.
• Open command line and navigate to the folder containing get-pip.py.
• Run the following command – python get-pip.py

3) Download zip from GitHub - https://github.com/gracet97/NLP_Project
• Extract from zip folder

4) Open command line
• Navigate to the extracted folder – cd if using Windows

5) Run the following commands – 
• To activate the virtual machine – venv\Scripts\activate
• To install Flask – pip install flask
• To set up the Flask app – set FLASK_APP=NLP_Project.py 
• Use export instead of set if not using Windows
• To install a necessary library – pip install boto3
• To install a necessary library – pip install nltk
• To install a necessary library – pip install pandas
• To install a necessary library – pip install sklearn
• To run flask – python -m flask run

6) Navigate to local host - http://127.0.0.1:5000/ - to view the website.
 
