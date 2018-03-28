'use strict';


// opponent
let heroNameOpponent = 'priest';//priest / mage / rogue
let heroWeaponOpponent = true;
let weaponAttackOpponent = 6;
let weaponTurnsOpponent = 8;
let amountShieldOpponent = 10;
let lifepointsOpponent = 30;
let manaChargeOpponent = 1; //max 10
let manaLimitOpponent = 4; //max 10

let arrayCardsInHandOpponent = [1, 2, 3, 4];
let arrayCardsOnFieldOpponent = [];


// player
let heroName = 'rogue';
let heroWeapon = true;
let weaponAttack = 5;
let weaponTurns = 3;
let amountShield = 0;
let lifepoints = 30;
let manaCharge = 8; //max 10
let manaLimit = 8; //max 10

let arrayCardsInHand = [];
let arrayCardsOnField = [];


document.addEventListener('DOMContentLoaded', init);

function init() {
    endTurn(true);
    manaCystalOpponent(manaChargeOpponent, manaLimitOpponent);
    manaCrystal(manaCharge, manaLimit);
    heroOpponent(heroWeaponOpponent, weaponAttackOpponent, weaponTurnsOpponent, heroNameOpponent, amountShieldOpponent, lifepointsOpponent);
    hero(heroWeapon, weaponAttack, weaponTurns, heroName, amountShield, lifepoints);
    cardsInHandOpponent(arrayCardsInHandOpponent);
    fetchCards();
}

function fetchCards() {
    console.log('fetchCards');

    let url = "https://omgvamp-hearthstone-v1.p.mashape.com/cards?attack=6";

    fetch(url, {
        headers: new Headers({
            "Accept": "application/json",
            "X-Mashape-Key": "y7rGFym8csmshrenbJFLUR5cVMslp1azdfKjsnPEQhhTb9Awvo"
        })
    }).then(function (resp) {
        if (resp.ok) {
            return resp.json();
        }
    }).then(function (text) {
            // console.log(text);

            for (let i = 0; i < text.Basic.length; i++) {
                let card = {
                    "cardId": text.Basic[i].cardId,
                    "attack": text.Basic[i].attack,
                    "health": text.Basic[i].health,
                    "name": text.Basic[i].name,
                    "img": text.Basic[i].img,
                    "i": i
                };
                arrayCardsInHand.push(card);
            }
            for (let i = 0; i < text.Classic.length; i++) {
                let card = {
                    "cardId": text.Classic[i].cardId,
                    "attack": text.Classic[i].attack,
                    "health": text.Classic[i].health,
                    "name": text.Classic[i].name,
                    "img": text.Classic[i].img,
                    "i": i + text.Basic.length
                };
                arrayCardsInHand.push(card);
            }
        }
    ).then(init2)
}

function init2() {
    // let elements = document.querySelectorAll(".card");
    // makeMovable(elements, cardController);
    injectCards(arrayCardsInHand);
}

//-----------------------------------------------------------------------------------------------
function injectCards(arrayOfCards) {
    for (let i = 0; i < 1; i++) {
        console.log(arrayOfCards[i]);
        showCardField(arrayOfCards[i])
    }

    let elements = document.querySelectorAll('.card');
    makeMovable(elements, cardController)

}


//-----------------------------------------------------------------------------------------------
function makeMovable(elements, controller) {

    /* HOW IT WORKS
    Eerst wordt het originele elements op onzichtbaar gezet.
    Dan wordt een kopie gemaakt die geplakt wordt aan het einde van het document.
    Die copy volgt (met absolute positioning) je muis.
    als die copy loslaat wordt die verwijderd
    daarna zorgt de controller-functie dat het originele element op de juiste plaats wordt toegevoegd.
    als laatste actie wordt de staat gereset (style enzo)
    */

    let original;
    let moving;

    let diffX;
    let diffY;

    function mouseup(e) {
        e.preventDefault();
        // let card = moving.cloneNode(true);

        moving.style.position = "";

        controller(e.clientX, e.clientY, moving);

        original.remove();

        document.removeEventListener('mouseup', mouseup)
    }

    document.addEventListener('mousemove', function (e) {
        e.preventDefault();
        try {
            // console.log("moving");
            moving.style.left = (e.clientX - diffX) + "px";
            moving.style.top = (e.clientY - diffY) + "px";
        } catch (e) {
            // console.log("moving");
        }
    });

    function mousedown(e) {
        e.preventDefault();

        original = this;

        diffX = e.clientX - original.offsetLeft - original.parentElement.offsetLeft;
        diffY = e.clientY - original.offsetTop - original.parentElement.offsetTop;
        // console.log(this.offsetLeft,this.offsetTop);
        console.log(diffX, diffY);

        moving = original.cloneNode(true);
        console.log(moving);

        moving.style.position = "absolute";
        moving.style.left = (e.clientX - diffX) + "px";
        moving.style.top = (e.clientY - diffY) + "px";

        original.style.visibility = "hidden";

        document.querySelector("body").appendChild(moving);

        document.addEventListener("mouseup", mouseup);
    }

    for (let i = 0; i < elements.length; i++) {
        elements[i].addEventListener('mousedown', mousedown);
    }
}

function cardController(X, Y, original) {
    let out = document.querySelector(".cardsOnField");
    if (Y < 800) {
        out.appendChild(original)
    }
}

//-----------------------------------------------------------------------------------------------

function showCardField(card) {
    //main card

    let startposition = 420;
    let spaceBetweenCards = 20;
    let element = document.createElement("div");
    let meta = document.createElement('p');

    meta.style.display = "none";
    meta.appendChild(document.createTextNode(card.cardId));
    element.appendChild(meta);
    element.className = "card";
    element.style.backgroundImage = "url('" + card.img + "')";
    element.style.top = 20 + "px";
    element.style.left = (card.i * spaceBetweenCards + startposition) + 'px';
    document.querySelector(".cardsInHand").appendChild(element);


    // name tag
    element = document.createElement("div");
    element.className = "cardName";
    let lol = document.createElement("h2");
    lol.appendChild(document.createTextNode(card.name));
    element.appendChild(lol);
    document.querySelector(".cardsInHand").lastChild.appendChild(element);

    // attack tag
    element = document.createElement("div");
    element.className = "cardAttack";
    element.appendChild(document.createTextNode(card.attack));
    document.querySelector(".cardsInHand").lastChild.appendChild(element);

    // health tag
    element = document.createElement("div");
    element.className = "cardHealth";
    element.appendChild(document.createTextNode(card.health));
    document.querySelector(".cardsInHand").lastChild.appendChild(element);
}

//-------------------------------------------------------------------------------------------------------------------------

function cardsInHandOpponent(array) {
    let startposition = 420;
    let spaceBetweenCards = 20;
    for (let i = 0; i < array.length; i++) {
        let element = document.createElement("div");
        element.style.backgroundImage = "url('images/redCard.png')";
        element.style.left = (i * spaceBetweenCards + startposition) + 'px';
        document.querySelector(".cardsInHandOpponent").appendChild(element)
    }
}

function heroOpponent(heroWeapon, weaponAttack, weaponTurns, hero, amountShield = 0, lifePoints) {
    if (amountShield > 0) {
        let shield = "<img src='images/shield.png' alt='shield' width='35'/>";
        document.querySelector(".heroShieldOpponent").innerHTML = shield;

        document.querySelector(".heroShieldNumberOpponent").innerHTML = amountShield;
    }
    if (heroWeapon) {
        if (hero !== "mage" && hero !== "priest") {
            // console.log('hero is not mage or priest');

            let weapon = "<img src='images/hero_" + hero + "_weaponOn.png' alt='hero " + hero + "_weapon' width='125'/>'";
            document.querySelector(".heroWeaponOpponent").innerHTML = weapon;
            document.querySelector(".heroWeaponAttackOpponent").innerHTML = weaponAttack;
            document.querySelector(".heroWeaponTurnsOpponent").innerHTML = weaponTurns;
        }

    } else {
        document.querySelector(".heroWeaponOpponent").innerHTML = '';
        document.querySelector(".heroWeaponAttackOpponent").innerHTML = '';
        document.querySelector(".heroWeaponTurnsOpponent").innerHTML = '';
    }

    let heroPic = "<img src='images/hero_" + hero + ".png' alt='hero" + hero + "' width='175'/>'";
    let power = "<img src='images/hero_" + hero + "_power.png' alt='hero " + hero + "' width='125'/>'";
    document.querySelector(".heroPictureOpponent").innerHTML = heroPic;
    document.querySelector(".heroPowerOpponent").innerHTML = power;

    document.querySelector(".heroLifePointsOpponent").innerHTML = lifePoints;
}

function hero(heroWeapon, weaponAttack, weaponTurns, hero, amountShield = 0, lifePoints) {
    if (amountShield > 0) {
        let shield = "<img src='images/shield.png' alt='shield' width='35'/>";
        document.querySelector(".heroShield").innerHTML = shield;

        document.querySelector(".heroShieldNumber").innerHTML = amountShield;
    }
    if (heroWeapon) {
        if (hero !== "mage" && hero !== "priest") {
            // console.log('opponent is not mage or priest');

            let weapon = "<img src='images/hero_" + hero + "_weaponOn.png' alt='hero " + hero + "_weapon' width='125'/>'";//heroWeapon;
            document.querySelector(".heroWeapon").innerHTML = weapon;
            document.querySelector(".heroWeaponAttack").innerHTML = weaponAttack;
            document.querySelector(".heroWeaponTurns").innerHTML = weaponTurns;
        }
    }
    else {
        document.querySelector(".heroWeapon").innerHTML = '';
        document.querySelector(".heroWeaponAttack").innerHTML = '';
        document.querySelector(".heroWeaponTurns").innerHTML = '';
    }

    let heroPic = "<img src='images/hero_" + hero + ".png' alt='hero" + hero + "' width='175'/>'";
    let power = "<img src='images/hero_" + hero + "_power.png' alt='hero " + hero + "' width='125'/>'";
    document.querySelector(".heroPicture").innerHTML = heroPic;
    document.querySelector(".heroPower").innerHTML = power;

    document.querySelector(".heroLifePoints").innerHTML = lifePoints;

}

function manaCystalOpponent(amountCharge, amountLimits) {
    //limit max 10 TODO
    document.querySelector(".manaCrystalsNumberOpponent").innerHTML = amountCharge;
    document.querySelector(".manaCrystalsLimitsOpponent").innerHTML = amountLimits;
}

function manaCrystal(amountCharge, amountLimits) {
    if (amountCharge <= 10 && amountLimits <= 10) {
        let unchargeMana = amountLimits - amountCharge;
        document.querySelector(".manaCrystalsNumber").innerHTML = amountCharge;
        document.querySelector(".manaCrystalsLimits").innerHTML = amountLimits;
        manaCrystalSymbols(amountCharge, unchargeMana);
    }
    else {
        let variable = 5; // TODO: tussen 0 en 10 + negatief
        let amountLimits = 10;
        let unchargeMana = amountLimits - variable;
        document.querySelector(".manaCrystalsNumber").innerHTML = variable;
        document.querySelector(".manaCrystalsLimits").innerHTML = amountLimits;

        manaCrystalSymbols(variable, unchargeMana);
    }

}

function endTurn(boolean) {
    let res = '';
    if (boolean) {
        res = '<img src="images/end-turn.png" alt="endTurn" width="130"/>';
        document.querySelector(".endTurn").innerHTML = res;
    }
}

function manaCrystalSymbols(amountCharge, amountUncharge) {
    let res = '';
    for (let i = 0; i < amountCharge; i++) {
        res += '<img src="images/manaCharged.png" alt="manaCharged" width="27"/>';
    }
    // console.log(amountUncharge);
    for (let j = 0; j < amountUncharge; j++) {

        res += '<img src="images/manaUncharged.png" alt="manaUncharged" width="27"/>';
    }

    document.querySelector(".manaCrystalSymbol").innerHTML = res;
}

