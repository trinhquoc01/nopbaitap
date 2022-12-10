// Get JSON from web API
let xhttp = new XMLHttpRequest();
xhttp.onload = function() {
    // Transform JSON into object/array
    let result = this.responseText;
    let data = JSON.parse(result);
    
    // Working with the object/array 
    console.log(data);
    
    var myRow = document.querySelector('.row');

    // 
    for (var i = 0; i < data.list.length;i++) {
        
        //
        const myArticle = document.createElement('article');
        myRow.appendChild(myArticle);
        myArticle.classList.add('col-3');
        // Create div element with class card
        var myDiv1 = document.createElement('div');
        myArticle.appendChild(myDiv1);
        myDiv1.classList.add('card', 'text-bg-secondary','mb-3');

        // Create div element with class card body
        var myDiv2 = document.createElement('div'); //cuc xam
        myDiv1.appendChild(myDiv2);
        myDiv2.classList.add('card-body');

        // Create H6 element for timedate
        var myH6 = document.createElement('h6');
        myDiv2.appendChild(myH6);
        myH6.innerText = data.list[i].dt_txt;

        // Create 
        var myDiv3 = document.createElement('div');
        myDiv2.appendChild(myDiv3);
        myDiv3.style.display = 'flex';
        myDiv3.style.alignItems = 'center';
        myDiv3.style.height = '60px';
        myDiv3.style.justifyContent = 'space-between';
         
        // Create H2 element for 
        var myH2 = document.createElement('h2');
        myDiv3.appendChild(myH2);
        myH2.innerText = data.list[i].main.temp;
        myH2.innerHTML += ' <sup>o</sup>C';

        // Create img element 
        var myImg = document.createElement('img');
        myDiv3.appendChild(myImg);
        myImg.src = `https://openweathermap.org/img/wn/${data.list[i].weather[0].icon}@2x.png`;
        
         // Create p element for weather description
         var myP = document.createElement('p');
         myDiv2.appendChild(myP);
         myP.innerText = data.list[i].weather[0].description;
    }
}

xhttp.open("GET", "http://api.openweathermap.org/data/2.5/forecast?q=Hanoi,vietnam&appid=09a71427c59d38d6a34f89b47d75975c&units=metric");
xhttp.send();

// Set background image
var myDiv0 = document.querySelector('div');
myDiv0.style.backgroundImage = 'url(./images/galaxy.jpg)';