"use strict"
document.addEventListener("DOMContentLoaded", init);

function init(){
    document.querySelector('a').addEventListener('click', nextScreen);;
}

function nextScreen(e) {
    e.preventDefault();
    window.location.href = "1_deckbuildOrPlay.html"

    return false; ;
}
