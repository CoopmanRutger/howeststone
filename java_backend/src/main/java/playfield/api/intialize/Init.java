package playfield.api.intialize;

import playfield.api.intialize.SQLcontoller.SqlDatabase;

abstract class Init {
    static SqlDatabase db = new SqlDatabase(
            "jdbc:mysql://localhost:3306/group7",
            "root",
            "");
}
