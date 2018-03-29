"use strict";

document.addEventListener("DOMContentLoaded", init);

function init(){
  console.log("page loaded, arrived in ftie init");
  fetchCards();
  fetchPromise.then(function () {
      injectCards(cards.Basic, "#generalCards .cards");
      injectCards(cards.Specific, "#specificCards .cards");
      makeMovable(document.querySelectorAll(".card"));
      document.addEventListener('mousemove', cardMousemove);
      document.addEventListener("mouseup", cardMouseup);
  });
}
