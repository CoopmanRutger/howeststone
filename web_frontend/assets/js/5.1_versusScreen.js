'use strict';

document.addEventListener("DOMContentLoaded", init);

function init() {
    window.setTimeout(function () {
        fetch("http://localhost:4242/API/versusScreen", {
        }).then(function (res) {
            console.log(res);
        }).then(function () {
            window.location.href = "6_gameStartingHand.html";
        });
    },1500);
}