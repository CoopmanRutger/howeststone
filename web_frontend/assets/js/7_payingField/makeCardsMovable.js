"use strict";

let original;
let moving;

let diffX;
let diffY;

function cardMousedown(e) {
    e.preventDefault();

    console.log("clicked");

    original = this; // this is de trigger van het event, in dti geval de kaart

    // e.clientX of Y is het coödrinaat van de plaats waar het event plaats nam
    // original.ofset is de afstand van het geklikte element tot de rand ( boven en links)
    diffX = e.clientX - original.offsetLeft;
    diffY = e.clientY - original.offsetTop;

    moving = original.cloneNode(true); // de methode element.cloneNode() returned een copy van je element

    // hier heb je dus 2 kaarten, moving en original, original inj deck, en moving onder je muis

    moving.style.position = "absolute";
    moving.style.left = (e.clientX - diffX) + "px";
    moving.style.top = (e.clientY - diffY) + "px";

    original.style.visibility = "hidden"; // optioneel, als je dit wil kan je de originele kaart verbergen tijdens het slepen, dan lijkt het alsof je hem mee pakt

    document.querySelector("body").appendChild(moving);
}

function cardMouseup(e) {
  e.preventDefault();
  try {
    // let card = moving.cloneNode(true);
    moving.style.position = "";

    controller(e.clientX, e.clientY, moving);

    original.remove();

    document.removeEventListener('mouseup', cardMouseup)
  } catch (e) {}
}

function cardMousemove(e) {
  e.preventDefault();
  try {
      moving.style.left = (e.clientX - diffX) + "px";
      moving.style.top = (e.clientY - diffY) + "px";
  } catch (e) {}
}

function makeMovable(elements, controller) {

    /* HOW IT WORKS
    Eerst wordt het originele elements op onzichtbaar gezet.
    Dan wordt een kopie gemaakt die geplakt wordt aan het einde van het document.
    Die copy volgt (met absolute positioning) je muis.
    als je die copy loslaat wordt die verwijderd
    daarna zorgt de controller-functie dat het originele element op de juiste plaats wordt toegevoegd.
    als laatste actie wordt de state gereset (style enzo)
    */

    for (let i = 0; i < elements.length; i++) {
        elements[i].addEventListener('mousedown', cardMousedown);
    }
}
