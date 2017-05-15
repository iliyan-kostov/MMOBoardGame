package boardNew;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;

/**
 * <p>
 * Абстрактен клас за дъската в играта. Дъската се състои от определен брой
 * полета, върху всяко от които може да бъде разположена най-много по една
 * фигура. Полетата са разположени в редове и колони в правилна грометрична
 * мрежа (триъгълна, квадратна или шестоъгълна). Полетата са номерирани, като за
 * всяко поле първо се задава номера на реда, а после - поредния номер на полето
 * в този ред. Номерирането започва отгоре вляво - (0, 0), като номерата на
 * редовете и колоните растат отгоре надолу и отляво надясно.
 * <p>
 * Управлението на играта се извършва чрез заявки към дъската. Дъската е
 * едновременно слушател и източник на събития съгласно конвенцията за свързани
 * и ограничени свойства. Всяка заявка се препраща от дъската към обект-логика
 * на играта ({@link GameLogic}), регистриран като слушател за съответната
 * дъска, за да бъде обработен и да бъде върнат отговор при необходимост.
 * <p>
 * След конструиране на дъската е необходимо да бъде извършено регистрирането на
 * слушатели в двете посоки:
 * <ul>
 * <li>дъската - като слушател за логиката
 * <li>логиката - като слушател за дъската
 * </ul>
 * <p>
 * В противен случай дъската няма да получава информация за събития, възникнали
 * в обекта-логика, и обратно.
 * <p>
 * При конструирането на дъската се задават само формата и размерите й, като
 * дъската се създава празна. Добавянето на фигури и полета се извършва
 * впоследствие, в зависимост от начина на представяне, включително графично,
 * съответно - дали тримерно или двумерно.
 *
 * @author iliyan-kostov <https://github.com/iliyan-kostov/>
 */
public abstract class Board implements PropertyChangeListener, VetoableChangeListener {

    // текстове на съобщения за грешки:
    private final static String EXCEPTION_MESSAGE_INCORRECT_SHAPE = "Shape not defined properly!";
    private final static String EXCEPTION_MESSAGE_INCORRECT_SEGMENTS = "Segments not defined properly!";

    /**
     * възможни форми на дъската
     */
    public static enum SHAPE {
        TRI,
        QUAD,
        HEX
    }

    /**
     * форма на дъската
     */
    protected final SHAPE shape;

    /**
     * брой полета по един ръб на дъската
     */
    protected final int segments;

    /**
     * масив с полетата на дъската, подреден по редове и колони
     */
    protected final Cell[][] cells;

    /**
     * масив с фигурите върху дъската, съответстващи на полетата, подреден по
     * редове и колони
     */
    protected final Figure[][] figures;

    /**
     * източник на събития за свързани свойства
     */
    protected final PropertyChangeSupport propertyChangeSupport;

    /**
     * източник на събития за ограничени свойства
     */
    protected final VetoableChangeSupport vetoableChangeSupport;

    /**
     * <p>
     * Конструктор. Създава празна дъска с определената правилна форма и
     * зададения брой полета по един от ръбовете.
     *
     * @param shape форма на дъската
     *
     * @param segments брой полета по един ръб на дъската
     */
    public Board(SHAPE shape, int segments) {
        // задаване на общите параметри на дъската:
        this.shape = shape;
        this.segments = segments;
        if (segments < 1) {
            throw new NullPointerException(Board.EXCEPTION_MESSAGE_INCORRECT_SEGMENTS);
        } else {
            // размери на масивите с фигури/ полета:
            int size1;
            int size2;
            switch (this.shape) {
                case TRI: {
                    size1 = this.segments;
                    size2 = 2 * this.segments - 1;
                }
                break;
                case QUAD: {
                    size1 = this.segments;
                    size2 = this.segments;
                }
                break;
                case HEX: {
                    size1 = 2 * this.segments - 1;
                    size2 = 2 * this.segments - 1;
                }
                break;
                default: {
                    throw new NullPointerException(Board.EXCEPTION_MESSAGE_INCORRECT_SHAPE);
                }
            }
            // инициализиране на масивите с фигури/ полета:
            this.cells = new Cell[size1][size2];
            this.figures = new Figure[size1][size2];
            for (int i = 0; i < size1; i++) {
                for (int j = 0; j < size2; j++) {
                    this.cells[i][j] = null;
                    this.figures[i][j] = null;
                }
            }
            // инициализиране на поддръжката на свързани и ограничени свойства:
            this.propertyChangeSupport = new PropertyChangeSupport(this);
            this.vetoableChangeSupport = new VetoableChangeSupport(this);
        }
    }

    /**
     * <p>
     * Добавя слушател за събития за свързани свойства.
     *
     * @param listener слушател за събития за свързани свойства
     */
    public final void addPropertyChangeListener(PropertyChangeListener listener) {
        this.propertyChangeSupport.addPropertyChangeListener(listener);
    }

    /**
     * <p>
     * Добавя слушател за събития за свързани свойства.
     *
     * @param propertyName ключова дума, характеризираща свойството
     *
     * @param listener слушател за събития за свързани свойства
     */
    public final void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        this.propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
    }

    /**
     * <p>
     * Добавя слушател за събития за ограничени свойства.
     *
     * @param listener слушател за събития за ограничени свойства
     */
    public final void addVetoableChangeListener(VetoableChangeListener listener) {
        this.vetoableChangeSupport.addVetoableChangeListener(listener);
    }

    /**
     * <p>
     * Добавя слушател за събития за ограничени свойства.
     *
     * @param propertyName ключова дума, характеризираща свойството
     *
     * @param listener слушател за събития за ограничени свойства
     */
    public final void addVetoableChangeListener(String propertyName, VetoableChangeListener listener) {
        this.vetoableChangeSupport.addVetoableChangeListener(propertyName, listener);
    }

    /**
     * <p>
     * Добавя фигура върху поле от дъската според зададени координати на полето.
     * <p>
     * Изпълнява се като следствие на съобщение от страна на обекта-логика.
     *
     * @param figure фигура
     *
     * @param toBoardCoords координати на полето
     */
    public abstract void respondFigureAdd(Figure figure, BoardCoords toBoardCoords);

    /**
     * <p>
     * Премахва фигура от поле от дъската според зададени координати на полето.
     * <p>
     * Изпълнява се като следствие на съобщение от страна на обекта-логика.
     *
     * @param fromBoardCoords координати на полето
     */
    public abstract void respondFigureDelete(BoardCoords fromBoardCoords);

    /**
     * <p>
     * Премества фигура по дъската според зададени координати на началното поле
     * и координати на крайното поле.
     * <p>
     * Изпълнява се като следствие на съобщение от страна на обекта-логика.
     *
     * @param fromBoardCoords координати на началното
     *
     * @param toBoardCoords координати на крайното поле
     */
    public abstract void respondFigureMove(BoardCoords fromBoardCoords, BoardCoords toBoardCoords);

    /**
     * <p>
     * Последователно премества няколко фигури (или една и съща) по дъската
     * според зададени масив от координати на началните полета и масив от
     * координати на крайните полета.
     * <p>
     * Изпълнява се като следствие на съобщение от страна на обекта-логика.
     *
     * @param fromBoardCoords масив от координати на началните полета
     *
     * @param toBoardCoords масив от координати на крайните полета
     */
    public abstract void respondFigureMove(BoardCoords[] fromBoardCoords, BoardCoords[] toBoardCoords);

    /**
     * Заявява намерение за добавяне на фигура върху поле от дъската според
     * зададени координати на полето.
     * <p>
     * Заявката се изпраща към обекта-логика за обработка и отговор.
     *
     * @param figure фигура
     *
     * @param toBoardCoords координати на полето
     */
    public abstract void requestFigureAdd(Figure figure, BoardCoords toBoardCoords);

    /**
     * <p>
     * Заявява намерение за премахване не фигура от поле от дъската според
     * зададени координати на полето.
     * <p>
     * Заявката се изпраща към обекта-логика за обработка и отговор.
     *
     * @param fromBoardCoords координати на полето
     */
    public abstract void requestFigureDelete(BoardCoords fromBoardCoords);

    /**
     * <p>
     * Заявява намерение за преместване на фигура по дъската според зададени
     * координати на началното поле и координати на крайното поле.
     * <p>
     * Заявката се изпраща към обекта-логика за обработка и отговор.
     *
     * @param fromBoardCoords координати на началното
     *
     * @param toBoardCoords координати на крайното поле
     */
    public abstract void requestFigureMove(BoardCoords fromBoardCoords, BoardCoords toBoardCoords);

    /**
     * <p>
     * Заявява намерение за последователно преместване на няколко фигури (или
     * една и съща) по дъската според зададени масив от координати на началните
     * полета и масив от координати на крайните полета.
     * <p>
     * Заявката се изпраща към обекта-логика за обработка и отговор.
     *
     * @param fromBoardCoords масив от координати на началните полета
     *
     * @param toBoardCoords масив от координати на крайните полета
     */
    public abstract void requestFigureMove(BoardCoords[] fromBoardCoords, BoardCoords[] toBoardCoords);
}
