"use strict";

function cardController(X,Y, element) {
    console.log("controller");

    let index;
    let cardJson;

    index = getIndex(element, "#specificCards .cards");
    console.log("index is =",index);
    let fullBasic = haveDouble(cards.Basic[index]);
    // console.log("controller index1",index);
    // console.log("controller haveDouble",fullBasic);

    if (index !== -1){
        cardJson = cards.Basic[index]
    }

    index = getIndex(element, "#generalCards .cards");
    console.log("index is =",index);
    let fullSpecific = haveDouble(cards.Basic[index]);
    // console.log("controller index1",index);
    // console.log("controller haveDouble",fullSpecific);

    if (index !== -1){
        cardJson = cards.Specific[index]
    }

    // console.log(cardJson);

    if (!fullBasic||fullSpecific) {
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

function getIndex(element, query) {
    console.log("getting index");
    console.log();
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
