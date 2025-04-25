import React, { useEffect, useState } from "react";
import axios from "axios";

function Eventos() {
    const [eventos, setEventos] = useState([]);

    useEffect(() => {
        axios
            .get("http://localhost:8080/api/eventos")
            .then((response) => {
                setEventos(response.data);
            })
            .catch((error) => {
                console.error("Erro ao buscar eventos:", error);
            });
    }, []);

    return (
        <div style={{ padding: "20px" }}>
            <h2>📅 Lista de Eventos</h2>
            {eventos.length > 0 ? (
                <ul>
                    {eventos.map((evento) => (
                        <li key={evento.id}>
                            <strong>ID:</strong> {evento.id} |{" "}
                            <strong>Status:</strong> {evento.statusEvento}
                        </li>
                    ))}
                </ul>
            ) : (
                <p>Nenhum evento encontrado.</p>
            )}
        </div>
    );
}

export default Eventos;
