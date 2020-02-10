package com.example.studysystem.DTO;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * @author Misaikun
 * @ClassName UserDto
 * @description 登陆用
 * @date 2020/2/4 22:21
 */
public class UserDto {
    @NotNull
    private String name;

    @NotNull
    private String password;

    @NotNull
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(name, userDto.name) &&
                Objects.equals(password, userDto.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password);
    }
}
