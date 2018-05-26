package playField.api.intialize;

import playField.api.intialize.SQLcontoller.SqlDatabase;

class Init {

    static SqlDatabase db = new SqlDatabase(
            "jdbc:mysql://localhost:3306/howest_stone",
            "root",
            "");
}
