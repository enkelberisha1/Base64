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

        for (int i = 0; i < paddingCount; i++) {
            result.append('=');
        }

        return result.toString();
    }

    // Fixed custom Base64 Decoding
    public static byte[] customDecode(String encoded) {
        if (encoded == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }

        // Remove all whitespace and padding
        String clean = encoded.replaceAll("\\s+", "").replaceAll("=+$", "");
        int length = clean.length();

        // Calculate output length
        int outputLength = (length * 6) / 8;
        byte[] result = new byte[outputLength];
        int buffer = 0;
        int bitCount = 0;
        int index = 0;

        for (char c : clean.toCharArray()) {
            int value = BASE64_CHARS.indexOf(c);
            if (value == -1) {
                throw new IllegalArgumentException(
                        "Invalid Base64 character: '" + c + "'");
            }

            buffer = (buffer << 6) | value;
            bitCount += 6;

            if (bitCount >= 8) {
                bitCount -= 8;
                result[index++] = (byte) ((buffer >> bitCount) & 0xFF);
            }
        }

        return result;
    }
}
    

