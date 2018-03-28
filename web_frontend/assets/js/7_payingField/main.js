"use strict";

document.addEventListener("DOMContentLoaded", init);

function init(){
  // TODO: functis samen smijten
    endTurn(true);
    manaCystalOpponent(manaChargeOpponent, manaLimitOpponent);
    manaCrystal(manaCharge, manaLimit);
    heroOpponent(heroWeaponOpponent, weaponAttackOpponent, weaponTurnsOpponent, heroNameOpponent, amountShieldOpponent, lifepointsOpponent);
    hero(heroWeapon, weaponAttack, weaponTurns, heroName, amountShield, lifepoints);
    cardsInHandOpponent(arrayCardsInHandOpponent);
    fetchCards();
  // fetchPromise komt uit 4_fetchCardsFunctions
  fetchPromise.then(function () {
    // TODO: injectCards
  }

  // makeMovable shit
  document.addEventListener('mousemove', cardMousemove);
  document.addEventListener("mouseup", mouseup);
}

function cardController(X, Y, original) {
  if (Y < 800) {
      // TODO: LOUIS hand.appendChild(original)
  } else {
    let out = document.querySelector(".cardsOnField");
  }
}
