package fr.utt.if26.doctolib.Utils;

import android.util.Base64;

import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public  class Encryption {

    public static String encrypt(String email, String password) throws Exception {
        SecretKeySpec key= generateKey(email);
        Cipher c=Cipher.getInstance("AES");
        c.init(Cipher.ENCRYPT_MODE,key);
        byte[] encVal=c.doFinal(password.getBytes());
        String encryptedValue= Base64.encodeToString(encVal, Base64.DEFAULT);
        return  encryptedValue;
    }

    public static String decrypt(String email, String password) throws Exception {
        SecretKeySpec key= generateKey(email);
        Cipher c=Cipher.getInstance("AES");
        c.init(Cipher.DECRYPT_MODE,key);
        byte[] decodedVal=Base64.decode(password,Base64.DEFAULT);
        byte[] decVal=c.doFinal(decodedVal);
        String decryptedValue= new String(decVal);

        return  decryptedValue;
    }

    public static SecretKeySpec generateKey(String email) throws Exception {
        final MessageDigest digest= MessageDigest.getInstance("SHA-256");
        byte[] bytes= email.getBytes("UTF-8");
        digest.update(bytes,0, bytes.length);
        byte[] key=digest.digest();
        SecretKeySpec secretKeySpec= new SecretKeySpec(key, "AES");
        return secretKeySpec;
    }
}
