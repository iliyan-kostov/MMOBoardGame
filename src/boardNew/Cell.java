package boardNew;

/**
 * <p>
 * Абстрактен клас за полетата от дъската.
 * <p>
 * Полетата в една дъска се различават по своите координати (ред, колона).
 * <p>
 * Веднъж зададени, координатите на едно поле в рамките на дъската не могат да
 * бъдат променяни.
 *
 * @author iliyan-kostov <https://github.com/iliyan-kostov/>
 */
public abstract class Cell {

    /**
     * дъска, от която полето е част
     */
    protected final Board board;

    /**
     * координати на полето в рамките на дъската
     */
    protected final BoardCoords boardCoords;

    /**
     * <p>
     * Конструктор.
     *
     * @param board дъска, от която полето е част
     *
     * @param row номер на реда на полето в рамките на дъската
     *
     * @param col номер на колоната на полето в рамките на дъската
     */
    public Cell(Board board, int row, int col) {
        this.board = board;
        this.boardCoords = new BoardCoords(row, col);
    }

    /**
     * <p>
     * Връща координатите на полето в рамките на дъската.
     *
     * @return координатите на полето в рамките на дъската
     */
    public final BoardCoords getBoardCoords() {
        return this.boardCoords;
    }
}
