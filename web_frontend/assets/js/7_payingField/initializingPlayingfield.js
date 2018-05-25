"use strict";

function cardsInHandOpponent(array) {
		document.querySelector("#cardsInHandOpponent").innerHTML = "";
    for (let i = 0; i < array.length; i++) {
        let element = document.createElement("div");
        element.style.backgroundImage = "url('images/redCard.png')";
        element.style.left = i + 'px';
        document.querySelector("#cardsInHandOpponent").appendChild(element)
    }
}

function hero(player) {
    let query = "";
    if (player.type === "opponent") {
        query += "Opponent";
    } else {
        query += "Player"
    }
    if (player.amountShield > 0) {
        let shield = "<img src='images/shield.png' alt='shield' width='28'/>";

        document.querySelector("#heroShield" + query).innerHTML = shield;
        document.querySelector("#heroShieldNumber" + query).innerHTML = player.amountShield;
    }
    if (player.heroWeapon) {
        if (player.heroName !== "mage" && player.heroName !== "priest") {
            let weapon = "<img src='images/hero_" + player.heroName + "_weaponOn.png' alt='hero " + player.heroName + "_weapon' width='90'/>'";

            document.querySelector("#heroWeapon" + query).innerHTML = weapon;
            document.querySelector("#heroWeaponAttack" + query).innerHTML = player.weaponAttack;
            document.querySelector("#heroWeaponTurns" + query).innerHTML = player.weaponTurns;
        }}
    else {
            document.querySelector("#heroWeapon" + query).innerHTML = '';
            document.querySelector("#heroWeaponAttack" + query).innerHTML = '';
            document.querySelector("#heroWeaponTurns" + query).innerHTML = '';

    }
    let heroPic = "<img src='images/hero_" + player.heroName + ".png' alt='hero" + player.heroName + "' width='120'/>'";
    let power = "<img src='images/hero_" + player.heroName + "_power.png' alt='hero " + player.heroName + "' width='90'/>'";

        document.querySelector("#heroPicture" + query).innerHTML = heroPic;
        document.querySelector("#heroPower" + query).innerHTML = power;
        document.querySelector("#heroLifePoints" + query).innerHTML = player.lifepoints;

}

function manaCrystal(player) {
    let query = "";
    if (player.type === "opponent") {
        query += "Opponent";
    } else {
        query += "Player"
    }
    if (player.manaCharge <= 10 && player.manaLimit <= 10) {
        let variable = player.manaCharge; // TODO: tussen 0 en 10 + negatief
        let unchargeMana = player.manaLimit - variable;
        document.querySelector("#manaCrystalsNumber" + query).innerHTML = player.manaCharge;
            document.querySelector("#manaCrystalsLimits" + query).innerHTML = player.manaLimit;
        if (query === "Player"){
            manaCrystalSymbols(player.manaCharge, unchargeMana);
			console.log(player.manaCharge,unchargeMana );
        }
    }
}

function endTurn(boolean) {
    let res = '';
    if (boolean) {
        res = '<img src="images/end-turn.png" alt="endTurn" width="95"/>';
        document.querySelector("#endTurn").innerHTML = res;
    }
}

function manaCrystalSymbols(amountCharge, amountUncharge) {
    let res = '';
    for (let i = 0; i < amountCharge; i++) {
        res += '<img src="images/manaCharged.png" alt="manaCharged" width="18"/>';
    }
    for (let j = 0; j < amountUncharge; j++) {
        res += '<img src="images/manaUncharged.png" alt="manaUncharged" width="18"/>';
    }
    document.querySelector("#manaCrystalSymbolPlayer").innerHTML = res;
}
