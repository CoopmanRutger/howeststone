"use strict";

let cards = {"Basic":[],"Specific":[]};
let cardsInhand = [];

let fetchPromise;

function fetchCards() {
    console.log('fetchCards');

    let url = "https://omgvamp-hearthstone-v1.p.mashape.com/cards?attack=6";

    fetchPromise = fetch(url, {
        headers: new Headers({
            "Accept": "application/json",
            "X-Mashape-Key": "y7rGFym8csmshrenbJFLUR5cVMslp1azdfKjsnPEQhhTb9Awvo"
        })
    }).then(function (resp) {
        if (resp.ok) {
            return resp.json();
        }
    }).then(function (text) {

        console.log(text.Basic);

        typesCards(text.Basic, "Basic");
        typesCards(text.Classic, "Specific");
    });
}

function typesCards(card, type) {
    let cardJson;
    for (let i = 0; i < card.length; i++) {
        cardJson = {
            "cardId": card[i].cardId,
            "attack": card[i].attack,
            "health": card[i].health,
            "name": card[i].name,
            "img": card[i].img,
            "i": i // + typeCard.length // TODO  "i": i 1ste keer
        };

        if (type === "Basic"){
            cards.Basic.push(cardJson)
        } else if (type === "Specific") {
            cards.Specific.push(cardJson)
        }
    }
}
