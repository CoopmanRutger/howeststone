"use strict";

document.addEventListener("DOMContentLoaded", init);

function init(){

    manaCrystal(player);
    manaCrystal(opponent);

    hero(opponent);
    hero(player);
    cardsInHandOpponent(opponent.arrayCardsInHand);

    fetchCards();
    // fetchPromise komt uit 4_fetchCardsFunctions
    fetchPromise.then(function () {
        injectCards(player.arrayCardsInHand);

        let elements = document.querySelectorAll(".cardHand")
        for (let i = 0; i < elements.length; i++) {
            elements[i].addEventListener("mousedown", cardMousedown);
            elements[i].addEventListener("mouseenter", cardOnmouseEnter);
            elements[i].addEventListener("mouseleave", cardOnmouseLeave);
        }
    });
    // makeMovable shit
    document.addEventListener('mousemove', cardMousemove);
    document.addEventListener("mouseup", cardMouseup);

    document.querySelector('.concede').addEventListener('click', concede);
    document.querySelector('.settings').addEventListener('click', settings);

    endTurn(true);
    document.querySelector('.endTurn').addEventListener('click', endTurnClickable);
}


function endTurnClickable(e) {
    endTurn(false);
}




function concede(e) {
e.preventDefault();
window.location.href = "10_concede.html"

return false; ;
}


function settings(e) {
e.preventDefault();
window.location.href = "11_settingsPlayField.html"

return false; ;
}
