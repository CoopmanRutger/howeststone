"use strict";

let heroesAndDecks = [
    {"name":"penis",
"img":"blablabla",
"decks":
[{"name":"penis",
"img":"https://i.imgur.com/qbP37xZ.png"},
{"name":"penis",
"img":"https://i.imgur.com/qbP37xZ.png"},
{"name":"penis",
"img":"https://i.imgur.com/qbP37xZ.png"},
{"name":"penis",
"img":"https://i.imgur.com/qbP37xZ.png"},
{"name":"penis",
"img":"https://i.imgur.com/qbP37xZ.png"}]
},
{"name":"penis",
"img":"blablabla",
"decks":[{"name":"penis",
"img":"blablabla"}]
},
{"name":"penis",
"img":"blablabla",
"decks":[{"name":"penis",
"img":"blablabla"}]
},
{"name":"penis",
"img":"blablabla",
"decks":[{"name":"penis",
"img":"blablabla"}]
}
];

document.addEventListener("DOMContentLoaded", init);

function init() {
    injectHeroDecks();

    document.querySelector('.deck').addEventListener('click', deck);
}


function deck(e) {
e.preventDefault();
window.location.href = "5_makeANewDeck=9deckBuildLevel2.html";

return false;
}



function injectHeroDecks() {
    for (let i = 0; i < heroesAndDecks.length; i++) {
        console.log(heroesAndDecks[i]);

        let hero = document.createElement("li");
        hero.className = "hero";

        let decks = document.createElement("ul");
        decks.className = "decks";

        for (let j = 0; j < heroesAndDecks[i].decks.length; j++) {
            console.log(heroesAndDecks[i].decks[i]);
            let deck = document.createElement("li");
            deck.appendChild(showDeck(heroesAndDecks[i].decks[j].name, heroesAndDecks[i].decks[j].img));
            decks.appendChild(deck);
        }

        hero.appendChild(showHero(heroesAndDecks[i].name, heroesAndDecks[i].img));
        hero.appendChild(decks);

        document.querySelector(".heroes").appendChild(hero);
    }
}

function showHero(name, img) {
    let hero = document.createElement("article");
    hero.className = "heroPreview";
    let heroName = document.createElement("h2");

    let text = document.createTextNode(name);
    heroName.appendChild(text);

    let heroImg = document.createElement("div");
    heroImg.style.backgroundImage = "url('" + img + "')";

    hero.appendChild(heroName);
    hero.appendChild(heroImg);
    return hero;
}

function showDeck(name, img) {
    let element = document.createElement("article");
    element.className = "deck";

    let title = document.createElement("h3");
    element.appendChild(title);

    let text = document.createTextNode(name);
    title.appendChild(text);

    let heroImg = document.createElement("div");
    heroImg.style.backgroundImage = "url('" + img + "')";
    element.appendChild(heroImg);

    return element;
}
