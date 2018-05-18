"use strict";

document.addEventListener("DOMContentLoaded", init);

function init(){
    console.log("im in init");
    loadButtons();
    document.getElementById('back').addEventListener('click', back);
    // console.log(document.querySelector('h2').value);
    // document.querySelectorAll('h2').addEventListener('click', pickAHero);
    let h2Heroes = document.querySelectorAll('.choose'); // creert lijst met 2 h2's, dan for drmee gebruiken
    for (let i = 0; i < h2Heroes.length; i++) {
        h2Heroes[i].addEventListener('click', pickAHero);
    }
}

function back(e){
    e.preventDefault();
    window.location.href = "1_deckbuildOrPlay.html";
}

function loadButtons(){
    document.querySelector('.button').innerHTML += "<button id='back' class='return' type='button'>Back</button>";
}

function pickAHero(e) {
    e.preventDefault();
    console.log(this.value);
    fetch("http://localhost:4242/API/deckbuildOrPlay/chooseYourHero", {
        method: 'post',
        body: JSON.stringify(this.value)
    }).then(function (res) {
        console.log(res);
    }).then(function () {
			window.location.href = "3_chooseDeckForHero.html";
    })
}
