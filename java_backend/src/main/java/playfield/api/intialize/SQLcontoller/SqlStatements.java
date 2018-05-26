package playfield.api.intialize.SQLcontoller;

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




    public static final String retrieveMinionByName =
            "SELECT * FROM minions WHERE name = ?;";

    public static final String retrieveMinionsById =
            "SELECT * FROM minions WHERE cardId = ?;";

    public static final String retrieveMinionsByHero =
            "SELECT * FROM minions WHERE heroType = ?;";

    public static final String retrieveSpellsByhero =
            "SELECT * FROM spells WHERE heroType = ?;";

    public static final String retrieveSpellByID =
            "SELECT * FROM spells WHERE cardId = ?;";

    public static final String retrieveWeaponsByHero =
            "SELECT * FROM weapons WHERE heroType = ?;";

    public static final String retrieveWeaponByID =
            "SELECT * FROM weapons WHERE cardId = ?;";

    public static final String retrieveHeroByName =
            "SELECT * FROM hero WHERE heroName = ?;";

    public static final String getHeroPowerByName =
            "SELECT *  FROM heroPower WHERE powerName = ?";

    public static final String retrievePlayableDeckByName =
            "SELECT * FROM playabledeck WHERE deckName = ?";

    public static final String retrievePlayableDeckByHero =
            "SELECT * FROM playabledeck WHERE hero = ?";

    public static final String INSERT_PLAYABLEDECK =
            "INSERT INTO `playabledeck`(*) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?, ?,"
                    + " ?, ?, ?, ?);";
}
