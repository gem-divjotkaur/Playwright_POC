package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * This ConfigReader class provides some data like username, password, url etc to avoid hardcoding
 * create instance of Properties class
 * Then followed by this, create an method to get the data from this properties file
 * create an instance of FileInputStream and store the path of this config.properties file inside it
 * now load this properties file and get the data from properties file
 */
public class ConfigReader {
    public static String AmazonUrl;
    public static String PlaywrightMethodUrl;
    public static String DropdownUrl;
    public static String AlertUrl;
    public static String AuthenticationUrl;
    public static String MyntraUrl;
    public static String Facebook;
    public static String bookCart;
    public static String locatorsUrl;
    public static String frameUrl;
    public static String downloadFiles;
    public static String uploadFile;
    public static String maskScreenshot;
    public static String windowHandleUrl;
    public static Properties properties = new Properties();
    public static void getProperties(){
        try{
            FileInputStream inputStream = new FileInputStream("C:\\Users\\divjot.kaur\\IdeaProjects\\integrationtesting\\src\\config.properties");
            properties.load(inputStream);

            AmazonUrl =  properties.getProperty("AmazonUrl");
            PlaywrightMethodUrl = properties.getProperty("PlaywrightMethodUrl");
            DropdownUrl = properties.getProperty("DropdownUrl");
            AlertUrl = properties.getProperty("AlertUrl");
            AuthenticationUrl= properties.getProperty("AuthenticationUrl");
            MyntraUrl  = properties.getProperty("MyntraUrl");
            Facebook = properties.getProperty("Facebook");
            bookCart = properties.getProperty("bookCart");
            locatorsUrl = properties.getProperty("locatorsUrl");
            frameUrl = properties.getProperty("frameUrl");
            downloadFiles = properties.getProperty("downloadFiles");
            uploadFile = properties.getProperty("uploadFile");
            maskScreenshot = properties.getProperty("maskScreenshot");
            windowHandleUrl = properties.getProperty("windowHandleUrl");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
