package com.dyangalih.lib;

import com.dyangalih.conf.Config;
import org.apache.commons.lang3.math.NumberUtils;

import java.sql.*;

public class Database {
    private Connection conn = null;
    public Database(){

        try {
            Class.forName(Config.getInstance().getDriver());
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(Config.getInstance().getHost() + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", Config.getInstance().getUser(), Config.getInstance().getPass());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet open(String sql, Object[] data){
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < data.length; i++) {
                pstmt.setString(i+1, String.valueOf(data[i]));
            }
            return pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void execute(String sql, Object[] data){
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < data.length; i++) {
                 pstmt.setString(i + 1, String.valueOf(data[i]));
            }
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
