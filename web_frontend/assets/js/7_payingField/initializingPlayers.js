"use strict";


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
        console.log(res);
        // console.log(res.player.weapon);

        player.heroName = res.player.hero.name;
        player.manaCharge = res.curMana;
        player.manaLimit = res.totalMana;
        player.lifepoints = res.player.hero.lifePoints;
        player.amountShield = res.player.hero.armourPoints;
        player.arrayCardsInHand = res.player.cardsInHand.cards;
        player.arrayCardsOnField = res.player.cardOnField.cards;
        // player.weaponAttack = res.player.weapon;
        // player.weaponTurns = res.player.weapon;
        // player.heroWeapon = res.player.weapon;


        opponent.heroName = res.opponent.hero.name;
        opponent.manaCharge = res.curMana;
        opponent.manaLimit = res.totalMana;
        opponent.lifepoints = res.opponent.hero.lifePoints;
        opponent.amountShield = res.opponent.hero.armourPoints;
        opponent.arrayCardsInHand = res.opponent.cardsInHand.cards;
        opponent.arrayCardsOnField = res.opponent.cardOnField.cards;
        // opponent.weaponAttack = res.opponent.weapon;
        // opponent.weaponTurns = res.opponent.weapon;
        // opponent.heroWeapon = res.opponent.weapon;

        manaCrystal(player);
        manaCrystal(opponent);
        cardsInHandOpponent(opponent.arrayCardsInHand);

        hero(opponent);
        hero(player);
        console.log(player);
        console.log(opponent);

        let elements = document.querySelectorAll(".cardHand");
        for (let i = 0; i < elements.length; i++) {
            elements[i].addEventListener("mousedown", cardMousedown);
            elements[i].addEventListener("mouseenter", cardOnmouseEnter);
            elements[i].addEventListener("mouseleave", cardOnmouseLeave);
        }
    })
}
