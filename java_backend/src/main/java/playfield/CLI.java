package playfield;

import playfield.cardCollection.cards.Card;
import playfield.cardCollection.cards.CardMinion;
import playfield.cardCollection.cards.CardSpell;
import playfield.cardCollection.cards.CardWeapon;
import playfield.player.heroes.Hero;
import playfield.player.heroes.HeroPower;

import java.util.ArrayList;

public class CLI extends GameCLI {

    public static void main(String[] args) {
        new CLI().run();
    }

    private String justHero = "hero";

    private void dollarSign() {
        System.out.print("$ ");
    }

    private void giveIdOfAttackingCard() {
        System.out.print("Give id of attacking card: ");
    }



    @Override
    protected void showWeapon() {
        System.out.println(pf.getPlayer().getWeapon());
    }

    @Override
    public void attackHeroPower(HeroPower heroPower) {
        final Hero oppponentHero = pf.getOppositePlayer().getHero();

        final int damage = heroPower.getAbilityValue();

        oppponentHero.takeDamage(damage);

        heroPower.setHeroPowerActive(false);
    }

    @Override
    public void healHeroPower(HeroPower heroPower) {
        System.out.print("Give id of card to heal: ");
        final String id = input.next();

        final Card card = pf.getCurrentPlayer().getCardsOnField().findById(id);

        if (card != null) {
            ((CardMinion) card).heal(heroPower.getAbilityValue());
            heroPower.setHeroPowerActive(false);
        }
    }

    @Override
    protected void showCardsOnFieldCLI() {
        System.out.println("Opponent's cards:");
        System.out.println(pf.getOpponent().getCardsOnField());
        System.out.println("Your cards:");
        System.out.println(pf.getPlayer().getCardsOnField());
    }

    @Override
    public void commit() {
        committed = true;
    }

    @Override
    public void attackWithWeapon() {
        System.out.println("Give id of card to heal or \"hero\" for healing hero");
        System.out.print("$");

        final String id = input.next();

        final int damage = pf.getCurrentPlayer().getHero().getHeroPower().getAbilityValue();

        if (justHero.equals(id)) {
            playWeaponOnHero(damage);
        } else {
            playWeaponOnCard(id, damage);
        }
    }

    @Override
    public void spellDamage(CardSpell card) {
        final int damage = card.getSpellDamage();

        System.out.print("Give ID of card to attack: ");
        final String oId = input.next();

        final CardMinion opponentCard = (CardMinion) pf.getOppositePlayer().getCardsOnField().findById(oId);

        final int mana = card.getMana();

        if (mana <= pf.getCurMana() && opponentCard != null) {
            opponentCard.takeDamage(damage);
            pf.decrMana(mana);

            if (!opponentCard.isAlive()) {
                pf.getOppositePlayer().getCardsOnField().remove(oId);
            }
        }
    }
    @Override
    public void playWeapon(Card card) {
        pf.getCurrentPlayer().setWeapon((CardWeapon) card);
    }

    @Override
    protected void getCurManaCLI() {
        System.out.println(pf.getCurMana());
    }

    @Override
    protected void showHeroesCLI() {
        System.out.println("Opponent's Hero:");
        System.out.println(pf.getOpponent().getHero());
        System.out.println("Your Hero:");
        System.out.println(pf.getPlayer().getHero());
    }

    @Override
    protected void showCardsInHandCLI() {
        System.out.println(pf.getCurrentPlayer().getCardsInHand());
    }

    @Override
    protected void playCardCLI() {
        System.out.print("Give id of card to play: ");
        final String id = input.next();
        playCard(id);
    }

    @Override
    protected void attackHeroCLI() {
        giveIdOfAttackingCard();
        final String pId = input.next();
        attackHero(pId);
    }

    @Override
    protected void attackCardCLI() {
        giveIdOfAttackingCard();
        final String pId = input.next();
        giveIdOfAttackingCard();
        final String oId = input.next();
        attackCard(pId, oId);
    }

    // IMPLEMENTING SPELL ACTIONS

    @Override
    public void addHealth(int healthToGive) {
        System.out.println("give id of card to heal or \"hero\" for healing hero");
        dollarSign();
        final String id = input.next();
        if (justHero.equals(id)) {
            addHealthHero(healthToGive);
        } else {
            addHealthCard(healthToGive, id);
        }
    }

    @Override
    public void addAttack(int amount) {
        System.out.println("give ID of card to give extra attack");
        dollarSign();
        final String id = input.next();
        ((CardMinion) pf.getCurrentPlayer().getCardsOnField().findById(id)).incrAttack(amount);
    }

    @Override
    protected ArrayList<CardMinion> specificMinion() {
        return null;
    }

    @Override
    protected ArrayList<CardMinion> allMinions() {
        return null;
    }

    @Override
    protected ArrayList<CardMinion> allMinionsEnemy() {
        return null;
    }

    @Override
    protected ArrayList<CardMinion> allMinionsFriendly() {
        return null;
    }

    @Override
    protected boolean playerChoice() {
        return false;
    }
}
