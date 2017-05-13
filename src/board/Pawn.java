package board;

import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;

/**
 * <p>
 * Клас за фигура (подобна на пешките от шаха), реализирана чрез прости JavaFX
 * триизмерни примитиви.
 *
 * @author iliyan-kostov <https://github.com/iliyan-kostov/>
 */
public final class Pawn extends board.Figure {

    // настройки по подразбиране за размерите
    private final static double DEFAULT_BASERADIUS = 9;
    private final static double DEFAULT_BASEHEIGHT = 3;
    private final static double DEFAULT_MIDDLERADIUS = 7;
    private final static double DEFAULT_TOPRADIUS = 4;
    // настройки по подразбиране за детайлността
    private final static int DEFAULT_BASEDIVISIONS = 16;
    private final static int DEFAULT_MIDDLEDIVISIONS = 16;
    private final static int DEFAULT_TOPDIVISIONS = 16;

    // съставни елементи на обема на фигурата:
    private final Cylinder base;
    private final Sphere middle;
    private final Sphere top;

    /**
     * Създава фигура (подобна на пешките от шаха), част от определена дъска..
     *
     * @param board дъска, от която фигурата е част
     *
     * @param row индекс на реда на полето (по Y), върху което е разположена
     * фигурата
     *
     * @param col индекс на колоната на полето (по X), върху което е разположена
     * фигурата
     */
    public Pawn(Board board, int row, int col) {
        super(board, row, col);
        this.base = new Cylinder(Pawn.DEFAULT_BASERADIUS, Pawn.DEFAULT_BASEHEIGHT, Pawn.DEFAULT_BASEDIVISIONS);
        this.middle = new Sphere(Pawn.DEFAULT_MIDDLERADIUS, Pawn.DEFAULT_MIDDLEDIVISIONS);
        this.top = new Sphere(Pawn.DEFAULT_TOPRADIUS, Pawn.DEFAULT_TOPDIVISIONS);
        this.base.setTranslateX(0);
        this.base.setTranslateY(0);
        this.base.setTranslateZ(0);
        this.middle.setTranslateX(0);
        this.middle.setTranslateY(0);
        this.middle.setTranslateZ(0 - Pawn.DEFAULT_BASEHEIGHT);
        this.top.setTranslateX(0);
        this.top.setTranslateY(0);
        this.top.setTranslateZ(0 - Pawn.DEFAULT_BASEHEIGHT - Pawn.DEFAULT_MIDDLERADIUS / 2);
        this.getChildren().add(this.base);
        this.getChildren().add(this.middle);
        this.getChildren().add(this.top);
    }
}
