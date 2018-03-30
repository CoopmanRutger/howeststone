'use strict';

function cardOnmouseEnter (e) {
    e.preventDefault();
    document.querySelector("#cardPreview").appendChild(this.cloneNode());
}

function cardOnmouseLeave (e) {
    e.preventDefault();
    document.querySelector("#cardPreview").innerHTML = '';
}
