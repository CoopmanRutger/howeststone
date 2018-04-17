"use strict";

document.addEventListener("DOMContentLoaded", init);

function init() {
    console.log("im in init");
    loadButtons();
    document.getElementById('chooseYourHero').addEventListener('click', nextScreen5);
    // console.log(document.getElementById('test'));
}
function nextScreen5(e){
    e.preventDefault();
    console.log("im in nextScreen");
    window.location.href = "1_deckbuildOrPlay.html";
}

function loadButtons(){
    document.getElementById('returnButton').innerHTML += "<button id=\"chooseYourHero\" type=\"button\">Back</button>\n";
}

