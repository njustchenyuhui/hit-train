package com.sample.domain;

/**
 * @创建人 Missbear
 * @创建时间 2018.9.28
 * @描述
 */
public class QueryVo {
    String username;
    String address;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "QueryVo{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
