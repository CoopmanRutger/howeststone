"use strict";

document.addEventListener("DOMContentLoaded", init);

function init(){
  console.log("page loaded, arrived in ftie init");
  fetchCards();
  fetchPromise.then(function () {
      injectCards(cards.Basic, "#generalCards");
      injectCards(cards.Specific, "#specificCards");
  });
}

// in de makeMovable we give an "controller" function, this determens what happens whith the card when we relaese it

function cardController(X,Y, element) {
  let index;
  let cardJson;

  index = getIndex(element, "#specificCards .cards");
  let fullB = haveDouble(cards.Basic[index]);
  // console.log("controller index1",index);
  // console.log("controller haveDouble",fullB);

  if (index !== -1){
    cardJson = cards.Basic[index]
  }

  index = getIndex(element, "#generalCards .cards");
  let fullS = haveDouble(cards.Basic[index]);
  // console.log("controller index1",index);
  // console.log("controller haveDouble",fullS);

  if (index !== -1){
    cardJson = cards.Specific[index]
  }

  // console.log(cardJson);

  if (!fullB||fullS) {
    if (X < document.querySelector("#generalCards").offsetLeft) {
      document.querySelector("#cardsForDeck .cards").appendChild(element);
      cardsInhand.push(cardJson);
    } else if (Y < document.querySelector("#generalCards").offsetTop){
      document.querySelector("#specificCards .cards").appendChild(element);
    } else {
      document.querySelector("#generalCards .cards").appendChild(element);
    }
  }
}

// help functions

function getIndex(element, query) {
  let array = document.querySelector(query).children;
  for (let i = 0; i < array.length; i++) {
    if (array[i].firstChild.innerHTML===element.firstChild.innerHTML) {
      return i;
    }
  }
  return -1;
}

function haveDouble(card) {
  if (cardsInhand.indexOf(card)===cardsInhand.lastIndexOf(card)) {
    return false;
  } else {
    return true;
  }
}
