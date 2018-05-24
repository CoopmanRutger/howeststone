"use strict";

let cards = {"Basic":[],"Specific":[]};
let cardsInhand = [];

let fetchPromise;

function typesCards(typeCard, type) {
		let card;
    for (let i = 0; i < typeCard.length; i++) {
        // console.log(typeCard[i]);
        card = {
            "cardId": typeCard[i].cardId,
            "attack": typeCard[i].attack,
            "health": typeCard[i].health,
            "name": typeCard[i].name,
            "img": typeCard[i].img,
            "type": typeCard[i].type,
            "durability": typeCard[i].durability,
            "i": i + typeCard.length
        };

		player.arrayCardsInHand.push(card)

        if (type === "Basic"){
            cards.Basic.push(card)
        } else if (type === "Specific"){
            cards.Specific.push(card)
        }
    }
}
