package com.example.osas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class RockPaperScissors extends Application {

    // Label to show result
    private final Label resultLabel = new Label("Choose Rock, Paper, or Scissors");

    @Override
    public void start(Stage stage) {
        // Create buttons
        Button rock = new Button("Rock");
        Button paper = new Button("Paper");
        Button scissors = new Button("Scissors");

        // Set button actions
        rock.setOnAction(e -> play("Rock"));
        paper.setOnAction(e -> play("Paper"));
        scissors.setOnAction(e -> play("Scissors"));

        // Arrange UI
        VBox layout = new VBox(10, rock, paper, scissors, resultLabel);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");
        Scene scene = new Scene(layout, 300, 200);

        // Set up the stage
        stage.setTitle("Rock Paper Scissors");
        stage.setScene(scene);
        stage.show();
    }

    // Game logic
    private void play(String userChoice) {
        String[] options = {"Rock", "Paper", "Scissors"};
        String computerChoice = options[new Random().nextInt(options.length)];

        String result;

        if (userChoice.equals(computerChoice)) {
            result = "It's a Tie!";
        } else if (
                (userChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
                        (userChoice.equals("Paper") && computerChoice.equals("Rock")) ||
                        (userChoice.equals("Scissors") && computerChoice.equals("Paper"))
        ) {
            result = "You Win!";
        } else {
            result = "Computer Wins!";
        }

        resultLabel.setText("You: " + userChoice + "\nComputer: " + computerChoice + "\n" + result);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
