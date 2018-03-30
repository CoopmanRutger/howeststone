"use strict";

function cardController(X,Y, element, original, origin) {
    let index;
    let cardJson;

    index = getIndex(original,"#cardsInHandPlayer");
    cardJson = player.arrayCardsInHand[index];
    
    switch (getPlace(X,Y)) {
        case "#cardsOnFieldPlayer":
        console.log("cardsOnFieldPlayer");
        if (player.arrayCardsOnField.length<7) {
            element.remove();
            original.remove();

            player.arrayCardsOnField.push(cardJson);
            player.arrayCardsInHand.splice(player.arrayCardsInHand.indexOf(cardJson), 1);

            showCardField(cardJson,"#cardsOnFieldPlayer");
            break;
        }
        case "#cardsInHandPlayer":
        console.log("cardsInHandPlayer");

        original.style.position = "";
        original.style.visibility = "visible";

        element.remove();
        break;
        default:
            console.log("weird case");
    }
}

function getIndex(element, query) {
   let array = document.querySelector(query).children;
   for (let i = 0; i < array.length; i++) {
       if (array[i].firstChild.innerHTML===element.firstChild.innerHTML) {
           return i;
       }
   }
   return -1;
}

function getPlace(X, Y) {
   if (Y < 500) {
       return "#cardsOnFieldPlayer";
   } else {
       return "#cardsInHandPlayer";
   }
}
