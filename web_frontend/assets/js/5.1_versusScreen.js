"use strict"
document.addEventListener("DOMContentLoaded", init);

function init(){
    setTimeout(function () {
        [nextScreen]
    }, 20);
    document.querySelector('#versus').addEventListener('click', nextScreen);;
}

function nextScreen(e) {
    e.preventDefault();
    window.location.href = "6_gameStartingHand.html"

    return false; ;
}
