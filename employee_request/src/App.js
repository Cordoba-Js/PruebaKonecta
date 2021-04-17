import React from 'react';
import { BrowserRouter as Router, Link, Route, Switch } from 'react-router-dom';

import 'bootstrap/dist/css/bootstrap.min.css';
import '@fortawesome/fontawesome-free/css/all.min.css';

import { Employees, EmployeeDetails, CreateEmployee, EditEmployee } from './components/employee';
import { Requests, RequestDetails, CreateRequest, EditRequest } from './components/request';

function App() {
  return (
    <div>
      <Router>
        <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
          <Link className="navbar-brand" to="/">Home</Link>
          <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                  aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"/>
          </button>
          <div className="collapse navbar-collapse" id="navbarNav">
            <ul className="navbar-nav">
              <li className="nav-item active mr-2">
                <Link className="text-decoration-none" to="/employees">Employees</Link>
              </li>
              <li className="nav-item mr-2">
                <Link className="text-decoration-none" to="/requests">Requests</Link>
              </li>
            </ul>
          </div>
        </nav>
        <Switch>

          <Route exact path="/employees"> <Employees/></Route>
          <Route exact path="/employees/create"> <CreateEmployee/> </Route>
          <Route exact path="/employees/:id"> <EmployeeDetails/> </Route>
          <Route exact path="/employees/:id/edit"> <EditEmployee/> </Route>

          <Route exact path="/requests"> <Requests/> </Route>
          <Route exact path="/requests/create"> <CreateRequest/> </Route>
          <Route exact path="/requests/:id"> <RequestDetails/> </Route>
          <Route exact path="/requests/:id/edit"> <EditRequest/> </Route>

        </Switch>
      </Router>
    </div>
  );
}

export default App;
