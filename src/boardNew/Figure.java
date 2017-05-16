package boardNew;

/**
 * <p>
 * Абстрактен клас за фигурите в играта.
 * <p>
 * Фигурите са разположени върху дъска и се различават по координатите (ред,
 * колона) на полетата, върху които са разположени. Всяка фигура принадлежи на
 * определен играч.
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
     * номер на играча, на когото принадлежи фигурата (уникален в рамките на
     * играта)
     */
    protected int player;

    /**
     * <p>
     * Конструктор.
     *
     * @param board дъска, върху която е разположена фигурата
     *
     * @param row номер на реда на полето на фигурата в рамките на дъската
     *
     * @param col номер на колоната на полето на фигурата в рамките на дъската
     *
     * @param player номер на играча, на когото принадлежи фигурата (уникален в
     * рамките на играта)
     */
    public Figure(Board board, int row, int col, int player) {
        this.board = board;
        this.boardCoords = new BoardCoords(row, col);
        this.player = player;
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

    /**
     * Връща номера на играча, на когото принадлежи фигурата.
     *
     * @return номера на играча, на когото принадлежи фигурата (уникален в
     * рамките на играта)
     */
    public final int getPlayer() {
        return this.player;
    }

    /**
     * Задава номера на играча, на когото принадлежи фигурата.
     *
     * @param player номера на играча, на когото принадлежи фигурата (уникален в
     * рамките на играта)
     */
    public void setPlayer(int player) {
        this.player = player;
    }
}
