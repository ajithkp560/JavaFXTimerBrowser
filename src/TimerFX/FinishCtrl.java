package TimerFX;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.AnchorPane;
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

import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Math.random;

/**
 * Created by TERMINAL on 1/8/2017.
 */
public class FinishCtrl implements Initializable {
    @FXML
    TextFlow TextFXX;
    @FXML
    Label TextFX;
    @FXML
    AnchorPane GraphicsFX;
    Integer timex = 0;
    Text t[] = new Text[11];
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        t[0] = new Text("z");
        t[1] = new Text("e");
        t[2] = new Text("I");
        t[3] = new Text("T");
        t[4] = new Text("g");
        t[5] = new Text("e");
        t[6] = new Text("i");
        t[7] = new Text("s");
        t[8] = new Text("t 2");
        t[9] = new Text("K");
        t[10] = new Text("17");
        Group circ = new Group();

        Font.loadFont(getClass().getResource("vermin-vibes.ttf").toExternalForm(), 100);

        /*Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(1),
                        new EventHandler() {
                            @Override
                            public void handle(Event tt) {
                                int c = 0;
                                for(int i=0;i<9;i++){
                                    Random rand = new Random();
                                    t[i%9].setFill(Color.rgb(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
                                    t[i%9].getStyleClass().add("zeITgeist");
                                }
                            }
                        }));
        timeline.playFromStart();*/
        t[0].setFill(Color.rgb(255, 255, 255));
        t[1].setFill(Color.rgb(255, 255, 255));
        t[2].setFill(Color.rgb(255, 0, 0));
        t[3].setFill(Color.rgb(255, 0, 0));
        t[4].setFill(Color.rgb(255, 255, 255));
        t[5].setFill(Color.rgb(255, 255, 255));
        t[6].setFill(Color.rgb(255, 255, 255));
        t[7].setFill(Color.rgb(255, 255, 255));
        t[8].setFill(Color.rgb(255, 255, 255));
        t[9].setFill(Color.rgb(255, 0, 0));
        t[10].setFill(Color.rgb(255, 255, 255));

        t[0].getStyleClass().add("zeITgeist");
        t[1].getStyleClass().add("zeITgeist");
        t[2].getStyleClass().add("zeITgeist");
        t[3].getStyleClass().add("zeITgeist");
        t[4].getStyleClass().add("zeITgeist");
        t[5].getStyleClass().add("zeITgeist");
        t[6].getStyleClass().add("zeITgeist");
        t[7].getStyleClass().add("zeITgeist");
        t[8].getStyleClass().add("zeITgeist");
        t[9].getStyleClass().add("zeITgeist");
        t[10].getStyleClass().add("zeITgeist");
        ObservableList list = TextFXX.getChildren();
        //Adding cylinder to the pane
        list.addAll(t[0], t[1], t[2], t[3], t[4], t[5], t[6], t[7], t[8], t[9], t[10]);//t[0], t[1], t[2], t[3], t[4], t[5], t[6], t[7], t[8]


        for (int i = 0; i < 50; i++) {
            Circle c = new Circle(5, Color.web("white", 0.05));
            c.setStrokeType(StrokeType.OUTSIDE);
            c.setStroke(Color.web("white", 0.16));
            c.setStrokeWidth(4);
            c.setEffect(new BoxBlur(10, 10, 3));
            circ.getChildren().add(c);
        }

        Rectangle col = new Rectangle(GraphicsFX.getWidth(), GraphicsFX.getHeight(), new LinearGradient(0f, 1f, 1f, 0f, true, CycleMethod.NO_CYCLE, new Stop[]{
                new Stop(0, Color.web("#f8bd55")),
                new Stop(0.14, Color.web("#c0fe56")),
                new Stop(0.28, Color.web("#5dfbc1")),
                new Stop(0.43, Color.web("#64c2f8")),
                new Stop(0.57, Color.web("#be4af7")),
                new Stop(0.71, Color.web("#ed5fc2")),
                new Stop(0.85, Color.web("#ef504c")),
                new Stop(1, Color.web("#f2660f")),}));
        col.widthProperty().bind(GraphicsFX.widthProperty());
        col.heightProperty().bind(GraphicsFX.heightProperty());
        Group grp = new Group(new Group(new Rectangle(GraphicsFX.getWidth(), GraphicsFX.getHeight(), Color.BLACK), circ), col);
        col.setBlendMode(BlendMode.OVERLAY);
        GraphicsFX.getChildren().add(grp);
        Timeline tm = new Timeline();
        for (Node cir : circ.getChildren()) {
            tm.getKeyFrames().addAll(new KeyFrame(Duration.ZERO, new KeyValue(cir.translateXProperty(), random() * 1366), new KeyValue(cir.translateYProperty(), random() * 786)), new KeyFrame(new Duration(20000), new KeyValue(cir.translateXProperty(), random() * 1366), new KeyValue(cir.translateYProperty(), random() * 786)));
        }
        tm.setCycleCount(Timeline.INDEFINITE);
        tm.setAutoReverse(true);
        tm.play();

        String sec = "" + (timex % 60);
        if ((timex % 60) < 10)
            sec = "0" + (timex % 60);
        String min = "" + (timex / 60);
        if ((timex / 60) < 10)
            min = "0" + (timex / 60);
        TextFX.setText("Your Time is up!!! Time Taken - "+min+":"+sec);
    }
    void setTimex(Integer timex){
        this.timex = (15*60)-timex;
        timex = this.timex;
        String sec = "" + (timex % 60);
        if ((timex % 60) < 10)
            sec = "0" + (timex % 60);
        String min = "" + (timex / 60);
        if ((timex / 60) < 10)
            min = "0" + (timex / 60);
        TextFX.setText("Your Time is up!!! Time Taken - "+min+":"+sec);
    }
}
