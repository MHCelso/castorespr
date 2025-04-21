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

        if (key.deletedAt !== null) {
            deletedAt = key.deletedAt;
        }

        fila.innerHTML = `
        <form>
        <td>${key.name}</td>
        <td>${key.price}</td>
        <td>
          <input 
            onchange="minMaxUsInputUpdate(this, 0, ${key.quantity}, true)" 
            type="number"
            class="form-control"
            id="iquantity-${key.id}"
            placeholder=${key.quantity} 
            value=${key.quantity} />
          </td>
        <td>${key.createdAt}</td>
        <td>${key.updatedAt}</td>
        <td>${deletedAt}</td>
        <td>${key.status}</td>
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

        const quantityButton = document.getElementById(`quantity-${key.id}`);
        const iQuantityButton = document.getElementById(`iquantity-${key.id}`);

        quantityButton.addEventListener("click", event => {
            event.preventDefault();

            const formDataQuantity = new FormData();

            formDataQuantity.append("quantity", iQuantityButton.value);
            formDataQuantity.append("action", "SALIDA");

            const url = `http://localhost:8080/v1/api/quantity/update/${key.id}`;

            axios.put(url, formDataQuantity, {
                "headers": {"content-type": 'application/x-www-form-urlencoded'},
                "responseType":'json'
            }).then(response => {
                console.log('cantidad actualizada:', response.data);
                window.location.reload(true);
            }).catch(error => {
                console.error('Error al realizar la solicitud:', error);
            });
        });
    });
}

function minMaxUsInputUpdate(element, min, max, zeroAllowed){
    if (element.value === 0 && zeroAllowed) {
        return;
    }

    if(element.value < min){
        element.value = min;

        const spanInfo = element.parentElement ? element.parentElement.querySelector('#spanInfo') : null;

        if (spanInfo) {
        } else {
            const spanInfo = document.createElement('span');

            spanInfo.id = 'spanInfo';
            spanInfo.style.color = 'red';
            spanInfo.textContent = 'No puedes sacar';
            element.parentElement.appendChild(spanInfo);
        }
    }

    if(element.value > max) {
        element.value = max;

        const spanInfoU = element.parentElement ? element.parentElement.querySelector('#spanInfoIdUpdate') : null;

        if (spanInfoU) {
        } else {
            const spanInfoU = document.createElement('span');

            spanInfoU.id = 'spanInfoIdUpdate';
            spanInfoU.style.color = 'red';
            spanInfoU.textContent = 'No puedes meter';
            element.parentElement.appendChild(spanInfoU);
        }
    }
}
