package api;

import intialize.InitDeckBuilderLvl2;
import io.javalin.Context;
import io.javalin.Javalin;

class Routes {

    Routes(final Javalin server) {
        server.get("/", this::handleRoot);
        server.get("/minions", this::minions);
        server.get("/API/welcomeScreen", this::welcomScreen);

        server.post("/API/deckbuildOrPlay", this::deckbuildOrPlay);
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
    }

    private void deckbuildLevelOne(Context context) {
        context.result("deckbuildLevelOne");
    }

    private void playField(Context context) {
        context.result("playField");
    }

    private void gameStartingHand(Context context) {
        context.result("gameStartingHand");
    }

    private void versusScreen(Context context) {
        context.result("versusScreen");
    }

    private void deckBuildLevel2(Context context) {
        context.result("deckBuildLevel2");
    }

    private void pickYourOpponent(Context context) {
        context.result("pickYourOpponent");
    }

    private void chooseDeckForHero(Context context) {
        context.result("chooseDeckForHero");
    }

    private void chooseYourHero(Context context) {
        context.result("chooseYourHero");
    }

    private void deckbuildOrPlay(Context context) {
        context.result("deckbuildOrPlay");
    }

    private void welcomScreen(Context context) {
        context.result("welcomScreen");
    }

    private void minions(Context context) {
        InitDeckBuilderLvl2 deck = new InitDeckBuilderLvl2();
        context.json(deck.selectMinion());
    }

    private void handleRoot(final Context context) {
        context.result("Hey you");
    }

}

//    private void getCardJson(Context context) {
//        context.json(new PlayingCard("bert",1));
//    }

//        server.post("/minions", context -> {
////            context.status(201);
//            InitDeckBuilderLvl2 deck = new InitDeckBuilderLvl2();
//            context.json(deck.selectMinion());
//        });