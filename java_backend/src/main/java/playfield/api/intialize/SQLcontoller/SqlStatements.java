package playfield.api.intialize.SQLcontoller;

public class SqlStatements {

    public static final String SELECT_MINION =
            "SELECT * FROM minions;";

    public static final String SELECT_SPELL =
            "SELECT * FROM spells;";

    public static final String SELECT_WEAPON =
            "SELECT * FROM weapons;";

    public static final String SELECT_HEROES =
            "SELECT * FROM hero;";

    public static final String SELECT_HEROPOWERS =
            "SELECT * FROM heroPower;";

    public static final String SELECT_PLAYABLEDECKS =
            "SELECT * FROM playabledeck";




    public static final String RETRIEVE_MINION_BY_NAME =
            "SELECT * FROM minions WHERE name = ?;";

    public static final String RETRIEVE_MINIONS_BY_ID =
            "SELECT * FROM minions WHERE cardId = ?;";

    public static final String RETRIEVE_MINIONS_BY_HERO =
            "SELECT * FROM minions WHERE heroType = ?;";

    public static final String RETRIEVE_SPELLS_BY_HERO =
            "SELECT * FROM spells WHERE heroType = ?;";

    public static final String RETRIEVE_SPELL_BY_ID =
            "SELECT * FROM spells WHERE cardId = ?;";

    public static final String RETRIEVE_WEAPONS_BY_HERO =
            "SELECT * FROM weapons WHERE heroType = ?;";

    public static final String RETRIEVE_WEAPON_BY_ID =
            "SELECT * FROM weapons WHERE cardId = ?;";

    public static final String RETRIEVE_HERO_BY_NAME =
            "SELECT * FROM hero WHERE heroNAME = ?;";

    public static final String GET_HERO_POWER_BY_NAME =
            "SELECT *  FROM heroPower WHERE powerNAME = ?";

    public static final String RETRIEVE_PLAYABLE_DECK_BY_NAME =
            "SELECT * FROM playabledeck WHERE deckNAME = ?";

    public static final String RETRIEVE_PLAYABLE_DECK_BY_HERO =
            "SELECT * FROM playabledeck WHERE hero = ?";

    public static final String INSERT_PLAYABLE_DECK =
            "INSERT INTO `playabledeck`(*) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?, ?,"
                    + " ?, ?, ?, ?);";
}
