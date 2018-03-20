package api.utils;

import org.apache.commons.io.IOUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

    private static Properties configuration;

    static {
        initConfig();
    }

    public static String get(String string) {
        return configuration.getProperty(string);
    }

    public static void initConfig() {
        String environmentName = "properties/" + getEnvironmentFromMasterProperties();
        Properties localProperties = new Properties();
        loadProperties(localProperties, getClassPathResourceStream(environmentName));
        configuration = localProperties;
    }

    private static String getEnvironmentFromMasterProperties() {
        Properties masterProperties = new Properties();
        loadProperties(masterProperties, getClassPathResourceStream("properties/application.properties"));
        String environment = masterProperties.getProperty("ENVIRONMENTPROPERTIESFILE");
        if (StringUtils.isEmpty(environment)) {
            throw new RuntimeException("The Environment key was not present in the master properties or was empty.");
        }
        return environment;
    }

    private static void loadProperties(Properties props, InputStream inputStream) {
        try {
            props.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Could not load properties", e);
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
    }

    public static InputStream getClassPathResourceStream(String classpathResourceLoc) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(classpathResourceLoc);
    }

}
