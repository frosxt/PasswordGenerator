package me.frost.passwordgen.managers;

import org.apache.commons.lang3.RandomStringUtils;

public class PasswordManager {
    private String password;

    public PasswordManager() {
    }

    public void generatePassword() {
        password = RandomStringUtils.random(54, true, true);
    }

    public String getPassword() {
        return password;
    }
}
