"use strict";

document.addEventListener("DOMContentLoaded", init);

function init(){
    update();
    endTurn(true);


    // makeMovable shit
    document.addEventListener('mousemove', cardMousemove);
    document.addEventListener("mouseup", cardMouseup);

    fetch("http://localhost:4242/API/playingField/getGameState", {
    }).then(function (res) {
        return res.Json;
    }).then(function (res) {
        console.log("fetched gamestate");
        console.log(res);
    });
}
