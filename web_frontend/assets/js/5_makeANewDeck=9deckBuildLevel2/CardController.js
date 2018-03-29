"use strict";

function cardController(X,Y, element, original, origin) {
    console.log("controller");

    let cardJson;
    let isInHand = false;

    let indexBasic = getIndex(element, "#specificCards .cards");
    let fullBasic = haveDouble(cards.Basic[indexBasic]);

    let indexSpecific = getIndex(element, "#generalCards .cards");
    let fullSpecific = haveDouble(cards.Specific[indexSpecific]);

    // console.log("indexBasic", indexBasic);
    // console.log("indexSpecific", indexSpecific);

    if (indexBasic !== -1){
        cardJson = cards.Basic[indexBasic]
    } else if (fullSpecific !== -1){
        cardJson = cards.Specific[indexSpecific]
    }

    if (origin==="#cardsForDeck .cards") {
        console.log("element came from hand");
        original.remove();
        cardsInhand.splice(cardsInhand.indexOf(cardJson), 1);
    } else {
        console.log("element came from choices");
        switch (getPlace(X,Y)) {
            case "#cardsForDeck .cards":
                if (!fullBasic||fullSpecific) {
                    element.addEventListener('mousedown', cardMousedown);
                    document.querySelector("#cardsForDeck .cards").appendChild(element);
                    cardsInhand.push(cardJson);
                } else {
                    element.remove();
                }
                break;
            case "#specificCards .cards":
                document.querySelector("#specificCards .cards").appendChild(element);
                break;
            case "#generalCards .cards":
                document.querySelector("#specificCards .cards").appendChild(element);
                break;
            default:
                console.log("weird case");
        }
    }
    console.log(cardsInhand);
}

function getIndex(element, query) {
    console.log("getting index");
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

function getPlace(X, Y) {
    if (X < document.querySelector("#generalCards").offsetLeft) {
        return "#cardsForDeck .cards";
    }else if (Y < document.querySelector("#generalCards").offsetTop) {
        return "#specificCards .cards";
    } else {
        return "#generalCards .cards";
    }
}
