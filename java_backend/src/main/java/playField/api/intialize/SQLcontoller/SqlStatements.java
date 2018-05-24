package playField.api.intialize.SQLcontoller;

public class SqlStatements {

    public static final String SElECT_MINION =
            "SELECT * FROM minions;";

    public static final String SElECT_SPELL =
            "SELECT * FROM spells;";

    public static final String SElECT_WEAPON =
            "SELECT * FROM weapons;";

    public static final String SElECT_HEROS =
            "SELECT * FROM hero;";

    public static final String SElECT_HEROPOWERS =
            "SELECT * FROM heroPower;";

    public static final String SElECT_PLAYABLEDECKS =
            "SELECT * FROM playabledeck";




    public static final String SELECT_MINION =
            "SELECT * FROM minions WHERE name = ?;";

    public static final String SELECT_MINIONID =
            "SELECT * FROM minions WHERE cardId = ?;";


    public static final String SELECT_HEROTYPE_MINIONS =
            "SELECT * FROM minions WHERE heroType = ?;";

    public static final String SElECT_HEROTYPE_SPELLS =
            "SELECT * FROM spells WHERE heroType = ?;";

    public static final String SElECT_SPELLSID =
            "SELECT * FROM spells WHERE cardId = ?;";

    public static final String SElECT_HEROTYPE_WEAPON =
            "SELECT * FROM weapons WHERE heroType = ?;";

    public static final String SElECT_WEAPONID =
            "SELECT * FROM weapons WHERE cardId = ?;";

    public static final String SElECT_HERO_HERONAME =
            "SELECT * FROM hero WHERE heroName = ?;";

    public static final String SElECT_HEROPOWER =
            "SELECT *  FROM heroPower WHERE powerName = ?";

    public static final String SElECT_PLAYABLEDECK =
            "SELECT * FROM playabledeck WHERE deckName = ?";

    public static final String SElECT_PLAYABLEDECK_BYHERONAME =
            "SELECT * FROM playabledeck WHERE hero = ?";




    public static final String INSERT_PLAYABLEDECK =
            "INSERT INTO `playabledeck`(*) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?, ?, ?, ?, ?, ?);";




//            "SELECT world.city.Name  FROM world.country INNER JOIN world.city ON world.country.Capital=world.city.ID " +
//                    "WHERE world.country.Name = ?;";

//
//    public static final String INSERT_CITY =
//            "INSERT INTO `world`.`city` (`Name`, `CountryCode`, `District`) " +
//                    "VALUES (?, 'BEL', ?);";

}
