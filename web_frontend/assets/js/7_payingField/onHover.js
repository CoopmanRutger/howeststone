'use strict';

function cardOnmouseEnter (e) {
    e.preventDefault();
    let preview = this.cloneNode();
    preview.className = "cardPreview";
    document.querySelector("#cardPreview").appendChild(preview);
}

function cardOnmouseLeave (e) {
    e.preventDefault();
    document.querySelector("#cardPreview").innerHTML = '';
}
