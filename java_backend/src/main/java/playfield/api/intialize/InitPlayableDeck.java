package playfield.api.intialize;

import playfield.api.intialize.SQLcontoller.SqlStatements;
import playfield.cardCollection.Deck;
import playfield.player.heroes.Hero;
import playfield.player.heroes.HeroPower;
import playfield.player.PlayableDeck;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InitPlayableDeck extends Init {
    
    final private String veldVoorDebieleStyleCheck = "card";

    public List<PlayableDeck> GetPlaybleDecks() {
        PlayableDeck playableDeck = null;
        final List<PlayableDeck> playableDecks = new ArrayList<>();
        try (
                Connection conn = db.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet playableDeckResult = stmt.executeQuery(SqlStatements.SELECT_PLAYABLEDECKS);
        ) {


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

        final InitChooseYourHero initChooseYourHero = new InitChooseYourHero();
        final String deckName = playableDeckResult.getString("deckName");

        final HeroPower heroPower = initChooseYourHero.getHeroPower(playableDeckResult.getString("heroPower"));
        final Hero hero = initChooseYourHero.getHero(playableDeckResult.getString("hero"), heroPower);


        final Deck deck = new Deck();
        final InitDeckBuilderLvl2 initDeckBuilderLvl2 = new InitDeckBuilderLvl2();

        for (int i = 1; i < 31; i++) {
            final String cardId = playableDeckResult.getString(veldVoorDebieleStyleCheck + i);
            if (initDeckBuilderLvl2.getMinion(cardId) != null) {
                deck.addCard(initDeckBuilderLvl2.getMinion(cardId));
            }
            if (initDeckBuilderLvl2.getSpells(cardId) != null) {
                deck.addCard(initDeckBuilderLvl2.getSpells(cardId));
            }
            if (initDeckBuilderLvl2.getWeapons(cardId) != null) {
                deck.addCard(initDeckBuilderLvl2.getWeapons(cardId));
            }
            // TODO: 18/05/2018  nieuw statement, om card'en te getten en nieuw deck te maken om deze terug te geven
            // en hier toe te voegen.
        }
        playableDeck = new PlayableDeck(deckName, hero, deck);
        return playableDeck;
    }


    public final Set<PlayableDeck> getPlayableDecksByHeroName(String heroName) {
        final Set<PlayableDeck> playableDeckSet = new HashSet<>();
        PlayableDeck playableDeck = null;
        try (
                Connection conn = db.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SqlStatements.RETRIEVE_PLAYABLE_DECK_BY_HERO);
        ) {
            stmt.setString(1, heroName);
            final ResultSet playableDeckResult = stmt.executeQuery();

            while (playableDeckResult.next()) {
                playableDeck = MakePlaybleDeck(playableDeckResult);
                playableDeckSet.add(playableDeck);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return playableDeckSet;
    }



    public PlayableDeck getPlayableDeck(String deckname) {
        PlayableDeck playableDeck = null;
        try (
                Connection conn = db.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SqlStatements.RETRIEVE_PLAYABLE_DECK_BY_NAME);
        ) {
            stmt.setString(1, deckname);
            final ResultSet playableDeckResult = stmt.executeQuery();

            if (playableDeckResult.next()) {
                playableDeck = MakePlaybleDeck(playableDeckResult);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return playableDeck;
    }




    public PlayableDeck setPlayableDeck(String deckname, String deckHero, String deckHeroPower,
                                        List<String> deckCardIDs) {
        final PlayableDeck playableDeck = null;
        try (
                Connection conn = db.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SqlStatements.INSERT_PLAYABLE_DECK);
        ) {
            stmt.setString(1, deckname);
            stmt.setString(2, deckHero);
            stmt.setString(3, deckHeroPower);
            for (int i = 0; i < deckCardIDs.size(); i++) {
                stmt.setString(i + 4, sqlFormatedList(i, deckCardIDs));
            }


            final ResultSet playableDeckResult = stmt.executeQuery();
            final InitChooseYourHero initChooseYourHero = new InitChooseYourHero();

            if (playableDeckResult.next()) {

                final String deckName = playableDeckResult.getString("deckName");
                final HeroPower heroPower = initChooseYourHero.getHeroPower(playableDeckResult.getString(
                        "herPower"));
                final Hero hero = initChooseYourHero.getHero(playableDeckResult.getString("hero"), heroPower);
                final List<String> cardIds = new ArrayList<>();

                for (int i = 0; i < deckCardIDs.size(); i++) {
                    final String card = playableDeckResult.getString(veldVoorDebieleStyleCheck + i);
                    cardIds.add(card);
                }
                // TODO: 18/05/2018  nieuw statement, om card'en te getten en nieuw deck te maken om deze terug te
                // geven en hier toe te voegen.
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return playableDeck;
    }

    private String sqlFormatedList(int number, List<String> cardIDs) {
        final String cardId = cardIDs.get(number);
        return cardId;
    }
}
