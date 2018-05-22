"use strict";

document.addEventListener("DOMContentLoaded", init);

function init() {
    console.log("im in init");
    loadButtons();
    document.getElementById('chooseYourHero').addEventListener('click', nextScreen5);
    document.getElementById('threeMakeItYourself').addEventListener('click', toDeckBuilderLevel2);
    let twoDecks = document.querySelectorAll('.deck');
    for(let i = 0; i < twoDecks.length; i++) {
        twoDecks[i].addEventListener('click', toPickYrOpponent);
    }
    // console.log(document.getElementById('test'));
}
function nextScreen5(e){
    e.preventDefault();
    console.log("im in nextScreen");
    window.location.href = "2_chooseYourHero.html";
}

function loadButtons(){

    document.getElementById('returnButton').innerHTML += "<button id=\"chooseYourHero\" type=\"button\">Back</button>\n";

}

function toDeckBuilderLevel2(e){
    e.preventDefault();
    window.location.href = "5_makeANewDeck=9deckBuildLevel2.html";
}

function toPickYrOpponent(e){
    e.preventDefault();
    fetch("http://localhost:4242/API/deckbuildOrPlay/chooseYourHero/chooseDeckForHero", {
        method: 'post',
        body: this.value
    }).then(function (res) {
        console.log(res);
    }).then(function () {
			window.location.href = "4_defaultPickYourOpponent.html";
    })
}
