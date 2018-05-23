"use strict";

document.addEventListener("DOMContentLoaded", init);
let heroName = '';


function init() {
    console.log("im in init");
    getHeroNameOutJava();
    getDecksSQL(heroName);
    setHeroDeckPictures(heroName);

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


function getDecksSQL(heroname) {

}

function setHeroDeckPictures(heroname) {

    document.getElementsByClassName(heroPicture).innerHTML = "<img src='hero_" + heroname  +  "_deck1' alt='hero_" + heroname  + "_deck1'";

    // main > div div:first-child div
    // main > div div:nth-child(2) div
    // background-image: url('../media/JainaChooseYrHero.jpg');

}

function toDeckBuilderLevel2(e){
    e.preventDefault();
    window.location.href = "5_makeANewDeck=9deckBuildLevel2.html";
}

function toPickYrOpponent(e){
    e.preventDefault();
    fetch("http://localhost:4242/API/deckbuildOrPlay/chooseYourHero/chooseDeckForHero/postHeroDeck", {
        method: 'post',
        body: this.value
    }).then(function (res) {
        console.log(res);
    }).then(function () {
			window.location.href = "4_defaultPickYourOpponent.html";
    });
}
function getHeroNameOutJava() {
    fetch("/API/deckbuildOrPlay/chooseYourHero/chooseDeckForHero/getHeroName", {
        method: 'get'
    }).then(function (res) {
        console.log(res);
        heroName = res;

    });

}
