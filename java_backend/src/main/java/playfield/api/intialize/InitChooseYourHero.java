package playfield.api.intialize;

import playfield.api.intialize.SQLcontoller.SqlStatements;
import playfield.player.heroes.Hero;
import playfield.player.heroes.HeroPower;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static playfield.player.heroes.AbilityType.heal;

public class InitChooseYourHero extends Init {



    public List<Hero> GetPlaybleHeros() {
        final List<Hero> heroes = new ArrayList<>();
        try (
                Connection conn = db.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet heroResult = stmt.executeQuery(SqlStatements.SElECT_HEROS);
        ) {
            while (heroResult.next()) {
                final String heroName = heroResult.getString("heroName");
                final String img = heroResult.getString("img");

                final Hero hero = new Hero(heroName, img, getHeroPower(heroResult.getString("heroPower")));
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
                PreparedStatement stmt = conn.prepareStatement(SqlStatements.retrieveHeroByName);
        ) {
            stmt.setString(1, HeroName);
            final ResultSet heroResult = stmt.executeQuery();

            if (heroResult.next()) {
                final String heroName = heroResult.getString("heroName");

                final String img = heroResult.getString("img");

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
                PreparedStatement stmt = conn.prepareStatement(SqlStatements.getHeroPowerByName);

        ) {
            stmt.setString(1, playerHeroPowerName);
            final ResultSet heroPowerResult = stmt.executeQuery();

            if (heroPowerResult.next()) {
                final String heroPowerName = heroPowerResult.getString("powerName");
                final int mana = heroPowerResult.getInt("mana");
                final String tags = heroPowerResult.getString("tags");
                final int abilityValue = heroPowerResult.getInt("abilityValue");
                final int duration = heroPowerResult.getInt("duration");
                final String img = heroPowerResult.getString("img");

                // TODO: 22/05/2018

                heroPower = new HeroPower(heroPowerName, mana, tags, heal, abilityValue, duration, img, true);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return heroPower;
    }
}