package com.thoughtworks.capacity.gtb.mvc;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServic {

    private Map<String, User> userMap = new HashMap<>();

    public UserServic(){
        userMap.put("user1", new User(1,"user1","123456","user1@qq.com"));
        userMap.put("user2", new User(2,"user2","112233","user2@163.com"));
        userMap.put("user3", new User(3,"user3","111222","user3@126.com"));
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
}
