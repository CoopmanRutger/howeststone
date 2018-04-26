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



    public static final String SELECT_ONE_MINION =
            "SELECT cardId, name, type, mana, attack, health, heroType, " +
                    "race, description, img, imgBack " +
                    "FROM minions WHERE name = ?;";

//            "SELECT world.city.Name  FROM world.country INNER JOIN world.city ON world.country.Capital=world.city.ID " +
//                    "WHERE world.country.Name = ?;";


    public static final String INSERT_CITY =
            "INSERT INTO `world`.`city` (`Name`, `CountryCode`, `District`) " +
                    "VALUES (?, 'BEL', ?);";

}
