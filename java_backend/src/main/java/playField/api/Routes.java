package playField.api;

import playField.GameAPI;
import playField.api.intialize.InitPlayableDeck;
import playField.cardCollection.Cards;
import playField.api.intialize.InitChooseYourHero;
import playField.api.intialize.InitDeckBuilderLvl2;
import io.javalin.Context;
import io.javalin.Javalin;
import playField.GameState;
import playField.cardCollection.Deck;
import playField.cardCollection.cards.CardAbility;
import playField.cardCollection.cards.CardMinion;
import playField.player.Player;
import playField.player.heroes.Hero;
import playField.player.heroes.HeroPower;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

        server.get("/API/deckbuildOrPlay/chooseYourHero/chooseDeckForHero/getHeroName", this::getHeroNameForDecks);


        server.get("/API/deckbuildOrPlay/chooseYourHero/chooseDeckForHero/getChooseDeckSQL", this::ChooseDeckForHeroSQL);
        server.post("/API/deckbuildOrPlay/chooseYourHero/chooseDeckForHero/postChooseDeck", this::ChooseDeckForHero);

        server.post("/API/pickYourOpponent", this::pickYourOpponent);
        // TODO fetchen uit database hero's
        server.get("/API/pickYourOpponent/getHeroName", this::getHeroNameFromOpponent);

        server.get("/API/deckbuildOrPlay/deckbuildLevelOne/getHeroNames", this::getAllHeroNames);

        server.post("/API/deckbuildOrPlay/deckbuildLevelOne", this::deckbuildLevelOne);
        // TODO
        server.post("/API/deckbuildOrPlay/deckbuildLevelOne/makeANewDeck=deckBuildLevel2", this::deckBuildLevel2);
        // TODO alle kaarten van het gekozen deck + alle mogelijke kaarten die je kunt kiezen

        server.get("/API/versusScreen", this::versusScreen);

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

    private void getAllHeroNames(Context context) {
        InitChooseYourHero initChooseYourHero = new InitChooseYourHero();
        context.json(initChooseYourHero.GetPlaybleHeros());

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

        context.result("chooseYourHero");
    }

    private void getHeroNameForDecks(Context context) {
        context.result(playerHero.getName());
        System.out.println(playerHero.getName());
    }

    private void getHeroNameFromOpponent(Context context) {
        context.result(opponentHero.getName());
        System.out.println(opponentHero.getName());
    }

    private void ChooseDeckForHero(Context context) {
       String in = context.body().replace("\"","");
       String hmm = in + playerHero.getName();
        System.out.println("Chosen Deck: " + hmm);
        InitPlayableDeck initPlayableDeck = new InitPlayableDeck();

        playerDeck = initPlayableDeck.GetPlayableDeck(hmm);
//        System.out.println(playerDeck);
    }


    private void ChooseDeckForHeroSQL(Context context) {
        InitPlayableDeck initPlayableDeck = new InitPlayableDeck();
        playableDeckSet = initPlayableDeck.GetPlayableDecksByHeroname(playerHero.getName());
        context.json(playableDeckSet);

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

//        System.out.println(opponentHero);

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
        Set<CardAbility> tempSet;
//
//        playerDeck = new Deck();
//        Deck opponentDeck = new Deck();
//
//
//
//            tempSet = new HashSet<>();
//            tempSet.add(divineShield);
//            opponentDeck.addCard(new CardMinion("ID" + i, "name" + i, "type", i/6 + 1, "type", "heroType", "img", i/5 + 1, (i+1)/5 + 1, "race", "mechanics", tempSet));
//        }
//
//        HeroPower playerHeroPower = new HeroPower("", 0, "", heal,1,1,"",true);
//        HeroPower opponentHeroPower = new HeroPower("", 0, "", attack,1,1,"",true);
//
//        Player p = new Player(playerDeck, playerHero);
//        Player o = new Player(opponentDeck, opponentHero);
//
//        game = new GameAPI(playerDeck,
//                opponentDeck,
//                playerHero,
//                opponentHero);
//
//        context.result("versusScreen " + p.getHero().getName() + " " + o.getHero().getName());
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