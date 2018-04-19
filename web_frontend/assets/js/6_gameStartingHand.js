"use strict"
document.addEventListener("DOMContentLoaded", init);

function init(){
    document.querySelector('#confirm').addEventListener('click', nextScreen);;
}

function nextScreen(e) {
    e.preventDefault();
    window.location.href = "7_playField.html"

    return false; ;
}
