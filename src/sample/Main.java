package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Main extends Application {

    public final int INTERVAL = 100; // interval between every render

    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane root = new GridPane();
        root.setGridLinesVisible(true);
        Game game = new Game();
        final int numCols = 50 ;
        final int numRows = 50 ;
        for (int i = 0; i < numCols; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / numCols);
            colConst.setFillWidth(true);
            colConst.setHgrow(Priority.ALWAYS);
            root.getColumnConstraints().add(colConst);
        }
        for (int i = 0; i < numRows; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(100.0 / numRows);
            rowConst.setFillHeight(true);
            rowConst.setVgrow(Priority.ALWAYS);
            root.getRowConstraints().add(rowConst);
        }
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
        game.displaySteps(root);

        final Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.millis(INTERVAL),
                        event -> {
                            game.displaySteps(root);
                        }
                )
        );
        timeline.setCycleCount( Animation.INDEFINITE );
        timeline.play();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
