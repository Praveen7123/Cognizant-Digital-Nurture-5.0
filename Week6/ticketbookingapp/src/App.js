import React, { useState } from "react";

function GuestPage() {
    return (
        <div>
            <h2>Guest Page</h2>
            <p>Welcome Guest! You can browse the flight details below.</p>
            <ul>
                <li>Flight AI101 - Chennai to Delhi</li>
                <li>Flight AI202 - Mumbai to Kolkata</li>
            </ul>
            <p>Please login to book tickets.</p>
        </div>
    );
}

function UserPage() {
    return (
        <div>
            <h2>User Page</h2>
            <p>Welcome User! You can now book your tickets.</p>
            <button>Book Ticket</button>
        </div>
    );
}

function App() {
    const [isLoggedIn, setIsLoggedIn] = useState(false);

    return (
        <div>
            <h1>Flight Ticket Booking</h1>

            {isLoggedIn ? (
                <div>
                    <button onClick={() => setIsLoggedIn(false)}>Logout</button>
                    <UserPage />
                </div>
            ) : (
                <div>
                    <button onClick={() => setIsLoggedIn(true)}>Login</button>
                    <GuestPage />
                </div>
            )}
        </div>
    );
}

export default App;
