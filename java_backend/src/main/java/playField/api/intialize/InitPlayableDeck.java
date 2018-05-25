package playField.api.intialize;

import playField.api.intialize.SQLcontoller.SqlStatements;
import playField.cardCollection.Deck;
import playField.player.heroes.Hero;
import playField.player.heroes.HeroPower;
import playField.player.PlayableDeck;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InitPlayableDeck extends Init {







    public List<PlayableDeck> GetPlaybleDecks(){
        PlayableDeck playableDeck = null;
        List<PlayableDeck> playableDecks = new ArrayList<>();
        try (
                Connection conn = db.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet playableDeckResult = stmt.executeQuery(SqlStatements.SElECT_PLAYABLEDECKS);
        ){


            while (playableDeckResult.next()) {
                playableDeck = MakePlaybleDeck(playableDeckResult);
                playableDecks.add(playableDeck);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return playableDecks;
    }


    public PlayableDeck MakePlaybleDeck(ResultSet playableDeckResult) throws SQLException {
        PlayableDeck playableDeck = null;

        InitChooseYourHero initChooseYourHero = new InitChooseYourHero();
        String deckName = playableDeckResult.getString("deckName");

        HeroPower heroPower = initChooseYourHero.getHeroPower(playableDeckResult.getString("heroPower"));
        Hero hero = initChooseYourHero.getHero(playableDeckResult.getString("hero"),heroPower);


        Deck deck = new Deck();
        InitDeckBuilderLvl2 initDeckBuilderLvl2 = new InitDeckBuilderLvl2();

        for (int i = 1; i < 31; i++){
            String cardId = playableDeckResult.getString("card" + i);
            if (initDeckBuilderLvl2.getMinion(cardId) !=null){
            deck.addCard(initDeckBuilderLvl2.getMinion(cardId));}
            if (initDeckBuilderLvl2.getSpells(cardId) != null){
                deck.addCard(initDeckBuilderLvl2.getSpells(cardId));
            }
            if (initDeckBuilderLvl2.getWeapons(cardId) != null){
                deck.addCard(initDeckBuilderLvl2.getWeapons(cardId));
            }

        }
        // noob Q; moet er geen else statement komen om aan te geven wat er gebeuren zou wnnr het wel null is?
        // TODO: 18/05/2018  nieuw statement, om card'en te getten en nieuw deck te maken om deze terug te geven en hier toe te voegen.


//                System.out.printf(" cardId: %s, name: %s, mana: %d, attack: %d, health: %d, description: %s \n", cardId,name , mana, attack, health, info);
//                PlayableDeck = new PlayableDeck(deckname, hero, cardIds);


        playableDeck = new PlayableDeck(deckName,hero,deck);
        return  playableDeck;
    }


    public Set<PlayableDeck> getPlayableDecksByHeroname(String heroname){
        Set<PlayableDeck> playableDeckSet = new HashSet<>();
        PlayableDeck playableDeck = null;
        try (
                Connection conn = db.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SqlStatements.SElECT_PLAYABLEDECK_BYHERONAME);
        ){
            stmt.setString(1, heroname);
            ResultSet playableDeckResult = stmt.executeQuery();

            while (playableDeckResult.next()) {
                playableDeck = MakePlaybleDeck(playableDeckResult);
                playableDeckSet.add(playableDeck);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        System.out.println(playableDeckSet);
        return playableDeckSet;
    }



    public PlayableDeck GetPlayableDeck(String deckname){
        PlayableDeck playableDeck = null;
        try (
                Connection conn = db.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SqlStatements.SElECT_PLAYABLEDECK);
        ){
            stmt.setString(1, deckname);
            ResultSet playableDeckResult = stmt.executeQuery();

            if (playableDeckResult.next()) {
                playableDeck = MakePlaybleDeck(playableDeckResult);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        System.out.println(playableDeck);
        return playableDeck;
    }




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


            ResultSet playableDeckResult = stmt.executeQuery();
//            System.out.println(playableDeckResult);
            InitChooseYourHero initChooseYourHero = new InitChooseYourHero();

            if (playableDeckResult.next()) {

                String deckName = playableDeckResult.getString("deckName");
                HeroPower heroPower = initChooseYourHero.getHeroPower(playableDeckResult.getString("herPower"));
                Hero hero = initChooseYourHero.getHero(playableDeckResult.getString("hero"), heroPower);
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
//        System.out.println(playableDeck);
        return playableDeck;
    }


    private String sqlFormatedList(int i ,List<String> cardIDs){
      String cardId = cardIDs.get(i);
        i++;
        return cardId;
    }
}
