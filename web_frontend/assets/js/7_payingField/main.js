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
		}).then(function (result) {
			console.log("Twas aan ons ma nu nie meer!");
			update();
            return result.text();
		}).then(function (result) {
            if (result === "stop") {
                if (player.lifepoints <= 0) {
                    window.alert("You lose!")
                } else {
                    window.alert("You won!!")
                }
            }

        }).then(function () {
			fetch("http://localhost:4242/API/playingField/bot",{
				method : "get",
			}).then(function () {
                fetch("http://localhost:4242/API/playingField/commitOpponent",{
                    method : "get",
                }).then(function (result) {
                    console.log("Twas aan undr ma nu nie meer!");
                    update();
                    return result.text();
                }).then(function (result) {
                    console.log(result);
                    if (result === "stop") {
                        if (player.lifepoints <= 0) {
                            window.alert("You lose!")
                        } else {
                            window.alert("You won!!")
                        }
                    }

                })
			})
		})
	}
}
