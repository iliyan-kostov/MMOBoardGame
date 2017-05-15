package boardNew;

/**
 * <p>
 * Абстрактен клас за фигурите в играта.
 * <p>
 * Фигурите са разположени върху дъска и се различават по координатите (ред,
 * колона) на полетата, върху които са разположени.
 *
 * @author iliyan-kostov <https://github.com/iliyan-kostov/>
 */
public abstract class Figure {

    /**
     * дъска, върху която е разположена фигурата
     */
    protected final Board board;

    /**
     * координати на полето на фигурата в рамките на дъската
     */
    protected BoardCoords boardCoords;

    /**
     * <p>
     * Конструктор.
     *
     * @param board дъска, върху която е разположена фигурата
     *
     * @param row номер на реда на полето на фигурата в рамките на дъската
     *
     * @param col номер на колоната на полето на фигурата в рамките на дъската
     */
    public Figure(Board board, int row, int col) {
        this.board = board;
        this.boardCoords = new BoardCoords(row, col);
    }

    /**
     * <p>
     * Връща координатите на полето на фигурата в рамките на дъската.
     *
     * @return координатите на полето на фигурата в рамките на дъската
     */
    public final BoardCoords getBoardCoords() {
        return this.boardCoords;
    }

    /**
     * <p>
     * Задава координатите на полето на фигурата в рамките на дъската.
     *
     * @param boardCoords координатите на полето на фигурата в рамките на
     * дъската
     */
    public void setBoardCoords(BoardCoords boardCoords) {
        this.boardCoords = new BoardCoords(boardCoords.row, boardCoords.col);
    }
}
