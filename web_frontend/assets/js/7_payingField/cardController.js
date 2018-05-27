"use strict";

function cardController(X,Y, element, original, origin) {
	let index;
	let cardJson;

	index = getIndex(original,"#cardsInHandPlayer");
	cardJson = player.arrayCardsInHand[index];

	let place = getPlace(X,Y);

	if (place === "#cardsOnFieldPlayer" && player.arrayCardsOnField.length < 7) {
		sendPlayCard(cardJson.cardId)
		element.remove();
		original.remove();
		element = null;
	} else {
		element.remove();
		update();
	}
}

function getIndex(element, query) {
	let array = document.querySelector(query).children;
	for (let i = 0; i < array.length; i++) {
		if (array[i].firstChild.innerHTML===element.firstChild.innerHTML) {
			return i;
		}
	}
	return -1;
}

function getPlace(X, Y) {
	if (Y < 500) {
		return "#cardsOnFieldPlayer";
	} else {
		return "#cardsInHandPlayer";
	}
}

function sendPlayCard(id) {
	return fetch("http://localhost:4242/API/playingField/playedCard",{
		method : "post",
		body : JSON.stringify(id)
	}).then(function (res) {
		update();
	});
}
