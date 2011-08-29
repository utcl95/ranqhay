package db;

import java.sql.*;

/**
 * (c) utcl95 - 07/05/11
 *
 * setDB("MySQL") // default: MySQL/localhost
 * setUser("user", "password")
 *
 *
 * uSelect("employee", "all")
 * uSelect("employee", "id=5")
 *
 * uDelete("employee", "id=2")
 * uDelete("employee", "type=fired")
 *
 * uUpdate("employee", "all", data)
 */
public class uDb {
    String mUrl="jdbc:";
    String mDbServer = "mysql"; // default
    String mServer = "127.0.0.1"; // default
    String mDatabase = "";
    String mUser = "";
    String mPassword = "";
    // Connection
    Connection m_conn;

    // connect to the database.
    // url = "jdbc:mysql://127.0.0.1/mineras";
    public void uConnect() {
        mUrl = mUrl + mDbServer + "://" + mServer + "/" + mDatabase;
        try {
            // TODO: generalizar.
            Class.forName("com.mysql.jdbc.Driver");
            m_conn = DriverManager.getConnection(mUrl, mUser, mPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }

    public void setDBServer(String dbserver) {
        mDbServer = dbserver;
    }

    public void setServer() {}

    public void setUser(String user, String password) {
        mUser = user;
        mPassword = password;
    }

    public void setDatabase(String database) {
        mDatabase = database;
    }

    // close database connection.
    public void uClose() {}

    // run a select command.
    public ResultSet uSelect(String table, String condition) {
        //Statement sqlCommand;
        Statement sqlCommand;
        ResultSet result = null;

        String sql = "SELECT * FROM " + table;

        if(condition.isEmpty())
            condition = "1 = 1";
        sql = sql + " WHERE " + condition;
        try {
            sqlCommand = m_conn.createStatement();
            //sqlCommand.setString(1, table);
            result = sqlCommand.executeQuery(sql);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // update command.
    public void uUpdate(String table, String condition, String data) {}

    // delete command.
    public void uDelete(String table, String condition) {}

}
