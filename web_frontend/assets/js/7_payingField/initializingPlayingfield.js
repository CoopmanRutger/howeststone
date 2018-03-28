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

function hero(player) {

        if (player.amountShield > 0) {
            let shield = "<img src='images/shield.png' alt='shield' width='35'/>";
            if (player.type = "opponent") {
            document.querySelector(".heroShieldOpponent").innerHTML = player.shield;
            document.querySelector(".heroShieldNumberOpponent").innerHTML = player.amountShield;
            }
            else {
                document.querySelector(".heroShield").innerHTML = player.shield;
                document.querySelector(".heroShieldNumber").innerHTML = player.amountShield;
            }
        }
        if (player.heroWeapon) {
            if (player.heroName !== "mage" && hero !== "priest") {
                let weapon = "<img src='images/hero_" + player.heroName + "_weaponOn.png' alt='hero " + hero + "_weapon' width='125'/>'";

                if (player.type = "opponent") {
                    document.querySelector(".heroWeaponOpponent").innerHTML = player.weapon;
                    document.querySelector(".heroWeaponAttackOpponent").innerHTML = player.weaponAttack;
                    document.querySelector(".heroWeaponTurnsOpponent").innerHTML = player.weaponTurns;
                }
                else {
                    document.querySelector(".heroWeapon").innerHTML = player.weapon;
                    document.querySelector(".heroWeaponAttack").innerHTML = player.weaponAttack;
                    document.querySelector(".heroWeaponTurns").innerHTML = player.weaponTurns;
                }
            }
        } else {
            if (player.type = "opponent") {
                document.querySelector(".heroWeaponOpponent").innerHTML = '';
                document.querySelector(".heroWeaponAttackOpponent").innerHTML = '';
                document.querySelector(".heroWeaponTurnsOpponent").innerHTML = '';
            }
            else {
                document.querySelector(".heroWeapon").innerHTML = '';
                document.querySelector(".heroWeaponAttack").innerHTML = '';
                document.querySelector(".heroWeaponTurns").innerHTML = '';
            }
        }
        let heroPic = "<img src='images/hero_" + player.heroName + ".png' alt='hero" + player.heroName + "' width='175'/>'";
        let power = "<img src='images/hero_" + player.heroName + "_power.png' alt='hero " + player.heroName + "' width='125'/>'";

    if (player.type = "opponent") {
        document.querySelector(".heroPictureOpponent").innerHTML = heroPic;
        document.querySelector(".heroPowerOpponent").innerHTML = power;
        document.querySelector(".heroLifePointsOpponent").innerHTML = player.lifepoints;
    }
    else {
        document.querySelector(".heroPicture").innerHTML = heroPic;
        document.querySelector(".heroPower").innerHTML = power;
        document.querySelector(".heroLifePoints").innerHTML = player.lifepoints;
    }
}

function manaCrystal(player) {
    if (player.manaCharge <= 10 && player.manaLimit <= 10) {
        if (player.type = "opponent") {
            document.querySelector(".manaCrystalsNumberOpponent").innerHTML = player.manaCharge;
            document.querySelector(".manaCrystalsLimitsOpponent").innerHTML = player.manaLimit;
        }
        else {
            let unchargeMana = amountLimits - amountCharge;
            document.querySelector(".manaCrystalsNumber").innerHTML = player.manaCharge;
            document.querySelector(".manaCrystalsLimits").innerHTML = player.manaLimit;
            manaCrystalSymbols(amountCharge, unchargeMana);
        }
    }
    else {
        if (player.type = "opponent") {
            let variable = 10; // TODO: tussen 0 en 10 + negatief
            let amountLimits = 10;
            document.querySelector(".manaCrystalsNumber").innerHTML = variable;
            document.querySelector(".manaCrystalsLimits").innerHTML = amountLimits;
        }
        else {
            let variable = 10; // TODO: tussen 0 en 10 + negatief
            let amountLimits = 10;
            let unchargeMana = amountLimits - variable;
            document.querySelector(".manaCrystalsNumber").innerHTML = variable;
            document.querySelector(".manaCrystalsLimits").innerHTML = amountLimits;

            manaCrystalSymbols(variable, unchargeMana);
        }
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
    for (let j = 0; j < amountUncharge; j++) {
        res += '<img src="images/manaUncharged.png" alt="manaUncharged" width="27"/>';
    }
    document.querySelector(".manaCrystalSymbol").innerHTML = res;
}
