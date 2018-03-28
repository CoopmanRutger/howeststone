"use strict";

function injectCards(arrayOfCards) {
    for (let i = 0; i < arrayOfCards.length; i++) {
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
    let name = document.createElement("div");

    name.className = "cardName";
    let title = document.createElement("h2");
    lol.appendChild(document.createTextNode(card.name));
    name.appendChild(title);

    element.appendChild(name);

    // attack tag
     let attack = document.createElement("div");

    attack.className = "cardAttack";
    attack.appendChild(document.createTextNode(card.attack));

    element.appendChild(attack);

    // health tag
     let health = document.createElement("div");

    health.className = "cardHealth";
    health.appendChild(document.createTextNode(card.health));

    element.appendChild(health);
}

function showCardHand(card) {
    let startposition = 420;
    let spaceBetweenCards = 20;

    let element = document.createElement('article');
    let meta = document.createElement('p');

    meta.style.display = "none";
    meta.appendChild(document.createTextNode(card.cardId));
    element.appendChild(meta);

    element.className = "card";
    element.style.backgroundImage = "url('" + card.img + "')";
    element.style.top = 20 + "px";
    element.style.left = (card.i * spaceBetweenCards + startposition) + 'px';

    document.querySelector(".cardsInHand").appendChild(element);
}
