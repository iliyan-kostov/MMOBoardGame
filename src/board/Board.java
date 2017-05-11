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
     * @throws IllegalArgumentException ако някой от зададените размери на
     * дъската не е положителен
     */
    public Board(Dimension dimension) throws IllegalArgumentException {
        if ((dimension.width < 1) || (dimension.height < 1)) {
            this.dimension = new Dimension(dimension.width, dimension.height);
            this.figures = new TreeMap<>();
        } else {
            throw new IllegalArgumentException("Някой от зададените размери на дъската не е положителен!");
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
     * Връща като резултат фигурата, разположена върху полето със зададените
     * координати, ако има такава; в противен случай връща null.
     *
     * @param boardCoordinates координатите на полето
     *
     * @return фигурата, разположена върху полето със зададените координати, ако
     * има такава; в противен случай връща null
     *
     * @throws IllegalArgumentException ако зададените координати са извън
     * обхвата на дъската
     */
    public Figure getFigure(BoardCoordinates boardCoordinates) throws IllegalArgumentException {
        int x = boardCoordinates.getX();
        int y = boardCoordinates.getY();
        if ((1 <= x) && (x <= this.dimension.width) && (1 <= y) && (y <= this.dimension.height)) {
            return this.figures.get(boardCoordinates);
        } else {
            throw new IllegalArgumentException("Зададените координати са извън обхвата на дъската!");
        }
    }

    /**
     * Премахва зададената фигура върху полето със зададените координати, ако
     * има такава.
     *
     * @param boardCoordinates координатите на полето
     *
     * @throws IllegalArgumentException ако зададените координати са извън
     * обхвата на дъската
     */
    public void removeFigure(BoardCoordinates boardCoordinates) throws IllegalArgumentException {
        int x = boardCoordinates.getX();
        int y = boardCoordinates.getY();
        if ((1 <= x) && (x <= this.dimension.width) && (1 <= y) && (y <= this.dimension.height)) {
            this.figures.remove(boardCoordinates);
        } else {
            throw new IllegalArgumentException("Зададените координати са извън обхвата на дъската!");
        }
    }

    /**
     * Поставя зададената фигура върху полето със зададените координати, като
     * заменя предишно поставената върху полето фигура, ако има такава.
     *
     * @param boardCoordinates координатите на полето
     *
     * @param figure фигурата, която да бъде поставена
     *
     * @throws IllegalArgumentException ако зададените координати са извън
     * обхвата на дъската
     *
     * @throws NullPointerException ако за фигура е зададена стойност null
     */
    public void setFigure(BoardCoordinates boardCoordinates, Figure figure) throws IllegalArgumentException, NullPointerException {
        if (figure == null) {
            throw new NullPointerException("За фигура е зададена стойност null!");
        } else {
            int x = boardCoordinates.getX();
            int y = boardCoordinates.getY();
            if ((1 <= x) && (x <= this.dimension.width) && (1 <= y) && (y <= this.dimension.height)) {
                this.figures.remove(boardCoordinates);
                this.figures.put(boardCoordinates, figure);
            } else {
                throw new IllegalArgumentException("Зададените координати са извън обхвата на дъската!");
            }
        }
    }

    /**
     * Последователно премества множество фигури според зададени масиви от
     * координати на началните и на крайните полета. Конкретната имплементация
     * на метода се предоставя за класовете-наследници, в съответствие с
     * конкретните правила и логика на играта.
     *
     * @param from масив с началните координати
     *
     * @param to масив с крайните координати
     *
     * @throws IllegalArgumentException ако зададените координати са извън
     * обхвата на дъската
     */
    public abstract void moveFigures(BoardCoordinates[] from, BoardCoordinates[] to);
}
