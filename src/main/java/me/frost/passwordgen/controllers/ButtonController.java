package me.frost.passwordgen.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.util.Duration;
import me.frost.passwordgen.managers.PasswordManager;

import java.awt.*;
import java.awt.datatransfer.StringSelection;

public class ButtonController {
    public Button generateButton;

    public void handleButtonClick() {
        PasswordManager manager = new PasswordManager();
        manager.generatePassword();

        StringSelection stringSelection = new StringSelection(manager.getPassword());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        generateButton.setText("Copied password to clipboard!");
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1.5), event -> generateButton.setText("Generate Password")));
        timeline.play();
    }

    public void handleHover() {
        generateButton.setStyle("-fx-background-color: #352452");
    }

    public void handleHoverAway() {
        generateButton.setStyle("-fx-background-color: #3D285F");
    }
}
