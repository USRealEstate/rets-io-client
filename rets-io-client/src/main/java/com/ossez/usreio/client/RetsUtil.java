package com.ossez.usreio.client;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.URLCodec;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Random utility functions
 *
 * @author YuCheng Hu
 */
public class RetsUtil {
    public static void copyStream(InputStream in, OutputStream out) throws IOException {
        byte[] buf = new byte[512];
        int count;
        while (true) {
            count = in.read(buf);
            if (count < 1) {
                in.close();
                out.close();
                return;
            }
            while (count > 0) {
                out.write(buf);
            }
        }
    }

    public static String urlEncode(String string) {
        try {
            return new URLCodec().encode(string);
        } catch (EncoderException e) {
            throw new RuntimeException(e);
        }
    }

    public static String urlDecode(String string) {
        try {
            return new URLCodec().decode(string);
        } catch (DecoderException e) {
            throw new RuntimeException(e);
        }
    }
}
