import React from 'react';
import {Link} from "react-router-dom";
import {employeeService} from "../../services/employee.service";

class Employees extends React.Component {

    constructor(props){
        super(props);
        this.state = {
            employees: []
        }

        this.getEmployees = this.getEmployees.bind(this);
        this.remove = this.remove.bind(this);
    }

    async getEmployees(){
        const employees = await employeeService.getAll();
        console.log("employees: ", employees);
        this.setState({employees: employees})
    }

    async remove(id){
        await employeeService.remove(id);
        await this.getEmployees();
    }

    async componentDidMount() {
        await this.getEmployees();
    }

    render(){
        return (
            <div className="m-5">
                <div className="card">
                    <div className="card-header">
                        Employees
                        <Link to={"/employees/create"} className="btn btn-success ml-2"><i className="fas fa-plus"/></Link>
                    </div>
                    <div className="card-body">
                        <table className="table">
                            <thead className="thead-dark">
                            <tr>
                                <th scope="col">Name</th>
                                <th scope="col">Entry date</th>
                                <th scope="col">Salary</th>
                                <th scope="col">Action</th>
                            </tr>
                            </thead>
                            <tbody>
                            {
                                this.state.employees.length > 0 && this.state.employees.map(employee => {
                                    return (
                                        <tr key={employee.id}>
                                            <th scope="row">{employee.name}</th>
                                            <td>{employee.entry_date}</td>
                                            <td>{employee.salary}</td>
                                            <td>
                                                <Link to={"/employees/"+employee.id}  className="btn btn-primary mr-2"><i className="fas fa-eye"/></Link>
                                                <Link to={"/employees/"+employee.id+"/edit"}  className="btn btn-warning mr-2"><i className="fas fa-pencil-alt"/></Link>
                                                <span className="btn btn-danger" onClick={async ()=>{await this.remove(employee.id)}}><i className="fas fa-trash-alt"/></span>
                                            </td>
                                        </tr>
                                    );
                                })
                            }
                            {
                                this.state.employees.length === 0 && (
                                    <tr>
                                        <td colSpan="5" className="center">Not data found</td>
                                    </tr>
                                )
                            }
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        );
    }

}

export {Employees};
