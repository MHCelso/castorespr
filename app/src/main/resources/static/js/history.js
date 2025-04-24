const filter = document.getElementById("filter");

const formData = new FormData();
formData.append("filter", filter.value);
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

filter.addEventListener("input", async (e) => {
    e.preventDefault();

    const formData = new FormData();
    formData.append("filter", e.target.value);

    const url = `http://localhost:8080/v1/api/history/all`;

    try {
        const response = await axios.post(url, formData, {
            headers: { "Content-Type": "application/x-www-form-urlencoded" },
            responseType: 'json'
        });

        const data = response.data;
        setTable(data);

    } catch (error) {
        console.error('Error al realizar la solicitud:', error);
    }
});

function setTable(data) {
    const bodyTable = document.getElementById('h_body-table');

    bodyTable.innerHTML = '';

    if (!data || data.length === 0) {
        console.warn('No hay datos para mostrar.');
        return;
    }

    data.forEach(item => {
        const row = document.createElement('tr');

        row.innerHTML = `
            <td>${item.id}</td>
            <td>${item.productId}</td>
            <td>${item.actionType}</td>
            <td>${item.quantity}</td>
            <td>${item.createdAt}</td>
            <td>${item.addedByName}</td>
        `;

        bodyTable.appendChild(row);
    });
}

