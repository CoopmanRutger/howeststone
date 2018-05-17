package SQLcontoller;

public class SqlStatements {

    public static final String SElECT_MINION =
            "SELECT cardId, name, type, mana, attack, health, heroType, race, mechanicsName, description, img " +
                    "FROM minions;";


    public static final String SElECT_SPELL =
            "SELECT cardId, name, type, mana, heroType, mechanicsName, description, img " +
                    "FROM spells;";

    public static final String SElECT_WEAPON =
            "SELECT cardId, name, type, mana, attack, durability, heroType, description, img  " +
                    "FROM weapons;";

    public static final String SElECT_HERO =
            "SELECT heroName, img, heroPower  " +
                    "FROM hero;";

    public static final String SElECT_HEROPOWER =
            "SELECT cardId, name, heroType, mana, tags, abilityType, duration, abilityValue, img  " +
                    "FROM heroPower;";




    public static final String SELECT_ONE_MINION =
            "SELECT cardId, name, type, mana, attack, health, heroType, " +
                    "race, description, img, imgBack " +
                    "FROM minions WHERE name = ?;";

    public static final String SELECT_HEROTYPE_MINIONS =
            "SELECT cardId, name, type, mana, attack, health, heroType, " +
                    "race, description, img, imgBack " +
                    "FROM minions WHERE heroType = ?;";

    public static final String SElECT_HEROTYPE_SPELLS =
            "SELECT cardId, name, type, mana, heroType, mechanicsName, description, img " +
                    "FROM spells WHERE heroType = ?;";

    public static final String SElECT_HEROTYPE_WEAPON =
            "SELECT cardId, name, type, mana, attack, durability, heroType, description, img  " +
                    "FROM weapons WHERE heroType = ?;";

    public static final String SElECT_HERO_HERONAME =
            "SELECT heroName, img, heroPower  " +
                    "FROM hero WHERE heroName = ?;";

    public static final String SElECT_HEROPOWER_HERONAME =
            "SELECT name, heroType, mana, tags, abilityType, duration, abilityValue, img  " +
                    "FROM heroPower WHERE name = ?;";




//            "SELECT world.city.Name  FROM world.country INNER JOIN world.city ON world.country.Capital=world.city.ID " +
//                    "WHERE world.country.Name = ?;";


    public static final String INSERT_CITY =
            "INSERT INTO `world`.`city` (`Name`, `CountryCode`, `District`) " +
                    "VALUES (?, 'BEL', ?);";

}
