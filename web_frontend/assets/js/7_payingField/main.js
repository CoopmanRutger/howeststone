"use strict";

document.addEventListener("DOMContentLoaded", init);

function init(){
    endTurn(true);

    manaCrystal(player);
    manaCrystal(opponent);

    hero(opponent);
    hero(player);
    cardsInHandOpponent(opponent.arrayCardsInHand);

    fetchCards();
    // fetchPromise komt uit 4_fetchCardsFunctions
    fetchPromise.then(function () {
        console.log(player);
        injectCards(player.arrayCardsInHand);
        let elements = document.querySelectorAll(".cardHand")
        console.log(elements);
        for (let i = 0; i < elements.length; i++) {
            console.log(elements[i]);
            elements[i].addEventListener("mousedown", cardMousedown)
        }
    });
    // makeMovable shit
    document.addEventListener('mousemove', cardMousemove);
    document.addEventListener("mouseup", cardMouseup);
}

function cardController(X, Y, original) {
    if (Y < 800) {
        document.querySelector("#cardsInHand").appendChild(original);
    } else {
        document.querySelector("#cardsOnField").appendChild(original);
    }
}
