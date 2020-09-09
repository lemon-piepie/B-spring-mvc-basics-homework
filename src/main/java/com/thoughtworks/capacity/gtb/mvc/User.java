package com.thoughtworks.capacity.gtb.mvc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer userId=0;

    @Size(min = 3, max =10, message = "用户名不合法")
    @NotNull(message = "用户名不为空")
    @Pattern(regexp = "^[_0-9a-zA-Z]+$" , message = "用户名不合法")
    private String userName;

    @Email(message = "邮箱地址不合法")
    private String email;

    @Size(min = 5, max =12, message = "密码不合法")
    @NotNull(message = "密码是不为空")
    private String password;
}
