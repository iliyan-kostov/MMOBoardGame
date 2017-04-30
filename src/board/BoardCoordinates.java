package board;

/**
 * <p>
 * Клас, описващ целочислена двойка координати на дъската (x, y). Двойките
 * координати са сравними помежду си съгласно интерфейса {@link Comparable} -
 * подредени са в нарастващ ред:
 * <li>
 * първо - по номера на реда (Y)
 * <li>
 * после - по номера на колоната (X)
 *
 * @author iliyan-kostov <https://github.com/iliyan-kostov/>
 */
public class BoardCoordinates implements Comparable<BoardCoordinates> {

    /**
     * стойността на X-координатата
     */
    private final int x;

    /**
     * стойността на Y-координатата
     */
    private final int y;

    /**
     * Конструктор.
     *
     * @param x стойността на X-координатата
     *
     * @param y стойността на Y-координатата
     */
    public BoardCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Връща стойността на X-координатата.
     *
     * @return стойността на X-координатата
     */
    public int getX() {
        return this.x;
    }

    /**
     * Връща стойността на Y-координатата.
     *
     * @return стойността на Y-координатата
     */
    public int getY() {
        return this.y;
    }

    @Override
    public int compareTo(BoardCoordinates other) {
        if (this.y > other.y) {
            return 1;
        } else if (this.y < other.y) {
            return -1;
        } else {
            if (this.x > other.x) {
                return 1;
            } else if (this.x < other.x) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
