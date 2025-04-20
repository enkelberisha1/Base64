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
