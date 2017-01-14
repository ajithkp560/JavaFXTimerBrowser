package TimerFX;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.util.Duration;

/**
 * Created by TERMINAL on 1/8/2017.
 */
public class Controller implements Initializable{
    @FXML
    TextFlow TextFX;
    @FXML
    AnchorPane StartFX;
    @FXML
    AnchorPane GraphicsFX;
    @FXML
    StackPane ButtonFX;
    @FXML
    Button StartBtn;
    String[] colors = { "#C0392B", "#9B59B6", "#2980B9", "#1ABC9C", "#F1C40F", "#E67E22", "#BDC3C7", "#7F8C8D", "#212F3C" };
    Text[] t = new Text[11];

    @FXML
    public void startClicked(ActionEvent evt) throws Exception {
        openNewWindow("Timer.fxml");
    }

    public void initialize(URL url, ResourceBundle rb){
        this.t[0] = new Text("z");
        this.t[1] = new Text("e");
        this.t[2] = new Text("I");
        this.t[3] = new Text("T");
        this.t[4] = new Text("g");
        this.t[5] = new Text("e");
        this.t[6] = new Text("i");
        this.t[7] = new Text("s");
        this.t[8] = new Text("t 2");
        this.t[9] = new Text("K");
        this.t[10] = new Text("17");
        Group circ = new Group();

        Font.loadFont(getClass().getResource("vermin-vibes.ttf").toExternalForm(), 100.0);

        this.t[0].setFill(Color.rgb(255, 255, 255));
        this.t[1].setFill(Color.rgb(255, 255, 255));
        this.t[2].setFill(Color.rgb(255, 0, 0));
        this.t[3].setFill(Color.rgb(255, 0, 0));
        this.t[4].setFill(Color.rgb(255, 255, 255));
        this.t[5].setFill(Color.rgb(255, 255, 255));
        this.t[6].setFill(Color.rgb(255, 255, 255));
        this.t[7].setFill(Color.rgb(255, 255, 255));
        this.t[8].setFill(Color.rgb(255, 255, 255));
        this.t[9].setFill(Color.rgb(255, 0, 0));
        this.t[10].setFill(Color.rgb(255, 255, 255));

        this.t[0].getStyleClass().add("zeITgeist");
        this.t[1].getStyleClass().add("zeITgeist");
        this.t[2].getStyleClass().add("zeITgeist");
        this.t[3].getStyleClass().add("zeITgeist");
        this.t[4].getStyleClass().add("zeITgeist");
        this.t[5].getStyleClass().add("zeITgeist");
        this.t[6].getStyleClass().add("zeITgeist");
        this.t[7].getStyleClass().add("zeITgeist");
        this.t[8].getStyleClass().add("zeITgeist");
        this.t[9].getStyleClass().add("zeITgeist");
        this.t[10].getStyleClass().add("zeITgeist");
        ObservableList list = this.TextFX.getChildren();

        list.addAll(new Object[] { this.t[0], this.t[1], this.t[2], this.t[3], this.t[4], this.t[5], this.t[6], this.t[7], this.t[8], this.t[9], this.t[10] });
        for (int i = 0; i < 50; i++){
            Circle c = new Circle(5.0, Color.web("white", 0.05));
            c.setStrokeType(StrokeType.OUTSIDE);
            c.setStroke(Color.web("white", 0.16));
            c.setStrokeWidth(4.0);
            c.setEffect(new BoxBlur(10.0, 10.0, 3));
            circ.getChildren().add(c);
        }
        Rectangle col = new Rectangle(this.GraphicsFX.getWidth(), this.GraphicsFX.getHeight(), new LinearGradient(0.0, 1.0, 1.0, 0.0, true, CycleMethod.NO_CYCLE, new Stop[] { new Stop(0.0, Color.web("#f8bd55")), new Stop(0.14, Color.web("#c0fe56")), new Stop(0.28, Color.web("#5dfbc1")), new Stop(0.43, Color.web("#64c2f8")), new Stop(0.57, Color.web("#be4af7")), new Stop(0.71, Color.web("#ed5fc2")), new Stop(0.85, Color.web("#ef504c")), new Stop(1.0, Color.web("#f2660f")) }));
        col.widthProperty().bind(this.GraphicsFX.widthProperty());
        col.heightProperty().bind(this.GraphicsFX.heightProperty());
        Group grp = new Group(new Node[] { new Group(new Node[] { new Rectangle(this.GraphicsFX.getWidth(), this.GraphicsFX.getHeight(), Color.BLACK), circ }), col });
        col.setBlendMode(BlendMode.OVERLAY);
        this.GraphicsFX.getChildren().add(grp);
        Timeline tm = new Timeline();
        for (Node cir : circ.getChildren()) {
            tm.getKeyFrames().addAll(new KeyFrame[] { new KeyFrame(Duration.ZERO, new KeyValue[] { new KeyValue(cir.translateXProperty(), Double.valueOf(Math.random() * 1366.0)), new KeyValue(cir.translateYProperty(), Double.valueOf(Math.random() * 786.0)) }), new KeyFrame(new Duration(20000.0), new KeyValue[] { new KeyValue(cir.translateXProperty(), Double.valueOf(Math.random() * 1366.0)), new KeyValue(cir.translateYProperty(), Double.valueOf(Math.random() * 786.0)) }) });
        }
        tm.setCycleCount(-1);
        tm.setAutoReverse(true);
        tm.play();
    }

    public void openNewWindow(String FXMLFile){
        try{
            URL url = getClass().getResource(FXMLFile);
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(url);
            fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
            AnchorPane page = (AnchorPane)fxmlLoader.load(url.openStream());

            this.StartFX.getChildren().clear();
            this.StartFX.getChildren().add(page);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
