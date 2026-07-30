import React from "react";

function IndianPlayers() {
    const T20players = ["Rohit", "Kohli", "Suryakumar"];
    const RanjiTrophy = ["Pujara", "Rahane", "Jadeja"];

    const allPlayers = [...T20players, ...RanjiTrophy];

    const [oddPlayer1, evenPlayer1, oddPlayer2] = allPlayers;

    return (
        <div>
            <h2>Indian Players</h2>

            <h3>Destructured Players</h3>
            <p>Odd Team Player 1: {oddPlayer1}</p>
            <p>Even Team Player 1: {evenPlayer1}</p>
            <p>Odd Team Player 2: {oddPlayer2}</p>

            <h3>Merged Players (T20 + Ranji Trophy)</h3>
            <ul>
                {allPlayers.map((name, i) => (
                    <li key={i}>{name}</li>
                ))}
            </ul>
        </div>
    );
}

export default IndianPlayers;
