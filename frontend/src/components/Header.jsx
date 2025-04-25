import React from 'react';
import './Header.css';

export default function Header() {
    return (
        <header className="header">
            <nav>
                <a href="/">About us</a>
                <a href="/contact">Contactos</a>
                <a href="/terms">Termos e Condições</a>
                <a href="/events">Eventos</a>
            </nav>
        </header>
    );
}
