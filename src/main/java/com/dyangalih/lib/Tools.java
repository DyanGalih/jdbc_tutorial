package com.dyangalih.lib;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Tools {
    private static Tools instance;

    public static Tools getInstance() {
        if(instance == null){
            instance = new Tools();
        }
        return instance;
    }

    public String loadSql(Class className, String sqlFilePath){
        try {
            return new String(Files.readAllBytes(Paths.get( className.getResource("sql/" + sqlFilePath).toURI())));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

        return null;
    }
}
