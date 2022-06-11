from flask import Flask, jsonify, request
import pickle

model = pickle.load(open('model.pkl','rb'))

app = Flask(__name__)

@app.route('/')
def hello():
    return 'Hello, World!'

@app.route('/predict', methods=['POST'])
def predict():
    text = request.form.get('text')
    
    prediction = model.predict([text])
    res = {'result': str(prediction[0])}
    return jsonify(res)

if __name__ == '__main__':
    app.run(debug=True)