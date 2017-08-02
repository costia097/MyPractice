package ru.javastudy.springMVC.model;

import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
public class User {

    private String name;
    private String password;
    private String bio;
    private byte[] track;
    private int countMoney;

    public User() {
    }

    public User(String name, String password, String bio, byte[] track, int countMoney) {
        this.name = name;
        this.password = password;
        this.bio = bio;
        this.track = track;
        this.countMoney = countMoney;
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

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public byte[] getTrack() {
        return track;
    }

    public void setTrack(byte[] track) {
        this.track = track;
    }

    public int getCountMoney() {
        return countMoney;
    }

    public void setCountMoney(int countMoney) {
        this.countMoney = countMoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (countMoney != user.countMoney) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (bio != null ? !bio.equals(user.bio) : user.bio != null) return false;
        return Arrays.equals(track, user.track);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (bio != null ? bio.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(track);
        result = 31 * result + countMoney;
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", bio='" + bio + '\'' +
                ", track=" + Arrays.toString(track) +
                ", countMoney=" + countMoney +
                '}';
    }
}
