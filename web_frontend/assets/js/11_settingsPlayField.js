"use strict"
document.addEventListener("DOMContentLoaded", init);

function init(){
    document.querySelector('#good').addEventListener('click', nextScreen);;
}

function nextScreen(e) {
    e.preventDefault();
    window.location.href = "7_playField.html"

    return false; ;
}
