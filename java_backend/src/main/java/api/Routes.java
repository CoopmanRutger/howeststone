package api;

import io.javalin.Context;
import io.javalin.Javalin;

class Routes {

    Routes(final Javalin server) {
        server.get("/", this::handleRoot);
//        server.get("/card/", this::getCardJson);
    }

//    private void getCardJson(Context context) {
//        context.json(new PlayingCard("bert",1));
//    }

    private void handleRoot(final Context context) {
        context.result("Hey you");
    }

}
