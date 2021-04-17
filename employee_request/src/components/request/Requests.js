import React from 'react';
import {Link} from "react-router-dom";
import {requestService} from "../../services/request.service";

class Requests extends React.Component {

    constructor(props){
        super(props);
        this.state = {
            requests: []
        }

        this.getRequests = this.getRequests.bind(this);
        this.remove = this.remove.bind(this);
    }

    async getRequests(){
        const requests = await requestService.getAll();
        console.log("Requests: ", requests);
        this.setState({requests: requests})
    }

    async remove(id){
        await requestService.remove(id);
        await this.getRequests();
    }

    async componentDidMount() {
        await this.getRequests();
    }

    render(){
        return (
            <div className="m-5">
                <div className="card">
                    <div className="card-header">
                        Requests
                        <Link to={"/requests/create"} className="btn btn-success ml-2"><i className="fas fa-plus"/></Link>
                    </div>
                    <div className="card-body">
                        <table className="table">
                            <thead className="thead-dark">
                            <tr>
                                <th scope="col">Code</th>
                                <th scope="col">Description</th>
                                <th scope="col">Resume</th>
                                <th scope="col">Employee</th>
                                <th scope="col">Action</th>
                            </tr>
                            </thead>
                            <tbody>
                            {
                                this.state.requests.length > 0 && this.state.requests.map(request => {
                                    return (
                                        <tr>
                                            <th scope="row">{request.code}</th>
                                            <td>{request.description}</td>
                                            <td>{request.code}</td>
                                            <td>{request.employee_name}</td>
                                            <td>
                                                <Link to={"/requests/"+request.id}  className="btn btn-primary mr-2"><i className="fas fa-eye"/></Link>
                                                <Link to={"/requests/"+request.id+"/edit"}  className="btn btn-warning mr-2"><i className="fas fa-pencil-alt"/></Link>
                                                <span className="btn btn-danger" onClick={async ()=>{await this.remove(request.id)}}><i className="fas fa-trash-alt"/></span>
                                            </td>
                                        </tr>
                                    );
                                })
                            }
                            {
                                this.state.requests.length === 0 && (
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

export {Requests};

