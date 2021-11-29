package com.ossez.usreio.client;

import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Properties;


/**
 * @author YuCheng Hu
 */
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public abstract class RetsTestCase {

    public Properties props = new Properties();
    public String retsLoginUrl;
    public String retsUsername;
    public String retsPassword;

    @BeforeAll
    public void setUp() throws IOException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        props.load(loader.getResourceAsStream("rets.properties"));

        retsLoginUrl = props.getProperty("rets_server");
        retsUsername = props.getProperty("rets_username");
        retsPassword = props.getProperty("rets_password");
    }

    /**
     * Get Resource from file
     *
     * @param name
     * @return
     */
    protected static InputStream getResource(String name) {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        return cl.getResourceAsStream(name);
    }

    /**
     * @param urlStr
     * @return
     */
    protected static InputStream getResourceFromURL(String urlStr) {

        try {
//			in = new URL( "" ).openStream();
            URL oracle = new URL("https://cdn.ossez.com/reso/rets-1x/login/login_response_valid_1.0.xml");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(oracle.openStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null)
                System.out.println(inputLine);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null
                ;
    }

    public void assertEquals(String message, Object[] expected, Object[] actual) {
        boolean success;
        if (expected.length == actual.length) {
            success = true;
            for (int i = 0; i < expected.length; i++) {
                success = true;
                if (!expected[i].equals(actual[i])) {
                    success = false;
                    break;
                }
            }
        } else {
            success = false;
        }

    }

}
