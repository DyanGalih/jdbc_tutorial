package com.dyangalih.conf;

public class Config {
    // JDBC driver name and database URL
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String host = "jdbc:mysql://localhost/jdbc_tutorial";

    //  Database credentials
    private final String user = "root";
    private final String pass = "root1";

    private static Config instance;

    private Config(){};

    public static Config getInstance() {
        if(instance==null){
            instance = new Config();
        }
        return instance;
    }

    public String getDriver() {
        return driver;
    }

    public String getHost() {
        return host;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }
}
