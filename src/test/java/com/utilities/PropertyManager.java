package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class PropertyManager {

    private static PropertyManager instance;
    private static final Object lock = new Object();
    private static String googleUrl;
    private static String emailId;
    private static String password;

    public static  PropertyManager getInstance(String className, String fileName) throws IOException, ClassNotFoundException {
        System.out.println("class name :"+className +" filename : "+ fileName + " user.dir="+System.getProperty("user.dir") );
        Class myClass = Class.forName(className);
        File file = new File(System.getProperty("user.dir")+"\\"+fileName);
        String path = file.getAbsolutePath();
        path = URLDecoder.decode(path, StandardCharsets.UTF_8); // remove encoders added to the file path
        FileInputStream fis =new FileInputStream(path);
        if(instance == null) {
            synchronized (lock) {
                instance = new PropertyManager();
                instance.loadProps(fis);
            }
        }
        return instance;
    }

    private void loadProps(FileInputStream fis) throws IOException {
        Properties prop1 = new Properties();
        String path=null;
        //try {
            prop1.load(fis);
        //} catch(Exception ex) {
          //  System.out.println("app.prop file abs path location :"+path);
           // System.out.println("not able to load properties using Properties Manager class : Reason : "+ ex.getMessage());
        //}

        googleUrl = prop1.getProperty("googleUrl");
        emailId = prop1.getProperty("emailId");
        password=prop1.getProperty("password");
    }

    public String getGoogleUrl() {
        return googleUrl;
    }

    public String getEmailId() {
        return emailId;
    }
    public String getPassword() {
        return password;
    }

}
