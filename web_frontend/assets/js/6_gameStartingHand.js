'use strict';

document.addEventListener("DOMContentLoaded", init);

function init() {
    document.getElementById("confirm").addEventListener("click", function () {
        window.location.href = "7_playingField.html";
    })
    fetch("http://localhost:4242/API/gameStartingHand/initializingGame")
}
