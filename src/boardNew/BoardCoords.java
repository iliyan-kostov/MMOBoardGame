package boardNew;

/**
 * <p>
 * Клас за обекти, представящи координати на поле от дъската като наредена
 * двойка (ред, колона).
 * <p>
 * Oбектите от класа са immutable - техните член-данни не могат да бъдат
 * променяни.
 *
 * @author iliyan-kostov <https://github.com/iliyan-kostov/>
 */
public final class BoardCoords {

    /**
     * номер на ред в рамките на дъската
     */
    public final int row;

    /**
     * номер на колона в рамките на дъската
     */
    public final int col;

    /**
     * <p>
     * Конструктор. Задава номер на ред и номер на колона в рамките на дъската.
     *
     * @param row номер на ред
     *
     * @param col номер на колона
     */
    public BoardCoords(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
