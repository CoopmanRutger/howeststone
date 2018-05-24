"use strict";

document.addEventListener("DOMContentLoaded", init);

function init() {
    getHeroNameOutJava();
    loadButtons();
    document.getElementById('chooseYourHero').addEventListener('click', nextScreen5);
    document.getElementById('threeMakeItYourself').addEventListener('click', toDeckBuilderLevel2);
    let twoDecks = document.querySelectorAll('.deck');
    for(let i = 0; i < twoDecks.length; i++) {
        twoDecks[i].addEventListener('click', pickADeck);
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



function pickADeck(e) {
    e.preventDefault();
    console.log(this.value);
    fetch("http://localhost:4242/API/deckbuildOrPlay/chooseYourHero/chooseDeckForHero/postChooseDeck", {
        method: 'post',
        body: JSON.stringify(this.value)
    }).then(function (res) {
        console.log(res);
    }).then(function () {
        window.location.href = "4_defaultPickYourOpponent.html";
    })
}




function getDecksSQL(heroname) {
    fetch("http://localhost:4242/API/deckbuildOrPlay/chooseYourHero/chooseDeckForHero/getChooseDeckSQL",).
    then(function (response) {
        return response.json();
    }).then(function (res) {
        console.log(res);
    })

}

function setHeroDeckPictures(heroname) {
    let tempArray = document.querySelectorAll('.heroPicture');
    for (var i = 1; i <= tempArray.length; i++) {
        tempArray[i-1].innerHTML += "<img src='/web_frontend/assets/media/hero_" + heroname
                +  "_deck" + i + ".jpg' alt='hero_" + heroname  + "_deck" + i + ".jpg'>";
    }
}

function toDeckBuilderLevel2(e){
    e.preventDefault();
    window.location.href = "5_makeANewDeck=9deckBuildLevel2.html";
}


function getHeroNameOutJava() {
    fetch("http://localhost:4242/API/deckbuildOrPlay/chooseYourHero/chooseDeckForHero/getHeroName", {
        method: 'get',
        headers: new Headers({
                    "Accept": "text/plain"
                })
    }).then(function (response) {
console.log(response);
        return response.text();

    }).then(function (res) {
        console.log(res);
        let heroname = res.toLowerCase();
        setHeroDeckPictures(heroname);
        getDecksSQL(heroname);
    })}
