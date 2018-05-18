package intialize;

import SQLcontoller.SqlStatements;
import cardCollection.Deck;
import heroes.Hero;
import heroes.HeroPower;
import player.PlayableDeck;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InitPlayableDeck extends Init {


    public PlayableDeck SetPlayableDeck(String deckname,String deckHero, String deckHeroPower, List<String> deckCardIDs){
        PlayableDeck playableDeck = null;
        try (
                Connection conn = db.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SqlStatements.INSERT_PLAYABLEDECK);
        ){
            stmt.setString(1, deckname);
            stmt.setString(2, deckHero);
            stmt.setString(3, deckHeroPower);
            for (int i = 0; i < deckCardIDs.size(); i++) {
                stmt.setString(i + 4, sqlFormatedList(i, deckCardIDs));
            }


            ResultSet playableDeckResult = stmt.executeQuery(SqlStatements.INSERT_PLAYABLEDECK);
            System.out.println(playableDeckResult);
            InitChooseYourHero initChooseYourHero = new InitChooseYourHero();

            if (playableDeckResult.next()) {

                String deckName = playableDeckResult.getString("deckName");
                Hero hero = initChooseYourHero.getHero(playableDeckResult.getString("hero"));
                HeroPower heroPower = initChooseYourHero.getHeroPower(playableDeckResult.getString("herPower"));
                List<String> cardIds = new ArrayList<>();

                for (int i = 0; i < deckCardIDs.size(); i++){
                    String card = playableDeckResult.getString("card" + i);
                    cardIds.add(card);
                }

                // TODO: 18/05/2018  nieuw statement, om card'en te getten en nieuw deck te maken om deze terug te geven en hier toe te voegen.


//                System.out.printf(" cardId: %s, name: %s, mana: %d, attack: %d, health: %d, description: %s \n", cardId,name , mana, attack, health, info);
//                PlayableDeck = new PlayableDeck(deckname, hero, cardIds);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(playableDeck);
        return playableDeck;
    }


    private String sqlFormatedList(int i ,List<String> cardIDs){
      String cardId = cardIDs.get(i);
        i++;
        return cardId;
    }
}
