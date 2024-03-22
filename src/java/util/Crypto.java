
package util;

import java.security.MessageDigest;

public class Crypto {
    public static String toSHA1(String str) {
        String salt = "@GyBBQZUX_vCqS9=V:!HU.zF7GavqS";   
        String result = null;
        
        str += salt;
        try {
            byte[] dataBytes = str.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            result = org.apache.tomcat.util.codec.binary.Base64.encodeBase64String(md.digest(dataBytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
