# fake-news-detection

A ML Project for Fake News Detection

In this project, we have used various natural language processing techniques and machine learning algorithms to classify fake news articles using sci-kit libraries from python.

# Getting Started

## Prerequisites

1. Android Studio
2. Python

## Python Modules

Install All Python modules using ```pip install module_name``` 

1. Flask
2. Sklearn
3. pandas
4. numpy
5. nltk

## App Part

1. Download and open Android Studio
2. Open the MAD Folder as the Project Folder
3. Connect your phone through USB (Allow USB Debugging) or use android emulator
4. Run the app and it will be installed on your phone
5. Enter News and hit the submit button to know if the result is fake or legitimate

## ML Part

The Dataset is taken from Kaggle
Dataset Link: https://www.kaggle.com/datasets/clmentbisaillon/fake-and-real-news-dataset

Note: The Dataset is also included in the ML Folder

1. Open and run the FakenewsDetection.ipynb using Juypter Notebook or Google Colab
2. model.pkl file is also included which is used in the backend part for prediction

## BackEnd Part

1. Backend is done using Flask and uses model.pkl file
2. The Backend is hosted on Heroku which is a free web hosting site
3. Current API Endpoint Link: https://fake-news-detection-aiml.herokuapp.com/predict
4. There is no need to run the server you can directly hit the API Endpoint using the App.
