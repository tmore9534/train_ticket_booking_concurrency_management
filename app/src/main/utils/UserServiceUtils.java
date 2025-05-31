package main.utils;

public class UserServiceUtils {

    public static String getHashedPassword(String plain_password){
        String pw_hash = BCrypt.hashpw(plain_password, BCrypt.gensalt());
        return pw_hash;
    }

    public static Boolean checkPassword(String candidate_password, String stored_hash){
       return BCrypt.checkpw(candidate_password, stored_hash)
    }
}
