"use strict";

function injectCards(arrayOfCards, query) {
    for (let i = 0; i < arrayOfCards.length; i++) {
        showCardHand(arrayOfCards[i], query)
    }
}

function showCardHand(card, query) {
    let element = document.createElement('article');
    let meta = document.createElement('p');

    meta.style.display = "none";
    meta.appendChild(document.createTextNode(card.cardId));
    element.appendChild(meta);

    element.className = "card";
    element.style.backgroundImage = "url('" + card.img + "')";
    element.style.top = 20 + "px";

    document.querySelector(query).appendChild(element);
}
