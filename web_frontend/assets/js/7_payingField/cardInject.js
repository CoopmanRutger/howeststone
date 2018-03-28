"use strict";

function injectCards(arrayOfCards) {
    for (let i = 0; i < 3; i++) {
        console.log(arrayOfCards[i]);
        showCardField(arrayOfCards[i])
    }

    let elements = document.querySelectorAll('.card');
    makeMovable(elements, cardController)
}

function showCardField(card) {
    //main card

    let startposition = 420;
    let spaceBetweenCards = 20;
    let element = document.createElement("div");
    let meta = document.createElement('p');

    meta.style.display = "none";
    meta.appendChild(document.createTextNode(card.cardId));
    element.appendChild(meta);

    element.className = "card";
    element.style.backgroundImage = "url('" + card.img + "')";
    element.style.top = 20 + "px";
    element.style.left = (card.i * spaceBetweenCards + startposition) + 'px';
    document.querySelector(".cardsInHand").appendChild(element);


    // name tag
    element = document.createElement("div");
    element.className = "cardName";
    let lol = document.createElement("h2");
    lol.appendChild(document.createTextNode(card.name));
    element.appendChild(lol);
    document.querySelector(".cardsInHand").lastChild.appendChild(element);

    // attack tag
    element = document.createElement("div");
    element.className = "cardAttack";
    element.appendChild(document.createTextNode(card.attack));
    document.querySelector(".cardsInHand").lastChild.appendChild(element);

    // health tag
    element = document.createElement("div");
    element.className = "cardHealth";
    element.appendChild(document.createTextNode(card.health));
    document.querySelector(".cardsInHand").lastChild.appendChild(element);
}
// TODO: making af showCardHand function LOUIS
