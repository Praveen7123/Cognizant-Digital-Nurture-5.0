import React, { Component } from "react";

class CurrencyConvertor extends Component {
    constructor(props) {
        super(props);
        this.state = { rupees: 0, euro: 0 };
    }

    handleChange = (e) => {
        this.setState({ rupees: e.target.value });
    }

    handleSubmit = (e) => {
        e.preventDefault();
        const euro = this.state.rupees / 90;
        this.setState({ euro: euro });
    }

    render() {
        return (
            <div>
                <h2>Currency Convertor (INR to Euro)</h2>
                <form onSubmit={this.handleSubmit}>
                    <input type="number" onChange={this.handleChange} placeholder="Enter rupees" />
                    <button type="submit">Convert</button>
                </form>
                <p>Euro: {this.state.euro}</p>
            </div>
        );
    }
}

export default CurrencyConvertor;
