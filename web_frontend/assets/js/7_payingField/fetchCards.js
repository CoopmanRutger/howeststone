"use strict";

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
            // console.log(text);
            // TODO: make functions vo deze shit

            for (let i = 0; i < text.Basic.length; i++) {
                let card = {
                    "cardId": text.Basic[i].cardId,
                    "attack": text.Basic[i].attack,
                    "health": text.Basic[i].health,
                    "name": text.Basic[i].name,
                    "img": text.Basic[i].img,
                    "i": i
                };
                arrayCardsInHand.push(card);
            }
            for (let i = 0; i < text.Classic.length; i++) {
                let card = {
                    "cardId": text.Classic[i].cardId,
                    "attack": text.Classic[i].attack,
                    "health": text.Classic[i].health,
                    "name": text.Classic[i].name,
                    "img": text.Classic[i].img,
                    "i": i + text.Basic.length
                };
                arrayCardsInHand.push(card);
            }
        }
    );
}
