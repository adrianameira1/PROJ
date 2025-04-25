import React, { useState } from "react";
import axios from "axios";

function Login() {
    const [username, setUsername] = useState("");
    const [senha, setSenha] = useState("");
    const [mensagem, setMensagem] = useState("");

    const handleLogin = async () => {
        try {
            const response = await axios.post("http://localhost:8080/api/login", {
                username,
                senha,
            });

            if (response.status === 200) {
                setMensagem("✅ Login efetuado com sucesso!");
                // Aqui podes redirecionar, por exemplo:
                // navigate("/dashboard");
            }
        } catch (error) {
            setMensagem("❌ Credenciais inválidas.");
        }
    };

    return (
        <div className="h-screen bg-[#e8e5d1] flex flex-col items-center justify-center px-4">
            <div className="bg-white shadow-lg rounded-xl p-10 w-full max-w-md">
                <h2 className="text-2xl font-bold text-center mb-6 text-[#335d4c]">
                    Acesso à Plataforma
                </h2>
                <input
                    type="text"
                    placeholder="Utilizador"
                    value={username}
                    onChange={(e) => setUsername(e.target.value)}
                    className="w-full p-3 border rounded-lg mb-4 focus:outline-none"
                />
                <input
                    type="password"
                    placeholder="Senha"
                    value={senha}
                    onChange={(e) => setSenha(e.target.value)}
                    className="w-full p-3 border rounded-lg mb-4 focus:outline-none"
                />
                <button
                    onClick={handleLogin}
                    className="bg-[#335d4c] text-white w-full p-3 rounded-lg hover:bg-[#264638] transition"
                >
                    Entrar
                </button>
                {mensagem && (
                    <p className="text-center mt-4 font-semibold text-red-600">{mensagem}</p>
                )}
            </div>
        </div>
    );
}

export default Login;
