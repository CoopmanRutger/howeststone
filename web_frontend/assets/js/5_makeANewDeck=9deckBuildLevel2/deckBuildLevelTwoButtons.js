"use strict";

document.addEventListener("DOMContentLoaded", init);

function init(){
	loadButtons();
	document.getElementById('deckbuildLevelOneButtons').addEventListener('click', nextScreen6);
	document.getElementById('refreshButton').addEventListener('click', refreshScreen);
	document.getElementById('saveAndPlayButton').addEventListener('click', nextScreen7);
}

function nextScreen6(e){
	e.preventDefault();
	console.log("i'm here now");
	window.location.href="8_deckbuildLevelOne.html";
}

function nextScreen7(e){
	e.preventDefault();
	console.log("i'm here now");
	window.location.href = "4_defaultPickYourOpponent.html"
}

function refreshScreen(e){
	e.preventDefault();
	location.reload();
}

function loadButtons(){
	document.querySelector('footer').innerHTML += "<button id=\"deckbuildLevelOneButtons\" class=\"return\" type=\"button\">Back</button>"+
	"<button id=\"refreshButton\" type=\"button\">Cancel</button>" +
	"<button id=\"saveDeck\" type=\"button\">Save deck</button>" +
	"<button id=\"saveAndPlayButton\" type=\"button\">Save & Play deck</button>";
}
