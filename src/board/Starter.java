package board;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author iliyan-kostov <https://github.com/iliyan-kostov/>
 */
public class Starter extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        // настройки - по избор:
        Board.SHAPE shape = Board.SHAPE.HEXAGON;
        //Board.SHAPE shape = Board.SHAPE.SQUARE;
        //Board.SHAPE shape = Board.SHAPE.TRIANGLE;
        int segments = 5;
        double cellSize = 20;
        double borderWidth = 1;
        Color borderColor = Color.RED;
        Color fillColor = Color.YELLOW;
        double sceneWidth = 900;
        double sceneHeight = 600;

        // надолу - инициализация на сцената:
        {
            Board board = new Board(shape, segments, cellSize, borderWidth, borderColor, fillColor);

            //Creating a scene object 
            Scene scene = new Scene(board, sceneWidth, sceneHeight);

            //Adding scene to the stage 
            stage.setScene(scene);

            //Displaying the contents of the stage 
            stage.show();

            board.setTranslateX(sceneWidth / 2);
            board.setTranslateY(sceneHeight / 2);
            board.setTranslateZ(0);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
