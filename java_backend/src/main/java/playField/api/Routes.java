package playField.api;

import playField.Game;
import playField.GameAPI;
import playField.cardCollection.Cards;
import playField.api.intialize.InitChooseYourHero;
import playField.api.intialize.InitDeckBuilderLvl2;
import io.javalin.Context;
import io.javalin.Javalin;
import playField.GameState;
import playField.cardCollection.Deck;
import playField.cardCollection.cards.CardMinion;
import playField.cardCollection.cards.CardMinionAbility;
import playField.player.Player;
import playField.player.heroes.Hero;
import playField.player.heroes.HeroPower;

import java.util.HashSet;
import java.util.Set;

import static playField.cardCollection.cards.CardMinionAbility.charge;
import static playField.cardCollection.cards.CardMinionAbility.divineShield;
import static playField.player.heroes.AbilityType.attack;
import static playField.player.heroes.AbilityType.heal;

class Routes extends GameState {

    Routes(final Javalin server) {
//        server.get("/", this::handleRoot);
//        server.get("/API/welcomeScreen", this::welcomScreen);
//
//        server.get("/API/deckbuildOrPlay", this::deckbuildOrPlay);
        server.post("/API/deckbuildOrPlay/chooseYourHero", this::chooseYourHero);
        // TODO fetchen uit database hero's
        server.post("/API/deckbuildOrPlay/chooseYourHero/chooseDeckForHero", this::chooseDeckForHero);
        // TODO fetchen decks

        server.post("/API/pickYourOpponent", this::pickYourOpponent);
        // TODO fetchen uit database hero's
        server.post("/API/deckbuildOrPlay/deckbuildLevelOne", this::deckbuildLevelOne);
        // TODO
        server.post("/API/deckbuildOrPlay/deckbuildLevelOne/makeANewDeck=deckBuildLevel2", this::deckBuildLevel2);
        // TODO alle kaarten van het gekozen deck + alle mogelijke kaarten die je kunt kiezen

        server.get("/API/versusScreen", this::versusScreen);
        // TODO de 2 kozen hero's
        server.post("/API/gameStartingHand", this::gameStartingHand);
        // TODO de eerste 3 kaarten van het deck tonen. (fetch n(aantal) kaarten)


        server.post("/API/gameStartingHand/playingField", this::playField);
        // TODO !!!!!

//        server.get("/card/", this::getCardJson);
        server.get("/API/test", this::test);
    }

    private void test(Context context) {
        System.out.println("test worked");
        context.result("test worked");
    }

    // FILLING FIELDS

    private void chooseYourHero(Context context) {
        String in = context.body().replace("\"","");
        System.out.println("Chosen Hero: " + in);

        InitChooseYourHero init = new InitChooseYourHero();
        playerHero = init.getHero(in, new HeroPower(
                "",
                0,
                "",
                heal,
                1,
                1,
                "",
                true)
        );

        System.out.println(playerHero);

        context.result("chooseYourHero");
    }

    private void chooseDeckForHero(Context context) {
        System.out.println(context.body());
        // TODO: 22/05/2018 sql liiiiiink
    }

    private void pickYourOpponent(Context context) {
        String in = context.body().replace("\"","");
        System.out.println("Chosen Opponent: " + in);

        InitChooseYourHero init = new InitChooseYourHero();
        opponentHero = init.getHero(in, new HeroPower(
                "",
                0,
                "",
                heal,
                1,
                1,
                "",
                true)
        );

        System.out.println(opponentHero);

        context.result("pickYourOpponent");
    }

    // MAKING DECK

    private void deckbuildLevelOne(Context context) {
        context.result("deckbuildLevelOne");
    }

    private void deckBuildLevel2(Context context) {
        InitDeckBuilderLvl2 db = new InitDeckBuilderLvl2();

        String heroType = "";

        Cards cards = new Cards();

        cards.addAllCards(db.getMinions("Neutral"));
        cards.addAllCards(db.getMinions(heroType));

        context.result("deckBuildLevel2");

    }

    // INITIALIZING GAME

    private void versusScreen(Context context) {
        Set<CardMinionAbility> tempSet;

        Deck playerDeck = new Deck();
        Deck opponentDeck = new Deck();

        for (int i = 0; i < 30; i++) {
            tempSet = new HashSet<>();
            tempSet.add(charge);
            playerDeck.addCard(new CardMinion("ID" + i, "name" + i, "type", i/6 + 1, "type", "heroType", "img", i/5 + 1, (i+1)/5 + 1, "race", "mechanics", tempSet));

            tempSet = new HashSet<>();
            tempSet.add(divineShield);
            opponentDeck.addCard(new CardMinion("ID" + i, "name" + i, "type", i/6 + 1, "type", "heroType", "img", i/5 + 1, (i+1)/5 + 1, "race", "mechanics", tempSet));
        }

        HeroPower playerHeroPower = new HeroPower("", 0, "", heal,1,1,"",true);
        HeroPower opponentHeroPower = new HeroPower("", 0, "", attack,1,1,"",true);
        Hero playerHero = new Hero("heroPlayer", "im", playerHeroPower);
        Hero opponentHero = new Hero("heroOpponent", "im", opponentHeroPower);

        Player p = new Player(playerDeck, playerHero);
        Player o = new Player(opponentDeck, opponentHero);

        game = new GameAPI(playerDeck,
                opponentDeck,
                playerHero,
                opponentHero);

        context.result("versusScreen");
    }

    private void gameStartingHand(Context context) {
        context.result("gameStartingHand");
    }

    private void playField(Context context) {
        game.run();
        context.result("playField");
    }
}

//    private void handleRoot(final Context context) {
//        context.result("Hey you");
//    }



//    private void getCardJson(Context context) {
//        context.json(new PlayingCard("bert",1));
//    }

//        server.post("/minions", context -> {
////            context.status(201);
//            InitDeckBuilderLvl2 deck = new InitDeckBuilderLvl2();
//            context.json(deck.selectMinion());
//        });