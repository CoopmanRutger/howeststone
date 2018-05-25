"use strict";

document.addEventListener("DOMContentLoaded", init);

let possibleTargets = document.getElementById("cardsOnFieldOpponent").children;
let possibleAttackers = document.getElementById("cardsOnFieldPlayer").children;

function init(){
    update();
	document.getElementById('endTurn').addEventListener("click", sendCommit)
}

function sendCommit(e) {
	// console.log("sending commit");
	if (!isOpponent) { //moet true zijn alst je beurt is
		fetch("http://localhost:4242/API/playingField/commit",{
			method : "get",
		}).then(function () {
			console.log("Twas aan ons ma nu nie meer!");
			update();
		}).then(function () {
			fetch("http://localhost:4242/API/playingField/commitOpponent",{
				method : "get",
			}).then(function () {
				console.log("Twas aan undr ma nu nie meer!");
				update();
			})
		})
	}
}
