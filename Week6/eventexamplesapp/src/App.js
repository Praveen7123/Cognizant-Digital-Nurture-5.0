import React, { Component } from "react";
import CurrencyConvertor from "./CurrencyConvertor";

class App extends Component {
    constructor(props) {
        super(props);
        this.state = { counter: 0 };
    }

    increment = () => {
        this.setState({ counter: this.state.counter + 1 });
        this.sayHello();
    }

    decrement = () => {
        this.setState({ counter: this.state.counter - 1 });
    }

    sayHello = () => {
        console.log("Hello! Welcome to the event example app");
    }

    sayWelcome = (msg) => {
        alert(msg);
    }

    handlePress = (e) => {
        alert("I was clicked");
    }

    render() {
        return (
            <div>
                <h1>Event Examples</h1>
                <h2>Counter: {this.state.counter}</h2>
                <button onClick={this.increment}>Increment</button>
                <button onClick={this.decrement}>Decrement</button>
                <br /><br />
                <button onClick={() => this.sayWelcome("welcome")}>Say Welcome</button>
                <button onClick={this.handlePress}>Press Me</button>
                <hr />
                <CurrencyConvertor />
            </div>
        );
    }
}

export default App;
