import React from 'react';
import {Link} from "react-router-dom";
import {requestService} from "../../services/request.service";

class RequestDetails extends React.Component {

    constructor(props){
        super(props);
        this.state = {
            id: this.props.match.params.id ? this.props.match.params.id : 0,
            code: "",
            description: "",
            resume: "",
            employee: ""
        }

        this.getRequest = this.getRequest.bind(this);
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

    async componentDidMount() {
        await this.getRequest();
    }

    render(){
        return (
            <div className="m-5">
                <div className="card">
                    <div className="card-header">
                        Request
                    </div>
                    <div className="card-body">
                        <div className="row">
                            <div className="col-3">Code:</div>
                            <div className="col-9">{this.state.code}</div>
                        </div>
                        <div className="row">
                            <div className="col-3">Description:</div>
                            <div className="col-9">{this.state.description}</div>
                        </div>
                        <div className="row">
                            <div className="col-3">Resume:</div>
                            <div className="col-9">{this.state.resume}</div>
                        </div>
                        <div className="row">
                            <div className="col-3">Employee:</div>
                            <div className="col-9">{this.state.employee}</div>
                        </div>
                        <div className="row">
                            <div className="col text-right">
                                <Link className="btn btn-default mr-2" to={"/requests"}>Back</Link>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }

}

export {RequestDetails};
