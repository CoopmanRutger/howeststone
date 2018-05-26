package playField.cardCollection.cards.additionalCardMechanics;

import playField.Game;
import playField.cardCollection.cards.CardMinion;
import playField.player.heroes.Hero;

import java.util.ArrayList;

public abstract class Conditions extends Game {
    public Object getCondition(String cond) {
        Object out = null;
        switch (cond) {
            case "playerChoice":
                out = playerChoice();
            case "allCharacters":
//                out = allCharacters();
            case "allCharactersFriendly":
//                out = allCharactersFriendly();
            case "allCharactersEnemy":
//                out = allCharactersEnemy();
            case "specificCharacterFriendly":
                out = specificCharacterFriendly();
            case "specificCharacterEnemy":
                out = specificCharacterEnemy();
            case "allMinions":
                out = allMinions();
            case "allMinionsFriendly":
                out = allMinionsFriendly();
            case "allMinionsEnemy":
                out = allMinionsEnemy();
            case "specificMinion":
                out = specificMinion();
            case "specificMinionFriendly":
                out = specificMinionFriendly();
            case "specificMinionEnemy":
                out = specificMinionEnemy();
            case "playerHero":
                out = playerHero();
            case "enemyHero":
                out = enemyHero();
            default:
                out = true;
        }
        return out;
    }

    // TODO allCharacters and variants

    protected abstract ArrayList<CardMinion> specificMinion();
    protected abstract ArrayList<CardMinion> allMinions();

    protected abstract ArrayList<CardMinion> allMinionsEnemy();
    protected abstract ArrayList<CardMinion> allMinionsFriendly();

    protected abstract Object specificCharacterEnemy();
    // using Object type because it's the superclass of all other types (only time sensitive way to combine Hero
    // & minion)

    protected abstract Object specificCharacterFriendly();
    // using Object type because it's the superclass of all other types (only time sensitive way to combine Hero
    // & minion)

    protected abstract Hero enemyHero();

    protected abstract Hero playerHero();

    protected abstract CardMinion specificMinionFriendly();

    protected abstract CardMinion specificMinionEnemy();

    protected abstract boolean playerChoice();


//    public boolean getCondition(String cond, Card card, int amount) {
//        switch (cond) {
//            case "fiveOrLessAttack":
//                return fiveOrLessAttack(amount, card);
//            default:
//                return true;
//        }
//    }
//
//    private boolean fiveOrLessAttack(int attackAmountOfTarget, Card card){
//        CardMinion newCard = ((CardMinion) card);
//        if( newCard.getAttack() <= 5) {
            //return
//        }
//    }

//    private boolean cond2(){return true;}


}
