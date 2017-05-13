package board;

/**
 * <p>
 * Базов абстрактен клас за фигурите в играта, основан на
 * {@link javafx.scene.Group}
 * .<p>
 * Всяка фигура е част от дъска.
 *
 * @author iliyan-kostov <https://github.com/iliyan-kostov/>
 */
public abstract class Figure extends javafx.scene.Group {

    /**
     * дъска, от която фигурата е част
     */
    private final Board board;

    /**
     * Създава фигура, част от определена дъска.
     *
     * @param board дъска, от която фигурата е част
     */
    public Figure(Board board) {
        super();
        this.board = board;
    }
}
