package UrlShortner.Util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtil {

    public static String generateMD5(String input) {
        try {
            // Create MD5 MessageDigest instance
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Calculate digest and convert to byte array
            byte[] digest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            StringBuilder hexString = new StringBuilder();
            for (byte b : digest) {
                // Convert to 2-digit hex string
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not found", e);
        }
    }

    // Example usage
    public static void main(String[] args) {
        String url = "https://example.com/my-url";
        String hash = generateMD5(url);
        System.out.println("MD5 Hash: " + hash);
    }
}
