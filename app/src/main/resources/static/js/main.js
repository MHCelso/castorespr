axios
    .get('http://localhost:8080/v1/api/products')
    .then(response => {
        console.log(response.data);
    })
    .catch(error => {
        console.error(error);
    });
