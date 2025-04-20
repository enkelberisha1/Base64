package Code;

import java.util.Base64;

public class Base64Implementation {
    private static final String BASE64_CHARS =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

    // Fixed custom Base64 Encoding
    public static String customEncode(byte[] data) {
        if (data == null) {
            throw new IllegalArgumentException("Input data cannot be null");
        }

        StringBuilder result = new StringBuilder();
        int paddingCount = 0;
        int chunk = 0;
        int bitCount = 0;

        for (byte b : data) {
            // Shift existing bits left and add new byte
            chunk = (chunk << 8) | (b & 0xFF);
            bitCount += 8;

            // When we have at least 6 bits, process them
            while (bitCount >= 6) {
                bitCount -= 6;
                int index = (chunk >> bitCount) & 0x3F;
                result.append(BASE64_CHARS.charAt(index));
            }
        }

        // Handle remaining bits
        if (bitCount > 0) {
            int index = (chunk << (6 - bitCount)) & 0x3F;
            result.append(BASE64_CHARS.charAt(index));
            paddingCount = (3 - (data.length % 3)) % 3;
        }

        // Add padding

