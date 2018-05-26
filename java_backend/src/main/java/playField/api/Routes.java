package playField.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import playField.GameAPI;
import playField.api.intialize.InitPlayableDeck;
import playField.cardCollection.Cards;
import playField.api.intialize.InitChooseYourHero;
import playField.api.intialize.InitDeckBuilderLvl2;
import io.javalin.Context;
import io.javalin.Javalin;
import playField.GameState;

import java.io.IOException;
import java.util.ArrayList;


class Routes extends GameState {

    Routes(final Javalin server) {
        server.post("/API/deckbuildOrPlay/chooseYourHero", this::chooseYourHero);

        server.get("/API/deckbuildOrPlay/chooseYourHero/chooseDeckForHero/getHeroName", this::getHeroNameForDecks);
        server.get("/API/deckbuildOrPlay/chooseYourHero/chooseDeckForHero/getChooseDeckSQL", this::getDeckForHeroSQL);
        server.post("/API/deckbuildOrPlay/chooseYourHero/chooseDeckForHero/postChooseDeck", this::ChooseDeckForHero);

        server.post("/API/pickYourOpponent", this::pickYourOpponent);
        server.get("/API/pickYourOpponent/getHeroName", this::getHeroNameFromOpponent);

        server.post("/API/gameStartingHand/remove", this::gameStartingHandRemove);
        server.get("/API/gameStartingHand/initializingGame", this::initializingGame);

        server.get("/API/playingField/getGameState", this::getGameState);
        server.post("/API/playingField/playedCard", this::postPlayedCard);
        server.get("/API/playingField/commitPlayer", this::commitPlayer);
        server.get("/API/playingField/bot", this::bot);
        server.get("/API/playingField/commitOpponent", this::commitOpponent);
        server.post("/API/playingField/sendAttack", this::sendAttack);

        // NOT CHRONOLOGICAL !!!!
        server.post("/API/deckbuildOrPlay/deckbuildLevelOne/postHero", this::postTempHero);
        server.get("/API/deckbuildOrPlay/deckbuildLevelOne/getDeck", this::getDeck);

        server.post("/API/deckbuildOrPlay/deckbuildLevelOne", this::deckbuildLevelOne);
        server.get("/API/deckbuildOrPlay/deckbuildLevelOne/getHeroNames", this::getAllHeroNames);
        // TODO
        server.post("/API/deckbuildOrPlay/deckbuildLevelOne/makeANewDeck=deckBuildLevel2", this::deckBuildLevel2);
        // TODO alle kaarten van het gekozen deck + alle mogelijke kaarten die je kunt kiezen
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
        playableDeckSet = initPlayableDeck.getPlayableDecksByHeroname(playerHero.getName());
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

        context.json(game);
    }

    // FIXING STARTING HAND

    private void gameStartingHandRemove(Context context) throws IOException {
        String in = context.body();

        ObjectMapper mapper = new ObjectMapper();
        ArrayList<String> array = mapper.readValue(in, new TypeReference<ArrayList<String>>(){});


        for (String id : array) {
            game.pf.getCurrentPlayer().moveBack(id);
        }

        for (int i = 0; i < array.size(); i++) {
            game.pf.getCurrentPlayer().drawCard();

        }
    }

    private void sendAttack(Context context) throws IOException {
        String in = context.body();
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<String> array = mapper.readValue(in, new TypeReference<ArrayList<String>>(){});

        if (array.get(1).equals("hero")) {
            game.attackHero(array.get(0));
        } else {
            game.attackCard(array.get(0), array.get(1));
        }
    }

    // THE GAME ITSELF

    private void getGameState(Context context) {
        context.json(game.pf);
    }

    private void postPlayedCard(Context context) {
        String in = context.body().replace("\"", "");
        System.out.println("Card id of played card is: " + in);
        game.playCard(in);
        context.result("you played card with id:" + in);
    }

    private void commitPlayer(Context context) {
        game.pf.getPlayer().drawCard();
        if (!game.pf.getOppositePlayer().getHero().isAlive()) {
            context.result("stop");
        } else {
            context.result("");
        }
        game.commit();
    }

    private void bot(Context context) {
        game.botMechanics();
    }


    private void commitOpponent(Context context) {
        if (!game.pf.getOppositePlayer().getHero().isAlive()) {
            context.result("stop");
        } else {
            context.result("");
        }
        game.commit();
    }

    private void postTempHero(Context context) {
        InitPlayableDeck init = new InitPlayableDeck();
        context.json(init.getPlayableDecksByHeroname(context.body().replace("\"", "")));
    }

    private void getDeck(Context context) {
        InitPlayableDeck init = new InitPlayableDeck();
        context.json(init.getPlayableDecksByHeroname(tempHero));
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
}