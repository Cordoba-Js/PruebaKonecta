import React from 'react';
import {Link, Redirect} from "react-router-dom";
import {employeeService} from "../../services/employee.service";

class EditEmployee extends React.Component {

    constructor(props){
        super(props);
        this.state = {
            id: this.props.match.params.id ? this.props.match.params.id : 0,
            entryDate: "",
            name: "",
            salary: ""
        }

        this.changeEntryDate = this.changeEntryDate.bind(this);
        this.changeName = this.changeName.bind(this);
        this.changeSalary = this.changeSalary.bind(this);;

        this.save = this.save.bind(this);
        this.getEmployee = this.getEmployee.bind(this);
    }

    changeEntryDate(event){
        this.setState({
            entryDate: event.target.value
        })
    }

    changeName(event){
        this.setState({
            name: event.target.value
        })
    }

    changeSalary(event){
        this.setState({
            salary: event.target.value
        })
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

    async save(){
        const { id, entryDate, name, salary } = this.state;
        const newEmployee = { id, entryDate, name, salary };
        await employeeService.update(id, newEmployee);
        return <Redirect to="/employees"/>;
    }

    async componentDidMount() {
        await this.getEmployee();
    }

    render(){
        return (
            <div className="m-5">
                <div className="card">
                    <div className="card-header">
                        Create Request
                    </div>
                    <div className="card-body">
                        <div className="form-group mb-3">
                            <label htmlFor="name">Name:</label>
                            <input type="text" className="form-control" id="name"
                                   placeholder="name" value={this.state.name} onChange={this.changeName}/>
                        </div>
                        <div className="form-group mb-3">
                            <label htmlFor="entryDate">Entry date:</label>
                            <input type="date" className="form-control" id="entryDate"
                                   placeholder="entryDate" value={this.state.entryDate} onChange={this.changeEntryDate}/>
                        </div>
                        <div className="form-group mb-3">
                            <label htmlFor="salary">Salary</label>
                            <input type="number" className="form-control" id="salary"
                                   placeholder="salary" value={this.state.salary} onChange={this.changeSalary}/>
                        </div>
                        <div className="row">
                            <div className="col text-right">
                                <Link className="btn btn-default mr-2" to={"/employees"}>Cancel</Link>
                                <span className="btn btn-success" onClick={async () => {await this.save()}}><i className="fas fa-save mr-2"/>Save</span>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        );
    }

}

export {EditEmployee};
