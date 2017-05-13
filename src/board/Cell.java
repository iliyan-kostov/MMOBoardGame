package board;

import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;

/**
 * <p>
 * Клас за полетата от дъската, основан на {@link javafx.scene.shape.Polygon}.
 * <p>
 * Според разположението си спрямо дъската и избрания начин на изчертаване
 * полето има:
 * <ul>
 * <li>индекси на реда и колоната
 * <li>числени координати (X, Y) на центъра
 * <li>дебелина на линията на контура
 * <li>цвят на контура и на вътрешността
 * </ul>
 * <p>
 * Контурът на полето се изчертава навътре, както е дефинирано според
 * {@link Cell#BORDERSTROKETYPE}.
 * <p>
 * Цветовете на полето и на контура могат да бъдат променяни, както и дебелината
 * на линията на контура, докато останалите член-данни (индексите на реда и на
 * колоната и координатите) са окончателни.
 *
 * @author iliyan-kostov <https://github.com/iliyan-kostov/>
 */
public class Cell extends javafx.scene.shape.Polygon {

    /**
     * начин за изчертаване на контура на полето
     */
    private final static StrokeType BORDERSTROKETYPE = StrokeType.INSIDE;

    /**
     * индекс на реда на полето (по Y)
     */
    private final int row;

    /**
     * индекс на колоната на полето (по X)
     */
    private final int col;

    /**
     * X-координата на центъра на полето (спрямо дъската)
     */
    private final double xcenter;

    /**
     * Y-координата на центъра на полето (спрямо дъската)
     */
    private final double ycenter;

    /**
     * дебелина на линията на контура
     */
    private double borderWidth;

    /**
     * цвят на контура
     */
    private Color borderColor;

    /**
     * цвят на вътрешността
     */
    private Color fillColor;

    /**
     * Конструктор. Създава поле със зададените координати (индекси на ред и
     * колона, както и (X, Y) координати на центъра), дебелина на линията на
     * контура, цвят на контура и на вътрешността на полето. Формата на полето
     * се описва чрез последния параметър - списък от числени координати на
     * върховете.
     *
     * @param row индекс на реда на полето (по Y)
     *
     * @param col индекс на колоната на полето (по X)
     *
     * @param xcenter X-координата на центъра на полето (спрямо дъската)
     *
     * @param ycenter Y-координата на центъра на полето (спрямо дъската)
     *
     * @param borderWidth дебелина на линията на контура
     *
     * @param borderColor цвят на контура
     *
     * @param fillColor цвят на вътрешността
     *
     * @param points координати на върховете на полето (полигона)
     *
     * @see javafx.scene.shape.Polygon#Polygon(double...)
     */
    public Cell(int row, int col, double xcenter, double ycenter, double borderWidth, Color borderColor, Color fillColor, double... points) {
        super(points);
        this.row = row;
        this.col = col;
        this.xcenter = xcenter;
        this.ycenter = ycenter;
        this.borderWidth = borderWidth;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
        this.setStrokeWidth(this.borderWidth);
        this.setStrokeType(Cell.BORDERSTROKETYPE);
        this.setStroke(this.borderColor);
        this.setFill(this.fillColor);
    }

    /**
     * Задава дебелина на линията на контура.
     *
     * @param borderWidth дебелина на линията на контура
     */
    public void setBorderWidth(double borderWidth) {
        this.setStrokeWidth(borderWidth);
        this.borderWidth = borderWidth;
    }

    /**
     * Задава цвят на контура.
     *
     * @param borderColor цвят на контура
     */
    public void setBorderColor(Color borderColor) {
        this.setStroke(borderColor);
        this.borderColor = borderColor;
    }

    /**
     * Задава цвят вътрешността.
     *
     * @param fillColor цвят вътрешността
     */
    public void setFillColor(Color fillColor) {
        this.setFill(fillColor);
        this.fillColor = fillColor;
    }

    /**
     * Връща индекса на реда на полето (по Y).
     *
     * @return индекса на реда на полето (по Y)
     */
    public final int getRow() {
        return this.row;
    }

    /**
     * Връща индекса на колоната на полето (по X).
     *
     * @return индекса на колоната на полето (по X)
     */
    public final int getCol() {
        return this.col;
    }

    /**
     * Връща X-координатата на центъра на полето (спрямо дъската).
     *
     * @return X-координатата на центъра на полето (спрямо дъската)
     */
    public final double getXcenter() {
        return this.xcenter;
    }

    /**
     * Връща Y-координатата на центъра на полето (спрямо дъската).
     *
     * @return Y-координатата на центъра на полето (спрямо дъската)
     */
    public final double getYcenter() {
        return this.ycenter;
    }

    /**
     * Връща дебелината на линията на контура.
     *
     * @return дебелината на линията на контура
     */
    public final double getBorderWidth() {
        return this.borderWidth;
    }

    /**
     * Връща цвета на контура.
     *
     * @return цвета на контура
     */
    public final Color getBorderColor() {
        return this.borderColor;
    }

    /**
     * Връща цвета на вътрешността.
     *
     * @return цвета на вътрешността
     */
    public final Color getFillColor() {
        return this.fillColor;
    }
}
