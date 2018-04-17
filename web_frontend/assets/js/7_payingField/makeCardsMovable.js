"use strict";

let original;
let moving;

let diffX;
let diffY;

function cardMousedown(e) {
    e.preventDefault();

    origin = getPlace(e.clientX, e.clientY);
    original = this;

    let rect = original.getBoundingClientRect();

    diffX = e.clientX - rect.left - 40;
    diffY = e.clientY - rect.top;

    moving = original.cloneNode(true);

    moving.style.position = "absolute";
    moving.style.left = (e.clientX - diffX) + "px";
    moving.style.top = (e.clientY - diffY) + "px";

    original.style.visibility = "hidden"

    document.querySelector("body").appendChild(moving);
}

function cardMouseup(e) {
   e.preventDefault();
   try {
       // let card = moving.cloneNode(true);
       moving.style.position = "";

       cardController(e.clientX, e.clientY, moving, original, origin);
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
