package playfield.cardCollection.cards.additionalCardMechanics;

import playfield.Game;
import playfield.cardCollection.cards.CardMinion;
import playfield.player.heroes.Hero;

import java.util.ArrayList;

public abstract class Conditions extends Game {
    public Object getCondition(String cond) {
        Object out = null;
        switch (cond) {
            case "playerChoice":
                out = playerChoice();
                break;
            case "allCharacters":
                //out = allCharacters();
                break;
            case "allCharactersFriendly":
                //out = allCharactersFriendly();
                break;
            case "allCharactersEnemy":
                //out = allCharactersEnemy();
                break;
            case "specificCharacterFriendly":
                out = specificCharacterFriendly();
                break;
            case "specificCharacterEnemy":
                out = specificCharacterEnemy();
                break;
            case "allMinions":
                out = allMinions();
                break;
            case "allMinionsFriendly":
                out = allMinionsFriendly();
                break;
            case "allMinionsEnemy":
                out = allMinionsEnemy();
                break;
            case "specificMinion":
                out = specificMinion();
                break;
            case "specificMinionFriendly":
                out = specificMinionFriendly();
                break;
            case "specificMinionEnemy":
                out = specificMinionEnemy();
                break;
            case "playerHero":
                out = playerHero();
                break;
            case "enemyHero":
                out = enemyHero();
                break;
            default:
                out = true;
                break;
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
}
