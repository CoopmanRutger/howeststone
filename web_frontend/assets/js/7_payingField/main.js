"use strict";

document.addEventListener("DOMContentLoaded", init);

function init(){
    endTurn(true);

    manaCrystal(player);
    manaCrystal(opponent);

    hero(opponent);
    hero(player);
    console.log(hero(player));
    cardsInHandOpponent(opponent.arrayCardsInHand);

    fetchCards();
    // fetchPromise komt uit 4_fetchCardsFunctions
    fetchPromise.then(function () {
        injectCards(player.arrayCardsInHand);
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
