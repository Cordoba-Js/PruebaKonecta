export const employeeService = {
    getAll,
    getOne,
    create,
    update,
    remove
};

async function getAll(){
    const requestOptions = {
        method: 'GET',
        headers: {'Content-Type': 'application/json'}
    };

    return await fetch("http://localhost:8080/api/employees", requestOptions).then(response => response.json())
}

async function getOne(id){
    const requestOptions = {
        method: 'GET',
        headers: {'Content-Type': 'application/json'}
    };

    return await fetch("http://localhost:8080/api/employees/"+id, requestOptions).then(response => response.json());
}

async function create(employee){
    const requestOptions = {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(employee)
    };

    return await fetch("http://localhost:8080/api/employees", requestOptions).then(response => response.json());
}

async function update(id, employee){
    const requestOptions = {
        method: 'PUT',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(employee)
    };

    return await fetch("http://localhost:8080/api/employees/"+id, requestOptions).then(response => response.json());
}

async function remove(id){
    const requestOptions = {
        method: 'DELETE',
        headers: {'Content-Type': 'application/json'}
    };

    return await fetch("http://localhost:8080/api/employees/"+id, requestOptions);
}
