import React from 'react';
import {employeeService} from "../../services/employee.service";
import {Link, Redirect} from "react-router-dom";

class CreateEmployee extends React.Component {

    constructor(props){
        super(props);
        this.state = {
            entryDate: "",
            name: "",
            salary: ""
        }

        this.changeEntryDate = this.changeEntryDate.bind(this);
        this.changeName = this.changeName.bind(this);
        this.changeSalary = this.changeSalary.bind(this);;

        this.save = this.save.bind(this);
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

    async save(){
        console.log("save")
        const { entryDate, name, salary } = this.state;
        const newEmployee = { entry_date: entryDate, name, salary }
        await employeeService.create(newEmployee);
        console.log("saved")
        return <Redirect to="/employees"/>;
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

export {CreateEmployee};
