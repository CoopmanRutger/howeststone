'use strict';

document.addEventListener("DOMContentLoaded", init);

function init(){
    console.log("im in init");
    loadButtons();
    document.getElementById('chooseDeckForHero').addEventListener('click', nextScreen4);
    // console.log(document.querySelector('h2').value);
    // document.querySelectorAll('h2').addEventListener('click', pickAHero);
    let h2Heroes = document.querySelectorAll('.choose'); // creert lijst met 2 h2's, dan for drmee gebruiken
    for (let i = 0; i < h2Heroes.length; i++) {
        h2Heroes[i].addEventListener('click', pickAHero);
    }
}

function nextScreen4(e){
    e.preventDefault();
    window.location.href = "3_chooseDeckForHero.html";
}

function loadButtons(){
    document.querySelector('#chooseDeckForHero').innerHTML += "<button id=\"deckbuildOrPlayButton\" class=\"return\" type=\"button\">Back</button>\n";
}

function pickAHero(e) {
    e.preventDefault();
    console.log("im in pick a hero");

		e.preventDefault();
    fetch("http://localhost:4242/API/pickYourOpponent", {
        method: 'post',
        body: JSON.stringify(this.value)
    }).then(function (res) {
        console.log(res);
    }).then(function () {
			window.location.href = "5.1_versusScreen.html";
    })

}
