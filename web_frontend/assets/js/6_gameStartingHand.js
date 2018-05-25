'use strict';

document.addEventListener("DOMContentLoaded", init);

let divToGetPics = document.getElementById("muhDiv").children;
let cardsToDelete = [];

function toRemoveCards(e) {
    e.preventDefault();

    cardsToDelete;

    console.log(cardsToDelete);
}

function init() {

    document.getElementById("confirm").addEventListener("click", function () {
        window.location.href = "7_playingField.html";
    });

    for(let i = 0; i < divToGetPics.length; i++){
        divToGetPics[i].addEventListener('click', toRemoveCards);
    }


    fetch("http://localhost:4242/API/gameStartingHand/initializingGame").then(function () {
        fetch("http://localhost:4242/API/playingField/getGameState").then(function (res) {
            return res.json();
        }).then(function (res) {
            console.log(res);

            let test = res.player.cardsInHand.cards;
            for (let i = 0; i < test.length; i++){
                divToGetPics[i].style.backgroundImage = "url(\"" + res.player.cardsInHand.cards[i].img + "\")";
            }
        })
    })
}

// function doSomeFetch(myApi4QuotesLinkBasics) {
//     console.log("in this fetch");
//     // fetch(myApi4QuotesLinkBasics, {
//     fetch(myApi4QuotesLinkBasics, {
//         headers: new Headers({
//             'Accept': 'application/json'
//         })
//     })
//         .then(function(response) {
//             return response.json();
//         })
//         .then(function(text) {
//             // text.value;
//             document.getElementById("getCategoryQuoteHere").appendChild(getSomeHTML('blockquote', text.value));
//         })
//
// }
// function getSomeHTML(name, text) {
//     let yourHTMLelement = document.createElement(name);
//     yourHTMLelement.innerHTML = text;
//     return yourHTMLelement;
// }
