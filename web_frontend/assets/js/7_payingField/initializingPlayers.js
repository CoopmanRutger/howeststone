"use strict";

let isOpponent;

let opponent ={
    "type" : "opponent",
    "heroName" : "",
    "heroWeapon" : false,
    // "weaponImage" : ,
    "weaponAttack" : null,
    "weaponTurns" : null,
    "amountShield" : null,
    "lifepoints" : null,
    "manaCharge" : null,
    "manaLimit" : null,
    "arrayCardsInHand" : [],
    "arrayCardsOnField" : []
}


let player = {
    "type" : "player",
    "heroName" : "",
    "heroWeapon" : false,
    // "weaponImage" : ,
    "weaponAttack" : null,
    "weaponTurns" : null,
    "amountShield" : null,
    "lifepoints" : null,
    "manaCharge" : null,
    "manaLimit" : null,
    "arrayCardsInHand" : [],
    "arrayCardsOnField" : []
}

function update() {
    fetch("http://localhost:4242/API/playingField/getGameState", {
        }).then(function (res) {
        return res.json();
        }).then(function (res) {
            // console.log(res);
            // console.log(res.player.weapon);

        isOpponent = res.isOpponent;
    	endTurn(!isOpponent);

        if (!isOpponent) {
    		player.manaCharge = res.curMana;
    		player.manaLimit = res.totalMana;
    	}

        player.heroName = res.player.hero.name;
        player.lifepoints = res.player.hero.lifePoints;
        player.amountShield = res.player.hero.armourPoints;
        player.arrayCardsInHand = res.player.cardsInHand.cards;
        player.arrayCardsOnField = res.player.cardOnField.cards;
        // player.weaponAttack = res.player.weapon;
        // player.weaponTurns = res.player.weapon;
        // player.heroWeapon = res.player.weapon;

        injectCards(player.arrayCardsInHand)
    	showCardsOnField(player)
        selectAttacker();

    	if (isOpponent) {
            opponent.manaCharge = res.curMana;
            opponent.manaLimit = res.totalMana;
    	}
    	opponent.heroName = res.opponent.hero.name;
        opponent.lifepoints = res.opponent.hero.lifePoints;
        opponent.amountShield = res.opponent.hero.armourPoints;
        opponent.arrayCardsInHand = res.opponent.cardsInHand.cards;
        opponent.arrayCardsOnField = res.opponent.cardOnField.cards;
        // opponent.weaponAttack = res.opponent.weapon;
        // opponent.weaponTurns = res.opponent.weapon;
        // opponent.heroWeapon = res.opponent.weapon;

    	showCardsOnField(opponent)
        makeAttackable();


        manaCrystal(player);
        manaCrystal(opponent);
        cardsInHandOpponent(opponent.arrayCardsInHand);
        hero(opponent);
        hero(player);

        let elements = document.querySelectorAll(".cardHand");

        for (let i = 0; i < elements.length; i++) {
            elements[i].addEventListener("mousedown", cardMousedown);
            elements[i].addEventListener("mouseenter", cardOnmouseEnter);
            elements[i].addEventListener("mouseleave", cardOnmouseLeave);
        }
    })
}

function showCardsOnField(player) {
	let target;
	if (player.type === "opponent") {
		target = '#cardsOnFieldOpponent';
	} else {
		target = '#cardsOnFieldPlayer';
	}
	document.querySelector(target).innerHTML = "";
	let card;
	for (card of player.arrayCardsOnField) {
		showCardField(card, target);
	}
}
