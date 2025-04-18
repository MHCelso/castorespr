axios
    .get('http://localhost:8080/v1/api/products')
    .then(response => {
        const data = response.data;
        setTable(data);
    }).catch(error => {
        console.error(error);
    });

function setTable(data) {
    const tablaBody = document.getElementById('body-table');

    data.forEach(key => {
        const fila = document.createElement('tr');
        let deletedAt = "-";

        if (key.deletedAt !== null) {
            deletedAt = key.deletedAt;
        }

        fila.innerHTML = `
        <td>${key.name}</td>
        <td>${key.price}</td>
        <td>${key.quantity}</td>
        <td>${key.createdAt}</td>
        <td>${key.updatedAt}</td>
        <td>${deletedAt}</td>
        <td>${key.status}</td>
        <td>${key.addedByName}</td>
      `;

        tablaBody.appendChild(fila);
    });
}
