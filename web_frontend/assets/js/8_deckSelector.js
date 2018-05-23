"use strict";

let heroesAndDecks = [
    {"name":"Mage",
"img":"blablabla",
"decks":
[{"name":"deck1",
"img":"https://i.imgur.com/qbP37xZ.png"},
]
},

{"name":"priest",
"img":"blablabla",
"decks":[{"name":"penis",
"img":"blablabla"}]
},
];

document.addEventListener("DOMContentLoaded", init);

function init() {
    // fillJson();
    console.log("test");
    // console.log(makeDecks("Mage"))
    // console.log(heroesAndDecks);
    // injectHeroDecks();
}

function fillJson(){
    fetch("http://localhost:4242/API/deckbuildOrPlay/deckbuildLevelOne/getHeroNames",)
    .then(function (response) {
        return response.json();
    }).then(function (res) {
        console.log("response ", res);
        for (let i = 0; i <res.length; i++){
            console.log(res[i].name);
            console.log(res[i].img);
            // console.log(res[i]);
            heroesAndDecks[i] = {
                "name" : res[i].name,
                "img" : "/web_frontend/assets/media/" + res[i].img + ".jpg",
                "decks" : makeDecks(res[i])
        };
    }}).then(function () {
        injectHeroDecks();
    })
}

function makeDecks(heroname) {
    fetch("http://localhost:4242/API/deckbuildOrPlay/chooseYourHero/chooseDeckForHero/getChooseDeckSQL",)
    .then(function (response) {
        return response.json();
    }).then(function (res) {
        console.log(res);
    })
}

function injectHeroDecks() {
    for (let i = 0; i < heroesAndDecks.length; i++) {
        // console.log(heroesAndDecks[i]);

        let hero = document.createElement("li");
        hero.className = "hero";

        let decks = document.createElement("ul");
        decks.className = "decks";

        for (let j = 0; j < heroesAndDecks[i].decks.length; j++) {
            // console.log(heroesAndDecks[i].decks[i]);
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
