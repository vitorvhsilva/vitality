from flask import Flask, request, jsonify
import joblib
import numpy as np

app = Flask(__name__)

model_classification = joblib.load("model_gym_classification.joblib")
model_frequency = joblib.load("model_gym_frequency.joblib")
model_duration = joblib.load("model_gym_duration.joblib")

def depara_treino(type_prediction: int) -> str:
  match type_prediction:
    case 0:
      return "Musculação"
    case 1:
      return "Treino de Alta Intensidade"
    case 2:
      return "Yoga"
    case 3:
      return "Cardio"
    case _:
      return "Tipo de treino não encontrado"

@app.route('/', methods=['POST'])
def predict():
  data = request.get_json()

  # Verificar se todos os campos necessários estão presentes
  required_fields = ['idade', 'genero', 'peso', 'altura', 'calorias']
  if not data or not all(field in data for field in required_fields):
    return jsonify({"error": "Missing required fields in request"}), 400
  
  # Extrair dados da requisição
  input_features = [
    data['idade'],
    data['genero'], 
    data['peso'],
    data['altura'],
    data['calorias']
  ]
  
  # Convertendo para numpy array para previsão
  input_features = np.array(input_features).reshape(1, -1)
  
  # Previsão do tipo de treino
  type_prediction = model_classification.predict(input_features)[0]
  
  # Previsão da frequência de treino
  frequency_prediction = model_frequency.predict(input_features)[0]

  # Previsão da duração de treino
  duration_prediction = model_duration.predict(input_features)[0]
  
  # Retorno da previsão
  response = {
    "tipo_treino": depara_treino(type_prediction),
    "frequencia_treino": int(frequency_prediction),
    "duracao_treino_horas": round(duration_prediction, 2),
  }
  
  return jsonify(response)
   
if __name__ == '__main__':
    app.run(debug=True)
