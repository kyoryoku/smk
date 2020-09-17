import React, { Component } from 'react';
class LabMain extends Component {

    state = {
        employees: [],
        selectedEmployees: []
    }

    componentDidMount() {
        const employeesData = [
            { id: 1, name: 'ООО рога и копыта' },
            { id: 2, name: 'roy' },
            { id: 3, name: 'albert' }
        ]
        this.setState({
            employees: employeesData
        });
    }


    render() {
        return (
            <div className='lab-main'>

            </div>
        );
    }
}

export default LabMain;