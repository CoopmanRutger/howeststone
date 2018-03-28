"use strict";

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
