from flask import Flask, jsonify, request

app = Flask(__name__)

@app.route("/api/login", methods=["POST"])
def login():
    data = request.json or {}
    # respuesta mock
    return jsonify({"token":"mock-jwt-token", "user": {"id":1,"name":"Test"}})

@app.route("/api/profile", methods=["GET"])
def profile():
    return jsonify({"id":1,"name":"Test User","email":"test@example.com"})

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000)

