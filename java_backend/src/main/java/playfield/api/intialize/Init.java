package playfield.api.intialize;

import playfield.api.intialize.SQLcontoller.SqlDatabase;

public class Init {
    protected static SqlDatabase db = new SqlDatabase(
            "jdbc:mysql://localhost:3306/howest_stone",
            "root",
            "");
}
