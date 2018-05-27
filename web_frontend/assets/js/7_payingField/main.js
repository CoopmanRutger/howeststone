"use strict";

document.addEventListener("DOMContentLoaded", init);

let possibleTargets = document.getElementById("cardsOnFieldOpponent").children;
let possibleAttackers = document.getElementById("cardsOnFieldPlayer").children;
let possibleAbility = document.getElementById("cardsOnFieldPlayer").children;

function init(){
	fetch("http://localhost:4242/API/playingField/getGameState", {
		}).then(function (res) {
		return res.json();
		}).then(function (res) {
		console.log(res);

		if (res.isOpponent) {
			sendBot();
		} else {
			update();
		}
	})
	document.getElementById('endTurn').addEventListener("click", sendPlayerCommit)
}

function sendPlayerCommit(e) {
	if (!isOpponent) { //moet true zijn alst je beurt is
		fetch("http://localhost:4242/API/playingField/commitPlayer",{
			method : "get",
		}).then(function (result) {
			console.log("Twas aan ons ma nu nie meer!");
			update();
			return result.text();
		}).then(function (result) {
			if (result === "stop") {
				update();
				if (opponent.lifepoints <= 0) {
					window.alert("You won!");
				} else {
					window.alert("You lose!");
				}
				window.location.href = "1_deckbuildOrPlay.html";
			}
		}).then(sendBot)
	}
}

function sendBot() {
	fetch("http://localhost:4242/API/playingField/bot",{
		method : "get",
	}).then(sendOpponentCommit)
}

function sendOpponentCommit() {
	fetch("http://localhost:4242/API/playingField/commitOpponent",{
		method : "get",
	}).then(function (result) {
		console.log("Twas aan undr ma nu nie meer!");
		update();
		return result.text();
	}).then(function (result) {
		if (result === "stop") {
			update();
			if (player.lifepoints <= 0) {
				window.alert("You won!");
			} else {
				window.alert("You lose!!");
			}
			window.location.href = "1_deckbuildOrPlay.html";
		}
	})
}
