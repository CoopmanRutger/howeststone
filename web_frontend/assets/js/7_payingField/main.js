"use strict";

document.addEventListener("DOMContentLoaded", init);

function init(){
    update();
    endTurn(true);

    // makeMovable shit
    document.addEventListener('mousemove', cardMousemove);
    document.addEventListener("mouseup", cardMouseup);
}
