package hr.algebra.java2.bingoproject.jndi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class JNDIManager {

    private static final String PROVIDER_URL = "file:c:/";
    private static final String CONFIGURATION_FILE_NAME = "conf.properties";
    private static InitialContext context;

    public static InitialContext getInitialContext() throws NamingException {
        if (context == null){
            Properties properties = new Properties();
            properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");
            properties.setProperty(Context.PROVIDER_URL, PROVIDER_URL);
            context = new InitialContext(properties);
        }
        return context;
    }

    public static String getConfigurationParameter(JNDIConfigurationKey key) throws NamingException, IOException {
        Object configurationFileObject = getInitialContext().lookup(CONFIGURATION_FILE_NAME);
        Properties prop = new Properties();
        prop.load(new FileReader(configurationFileObject.toString()));
        return prop.getProperty(key.getConfigurationKey());
    }

}
