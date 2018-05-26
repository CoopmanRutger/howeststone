package playField.api.intialize;

import playField.api.intialize.SQLcontoller.SqlStatements;
import playField.player.heroes.Hero;
import playField.player.heroes.HeroPower;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static playField.player.heroes.AbilityType.heal;

public class InitChooseYourHero extends Init {



    public List<Hero> GetPlaybleHeros() {
        List<Hero> heroes = new ArrayList<>();
        try (
                Connection conn = db.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet heroResult = stmt.executeQuery(SqlStatements.SElECT_HEROS);
        ) {
            while (heroResult.next()) {
                String heroName = heroResult.getString("heroName");
                String img = heroResult.getString("img");

                Hero hero = new Hero(heroName, img, getHeroPower(heroResult.getString("heroPower")));
                heroes.add(hero);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return heroes;
    }





    public Hero getHero(String HeroName, HeroPower heroPower) {
        Hero hero = null;
        try (
                Connection conn = db.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SqlStatements.SElECT_HERO_HERONAME);
        ) {
            stmt.setString(1, HeroName);
            ResultSet heroResult = stmt.executeQuery();

            if (heroResult.next()) {
                String heroName = heroResult.getString("heroName");

                String img = heroResult.getString("img");

                if (heroPower != null) {
                    hero = new Hero(heroName, img, heroPower);
                } else {
                    hero = new Hero(heroName, img, getHeroPower(heroResult.getString("heroPower")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hero;
    }

    public HeroPower getHeroPower(String playerHeroPowerName) {
        HeroPower heroPower = null;
        try (
                Connection conn = db.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SqlStatements.SElECT_HEROPOWER);

        ) {
            stmt.setString(1, playerHeroPowerName);
            ResultSet heroPowerResult = stmt.executeQuery();

            if (heroPowerResult.next()) {
                String heroPowerName = heroPowerResult.getString("powerName");
                int mana = heroPowerResult.getInt("mana");
                String tags = heroPowerResult.getString("tags");
                int abilityValue = heroPowerResult.getInt("abilityValue");
                int duration = heroPowerResult.getInt("duration");
                String img = heroPowerResult.getString("img");

                // TODO: 22/05/2018

                heroPower = new HeroPower(heroPowerName, mana, tags, heal, abilityValue, duration, img, true);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return heroPower;
    }
}