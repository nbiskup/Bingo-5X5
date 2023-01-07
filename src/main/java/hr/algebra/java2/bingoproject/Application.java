package hr.algebra.java2.bingoproject;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.RecursiveTask;


public class Application extends javafx.application.Application {

    private static Stage mainStage;
    private static String playerName = "";

    @Override
    public void start(Stage stage) throws IOException {
        mainStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("selectTicket.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 550, 250);
        mainStage.setTitle("SELECT TICKET!");
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static Stage getMainStage(){
        return mainStage;
    }

    public static String getPlayerName() {return playerName;}

    public static void main(String[] args) {

        int counter = 1;

        for (String param : args){
            if (args.length > counter)
                playerName = param + " ";
            else
                playerName += param;

            counter++;
        }

        launch();
    }
}