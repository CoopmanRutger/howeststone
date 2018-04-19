"use strict";

document.addEventListener("DOMContentLoaded", init);
let cijfer = 0;

function init() {
    console.log("page loaded, arrived in ftie init");
    fetchCards();
    updateImage("zwaard1final.png");
    document.getElementById('deckPic').addEventListener('click', changeDickPics);
    console.log(document.getElementById('deckPic'));
    fetchPromise.then(function () {
        injectCards(cards.Basic, "#generalCards .cards");
        injectCards(cards.Specific, "#specificCards .cards");
        makeMovable(document.querySelectorAll(".cardHand"));
        document.addEventListener('mousemove', cardMousemove);
        document.addEventListener("mouseup", cardMouseup);
    });


    document.querySelector('#saveAndPlayButton').addEventListener('click', saveAndPlayGo);
}


function saveAndPlayGo(e) {
e.preventDefault();
window.location.href = "4_defaultPickYourOpponent.html"

return false; ;
}





/*fixme: click on scrollbar, card dissapears */

let imageSelectingShit = ['AggroDeckStock.jpg', 'MagicDeckStock.png', 'RangeDeckStock.jpg'];
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
    document.getElementById('deckPic').innerHTML = "<img src='"+final+"'/>";
}
