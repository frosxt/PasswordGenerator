package me.frost.passwordgen.managers;

import org.apache.commons.lang3.RandomStringUtils;

public class PasswordManager {
    private String password;
    private final int passwordLength;
    private final boolean lettersEnabled;
    private final boolean numbersEnabled;

    public PasswordManager(int passwordLength, boolean lettersEnabled, boolean numbersEnabled) {
        this.passwordLength = passwordLength;
        this.lettersEnabled = lettersEnabled;
        this.numbersEnabled = numbersEnabled;
    }

    public void generatePassword() {
        password = RandomStringUtils.random(passwordLength, lettersEnabled, numbersEnabled);
    }

    public String getPassword() {
        return password;
    }
}
