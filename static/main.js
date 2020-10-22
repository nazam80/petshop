

const drawPets = () =>{ 
    fetch('http://localhost:8080/pets')
    .then(response => response.json())
    .then(data => {      
        const petList = document.getElementById('ps-shop-pet-list');                
        petList.appendChild(data);

    });

}