"use strict";

console.log("We arived in the makeCardsMovable file!");

let original;
let moving;
let origin;

let diffX;
let diffY;

function cardMousedown(e) {
	e.preventDefault();

	origin = getPlace(e.clientX, e.clientY);

	original = this; // this is de trigger van het event, in dit geval de kaart

	let rect = original.getBoundingClientRect();

	diffX = e.clientX - rect.left;
	diffY = e.clientY - rect.top;

	moving = original.cloneNode(true); // de methode element.cloneNode() returned een copy van je element

	// hier heb je dus 2 kaarten, moving en original, original inj deck, en moving onder je muis

	moving.style.position = "absolute";
	moving.style.left = (e.clientX - diffX) + "px";
	moving.style.top = (e.clientY - diffY) + "px";

	if (origin === "#cardsForDeck .cards") {
		original.style.visibility = "hidden"; // optioneel, als je dit wil kan je de originele kaart verbergen tijdens het slepen, dan lijkt het alsof je hem mee pakt
	}

	document.querySelector("body").appendChild(moving);
}

function cardMousemove(e) {
	e.preventDefault();
	try {
		moving.style.left = (e.clientX - diffX) + "px";
		moving.style.top = (e.clientY - diffY) + "px";
	} catch (e) {}
}

function cardMouseup(e) {
	e.preventDefault();
	try {
		moving.style.position = "";

		cardController(e.clientX, e.clientY, moving, original, origin);
	} catch (e) {}
}

function makeMovable(elements) {

	console.log("makeMovable function");

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
