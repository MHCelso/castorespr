axios
    .get('http://localhost:8080/v1/api/products')
    .then(response => {
        const data = response.data;
        setTable(data);
    }).catch(error => {
    console.error(error);
});

function setTable(data) {
    const tableBody = document.getElementById('body-table');

    data.forEach(key => {
        const fila = document.createElement('tr');
        let deletedAt = "-";
        let statusToChange = "ACTIVAR";
        let statusToChangeRequest = "ACTIVO";

        if (key.deletedAt !== null) {
            deletedAt = key.deletedAt;
        }

        if (key.status === "ACTIVO") {
            statusToChange = "DESACTIVAR";
            statusToChangeRequest = "INACTIVO";
        }

        fila.innerHTML = `
        <form>
        <td>${key.name}</td>
        <td>${key.price}</td>
        <td>
          <input 
            onchange="minMaxInputUpdate(this, ${key.quantity}, true)" 
            type="number"
            class="form-control"
            id="iquantity-${key.id}"
            placeholder=${key.quantity} 
            value=${key.quantity} />
          </td>
        <td>${key.createdAt}</td>
        <td>${key.updatedAt}</td>
        <td>${deletedAt}</td>
        <td>
          <button 
            class="btn btn-link" 
            id="status-${key.id}">
            ${statusToChange}
          </button>
        </td>
        <td>${key.addedByName}</td>
        <td>
          <button
            class="btn btn-secondary" 
            id="quantity-${key.id}">
            nueva cantidad
          </button>
        </td>
        </form>
      `;

        tableBody.appendChild(fila);

        const statusButton = document.getElementById(`status-${key.id}`);
        const quantityButton = document.getElementById(`quantity-${key.id}`);
        const iQuantityButton = document.getElementById(`iquantity-${key.id}`);

        statusButton.addEventListener("click", event => {
            event.preventDefault();

            const formData = new FormData();

            formData.append("status", statusToChangeRequest);

            const url = `http://localhost:8080/v1/api/status/update/${key.id}`;

            axios.put(url, formData, {
                "headers": {"content-type": 'application/x-www-form-urlencoded'},
                "responseType":'json'
            }).then(response => {
                console.log('Estado actualizado:', response.data);
                // window.location.reload(true);
            }).catch(error => {
                console.error('Error al realizar la solicitud:', error);
            });
        });

        quantityButton.addEventListener("click", event => {
            event.preventDefault();

            const formDataQuantity = new FormData();

            formDataQuantity.append("quantity", iQuantityButton.value);

            const url = `http://localhost:8080/v1/api/quantity/update/${key.id}`;

            axios.put(url, formDataQuantity, {
                "headers": {"content-type": 'application/x-www-form-urlencoded'},
                "responseType":'json'
            }).then(response => {
                console.log('cantidad actualizada:', response.data);
                //window.location.reload(true);
            }).catch(error => {
                console.error('Error al realizar la solicitud:', error);
            });
        });
    });
}

function minMaxInputUpdate(element, min, zeroAllowed){
    if (element.value === 0 && zeroAllowed) {
        return;
    }

    if (element.value < min) {
        element.value = min;

        const spanInfo = element.parentElement ? element.parentElement.querySelector('#spanInfoIdUpdate') : null;

        if (spanInfo) {
        } else {
            const spanInfo = document.createElement('span');

            spanInfo.id = 'spanInfoIdUpdate';
            spanInfo.style.color = 'red';
            spanInfo.textContent = 'No puedes sacar';
            element.parentElement.appendChild(spanInfo);
        }
    }
}
