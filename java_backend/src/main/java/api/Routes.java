package api;

import intialize.InitDeckBuilderLvl2;
import io.javalin.Context;
import io.javalin.Javalin;

class Routes {

    Routes(final Javalin server) {
        server.get("/", this::handleRoot);
        server.get("/minions", this::minions);
//        server.get("/card/", this::getCardJson);
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