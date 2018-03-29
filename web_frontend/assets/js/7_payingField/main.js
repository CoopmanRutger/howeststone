"use strict";

document.addEventListener("DOMContentLoaded", init);

function init(){
  // TODO: functis samen smijten
    endTurn(true);

    manaCrystal(player);
    manaCrystal(opponent);

    hero(player);
    hero(opponent);

    cardsInHandOpponent(opponent.arrayCardsInHand);

    fetchCards();
  // fetchPromise komt uit 4_fetchCardsFunctions
  fetchPromise.then(function () {
      injectCards(opponent.arrayCardsInHand);
  });
  // makeMovable shit
  document.addEventListener('mousemove', cardMousemove);
  document.addEventListener("mouseup", mouseup);

}

function cardController(X, Y, original) {
  if (Y < 800) {
    document.querySelector(".cardsInHand").appendChild(original);
  } else {
    document.querySelector(".cardsOnField").appendChild(original);
  }
}
