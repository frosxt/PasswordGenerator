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
    private boolean clickedGenerateButton = false;
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
        clickedGenerateButton = !clickedGenerateButton;
        PasswordManager manager = new PasswordManager(50, toggleButton2.isSelected(), toggleButton1.isSelected());
        manager.generatePassword();

        StringSelection stringSelection = new StringSelection(manager.getPassword());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        generateButton.setText("Copied password to clipboard!");
        setStyle(generateButton, clickedGenerateButton);
        resetGenerateText();
    }

    public void handleSettingsButtonClick() {
        onSettingsPage = !onSettingsPage;
        numbersEnabled.setVisible(onSettingsPage);
        lettersEnabled.setVisible(onSettingsPage);
        toggleButton1.setVisible(onSettingsPage);
        toggleButton2.setVisible(onSettingsPage);
        onOff1.setVisible(onSettingsPage);
        onOff2.setVisible(onSettingsPage);
        setStyle(settingsButton, onSettingsPage);
    }

    public void handleNumbersEnabled() {
        onOff1.setText(toggleButton1.isSelected() ? "ON" : "OFF");
    }

    public void handleLettersEnabled() {
        onOff2.setText(toggleButton2.isSelected() ? "ON" : "OFF");
    }

    private void resetGenerateText() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1.5), event -> {
            clickedGenerateButton = !clickedGenerateButton;
            generateButton.setText("Generate Password");
            setStyle(generateButton, clickedGenerateButton);
        }));
        timeline.play();
    }

    private void setStyle(Button button, boolean bool) {
        if (bool) {
            button.setStyle("-fx-background-color: #352452");
            return;
        }
        button.setStyle("-fx-background-color: #3D285F");
    }
}
