// src/pages/LandingPage.jsx
import React from 'react';
import Header from '../components/Header';
import Button from '../components/Button';
import './LandingPage.css';

export default function LandingPage() {
    return (
        <div className="container">
            <Header />
            <main className="landing">
                <img src="/logo.png" alt="Quinta Eventos" className="logo" />
                <div className="actions">
                    <Button onClick={() => {/* navegar para público */}}>Acesso público</Button>
                    <Button onClick={() => {/* navegar para login */}}>Acesso restrito</Button>
                </div>
            </main>
        </div>
    );
}
