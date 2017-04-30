package board;

import java.awt.Dimension;
import java.util.TreeMap;

/**
 * <p>
 * Абстрактен клас за дъската в играта.
 * <p>
 * Дъската може да бъде абстрактно представена като ортогонална мрежа от полета,
 * върху всяко от които в даден момент може да бъде разположена най-много една
 * фигура. Полетата са разположени по две оси - в редове (по X - ширина) и
 * колони (по Y - височина). Размерите на дъската са от типа {@link Dimension},
 * определящ броя редове (височина, Y, height) и броя колони (ширина, X, width).
 * Горното ляво поле е с координати (x=1, y=1), като координатите нарастват в
 * посока отляво надясно и отгоре надолу.
 * <p>
 * Възможно и препоръчително е при описание на логиката на играта чрез
 * класове-наследници да бъде реализирана концепцията за свързани и ограничени
 * свойства.
 *
 * @author iliyan-kostov <https://github.com/iliyan-kostov/>
 */
public abstract class Board {

    /**
     * размерите на дъската
     */
    private final Dimension dimension;

    /**
     * описание на наличните върху дъската фигури - на координатите на поле
     * ({@link BoardCoordinates}) съпоставя наличната върху полето фигура.
     * Полетата са подредени според подредбата на класа-ключ:
     * {@link BoardCoordinates}
     */
    private final TreeMap<BoardCoordinates, Figure> figures;

    /**
     * Конструктор. Създава празна дъска със зададените размери.
     *
     * @param dimension размерите на дъската
     *
     * @throws IllegalArgumentException ако накой от зададените размери на
     * дъската не е положителен
     */
    public Board(Dimension dimension) throws IllegalArgumentException {
        if ((dimension.width < 1) || (dimension.height < 1)) {
            this.dimension = new Dimension(dimension.width, dimension.height);
            this.figures = new TreeMap<>();
        } else {
            throw new IllegalArgumentException("Накой от зададените размери на дъската не е положителен!");
        }
    }

    /**
     * Връща размерите на дъската.
     *
     * @return размерите на дъската
     */
    public Dimension getDimension() {
        return new Dimension(this.dimension.width, this.dimension.height);
    }

    /**
     * Връща като резултат фигурата, разположена върху полето със зададените X и
     * Y координати, ако има такава; в противен случай връща null.
     *
     * @param x X-координатата на полето
     *
     * @param y Y-координатата на полето
     *
     * @return фигурата, разположена върху полето със зададените X и Y
     * координати, ако има такава; в противен случай връща null
     *
     * @throws IllegalArgumentException ако зададените координати са извън
     * обхвата на дъската
     */
    public Figure getFigure(int x, int y) throws IllegalArgumentException {
        if ((1 <= x) && (x <= this.dimension.width) && (1 <= y) && (y <= this.dimension.height)) {
            return this.figures.get(new BoardCoordinates(x, y));
        } else {
            throw new IllegalArgumentException("Зададените координати са извън обхвата на дъската!");
        }
    }

    /**
     * Поставя зададената фигура върху полето със зададените X и Y координати,
     * като заменя предишно поставената върху полето фигура, ако има такава.
     * Връща като резултат предишно поставената върху полето фигура, ако има
     * такава; в противен случай връща null.
     *
     * @param x X-координатата на полето
     *
     * @param y Y-координатата на полето
     *
     * @param figure фигурата, която да бъде поставена
     *
     * @return предишно поставената върху полето фигура, ако има такава; в
     * противен случай връща null
     *
     * @throws IllegalArgumentException ако зададените координати са извън
     * обхвата на дъската
     */
    public Figure setFigure(int x, int y, Figure figure) throws IllegalArgumentException {
        if ((1 <= x) && (x <= this.dimension.width) && (1 <= y) && (y <= this.dimension.height)) {
            Figure previous = this.getFigure(x, y);
            this.figures.remove(new BoardCoordinates(x, y));
            this.figures.put(new BoardCoordinates(x, y), figure);
            return previous;
        } else {
            throw new IllegalArgumentException("Зададените координати са извън обхвата на дъската!");
        }
    }

    /**
     * Премества фигура от едно поле в друго по зададени координати на началното
     * и крайното поле. Връща като резултат предишно поставената върху крайното
     * поле фигура, ако има такава; в противен случай връща null. Конкретната
     * имплементация на метода се предоставя за класовете-наследници, в
     * съответствие с конкретните правила и логика на играта.
     *
     * @param x1 X-координатата на началното поле
     *
     * @param y1 Y-координатата на началното поле
     *
     * @param x2 X-координатата на крайното поле
     *
     * @param y2 Y-координатата на крайното поле
     *
     * @return предишно поставената върху крайното поле фигура, ако има такава;
     * в противен случай връща null
     *
     * @throws IllegalArgumentException ако зададените координати са извън
     * обхвата на дъската
     */
    public abstract Figure moveFigure(int x1, int y1, int x2, int y2);
}
