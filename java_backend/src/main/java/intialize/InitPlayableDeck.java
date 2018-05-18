package intialize;

import SQLcontoller.SqlStatements;
import heroes.Hero;
import heroes.HeroPower;
import player.PlayableDeck;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class InitPlayableDeck extends Init {


//    public PlayableDeck SetPlayableDeck(String deckname,Hero deckHero, HeroPower deckHeroPower, List<String> deckCardIDs){
//        PlayableDeck playableDeck = null;
//        try (
//                Connection conn = db.getConnection();
//                //Statement stmt = conn.createStatement();
//                PreparedStatement stmt = conn.prepareStatement(SqlStatements.INSERT_PLAYABLEDECK);
//        ){
//            stmt.setString(1, deckname);
//            stmt.setString(2, deckHero);
//            stmt.setString(3, deckHeroPower);
//            stmt.setString(1, cardIDs);
//
//
//            ResultSet heroResult = stmt.executeQuery(SqlStatements.INSERT_PLAYABLEDECK);
//            System.out.println(heroResult);
//            InitChooseYourHero initChooseYourHero = new InitChooseYourHero();
//
//            if (heroResult.next()) {
//
//                String deckName = heroResult.getString("deckName");
//                Hero hero = initChooseYourHero.getHero(heroResult.getString("hero"));
//                HeroPower heroPower = initChooseYourHero.getHeroPower(heroResult.getString("herPower"));
//
//                System.out.printf(" cardId: %s, name: %s, mana: %d, attack: %d, health: %d, description: %s \n", cardId,name , mana, attack, health, info);
//                PlayableDeck = new PlayableDeck(deckname, hero, heroPower, List<String> cardIDs);
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        System.out.println(hero);
//        return hero;
//    }
}
