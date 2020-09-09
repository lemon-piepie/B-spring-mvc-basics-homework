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

    public List<User> getAllUsers() {
        return new ArrayList<User>(userMap.values());
    }

    public void newUser(User user) {
        userMap.put(user.getUserName(),user);
    }

    public User getUserByUserName(String userName){
        return userMap.get(userName);
    }

    public static boolean isUserExistsAndPswCorrect(String userName, String password) {
        if (userMap.get(userName) == null || userMap.get(userName).getPassword().equals(password) == false){
            return false;
        }else{
            return true;
        }
    }
}