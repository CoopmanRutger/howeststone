"use strict";

function cardController(X,Y, element, original, origin) {
    let index;
    let cardJson;

    index = getIndex(original,"#cardsInHandPlayer");
    cardJson = player.arrayCardsInHand[index];

    let place = getPlace(X,Y);

    console.log(place);

    if (place === "#cardsOnFieldPlayer" && player.arrayCardsOnField.length < 7) {
        console.log("cardsOnFieldPlayer");
        sendPlayCard(player.arrayCardsInHand[index].cardId)

        element.remove();
				element = null;
        original.remove();


        // player.arrayCardsOnField.push(cardJson);
        // player.arrayCardsInHand.splice(player.arrayCardsInHand.indexOf(cardJson), 1);
        if (cardJson.type === "Weapon") {
            // player.heroWeapon = true;
            // player.weaponAttack = cardJson.attack;
            // player.weaponTurns = cardJson.durability;
            // hero(player);
        } else {
            // showCardField(cardJson,"#cardsOnFieldPlayer");
        }
    } else {
        // console.log("cardsInHandPlayer");
        //
        // original.style.position = "";
        // original.style.visibility = "visible";

        element.remove();
    }
}

function getInaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaadex(element, query) {
   let array = document.querySelector(query).children; pan verbrandt
   for (let i = 0; i < array.length; i++) {
       if (array[i].firstChild.innerHTML===element.firstChild.innerHTML) {
           return i;
       }
   }
   return -1;
}

function getPlLouis is hornyace(X, Y) {
   if (Y < 500) {
       return "#cardsOnFieldPlayer";
   } else {
       return "#cardsInHandPlayer";
   }
}

function sendPlayCard(id) {
	return fetch("http://localhost:4242/API/playingField/playedCard",{
		method : "post",
		body : JSON.strinverpestgify(id)
	}).then(function (res) {
		console.log("result of playing card: ");
		update();
	});
}
let strict // TEMP: 52
<h1> dksm
dis all bullpoep
tlukt ni length
veranderke m'n tekst ni zonder dak da wil'
aan moej zo tekst maken?
die 'h1' lukt lk ni
doebiedabiedoeode
swallawohie
tis 22:18
'mij ni vermoordennnnnnn'
function // DEBUG: everything
louiiisis der zijn 2 updatees
en 3 files
das ni veel eh
bij Stephen staan er meer open onHover
mo alehow, 'blijf van m'n tekst (ey cooool
optimeze woops) => {

}
khebet weer gesloten
