"use strict";

function injectCards(arrayOfCards) {
    for (let i = 0; i < 3; i++) {
        showCardHand(arrayOfCards[i])
    }
}

function showCardField(card, side) {

    if (side = "#cardsOnFieldPlayer") {
        
    }
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
    document.querySelector(side).appendChild(element);


    // name tag
    let name = document.createElement("div");

    name.className = "cardName";
    let title = document.createElement("h2");
    title.appendChild(document.createTextNode(card.name));
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

    element.className = "cardHand";
    element.style.backgroundImage = "url('" + card.img + "')";
    // element.style.top = 20 + "px";
    // element.style.left = (card.i * spaceBetweenCards + startposition) + 'px';
    document.querySelector("#cardsInHandPlayer").appendChild(element);
}
