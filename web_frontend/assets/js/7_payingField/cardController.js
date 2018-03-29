"use strict";

function cardController(X,Y, element, original, origin) {
    console.log("controller");

    let index;
    let cardJson;

    index = getIndex(original,"#cardsInHandPlayer");
    cardJson = player.arrayCardsInHand[index];
    switch (getPlace(X,Y)) {
        case "#cardsInHandPlayer":
            console.log("cardsInHandPlayer");
            original.style.position = "";
            original.style.visibility = "visible";
            element.remove();
            break;
        case "#cardsOnFieldPlayer":
        console.log("cardsOnFieldPlayer");
            element.remove();
            original.remove();
            player.arrayCardsOnField.push(cardJson);
            console.log("volledige array", player.arrayCardsInHand);
            console.log("card",cardJson);
            console.log("index van die kaart", player.arrayCardsInHand.indexOf(cardJson));
            console.log(player.arrayCardsInHand[player.arrayCardsInHand.indexOf(cardJson)]);
            console.log(player.arrayCardsInHand[1]);
            player.arrayCardsInHand.splice(player.arrayCardsInHand.indexOf(cardJson), 1);
            showCardField(cardJson);
            break;
        default:
            console.log("weird case");

}}

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

function getPlace(X, Y) {
   if (Y < 600) {
       return "#cardsOnFieldPlayer";
   } else {
       return "#cardsInHandPlayer";
   }
}
