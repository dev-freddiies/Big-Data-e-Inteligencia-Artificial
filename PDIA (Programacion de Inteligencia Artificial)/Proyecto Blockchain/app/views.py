import datetime
import json
import requests
from flask import render_template, redirect, request
from app import app

DIRECCION_NODO_CONECTADO = "http://127.0.0.1:8000"

posts = []


def obten_posts():
    obten_direccion_cadena = "{}/cadena".format(DIRECCION_NODO_CONECTADO)
    respuesta = requests.get(obten_direccion_cadena)
    if respuesta.status_code == 200:
        contenido = []
        cadena = json.loads(respuesta.content)
        for bloque in cadena["cadena"]:
            for tx in bloque["transacciones"]:
                tx["id"] = bloque["id"]
                tx["hash"] = bloque["hash_previo"]
                contenido.append(tx)
        global posts
        posts = sorted(contenido, key=lambda k: k['timestamp'],reverse=True)


@app.route('/')
def index():
    obten_posts()
    return render_template('index.html', title='Compartiendo contendio de forma descentralizada', posts=posts, node_address=DIRECCION_NODO_CONECTADO, readable_time=timestamp_a_cadena)


@app.route('/enviar', methods=['POST'])
def enviar_textarea():
    post_contenido =request.form ['content']
    autor = request.form ['autor']
    post_object = {
        'autor': autor,
        'contenido': post_contenido,
    }
    direccion_nueva_tx = "{}/nueva_transaccion".format(DIRECCION_NODO_CONECTADO)
   
    requests.post(direccion_nueva_tx, json=post_object,
        headers={'Content-type': 'application/json'})
    return redirect('/')


def timestamp_a_cadena(epoch_time):
    return datetime.datetime.fromtimestamp(epoch_time).strftime('%H:%M')
