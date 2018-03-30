"use strict";

document.addEventListener("DOMContentLoaded", init);
let cijfer = 0;

function init() {
    console.log("page loaded, arrived in ftie init");
    fetchCards();
    updateImage("zwaard1final.png");
    document.getElementById('theDickPick').addEventListener('click', changeDickPics);
    console.log(document.getElementById('theDickPick'));
    fetchPromise.then(function () {
        injectCards(cards.Basic, "#generalCards .cards");
        injectCards(cards.Specific, "#specificCards .cards");
        makeMovable(document.querySelectorAll(".cardHand"));
        document.addEventListener('mousemove', cardMousemove);
        document.addEventListener("mouseup", cardMouseup);
    });
}

/*fixme: click on scrollbar, card dissapears */

let imageSelectingShit = ['anvilFinal.png', 'chooseYrDeckSymbol.png', 'JainaChooseYrHero.jpg', 'papyrusForDeckbuilder.png', 'kaderChooseYrHero.png'];
// let imageSelectingShit = ['anvilFinal.png', 'zwaard1final.png', 'anvilFinal.png', 'anvilFinal.png', 'anvilFinal.png', 'anvilFinal.png'];

function changeDickPics(e) {
    console.log("clicked");
    cijfer++;
    cijfer %= imageSelectingShit.length;
    updateImage(imageSelectingShit[cijfer]);
}

function updateImage(src) {
    let final = "assets/media/";
    final += src;
    document.getElementById('theDickPick').innerHTML = "<img src='"+final+"'/>";
}