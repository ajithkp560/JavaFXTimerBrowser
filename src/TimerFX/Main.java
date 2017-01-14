package TimerFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    /*

    Coded By Ajith Kp [ajithkp560]
    http://www.terminalcoders.blogspot.com
    http://fb.com/ajithkp560

     */

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        primaryStage.setTitle("..:: zeITgeist: Ajith Kp ::..");
        primaryStage.setScene(new Scene(root));//, 1366, 786
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("icons/logo.png")));
    }


    public static void main(String[] args) {
        launch(args);
    }
}
