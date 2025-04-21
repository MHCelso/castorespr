const filter = document.getElementById("filter");

filter.addEventListener("input", e => {
    e.preventDefault();

    const formData = new FormData();

    formData.append("filter", e.target.value);

    const url = `http://localhost:8080/v1/api/history/all`;

    axios.post(url, formData, {
        "headers": {"content-type": 'application/x-www-form-urlencoded'},
        "responseType":'json'
    }).then(response => {
        const data = response.data;
        setTable(data);
    }).catch(error => {
        console.error('Error al realizar la solicitud:', error);
    });
});

function setTable(data) {
    const bodyTable = document.getElementById('h_body-table');

    data.forEach(key => {
        const row = document.createElement('tr');

        row.innerHTML = `
        <td>${key.id}</td>
        <td>${key.productId}</td>
        <td>${key.actionType}</td>
        <td>${key.quantity}</td>
        <td>${key.createdAt}</td>
        <td>${key.addedByName}</td>
      `;

        bodyTable.appendChild(row);
    });
}
