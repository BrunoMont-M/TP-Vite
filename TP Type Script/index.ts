type Rating = {
    count: number;
    rate: number;
    };
    
    type Product = {
    category: string;
    description: string;
    id: number;
    image: string;
    price: number;
    rating: Rating;
    title: string;
    };
    

fetch('https://fakestoreapi.com/products')
    .then(res => res.json())
    .then((products: Product[]) => {
        //Prepare table HTML
        let tableHTML: string = '<thead><tr><th>Id</th><th>Title</th><th>Description</th><th>Price</th></tr></thead><tbody>';
        // Loop thru all products to generate of the table
        products.forEach((p: Product) => {
            tableHTML += `<tr><td>${p.id}</td><td>${p.title}</td><td>${p.description}</td><td>${p.price}</td></tr>`;
        })
        // Close table body
        tableHTML += '</tbody>';
        // Grab table element to set its inner html
        document.querySelector('#tableElement')!.innerHTML = tableHTML; //esta línea puede ser nula, con un '?' lo hacemos opcional, con un '!' lo obligamos a que matchee
        // Hide spinner
        const spinnerElement: HTMLElement = document.querySelector('#spinnerContainer')!;
        spinnerElement.style.display = 'none';
    });