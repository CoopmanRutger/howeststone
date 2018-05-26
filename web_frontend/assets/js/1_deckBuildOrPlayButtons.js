"use strict";

document.addEventListener("DOMContentLoaded", init);


function init(){
    console.log("im in init");
    loadButtons();
    console.log(document.getElementById("deckbuildLevelOneButton"));
    document.getElementById('deckbuildLevelOneButton').addEventListener('click', nextScreen2);
    document.getElementById('chooseHeroButton').addEventListener('click', nextScreen3);
}

function nextScreen2(e){
    e.preventDefault();
    window.location.href= "8_deckbuildLevelOne.html";
}
function nextScreen3(e){
    e.preventDefault();
    window.location.href="2_chooseYourHero.html";
}
function loadButtons(){
    document.querySelector('#deckBuild div').innerHTML += "<button id=\"deckbuildLevelOneButton\" type=\"button\">DeckBuilder</button>";
    document.querySelector('#play div').innerHTML += "<button id=\"chooseHeroButton\" type=\"button\">Play</button>";
    console.log("im in loadingbuttons");
}
