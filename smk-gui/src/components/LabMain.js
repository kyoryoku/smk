import React, { Component } from 'react';
import Button from "react-bootstrap/Button";
import Modal from "react-bootstrap/Modal";
import Table from "react-bootstrap/Table";
import API from "../utils/API";

class LabMain extends Component {

    constructor(props) {
        super(props);
        let weatherData = {
            id: null,
            date: null,
            time: null,
            temp: null,
            pres: null,
            hum: null
        }

        this.state = {date: new Date(), m: false, weatherData: weatherData};

        this.openModal = this.openModal.bind(this);
        this.closeModal = this.closeModal.bind(this);
        this.saveModal = this.saveModal.bind(this);
    }

    componentDidMount() {
        this.timerID = setInterval(
            () => this.tick(),
            1000
        );


    }

    componentWillUnmount() {
        clearInterval(this.timerID);
    }

    tick() {
        this.setState({
            date: new Date()
        });
    }

    openModal(){
        this.setState({
            m: true
        });
    }

    closeModal(){
        this.setState({
            m: false
        });
    }

    async saveModal(){
        this.setState({
            m: false
        });
        clearInterval(this.timerID);


        let weatherData = await API.get('/weather');
        weatherData = weatherData.data[0];

        this.setState({
            weatherData: weatherData
        })

    }


    render() {
        return (
            <div className='lab-main'>
                {this.state.date.toLocaleTimeString()}

                <Button variant="primary" onClick={this.openModal}>
                    Launch demo modal
                </Button>

                <Modal show={this.state.m} onHide={this.closeModal} centered size="lg">
                    <Modal.Header closeButton>
                        <Modal.Title>Modal heading</Modal.Title>
                    </Modal.Header>
                    <Modal.Body>Woohoo, you're reading this text in a modal!</Modal.Body>
                    <Modal.Footer>
                        <Button variant="secondary" onClick={this.closeModal}>
                            Close
                        </Button>
                        <Button variant="primary" onClick={this.saveModal}>
                            Save Changes
                        </Button>
                    </Modal.Footer>
                </Modal>

                <Table striped bordered hover variant="dark">
                    <thead>
                    <tr>
                        <td>q1</td>
                        <td>q2</td>
                        <td>q3</td>
                        <td>q4</td>
                        <td>q5</td>
                        <td>q6</td>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>{this.state.weatherData.id}</td>
                    </tr>
                    </tbody>
                </Table>


            </div>
        );
    }
}

export default LabMain;