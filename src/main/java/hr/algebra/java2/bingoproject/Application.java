package hr.algebra.java2.bingoproject;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Application extends javafx.application.Application {

    private static Stage mainStage;

    @Override
    public void start(Stage stage) throws IOException {
        mainStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("selectTicket.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 550, 250);
        //scene.getStylesheets().add(Application.class.getResource("Style.css").toExternalForm());
        mainStage.setTitle("SELECT TICKET!");
        mainStage.setScene(scene);
        mainStage.show();
    }
    //linear-gradient(to right, #37D5D6, #ABE9CD);

    //linear-gradient(to right, #4884EE, #06BCFB);

    public static Stage getMainStage(){
        return mainStage;
    }

    public static void main(String[] args) {
        launch();
    }
}