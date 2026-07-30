import React from "react";

function App() {
    const offices = [
        { name: "DBS", rent: 50000, address: "Chennai" },
        { name: "WeWork", rent: 75000, address: "Bangalore" },
        { name: "Regus", rent: 60000, address: "Hyderabad" },
        { name: "Cowrks", rent: 45000, address: "Pune" }
    ];

    return (
        <div>
            <h1>Office Space Rental</h1>

            <img
                src="https://picsum.photos/300/150"
                alt="office space"
                width="300"
            />

            {offices.map((office, index) => (
                <div key={index} style={{ border: "1px solid gray", margin: "10px", padding: "10px", width: "300px" }}>
                    <h3>{office.name}</h3>
                    <p>Address: {office.address}</p>
                    <p style={{ color: office.rent < 60000 ? "red" : "green" }}>
                        Rent: {office.rent}
                    </p>
                </div>
            ))}
        </div>
    );
}

export default App;
