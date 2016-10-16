package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Root
        VBox root = new VBox();

        //Menu
        HBox menu = new HBox();
        menu.setAlignment(Pos.CENTER);

        root.getChildren().add(menu);

        //Menu - Buttons
        Button btn = new Button();
        btn.setText("Hallo IS108!");
        btn.setPrefSize(400, 20);
        btn.setStyle("-fx-base:yellow;-fx-border-color:red");
        btn.setStyle("");

        Button btn2 = new Button();
        btn2.setText("Hallo IS107!");
        btn2.setPrefSize(400, 20);
        btn2.setStyle("-fx-base:yellow;-fx-border-color:red");
        btn2.setDisable(true);

        Button btn3 = new Button();
        btn3.setText("Nieuw scherm");
        btn3.setPrefSize(400, 20);
        btn3.setStyle("-fx-base:yellow;-fx-border-color:red");

        menu.getChildren().add(btn);
        menu.getChildren().add(btn2);
        menu.getChildren().add(btn3);

        //Scherm container
        BorderPane schermContainer = new BorderPane();
        root.getChildren().add(schermContainer);

        //Scherm 1
        StackPane scherm1 = new StackPane();
        Label labelScherm1 = new Label("Labeltje scherm 1!");
        scherm1.getChildren().add(labelScherm1);

        //Scherm 2
        StackPane scherm2 = new StackPane();
        Label labelScherm2 = new Label("Labeltje scherm 2!");
        scherm2.getChildren().add(labelScherm2);

        //Scherm 3
        FlowPane scherm3 = new FlowPane();
        scherm3.setStyle("-fx-background-color: darkturquoise");


        //Scene 1
        Scene scene = new Scene(root, 300, 250);

        //Scene 2
        VBox root2 = new VBox();

        Button btn4 = new Button("Vorige scherm");
        root2.getChildren().add(btn4);

        Label labelRoot2 = new Label("Label voor nieuwe scene!");
        root2.getChildren().add(labelRoot2);

        Scene scene2 = new Scene(root2, 300, 250);

        //Event handlers for menu
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                btn.setDisable(true);
                btn2.setDisable(false);
                schermContainer.setCenter(scherm1);
            }
        });

        btn2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                btn.setDisable(false);
                btn2.setDisable(true);
                schermContainer.setCenter(scherm2);

            }
        });

        btn3.setOnAction((ActionEvent event) -> {

            primaryStage.setScene(scene2);

        });

        btn4.setOnAction((ActionEvent event) -> {
            primaryStage.setScene(scene);
        });

        //Magic
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
