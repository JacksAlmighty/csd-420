
 // Jackson Webster
 // CSD-420
 // Assignment: Module 1 – Random Card Display
 // Description:
 // This JavaFX program displays four random playing card images
 // from a deck of 52. The user can click the "Refresh" button to load
 // four new random cards. This program uses lambda expressions and JavaFX layouts.
 

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main extends Application {

    
    private HBox cardBox;

    
    public void start(Stage primaryStage) {

        
        cardBox = new HBox(10);

        
        loadCards();

        
        Button refreshBtn = new Button("Refresh Cards");

        
        refreshBtn.setOnAction(e -> loadCards());

        
        VBox root = new VBox(10);
        root.getChildren().addAll(cardBox, refreshBtn);

        
        Scene scene = new Scene(root, 600, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Card Drawer");
        primaryStage.show();
    }

    
    private void loadCards() {
        cardBox.getChildren().clear();  

        List<Integer> cards = getRandomCards();

        for (int cardNumber : cards) {
            String path = "file:/C:/csd/csd-420/module-1/cards/AssignmentCards/"
                    + cardNumber + ".png";

            Image cardImage = new Image(path);
            ImageView cardView = new ImageView(cardImage);

            cardView.setFitHeight(150);
            cardView.setPreserveRatio(true);

            cardBox.getChildren().add(cardView);
        }
    }

    
    private List<Integer> getRandomCards() {
        List<Integer> numbers = new ArrayList<>();
        Random rand = new Random();

        while (numbers.size() < 4) {
            int number = rand.nextInt(1, 53);
            numbers.add(number);
        }

        return numbers;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
