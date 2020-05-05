package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    public final int INTERVAL = 100; // interval between every render
    public final int COLUMNS_NUM = 50;
    public final int ROWS_NUM = 50;

    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane root = initGridPane(COLUMNS_NUM, ROWS_NUM);
        Game game = new Game();
        Scene scene = new Scene(root, 800, 600);
        scene.setOnKeyPressed(e -> { // if enter is pressed get new pattern
            if(e.getCode() == KeyCode.ENTER) {
                game.nextPattern();
            }
        });
        primaryStage.setScene(scene);
        primaryStage.show();

        final Timeline timeline = new Timeline( // refresh grid every given interval
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

    public GridPane initGridPane(int colnum, int rownum) { // initiate grid with given columns and rows
        GridPane root = new GridPane();
        for (int i = 0; i < colnum; i++) { // add column constraint for every column
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / colnum); // setts column width
            colConst.setFillWidth(true);
            colConst.setHgrow(Priority.ALWAYS); // allows cell to change size if needed
            root.getColumnConstraints().add(colConst);
        }
        for (int i = 0; i < rownum; i++) { // add row constraint for every row
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(100.0 / rownum); // setts row height
            rowConst.setFillHeight(true);
            rowConst.setVgrow(Priority.ALWAYS); // allows cell to change size if needed
            root.getRowConstraints().add(rowConst);
        }
        return root;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
