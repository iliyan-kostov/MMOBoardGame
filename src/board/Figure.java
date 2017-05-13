package board;

/**
 * <p>
 * Базов абстрактен клас за фигурите в играта, основан на
 * {@link javafx.scene.Group}
 * .<p>
 * Всяка фигура е разположена върху поле от дъска.
 *
 * @author iliyan-kostov <https://github.com/iliyan-kostov/>
 */
public abstract class Figure extends javafx.scene.Group {

    /**
     * дъска, от която фигурата е част
     */
    private final Board board;

    /**
     * индекс на реда на полето (по Y), върху което е разположена фигурата
     */
    private int row;

    /**
     * индекс на колоната на полето (по X), върху което е разположена фигурата
     */
    private int col;

    /**
     * Създава фигура, част от определена дъска.
     *
     * @param board дъска, от която фигурата е част
     *
     * @param row индекс на реда на полето (по Y), върху което е разположена
     * фигурата
     *
     * @param col индекс на колоната на полето (по X), върху което е разположена
     * фигурата
     */
    public Figure(Board board, int row, int col) {
        super();
        this.board = board;
        this.row = row;
        this.col = col;
    }

    /**
     * Задава индекс на реда на полето (по Y), върху което е разположена
     * фигурата.
     *
     * @param row индекс на реда на полето (по Y), върху което е разположена
     * фигурата
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * Задава индекс на колоната на полето (по X), върху което е разположена
     * фигурата.
     *
     * @param col индекс на колоната на полето (по X), върху което е разположена
     * фигурата
     */
    public void setCol(int col) {
        this.col = col;
    }

    /**
     * Връща дъската, от която фигурата е част.
     *
     * @return дъската, от която фигурата е част
     */
    public final Board getBoard() {
        return this.board;
    }

    /**
     * Връща индекса на реда на полето (по Y), върху което е разположена
     * фигурата.
     *
     * @return индекса на реда на полето (по Y), върху което е разположена
     * фигурата
     */
    public final int getRow() {
        return this.row;
    }

    /**
     * Връща индекса на колоната на полето (по X), върху което е разположена
     * фигурата.
     *
     * @return индекса на колоната на полето (по X), върху което е разположена
     * фигурата
     */
    public final int getCol() {
        return this.col;
    }
}
