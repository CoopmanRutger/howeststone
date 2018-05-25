package playField.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import playField.GameAPI;
import playField.api.intialize.InitPlayableDeck;
import playField.cardCollection.Cards;
import playField.api.intialize.InitChooseYourHero;
import playField.api.intialize.InitDeckBuilderLvl2;
import io.javalin.Context;
import io.javalin.Javalin;
import playField.GameState;
import playField.cardCollection.cards.Card;

import java.util.ArrayList;


class Routes extends GameState {

    Routes(final Javalin server) {
//        server.get("/", this::handleRoot);
//        server.get("/API/welcomeScreen", this::welcomScreen);
//
//        server.get("/API/deckbuildOrPlay", this::deckbuildOrPlay);
        server.post("/API/deckbuildOrPlay/chooseYourHero", this::chooseYourHero);

        server.get("/API/deckbuildOrPlay/chooseYourHero/chooseDeckForHero/getHeroName", this::getHeroNameForDecks);
        server.get("/API/deckbuildOrPlay/chooseYourHero/chooseDeckForHero/getChooseDeckSQL", this::getDeckForHeroSQL);
        server.post("/API/deckbuildOrPlay/chooseYourHero/chooseDeckForHero/postChooseDeck", this::ChooseDeckForHero);

        server.post("/API/pickYourOpponent", this::pickYourOpponent);
        server.get("/API/pickYourOpponent/getHeroName", this::getHeroNameFromOpponent);

        // TODO: 24/05/2018 make gameStartingHand
//        server.post("/API/gameStartingHand/remove", this::gameStartingHandRemove);

        server.get("/API/gameStartingHand/initializingGame", this::initializingGame);

        server.get("/API/playingField/getGameState", this::getGameState);
        server.post("/API/playingField/playedCard", this::postPlayedCard);
        server.get("/API/playingField/commit", this::commit);
        server.get("/API/playingField/commitOpponent", this::commitOpponent);


        // NOT CHRONOLOGICAL !!!!

//        server.post("/API/deckbuildOrPlay/chooseYourHero/chooseDeckForHero/postHeroNamesOneByOne", this::getDeckForHeroSQL);

        server.post("/API/deckbuildOrPlay/deckbuildLevelOne", this::deckbuildLevelOne);
        server.get("/API/deckbuildOrPlay/deckbuildLevelOne/getHeroNames", this::getAllHeroNames);
        // TODO
        server.post("/API/deckbuildOrPlay/deckbuildLevelOne/makeANewDeck=deckBuildLevel2", this::deckBuildLevel2);
        // TODO alle kaarten van het gekozen deck + alle mogelijke kaarten die je kunt kiezen

//        server.get("/API/versusScreen", this::versusScreen);

        // TODO de eerste 3 kaarten van het deck tonen. (fetch n(aantal) kaarten)

        server.get("/API/test", this::test);
    }




    private void test(Context context) {
        System.out.println("test worked");
        context.result("test worked");
    }

    private void getAllHeroNames(Context context) {
        InitChooseYourHero initChooseYourHero = new InitChooseYourHero();
        context.json(initChooseYourHero.GetPlaybleHeros());
    }



    // FILLING FIELDS
    private void chooseYourHero(Context context) {
        String in = context.body().replace("\"", "");
        System.out.println("Chosen Hero: " + in);

        InitChooseYourHero init = new InitChooseYourHero();
        playerHero = init.getHero(in, null);

        context.result("chooseYourHero");
    }

    private void getHeroNameForDecks(Context context) {
        context.result(playerHero.getName());
    }
    private void getDeckForHeroSQL(Context context) {
        InitPlayableDeck initPlayableDeck = new InitPlayableDeck();
        playableDeckSet = initPlayableDeck.GetPlayableDecksByHeroname(playerHero.getName());
        context.json(playableDeckSet);
    }

    private void ChooseDeckForHero(Context context) {
        String in = context.body().replace("\"", "");
        String name = in + playerHero.getName();

        InitPlayableDeck initPlayableDeck = new InitPlayableDeck();
        System.out.println("Chosen Deck: " + name);

        playerDeck = initPlayableDeck.GetPlayableDeck(name);
    }

    private void pickYourOpponent(Context context) {
        String in = context.body().replace("\"", "");
        System.out.println("Chosen Opponent: " + in);

        InitChooseYourHero init = new InitChooseYourHero();
        opponentHero = init.getHero(in, null);

        context.result("pickYourOpponent");
    }

    private void getHeroNameFromOpponent(Context context) {
        context.result(opponentHero.getName());
    }



    // INITIALIZE GAME
    private void initializingGame(Context context) {
        opponentDeck = new InitPlayableDeck().GetPlayableDeck("noob" + opponentHero.getName());
        System.out.println("Chosen Opponent Deck: noob" + opponentHero.getName());

        game = new GameAPI(playerDeck, opponentDeck);

        System.out.println(game.pf);

        context.json(game);
    }


    // FIXING STARTING HAND
    private void gameStartingHandRemove(Context context) {
        String array = context.body();
        System.out.println(array);

        String pickedCardAsJsonString = context.body();
        System.out.println(pickedCardAsJsonString);

        ObjectMapper mapper = new ObjectMapper();
        Card actualCardObject = mapper.readValue(pickedCardAsJsonString, Card.class);

        pickedCardId = actualCardObject.getId();

        System.out.printf("Some picked %s as card\n", pickedCardId);

//        ArrayList<String> array = context.body();
//        for (String id : array) {
//            game.pf.getCurrentPlayer().moveBack(id);
//        }
    }

    // THE GAME ITSELF

    private void getGameState(Context context) {
        context.json(game.pf);
    }

    private void postPlayedCard(Context context) {
        String in = context.body().replace("\"", "");
        System.out.println("Card id is: " + in);
        game.playCard(in);
        System.out.println(game.pf.getPlayer().getCardsOnField());
        context.result("you played card with id:" + in);
    }

    private void commit(Context context) {
        game.pf.getPlayer().drawCard();
        game.commit();
        game.botMechanics();
    }

    private void commitOpponent(Context context){
        game.commit();
        System.out.println("commited");
    }

    //                              //
    // NOT FOR CHRONOLOGICAL ORDERD //
    //------------------------------//
    //                              //
    //------------------------------//

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
    //        InitPlayableDeck initPlayableDeck = new InitPlayableDeck();
    //        Set<PlayableDeck> tempplayableDeckSet = initPlayableDeck.GetPlayableDecksByHeroname(context.body().replace("\"", ""));
    //        context.json(tempplayableDeckSet);

//    private void getDeckForHeroSQL(Context context) {

//    }
}