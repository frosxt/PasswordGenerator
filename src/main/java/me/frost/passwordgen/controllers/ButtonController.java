package me.frost.passwordgen.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.text.Text;
import javafx.util.Duration;
import me.frost.passwordgen.managers.PasswordManager;

import java.awt.*;
import java.awt.datatransfer.StringSelection;

public class ButtonController {
    private boolean onSettingsPage = false;
    public Button generateButton;
    public Button settingsButton;
    public ToggleButton toggleButton1;
    public ToggleButton toggleButton2;
    public Text numbersEnabled;
    public Text lettersEnabled;
    public Text onOff1;
    public Text onOff2;

    public void handleGenerateButtonClick() {
        PasswordManager manager = new PasswordManager(50, toggleButton2.isSelected(), toggleButton1.isSelected());
        manager.generatePassword();

        StringSelection stringSelection = new StringSelection(manager.getPassword());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        generateButton.setText("Copied password to clipboard!");
        resetGenerateText();
    }

    public void handleSettingsButtonClick() {
        onSettingsPage = !onSettingsPage;
        if (onSettingsPage) {
            numbersEnabled.setVisible(onSettingsPage);
            lettersEnabled.setVisible(onSettingsPage);
            toggleButton1.setVisible(onSettingsPage);
            toggleButton2.setVisible(onSettingsPage);
            onOff1.setVisible(onSettingsPage);
            onOff2.setVisible(onSettingsPage);
            return;
        }
        numbersEnabled.setVisible(onSettingsPage);
        lettersEnabled.setVisible(onSettingsPage);
        toggleButton1.setVisible(onSettingsPage);
        toggleButton2.setVisible(onSettingsPage);
        onOff1.setVisible(onSettingsPage);
        onOff2.setVisible(onSettingsPage);
    }

    public void handleGenerateHover() {
        generateButton.setStyle("-fx-background-color: #352452");
    }

    public void handleGenerateHoverAway() {
        generateButton.setStyle("-fx-background-color: #3D285F");
    }

    public void handleSettingsHover() {
        settingsButton.setStyle("-fx-background-color: #352452");
    }

    public void handleSettingsHoverAway() {
        settingsButton.setStyle("-fx-background-color: #3D285F");
    }

    public void handleNumbersEnabled() {
        if (toggleButton1.isSelected()) {
            onOff1.setText("ON");
            return;
        }
        onOff1.setText("OFF");
    }

    public void handleLettersEnabled() {
        if (toggleButton2.isSelected()) {
            onOff2.setText("ON");
            return;
        }
        onOff2.setText("OFF");
    }

    private void resetGenerateText() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1.5), event -> generateButton.setText("Generate Password")));
        timeline.play();
    }
}
