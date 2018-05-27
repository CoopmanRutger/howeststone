"use strict"
document.addEventListener("DOMContentLoaded", init);

function init(){
    document.querySelector('#no').addEventListener('click', returnBack);
    document.querySelector('#yes').addEventListener('click', restartGame);
}

function returnBack(e) {
    e.preventDefault();
    window.location.href = "7_playField.html"

    return false; ;
}

function restartGame(e) {
    e.preventDefault();
    window.location.href = "1_deckbuildOrPlay.html"

    return false; ;
}
