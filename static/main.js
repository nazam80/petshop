

const drawPets = () =>{ 

    const createPetRowElement = (label, value)=>{
        const row = document.createElement("div");
        row.appendChild(document.createTextNode(label + value));
        return row;
    }

    const createPetElement = (petData)=>{
        const petDiv = document.createElement("div");
        
        petDiv.appendChild( createPetRowElement("Id: ", petData.id) );
        petDiv.appendChild(createPetRowElement("Name: ", petData.name));
        petDiv.appendChild(createPetRowElement("Breed: ", petData.breed));
        petDiv.appendChild(createPetRowElement("Specie: ", petData.specie));

        return petDiv;
    }

    fetch('http://localhost:8080/pets')
    .then(response => response.json())
    .then(data => {      
        const petList = document.getElementById('ps-shop-pet-list');                
        petList.appendChild(data);

        data.forEach((petData)=>{
            const petDiv = createPetElement(petData);            
            petList.appendChild(petDiv);
        });        

    });

}