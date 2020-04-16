package core;


import org.apache.commons.lang3.RandomStringUtils;

import java.util.HashMap;

public class UserGenerator {

    public static UserDetails userDetails = new UserDetails();

    public void createUser() {
        userDetails.setUserName("FullClient" + RandomStringUtils.randomNumeric(4));
        userDetails.setFullName("UserName" + RandomStringUtils.randomNumeric(4) + "@mail.com");
    }

    public HashMap<String,String> prepareFullUserDetailForRequest(){
        HashMap<String,String> user = new HashMap<>();
        user.put("username", userDetails.getUserName());
        user.put("fullName", userDetails.getFullName());
        return user;
    }

    public HashMap<String,String> prepareUsernameForRequest(){
        HashMap<String,String> user = new HashMap<>();
        user.put("username", userDetails.getUserName());
        return user;
    }

    public HashMap<String,String> prepareUserFullNameForRequest(){
        HashMap<String,String> user = new HashMap<>();
        user.put("fullName", userDetails.getFullName());
        return user;
    }

}
