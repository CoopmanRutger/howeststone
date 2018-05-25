"use strict";


let attacker;
let target;


function selectAttacker() {

    for (let i = 0; i < possibleAttackers.length; i++) {
        possibleAttackers[i].addEventListener('click', selectedAttacker);
    }
}

function selectedAttacker(e) {
    if (this.className === "selectedToAttack"){
        this.className = "card";
        deSelect();
    } else if (single()) {
        attacker = this.children[0].innerHTML;
        this.className = "selectedToAttack";
    }
}


function makeAttackable() {

    for (let i = 0; i < possibleTargets.length; i++) {
        possibleTargets[i].addEventListener('click', selectTarget);
    }
}

function selectTarget(e) {
    if (this.className === "selectedForAttack"){
        this.className = "card"
    } else if (!single()) {
        target = this.children[0].innerHTML;
        this.className = "selectedForAttack";
        sendAttack();
    }
}

function single() {
    let element;
    for (element of possibleAttackers) {
        if (element.className === "selectedToAttack") {
            return false;
        }
    }
    return true;
}
function deSelect () {
    let element;
    for (element of possibleTargets) {
            element.className = "card"
    }
}

function sendAttack() {
    let arr = [attacker,target]
    console.log("array is", arr);
    fetch("http://localhost:4242/API/playingField/sendAttack", {
        method: "post",
        body: JSON.stringify(arr)
    }).then(update)
}
