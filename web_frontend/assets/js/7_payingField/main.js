"use strict";

document.addEventListener("DOMContentLoaded", init);

function init(){
    update();

    // makeMovable shit
}

function sendCommit(id) {
	if (!isOpponent) { //moet true zijn alst je beurt is
		fetch("http://localhost:4242/API/playingField/commit",{
			method : "get",
		}).then(function (res) {
				return res.text();
		}).then(function () {
			console.log("Twas aan ons ma nu nie meer!");
			update();
		})
	} else {
		fetch("http://localhost:4242/API/playingField/commit",{
			method : "get",
		}).then(function (res) {
				return res.text();
		}).then(function () {
			console.log("Twas aan undr ma nu nie meer!");
			update();
		})
	}
}
