/* Order Of Functions

Document gets loaded
cards get fetched
we go in to the init

*/

"use strict";

document.addEventListener("DOMContentLoaded", fetchCards);

// initializing card arrays



// After fetch we go to the init

function init(){
  console.log("page loaded, arrived in ftie init");
  injectCards();
}

// In the init we caal "injectCards"
// injectCards inject cards from our arrays in to the proper html elements
// We use "showCardsHand" to get the cards in to out html

function injectCards() {
  function showCardsHand(array, query) {
    for (let i = 0; i < array.length; i++) {
      let card = document.createElement('article');

      card.className = "card";
      card.style.backgroundImage = "url('" + array[i].img + "')";

      let meta = document.createElement('p');

      meta.style.display = "none";
      meta.appendChild(document.createTextNode(array[i].cardId));

      card.appendChild(meta)

      document.querySelector(query).appendChild(card);
    }
  }

  showCardsHand(cards.Basic, "#generalCards .cards");
  showCardsHand(cards.Specific, "#specificCards .cards");

  let elements = document.querySelectorAll('.card');
  makeMovable(elements,cardController);
}

// in "injectCards" we call the function "makeMovable" wich alows cards to be moved

function makeMovable(elements,controller) {

  /* HOW IT WORKS
  Eerst wordt het originele element op onzichtbaar gezet.
  Dan wordt een kopie gemaakt die geplakt wordt aan het einde van het document.
  Die copy volgt (met absolute positioning) je muis.
  als die copy loslaat wordt die verwijderd
  daarna zorgt de controller-functie dat het originele element op de juiste plaats wordt toegevoegd.
  als laatste actie wordt de staat gereset (style enzo)
  */

  let original;
  let moving;

  let diffX;
  let diffY;

  function mouseup(e) {
    e.preventDefault();
    let card = moving.cloneNode(true);

    card.style.position = "";

    controller(e.clientX, e.clientY, card);

    moving.remove();

    document.removeEventListener('mouseup', mouseup)
  }

  document.addEventListener('mousemove', function (e) {
    e.preventDefault();
    try {
      moving.style.left = (e.clientX-diffX) + "px";
      moving.style.top = (e.clientY-diffY) + "px";
    } catch (e) {}
  });

  function mousedown(e) {
    e.preventDefault();

    console.log(this.parentElement.scrollTop );

    diffX = e.clientX-this.offsetLeft + this.parentElement.scrollLeft;
    diffY = e.clientY-this.offsetTop + this.parentElement.scrollTop;

    moving = this.cloneNode(true);

    moving.style.position = "absolute";
    moving.style.left = (e.clientX-diffX) + "px";
    moving.style.top = (e.clientY-diffY) + "px";

    original = this;

    document.querySelector("body").appendChild(moving);

    document.addEventListener("mouseup", mouseup);

  }

  for (let i = 0; i < elements.length; i++) {
    elements[i].addEventListener('mousedown', mousedown);
  }
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
