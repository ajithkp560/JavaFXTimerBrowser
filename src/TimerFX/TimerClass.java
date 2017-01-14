package TimerFX;
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.ContextMenuHandler;
import com.teamdev.jxbrowser.chromium.ContextMenuParams;
import com.teamdev.jxbrowser.chromium.events.TitleEvent;
import com.teamdev.jxbrowser.chromium.events.TitleListener;
import com.teamdev.jxbrowser.chromium.javafx.BrowserView;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.geometry.Point2D;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.io.IOException;
import java.net.*;
import java.util.ResourceBundle;

/**
 * Created by TERMINAL on 1/6/2017.
 */
/*

WebView myBrowser = new WebView();
      WebEngine myWebEngine = myBrowser.getEngine();
      myWebEngine.load("http://terminalcoders.blogspot.com/");
 */
public class TimerClass implements Initializable {
    static final Integer START = (15 * 60);
    Integer timesec = START;
    Timeline timeline, checkInternet;
    @FXML
    VBox VBoxFX;
    @FXML
    Label TimerFX;
    //@FXML
    StackPane WebSpace = new StackPane();
    @FXML
    AnchorPane StartFX, TabFX;

    KeyCodeCombination minimize;

    TabPane tabPane = new TabPane();

    @FXML
    public void KeyPressed(KeyEvent event) {
        if(minimize.match(event))
        {
            Stage app = (Stage) StartFX.getScene().getWindow();
            app.setIconified(true);
        }
    }

    @FXML
    public void KeyRel(KeyEvent event) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        minimize = new KeyCodeCombination(KeyCode.M, KeyCombination.CONTROL_DOWN);
        Browser browser = new Browser();
        BrowserView browserView = new BrowserView(browser);
        browser.setContextMenuHandler(new MyContextMenuHandler(browserView));
        WebSpace.getChildren().add(browserView);
        browser.loadURL("http://google.com");
        timesec = START;
        TimerFX.setText("Time Left: " + (timesec / 60) + ":" + (timesec % 60));
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(1),
                        new EventHandler() {
                            @Override
                            public void handle(Event t) {
                                String sec = "" + (timesec % 60);
                                if ((timesec % 60) < 10)
                                    sec = "0" + (timesec % 60);
                                String min = "" + (timesec / 60);
                                if ((timesec / 60) < 10)
                                    min = "0" + (timesec / 60);
                                timesec--;
                                TimerFX.setText("Time Left: " + min + ":" + sec);
                                if (timesec <= 0) {
                                    timeline.stop();
                                    //question.setText("Time Out!!!\nYour Score is "+score);
                                    //root.setDisable(true);
                                    finish();
                                }
                            }
                        }));
        timeline.playFromStart();

        tabPane.getStyleClass().add("tab-pane");

        WebSpace.setPrefWidth(1366);
        WebSpace.setPrefHeight(685);
        Tab tabMain = new Tab();
        tabMain.setText("zeITgeist 2k17");
        tabMain.setContent(WebSpace);
        tabPane.getTabs().add(tabMain);
        VBoxFX.getChildren().add(tabPane);
    }



    @FXML
    public void goGoole(ActionEvent actionEvent) {
        Browser browser = new Browser();
        BrowserView browserView = new BrowserView(browser);
        browser.setContextMenuHandler(new MyContextMenuHandler(browserView));
        StackPane WebSpace = new StackPane();
        WebSpace.getChildren().add(browserView);
        Tab tabMain = new Tab();
        tabMain.setContent(WebSpace);
        tabPane.getTabs().add(tabMain);
        browser.loadURL("http://google.com");
        tabMain.setText("zeITgeist 2k17");
    }

    @FXML
    public void goBing(ActionEvent actionEvent) {
        Browser browser = new Browser();
        BrowserView browserView = new BrowserView(browser);
        browser.setContextMenuHandler(new MyContextMenuHandler(browserView));
        StackPane WebSpace = new StackPane();
        WebSpace.getChildren().add(browserView);
        Tab tabMain = new Tab();
        tabMain.setContent(WebSpace);
        tabPane.getTabs().add(tabMain);
        browser.loadURL("http://bing.com");
        tabMain.setText("zeITgeist 2k17");
    }

    @FXML
    private void finish() {
        openNewWindow("Finish.fxml");
    }

    public boolean internetAvailable() {
        try {
            URL url = new URL("http://google.com");
            URLConnection conn = url.openConnection();
            conn.connect();
            return true;
        } catch (UnknownHostException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
    }

    /*@FXML
    public void goBack(ActionEvent actionEvent) {
        //browser.goBack();
        Tab activeTab = tabPane.getSelectionModel().getSelectedItem();
    }
    @FXML
    public void goForward(ActionEvent actionEvent) {
        browser.goForward();
    }*/

    @FXML
    public void addTab(ActionEvent actionEvent) {
        Browser browser = new Browser();
        BrowserView browserView = new BrowserView(browser);
        browser.setContextMenuHandler(new MyContextMenuHandler(browserView));
        StackPane WebSpace = new StackPane();
        WebSpace.getChildren().add(browserView);
        Tab tabMain = new Tab();
        tabMain.setContent(WebSpace);
        tabPane.getTabs().add(tabMain);
        browser.loadURL("http://google.com");
        tabMain.setText("zeITgeist 2k17");
    }

    private class MyContextMenuHandler implements ContextMenuHandler {

        private final Pane pane;

        private MyContextMenuHandler(Pane paren) {
            this.pane = paren;
        }

        public void showContextMenu(final ContextMenuParams params) {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    createAndDisplayContextMenu(params);
                }
            });
        }

        private void createAndDisplayContextMenu(final ContextMenuParams params) {
            final ContextMenu contextMenu = new ContextMenu();

            // Since context menu doesn't auto hide, listen mouse press events
            // on BrowserView and hide context menu on mouse press
            pane.getChildren().get(0).setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    contextMenu.hide();
                }
            });

            // If there's link under mouse pointer, create and add
            // the "Open link in new window" menu item to our context menu
            if (!params.getLinkText().isEmpty()) {
                contextMenu.getItems().add(createMenuItem(
                        "Open in new Tab", new Runnable() {
                            public void run() {
                                String linkURL = params.getLinkURL();
                                System.out.println("linkURL = " + linkURL);
                                Browser browser = new Browser();
                                BrowserView browserView = new BrowserView(browser);
                                browser.setContextMenuHandler(new MyContextMenuHandler(browserView));
                                StackPane WebSpace = new StackPane();
                                WebSpace.getChildren().add(browserView);
                                Tab tabMain = new Tab();
                                tabMain.setContent(WebSpace);
                                tabPane.getTabs().add(tabMain);
                                browser.loadURL(linkURL);
                                tabMain.setText("zeITgeist 2k17");
                            }
                        }));
            }

            // Create and add "Reload" menu item to our context menu
            contextMenu.getItems().add(createMenuItem("Reload", new Runnable() {
                public void run() {
                    params.getBrowser().reload();
                }
            }));

            contextMenu.getItems().add(createMenuItem("Forward", new Runnable() {
                public void run() {
                    params.getBrowser().goForward();
                }
            }));

            contextMenu.getItems().add(createMenuItem("Backward", new Runnable() {
                public void run() {
                    params.getBrowser().goBack();
                }
            }));

            // Display context menu at required location on screen
            Point location = params.getLocation();
            Point2D screenLocation = pane.localToScreen(location.x, location.y);
            contextMenu.show(pane, screenLocation.getX(), screenLocation.getY());
        }

        private MenuItem createMenuItem(String title, final Runnable action) {
            MenuItem menuItem = new MenuItem(title);
            menuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    action.run();
                }
            });
            return menuItem;
        }
    }
    public void openNewWindow(String FXMLFile)
    {
        //ChildNode child;
        try {
            URL url = getClass().getResource(FXMLFile);
            FXMLLoader fxmlLoader = new FXMLLoader();

            fxmlLoader.setLocation(url);
            fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
            AnchorPane page = (AnchorPane) fxmlLoader.load(url.openStream());

            FinishCtrl finishCtrl = fxmlLoader.<FinishCtrl>getController();
            finishCtrl.setTimex(timesec);

            StartFX.getChildren().clear();///name of pane where you want to put the fxml.
            StartFX.getChildren().add(page);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
