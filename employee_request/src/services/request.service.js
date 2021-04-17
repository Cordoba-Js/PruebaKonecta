export const requestService = {
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

    return await fetch("http://localhost:8080/api/requests", requestOptions).then(response => response.json());
}

async function getOne(id){
    const requestOptions = {
        method: 'GET',
        headers: {'Content-Type': 'application/json'}
    };

    return await fetch("http://localhost:8080/api/requests/"+id, requestOptions).then(response => response.json());
}

async function create(request){
    const requestOptions = {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(request)
    };

    return await fetch("http://localhost:8080/api/requests", requestOptions).then(response => response.json());
}

async function update(id, request){
    const requestOptions = {
        method: 'PUT',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(request)
    };

    return await fetch("http://localhost:8080/api/requests/"+id, requestOptions).then(response => response.json());
}

async function remove(id){
    const requestOptions = {
        method: 'DELETE',
        headers: {'Content-Type': 'application/json'}
    };

    return await fetch("http://localhost:8080/api/requests/"+id, requestOptions);
}
