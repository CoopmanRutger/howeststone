"use strict"
document.addEventListener("DOMContentLoaded", init);

document.addEventListener("DOMContentLoaded", init);

function init() {
	getPlayerHeroNameOutJava()
	getOpponentHeroNameOutJava();
	window.setTimeout(moveForward,1500);
}

function moveForward() {
	fetch("http://localhost:4242/API/versusScreen", {
	}).then(function (res) {
		console.log(res);
	}).then(function () {
		window.location.href = "6_gameStartingHand.html";
	});
}

function setPlayerHeroPicture(heroname) {
	document.querySelector('#playerHeroPicture').innerHTML += "<img src='/web_frontend/assets/media/hero_" + heroname
	+ ".jpg' alt='hero_" + heroname  + ".jpg'>";
}

function setOpponetHeroPicture(heroname) {
	document.querySelector('#opponentHeroPicture').innerHTML += "<img src='/web_frontend/assets/media/hero_" + heroname
	+ ".jpg' alt='hero_" + heroname  + ".jpg'>";
}


function getPlayerHeroNameOutJava() {
	fetch("http://localhost:4242/API/deckbuildOrPlay/chooseYourHero/chooseDeckForHero/getHeroName", {
		method: 'get',
		headers: new Headers({
			"Accept": "text/plain"
		})
	}).then(function (response) {
		console.log(response);
		return response.text();
	}).then(function (res) {
		console.log(res);
		let heroname = res.toLowerCase();
		setPlayerHeroPicture(heroname)
	})
}

function getOpponentHeroNameOutJava() {
	fetch("http://localhost:4242/API/pickYourOpponent/getHeroName", {
		method: 'get',
		headers: new Headers({
			"Accept": "text/plain"
		})
	}).then(function (response) {
		console.log(response);
		return response.text();
	}).then(function (res) {
		console.log(res);
		let heroname = res.toLowerCase();
		setOpponetHeroPicture(heroname);
	})
}
