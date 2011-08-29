package db;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * (c) utcl95 - 10/05/11
 */
public class TestDB {
    public static void main(String[] args) {
        uDb db = new uDb();
        db.setUser("root", "87654321");
        db.setDatabase("mineras");

        db.uConnect();

        ResultSet rs = db.uSelect("customers", "");
        try {
            while(rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
