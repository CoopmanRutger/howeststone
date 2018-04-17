"use strict"

function showPlayer() {

    let startposition = 50;
    let element = document.createElement("div");

    element.style.backgroundImage = "url('images/".png')";
    element.style.left = (i * spaceBetweenCards + startposition) + 'px';
    element.style.width = 270 + 'px';
    element.style.height = 275 + 'px';
    document.querySelector("#pickYourOpponent").appendChild(element);



}