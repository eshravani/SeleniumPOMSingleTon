package uitlities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {

    private static ConfigProperties configInstance = null;
    private static Properties propInstance = null;


    private ConfigProperties()
    {
        String envName = System.getProperty("envName");
        String appName = System.getProperty("appName");
       // String filePath = "src\\resources\\" + appName + "\\" + appName + "_" + envName + ".properties";
       // envName = System.getProperty("envName");
       //appName=System.getProperty("appName");
        System.out.println(envName);
        System.out.println(appName);
        String filePath = "resources/"+appName+envName+".properties";
        System.out.println(filePath);
        try {
            switch(envName.toLowerCase())
            {
                case "test"-> filePath="resources/"+appName+envName+".properties";
                case "prod"-> filePath="resources/"+appName+envName+".properties";
                case "dev"-> filePath+="resources/"+appName+envName+".properties";
                default->
                    throw new IllegalArgumentException("Unknown environment: " + envName);
            }
            if(propInstance==null){
                propInstance = new Properties();
            FileInputStream fis = new FileInputStream(filePath);
            propInstance.load(fis);
            System.out.println(envName+" properties are loaded");
        }}
        catch (IOException e)
        {
            System.out.println("file not found exception");
        }
    }

    public static ConfigProperties getConfigInstance()
    {
        if( configInstance==null)
        {
            String envName=System.getProperty("envName","test");
            String appName=System.getProperty("appName","amazon");
            String browserName=System.getProperty("browserName","chrome");
            configInstance =new ConfigProperties();
        }
        return configInstance;
    }

    public static String getPropValue(String property)
    {
        return getConfigInstance().propInstance.getProperty(property);
    }
}
