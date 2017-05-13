package board;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

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

        // надолу - инициализация на сцената:
        {
            Board board = new Board(shape, segments, cellSize, borderWidth, borderColor, fillColor);
            PerspectiveCamera camera = new PerspectiveCamera(false);
            Group sceneGroup = new Group(board, camera);
            double sceneXsize = 600;
            double sceneYsize = 400;
            Scene scene = new Scene(sceneGroup, sceneXsize, sceneYsize);
            board.setTranslateX(0);
            board.setTranslateY(0);
            board.setTranslateZ(0);
            board.setTranslateX(0);
            board.setTranslateY(0);
            board.setTranslateZ(0);
            camera.setTranslateX(-sceneXsize / 2);
            camera.setTranslateY(-sceneYsize / 2);
            camera.setTranslateZ(-100);
            camera.setRotationAxis(Rotate.X_AXIS);
            camera.setRotate(60);
            board.setRotate(30);

            RotateTransition rotateTransition = new RotateTransition();
            rotateTransition.setDuration(Duration.millis(5000));
            rotateTransition.setNode(board);
            rotateTransition.setAxis(Rotate.Z_AXIS);
            rotateTransition.setByAngle(360);
            rotateTransition.setCycleCount(RotateTransition.INDEFINITE);
            rotateTransition.setAutoReverse(false);
            rotateTransition.play();

            scene.setCamera(camera);
            stage.setScene(scene);
            stage.show();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
