import React from 'react';
import {Link} from "react-router-dom";
import {employeeService} from "../../services/employee.service";

class EmployeeDetails extends React.Component {

    constructor(props){
        super(props);
        this.state = {
            id: this.props.match.params.id ? this.props.match.params.id : 0,
            entryDate: "",
            name: "",
            salary: ""
        }

        this.getEmployee = this.getEmployee.bind(this);
    }

    async getEmployee(){
        const employee = await employeeService.getOne(this.state.id);
        this.setState({
            id: employee.id ,
            entryDate: employee.entryDate ,
            name: employee.name ,
            salary: employee.salary
        });
    }

    async componentDidMount() {
        await this.getEmployee();
    }

    render(){
        return (
            <div className="m-5">
                <div className="card">
                    <div className="card-header">
                        Employee
                    </div>
                    <div className="card-body">
                        <div className="row">
                            <div className="col-3">Name:</div>
                            <div className="col-9">{this.state.name}</div>
                        </div>
                        <div className="row">
                            <div className="col-3">Entry date:</div>
                            <div className="col-9">{this.state.entryDate}</div>
                        </div>
                        <div className="row">
                            <div className="col-3">Salary:</div>
                            <div className="col-9">{this.state.salary}</div>
                        </div>
                        <div className="row">
                            <div className="col text-right">
                                <Link className="btn btn-default mr-2" to={"/employees"}>Back</Link>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }

}

export {EmployeeDetails};
