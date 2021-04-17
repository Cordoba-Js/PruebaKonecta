import React from 'react';
import {Link, Redirect} from "react-router-dom";
import {employeeService} from "../../services/employee.service";
import {requestService} from "../../services/request.service";

class EditRequest extends React.Component {

    constructor(props){
        super(props);
        this.state = {
            id: this.props.match.params.id ? this.props.match.params.id : 0,
            code: "",
            description: "",
            resume: "",
            employee: "",
            employees: []
        }

        this.changeCode = this.changeCode.bind(this);
        this.changeDescription = this.changeDescription.bind(this);
        this.changeResume = this.changeResume.bind(this);
        this.changeEmployee = this.changeEmployee.bind(this);

        this.save = this.save.bind(this);
        this.getRequest = this.getRequest.bind(this);
        this.getEmployees = this.getEmployees.bind(this);
    }

    changeCode(event){
        this.setState({
            code: event.target.value
        })
    }

    changeDescription(event){
        this.setState({
            description: event.target.value
        })
    }

    changeResume(event){
        this.setState({
            resume: event.target.value
        })
    }

    changeEmployee(event){
        this.setState({
            employee: event.target.value
        })
    }

    async getEmployees(){
        const employees = await employeeService.getAll();
        this.setState({
            employees: employees
        })
    }

    async getRequest(){
        const request = await requestService.getOne(this.state.id);
        this.setState({
            id: request.id,
            code: request.code,
            description: request.description,
            resume: request.resume,
            employee: request.employee
        })
    }

    async save(){
        const { id, code, description, resume, employee } = this.state;
        const newEmployee = { id, code, description, resume, employee_id: employee}
        await requestService.update(id, newEmployee);
        return <Redirect to="/requests"/>;
    }

    async componentDidMount() {
        await this.getRequest();
        await this.getEmployees();
    }


    render(){
        return (
            <div className="m-5">
                <div className="card">
                    <div className="card-header">
                        Edit Requests
                    </div>
                    <div className="card-body">
                        <div className="form-group mb-3">
                            <label htmlFor="code">Code:</label>
                            <input type="text" className="form-control" id="code"
                                   placeholder="name@example.com" value={this.state.code} onChange={this.changeCode}/>
                        </div>
                        <div className="form-group mb-3">
                            <label htmlFor="description">Description</label>
                            <input type="text" className="form-control" id="description"
                                   placeholder="name@example.com" value={this.state.description} onChange={this.changeDescription}/>
                        </div>
                        <div className="form-group mb-3">
                            <label htmlFor="resume">Resume</label>
                            <input type="email" className="form-control" id="resume"
                                   placeholder="name@example.com" value={this.state.resume} onChange={this.changeResume}/>
                        </div>
                        <div className="form-group mb-3">
                            <label htmlFor="employee">Employee</label>
                            <select className="form-control" name="employee" id="employee" placeholder="choose employee..." onChange={this.changeEmployee}>
                                <option value=""/>
                                {this.state.employees.length > 0 && this.state.employees.map(employee => {
                                    return (
                                        <option value={employee.id}>{employee.name}</option>
                                    );
                                })}
                            </select>
                        </div>
                        <div className="row">
                            <div className="col text-right">
                                <Link className="btn btn-default mr-2" to={"/requests"}>Cancel</Link>
                                <span className="btn btn-success" onClick={async () => {await this.save()}}><i className="fas fa-save mr-2"/>Save</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }

}

export {EditRequest};
