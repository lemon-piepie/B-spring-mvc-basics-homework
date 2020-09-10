package com.thoughtworks.capacity.gtb.mvc;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private static Map<String, User> userMap = new HashMap<>();

    public UserService(){
        userMap.put("user1", new User(1,"user1","user1@qq.com","123456"));
        userMap.put("user2", new User(2,"112233","user2@163.com","user2"));
        userMap.put("user3", new User(3,"user3","user3@126.com","111222"));
    }

    public void newUser(User user) {
        userMap.put(user.getUserName(),user);
    }

    public User getUserByUserName(String userName){
        return userMap.get(userName);
    }

    public boolean isUserExistsAndPswCorrect (String userName, String password) {
        return(userMap.get(userName) != null && userMap.get(userName).getPassword().equals(password));
    }

    public User isUserLegalAndPswLegal(String userName, String password) {
        int nameLengthMin = 3;
        int nameLengthMax = 10;
        int pswLengthMin = 5;
        int pswLengthMax = 12;
        String userNamePattern = "^[_0-9a-zA-Z]+$";
        if (userName.length() < nameLengthMin || userName.length() > nameLengthMax || (!userName.matches(userNamePattern))){
            throw new IllegalUserNameException();
        }else if (password.length() < pswLengthMin || password.length() > pswLengthMax){
            throw new IllegalPasswordException();
        }else if (this.isUserExistsAndPswCorrect(userName,password)){
            return this.getUserByUserName(userName);
        }else{
            throw new UserNameOrPasswordNotMatchException();
        }
    }
}