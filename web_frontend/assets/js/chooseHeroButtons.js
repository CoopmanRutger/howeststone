"use strict";

document.addEventListener("DOMContentLoaded", init);

function init(){
    console.log("im in init");
    loadButtons();
    document.getElementById('deckbuildOrPlayButton').addEventListener('click', nextScreen4);
    console.log(document.querySelector('h2').value);
    document.querySelectorAll('h2').addEventListener('click', pickAHero);
}

function nextScreen4(e){
    e.preventDefault();
    window.location.href = "1_deckbuildOrPlay.html";
}

function loadButtons(){
    document.getElementById('returnButton').innerHTML += "<button id=\"deckbuildOrPlayButton\" class=\"return\" type=\"button\">Back</button>\n";
}

function pickAHero(e) {
    e.preventDefault();
    console.log("im in pickAHero");
    console.log(document.querySelector('h2').value);
    // let firstHero = document.querySelector('main article:first-child div h2').value;
    // let secondHero = document.querySelector('main article:last-child div h2').value;
    let allHero = document.querySelectorAll('h2').value;
    for (let i; i < allHero.length )
}

