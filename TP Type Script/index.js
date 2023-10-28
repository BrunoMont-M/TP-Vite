fetch('https://fakestoreapi.com/products')
    .then(function (res) { return res.json(); })
    .then(function (products) {
    //Prepare table HTML
    var tableHTML = '<thead><tr><th>Id</th><th>Title</th><th>Description</th><th>Price</th></tr></thead><tbody>';
    // Loop thru all products to generate of the table
    products.forEach(function (p) {
        tableHTML += "<tr><td>".concat(p.id, "</td><td>").concat(p.title, "</td><td>").concat(p.description, "</td><td>").concat(p.price, "</td></tr>");
    });
    // Close table body
    tableHTML += '</tbody>';
    // Grab table element to set its inner html
    document.querySelector('#tableElement').innerHTML = tableHTML; //esta línea puede ser nula, con un '?' lo hacemos opcional, con un '!' lo obligamos a que matchee
    // Hide spinner
    var spinnerElement = document.querySelector('#spinnerContainer');
    spinnerElement.style.display = 'none';
});
