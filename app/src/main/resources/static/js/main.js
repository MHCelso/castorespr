axios
    .get('http://localhost:8080/v1/api/products')
    .then(response => {
        const data = response.data;

        const tablaBody = document.getElementById('body-table');

        data.forEach(key => {

            const fila = document.createElement('tr');

            let deletedAt = "-";

            if (key.deletedAt !== null) {
                deletedAt = key.deletedAt;
            }

            fila.innerHTML = `
        <td>${key.id}</td>
        <td>${key.name}</td>
        <td>${key.price}</td>
        <td>${key.quantity}</td>
        <td>${key.createdAt}</td>
        <td>${key.updatedAt}</td>
        <td>${deletedAt}</td>
        <td>${key.status}</td>
        <td>${key.addedByUserId}</td>
      `;

            tablaBody.appendChild(fila);
        });

    })
    .catch(error => {
        console.error(error);
    });


function setTable(data) {
    const table = document.createElement("table");
    const head = document.createElement("thead");
    const body = document.createElement("tbody");
    const headRow = document.createElement("tr");

    Object.keys(data[0]).forEach((key) => {
        const cellHead = document.createElement("th");

        cellHead.textContent = key;

        headRow.appendChild(cellHead);
    });

    head.appendChild(headRow);
    table.appendChild(head);

    data.forEach((key) => {
        const rowBody = document.createElement("tr");

        Object.values(key).forEach((value) => {
            const cellBody = document.createElement("td");
            cellBody.textContent = value;
            rowBody.appendChild(cellBody);
        });

        body.appendChild(rowBody);
    });

    table.appendChild(body);

    document.body.appendChild(table);
}
