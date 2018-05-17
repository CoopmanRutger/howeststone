package api;

import cardCollection.Cards;
import heroes.Hero;
import intialize.InitChooseYourHero;
import intialize.InitDeckBuilderLvl2;
import io.javalin.Context;
import io.javalin.Javalin;

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
        server.post("/API/gameStartingHand/playField", this::playField);
        // TODO !!!!!

//        server.get("/card/", this::getCardJson);
        server.get("/API/test", this::test);
    }

    private void test(Context context) {
        System.out.println("test worked");
        context.result("test worked");
    }



    private void chooseYourHero(Context context) {
        System.out.println(context.body());
        InitChooseYourHero initChooseYourHero = new InitChooseYourHero();
        hero = initChooseYourHero.getHero(context.body());
        System.out.println(hero);
//        context.result("chooseYourHero");
    }

    private void chooseDeckForHero(Context context) {
        System.out.println(context.body());
    }

    private void pickYourOpponent(Context context) {
        System.out.println(context.body());


    }

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

    private void versusScreen(Context context) {
        context.result("versusScreen");
    }


    private void gameStartingHand(Context context) {
        context.result("gameStartingHand");
    }

    private void playField(Context context) {
        context.result("playField");
    }





//    private void handleRoot(final Context context) {
//        context.result("Hey you");
//    }

}

//    private void getCardJson(Context context) {
//        context.json(new PlayingCard("bert",1));
//    }

//        server.post("/minions", context -> {
////            context.status(201);
//            InitDeckBuilderLvl2 deck = new InitDeckBuilderLvl2();
//            context.json(deck.selectMinion());
//        });