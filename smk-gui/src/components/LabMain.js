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



        this.state = {
            date: new Date(),
            m: false,
            weatherData: weatherData,
            isLoadData: false,
            text: 'Загрузка данных'
        };

        this.openModal = this.openModal.bind(this);
        this.closeModal = this.closeModal.bind(this);
        this.saveModal = this.saveModal.bind(this);
        this.loadData = this.loadData.bind(this);
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

     saveModal(){
        this.setState({
            m: false
        });
        clearInterval(this.timerID);
    }

    async loadData(){
        let weatherData;
        try {
            this.setState({
                text: 'Данные загружаются...'
            });
            weatherData = await API.get('/weather');

        } catch (e){
            this.setState({
                text: 'Ошибка при получении данных с сервера. Проверьте подключение!'
            });
            return
        }

        weatherData = weatherData.data[0];
        this.setState({
            weatherData: weatherData,
            isLoadData: true
        })
    }

    render() {
        let content;
        if (this.state.isLoadData) {
            content =
                <Table striped bordered hover variant="dark">
                    <thead>
                    <tr>
                        <td>#</td>
                        <td>Дата</td>
                        <td>Время</td>
                        <td>Температура</td>
                        <td>Влажность</td>
                        <td>Давление</td>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>{this.state.weatherData.id}</td>
                        <td>{this.state.weatherData.date}</td>
                        <td>{this.state.weatherData.time}</td>
                        <td>{this.state.weatherData.temp}</td>
                        <td>{this.state.weatherData.hum}</td>
                        <td>{this.state.weatherData.pres}</td>
                    </tr>
                    </tbody>
                </Table>;
        } else {
            content = <p>{this.state.text}</p>;
        }

        return (
            <div className='lab-main'>
                {this.state.date.toLocaleTimeString()}

                <Button variant="primary" onClick={this.openModal}>
                    Launch demo modal
                </Button>

                <Button variant="primary" onClick={this.loadData}>
                    Загрузить данные
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

                {content}

            </div>
        );
    }
}

export default LabMain;