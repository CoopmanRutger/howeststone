package playField.cardCollection.cards.additionalCardMechanics;

import playField.Game;
import playField.cardCollection.cards.CardMinion;
import playField.player.heroes.Hero;

import java.util.ArrayList;

public abstract class Conditions extends Game {
    public Object getCondition(String cond) {
        switch (cond) {
            case "playerChoice":
                return playerChoice();
            case "allCharacters":
                return allCharacters();
            case "allCharactersFriendly":
                return allCharactersFriendly();
            case "allCharactersEnemy":
                return allCharactersEnemy();
            case "specificCharacterFriendly":
                return specificCharacterFriendly();
            case "specificCharacterEnemy":
                return specificCharacterEnemy();
            case "allMinions":
                return allMinions();
            case "allMinionsFriendly":
                return allMinionsFriendly();
            case "allMinionsEnemy":
                return allMinionsEnemy();
            case "specificMinion":
                return specificMinion();
            case "specificMinionFriendly":
                return specificMinionFriendly();
            case "specificMinionEnemy":
                return specificMinionEnemy();
            case "playerHero":
                return playerHero();
            case "enemyHero":
                return enemyHero();
            default:
                return true;
        }
    }

    // TODO allCharacters and variants

    protected abstract ArrayList<CardMinion> specificMinion();
    protected abstract ArrayList<CardMinion> allMinions();

    protected abstract ArrayList<CardMinion> allMinionsEnemy();
    protected abstract ArrayList<CardMinion> allMinionsFriendly();

    protected abstract Object specificCharacterEnemy();
    // using Object type because it's the superclass of all other types (only time sensitive way to combine Hero & minion)

    protected abstract Object specificCharacterFriendly();
    // using Object type because it's the superclass of all other types (only time sensitive way to combine Hero & minion)

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
//            return
//        }
//    }

//    private boolean cond2(){return true;}


}
