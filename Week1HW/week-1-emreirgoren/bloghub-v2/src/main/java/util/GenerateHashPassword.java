package util;

import model.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Optional;

public class GenerateHashPassword {


    public String hashPassword(Optional<User> user) throws NoSuchAlgorithmException {

        MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");

        byte[] passwordBytes = user.get().getPassword().getBytes(); // password to byte

        byte[] hashedBytes = messageDigest.digest(passwordBytes); // byte to sha-512 hash

        String hashedPassword = Base64.getEncoder().encodeToString(hashedBytes); // sha-512 to string

        user.get().setPassword(hashedPassword);

        return hashedPassword;

    }




}
