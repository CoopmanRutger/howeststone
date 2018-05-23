package playField;

import playField.cardCollection.cards.Card;
import playField.cardCollection.cards.CardMinion;
import playField.player.heroes.Hero;
import playField.player.heroes.HeroPower;

public class CLI extends GameCLI {
    public static void main(String[] args) {
        new CLI().run();
    }

    private CLI() {
        super();
    }

    @Override
    protected void attackHeroPower(HeroPower heroPower) {
        Hero oppponentHero = pf.getOppositePlayer().getHero();

        int damage = heroPower.getAbilityValue();

        oppponentHero.takeDamage(damage);

        heroPower.setHeroPowerActive(false);
    }

    @Override
    protected void healHeroPower(HeroPower heroPower){
        System.out.print("Give id of card to heal: ");
        String id = input.next();

        Card card = pf.getCurrentPlayer().getCardsOnField().findById(id);

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
    protected void commit() {
        committed = true;
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
        String id = input.next();
        playCard(id);
    }

    @Override
    protected void attackHeroCLI() {
        System.out.print("Give id of attacking card: ");
        String pId = input.next();
        attackHero(pId);
    }

    @Override
    protected void attackCardCLI() {
        System.out.print("Give id of attacking card: ");
        String pId = input.next();
        System.out.print("Give id of attacked card: ");
        String oId = input.next();
        attackCard(pId,oId);
    }

    // IMPLEMENTING SPELL ACTIONS

    @Override
    protected void addArmour(int amount){
        pf.getCurrentPlayer().getHero().incrArmour(amount);
    }

    @Override
    protected void addHealth(){

    }

    @Override
    protected void addAttack(){

    }

    @Override
    protected void directAttackCLI() {
        System.out.print("Give id of attacking card: ");
        String pId = input.next();
        System.out.println("Give id of attacked card: ");
        String oId = input.next();
        directAttackCard(pId,oId);
    }

}
