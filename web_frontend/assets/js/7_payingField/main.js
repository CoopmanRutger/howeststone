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
        injectCards(player.arrayCardsInHand);

        let elements = document.querySelectorAll(".cardHand");
        for (let i = 0; i < elements.length; i++) {
            elements[i].addEventListener("mousedown", cardMousedown);
            elements[i].addEventListener("mouseenter", cardOnmouseEnter);
            elements[i].addEventListener("mouseleave", cardOnmouseLeave);
        }
    });
    // makeMovable shit
    document.addEventListener('mousemove', cardMousemove);
    document.addEventListener("mouseup", cardMouseup);

    fetch("/API/gameStartingHand/playingField", {
    }).then(function (res) {
        console.log(res);
    });
}
