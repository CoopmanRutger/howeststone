"use strict";

document.addEventListener("DOMContentLoaded", init);

function init(){
    document.getElementById('gemButton').addEventListener('click', nextScreen1);
}

function nextScreen1(e){
    e.preventDefault();
    window.location.href = "1_deckbuildOrPlay.html";

}