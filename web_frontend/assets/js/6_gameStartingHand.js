'use strict';

document.addEventListener("DOMContentLoaded", init);

let divToGetPics = document.getElementById("muhDiv").children;
let cardsToStartingHand = [];

function init() {
	document.getElementById("confirm").addEventListener("click", comfirm);

	for (let i = 0; i < divToGetPics.length; i++) {
		divToGetPics[i].addEventListener('click', toRemoveCards);
	}

	fetch("http://localhost:4242/API/gameStartingHand/initializingGame").then(update)
}

function toRemoveCards(e) {
	if (this.className === "yourStartingHand") {
		this.className = "chosen";
	} else {
		this.className = "yourStartingHand";
	}
}

function update() {
	fetch("http://localhost:4242/API/playingField/getGameState").then(function (res) {
		return res.json();
	}).then(function (res) {
		console.log(res);
		let test = res.player.cardsInHand.cards;
		for (let i = 0; i < test.length; i++) {
			divToGetPics[i].style.backgroundImage = "url(\"" + res.player.cardsInHand.cards[i].img + "\")";
			divToGetPics[i].id = res.player.cardsInHand.cards[i].cardId;
		}
	})
}

function comfirm(e) {
	let card;
	for (card of divToGetPics) {
		if (card.className === "chosen") {
			cardsToStartingHand.push(card.id);
		}
	}
	sendStartingHand(cardsToStartingHand)
}

function sendStartingHand(cardsToStartingHand) {
	return fetch("http://localhost:4242/API/gameStartingHand/remove",{
		method : "post",
		body : JSON.stringify(cardsToStartingHand)
	}).then(function () {
		window.location.href = "7_playingField.html";
	});
}
