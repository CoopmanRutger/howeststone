"use strict";

let cards = {"Basic":[],"Specific":[]};
let cardsInhand = [];

let fetchPromise;

function fetchCards() {
    let url = "https://omgvamp-hearthstone-v1.p.mashape.com/cards?attack=5";

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

function typesCards(typeCard, type) {
	let card;
    for (let i = 0; i < typeCard.length; i++) {
        card = {
            "cardId": typeCard[i].cardId,
            "attack": typeCard[i].attack,
            "health": typeCard[i].health,
            "name": typeCard[i].name,
            "img": typeCard[i].img,
            "i": i + typeCard.length // TODO  "i": i 1ste keer
        };

        if (type === "Basic"){
            cards.Basic.push(card)
        } else if (type === "Specific"){
            cards.Specific.push(card)
        }
    }
}
