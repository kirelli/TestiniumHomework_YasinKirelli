package utils;


import static utils.ConfigUtil.getProperty;


public class Config {

    public static final String URL= getProperty("URL");
    public static final String USERNAME= getProperty("USERNAME");
    public static final String PASSWORD= getProperty("PASSWORD");
    public static final String BROWSER= getProperty("BROWSER");
    public static final String SEARCHKEY= getProperty("SEARCHKEY");
    public static final String PRODUCTCOUNT= getProperty("PRODUCTCOUNT");
    public static final String EMPTYMESSAGE= getProperty("EMPTYMESSAGE");
}
