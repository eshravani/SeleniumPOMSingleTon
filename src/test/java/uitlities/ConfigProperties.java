package uitlities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {

    private static ConfigProperties configInstance = null;
    private static Properties propInstance = null;

    private ConfigProperties()
    {

        String envName = System.getenv("env");
        String filePath = "resources/";
        try {
            switch(envName.toLowerCase())
            {
                case "test"-> filePath+="data.properties";
                case "prod"-> filePath+="prod.properties";
                case "dev"-> filePath+="dev.properties";
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
            configInstance =new ConfigProperties();
        }
        return configInstance;
    }

    public static String getPropInstance(String property)
    {
        return getConfigInstance().propInstance.getProperty(property);
    }
}
