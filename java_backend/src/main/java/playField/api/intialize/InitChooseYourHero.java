package playField.api.intialize;

import playField.api.intialize.SQLcontoller.SqlStatements;
import playField.player.heroes.AbilityType;
import playField.player.heroes.Hero;
import playField.player.heroes.HeroPower;

import java.sql.*;

import static playField.player.heroes.AbilityType.heal;

public class InitChooseYourHero extends Init {


    public Hero getHero(String HeroName, HeroPower heroPower){
        Hero hero = null;
        try (
                Connection conn = db.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SqlStatements.SElECT_HERO_HERONAME);
        ){
            stmt.setString(1, HeroName);
            System.out.println(stmt);

            ResultSet heroResult = stmt.executeQuery();

            if (heroResult.next()) {
                String heroName = heroResult.getString("heroName");

                String img = heroResult.getString("img");

                hero = new Hero(heroName, img, heroPower);
            } else {
                // TODO: 17/05/2018
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(hero);
        return hero;
    }

    public HeroPower getHeroPower(String playerHeroPowerName){
        HeroPower heroPower = null;
        try (
                Connection conn = db.getConnection();
//                Statement stmt = conn.createStatement();
                PreparedStatement stmt = conn.prepareStatement(SqlStatements.SElECT_HEROPOWER);

        ){
            stmt.setString(1, playerHeroPowerName);
            ResultSet heroPowerResult = stmt.executeQuery();

            if(heroPowerResult.next()) {

                String heroPowerName = heroPowerResult.getString("powerName");

                int mana = heroPowerResult.getInt("mana");

                String tags = heroPowerResult.getString("tags");

                String abilityType = heroPowerResult.getString("AbilityType");

                int abilityValue = heroPowerResult.getInt("abilityValue");

                int duration = heroPowerResult.getInt("duration");

                String img = heroPowerResult.getString("img");

                // TODO: 22/05/2018 make string to enum parser

                heroPower = new HeroPower(heroPowerName, mana, tags, heal, abilityValue, duration, img, true);
            } else {
                // TODO: 17/05/2018
            }

            } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(heroPower);
        return heroPower;
    }


}
