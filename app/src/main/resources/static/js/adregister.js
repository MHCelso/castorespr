const registerButton = document.getElementById("registerButton");
const name = document.getElementById("name");
const price = document.getElementById("price");
const quantity = document.getElementById("quantity");
const status = document.getElementById("status");

registerButton.addEventListener('click', e => {
    e.preventDefault();

    const formData = new FormData();

    formData.append("name", name.value);
    formData.append("price", price.value);
    formData.append("quantity", quantity.value);
    formData.append("status", status.value);

    axios.post("http://localhost:8080/v1/api/register", formData, {
        "headers": {"content-type": 'application/x-www-form-urlencoded'},
        "responseType":'json'
    }).then(response => {
        console.log(JSON.stringify(response, null, 3));
    }).catch(error => {
        console.error(JSON.stringify(error, null, 3));
    });

    name.value = "";
    price.value = 0.0;
    quantity.value = 0;
    status.value = "ACTIVO";
});

function minMaxInput(element, min, zeroAllowed){
    if (element.value == 0 && zeroAllowed) {

        return;
    }

    if (element.value < min) {
        element.value = min;

        return;
    }
}
