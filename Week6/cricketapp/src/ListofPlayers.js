import React from "react";

function ListofPlayers() {
    const players = [
        { name: "Rohit", score: 85 },
        { name: "Dhawan", score: 45 },
        { name: "Kohli", score: 90 },
        { name: "Rahul", score: 60 },
        { name: "Pant", score: 75 },
        { name: "Hardik", score: 55 },
        { name: "Jadeja", score: 40 },
        { name: "Bumrah", score: 20 },
        { name: "Shami", score: 30 },
        { name: "Kuldeep", score: 25 },
        { name: "Chahal", score: 65 }
    ];

    const belowSeventy = players.filter((p) => p.score < 70);

    return (
        <div>
            <h2>All Players</h2>
            <ul>
                {players.map((p, i) => (
                    <li key={i}>{p.name} - {p.score}</li>
                ))}
            </ul>

            <h2>Players with score below 70</h2>
            <ul>
                {belowSeventy.map((p, i) => (
                    <li key={i}>{p.name} - {p.score}</li>
                ))}
            </ul>
        </div>
    );
}

export default ListofPlayers;
