"use strict";
let arrayHeroes = ["mage", "priest"];
document.addEventListener("DOMContentLoaded", init);
let arrayDecks = ["mage", "priest", "rouge"];

function init() {
    showHeroPic();
    showHeroes();

}

function showHeroes() {
    for (let j = 0; j < arrayHeroes.length; j++) {
        let hero = document.createElement("article");
        let heroName = document.createElement("h2");
        let heroImg = document.createElement("div");
        let heroList = document.createElement("li");


        let text = document.createTextNode(arrayHeroes[j].name);

        heroList.appendChild(hero);
        heroName.appendChild(text);

        heroImg.style.backgroundImage = "url('" + arrayHeroes[j].img + "')";

        document.querySelector(".heroes").appendChild(text);
        for (let i = 0; i < arrayHeroes[i].decks.length; i++) {
            let deck = document.createElement("article");
            let deckName = document.createElement("h2");
            let deckImg = document.createElement("div");
            let text = document.createTextNode(arrayHeroes[i].deck.name);

            deckName.appendChild(text);

            deckImg.style.backgroundImage = "url('" + arrayHeroes[i].deck.img + "')";

            document.querySelector(".decks").appendChild(text);

        }
    }
}

// function showHeroPic() {
//     for (let j = 0; j <= arrayHeroes.length; j++) {
//
//         let element = document.createElement("section");
//         let title = document.createElement("h2");
//         document.querySelector(".hero").appendChild(element);
//         element.style.backgroundImage = "url('images/hero_" + arrayHeroes[j] + ".png')";
//         title.appendChild(document.createTextNode(arrayHeroes[j]));
//
//
//         element.appendChild(title);
//         element.style.height = 50 + "px";
//         element.style.width = 50 + "px";
//     }
// }

function showDeck() {
    let element = document.createElement("section");
    let title = document.createElement("h3");

}

//
// function showDeck() {
//     let element = document.createElement("section");
//     let title = document.createElement("h3");
//
//     for (let j = 0; j <= arrayDecks.length; j++) {
//         if (arrayDecks[j] === arrayDecks[j]) {
//             if (arrayDecks[j] === arrayDecks[0]) {
//                 document.querySelector(".deck").appendChild(element);
//             } else if (arrayDecks[j] === arrayDecks[1]) {
//                 document.querySelector(".deck:nth-child(2)").appendChild(element);
//             } else if (arrayDecks[j] === arrayDecks[2]) {
//                 document.querySelector(".deck:last-child").appendChild(element);
//             }
//             element.style.backgroundImage = "url('images/hero_" + arrayDecks[j] + ".png')";
//             title.appendChild(document.createTextNode(arrayDecks[j]));
//         }
//
//         element.appendChild(title);
//         element.style.height = 50 + "px";
//         element.style.width = 50 + "px";
//     }
// }
