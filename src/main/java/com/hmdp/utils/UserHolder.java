package com.hmdp.utils;

import com.hmdp.dto.UserDTO;

public class UserHolder {
    // 一次请求是一个线程，一次请求一个ThreadLocal线程域对象
    private static final ThreadLocal<UserDTO> tl = new ThreadLocal<>();

    public static void saveUser(UserDTO user){
        tl.set(user);
    }

    public static UserDTO getUser(){
        return tl.get();
    }

    public static void removeUser(){
        tl.remove();
    }
}
