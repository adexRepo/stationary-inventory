package com.prodex.stationaryinventory.common;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.apache.commons.codec.binary.Hex;

public class HashingPassword {

    private String password = "1";
    private final String salt = "Stationaryes";
    private final int iterations = 10000;
    private final int keyLength = 512;
    private final char[] passwordChars = password.toCharArray();
    private final byte[] saltBytes = salt.getBytes();

    private static byte[] hashPassword(final char[] password, final byte[] salt, final int iterations,
            final int keyLength) {
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, keyLength);
            SecretKey key = skf.generateSecret(spec);
            byte[] res = key.getEncoded();
            return res;
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    public String tryHashPassword(String password) {
        this.password = password;
        
        byte[] hashedBytes = hashPassword(passwordChars, saltBytes, iterations, keyLength);
        String hashedString = Hex.encodeHexString(hashedBytes);

        return hashedString;
    }
}
