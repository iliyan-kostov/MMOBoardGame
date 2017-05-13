package board;

import javafx.scene.paint.Color;

/**
 * <p>
 * Клас за дъската. Дъската е изградена от равномерна правилна мрежа от
 * множество еднакви по форма и размери полета - правилни многоъгълници
 * (триъгълници, квадрати или шестоъгълници). Полетата са подредени в редове и
 * колони така, че формата на дъската наподобява формата на полето (триъгълна,
 * квадратна или шестоъгълна дъска). По всеки ръб на дъската са разположени
 * равен брой полета.
 * <p>
 * Дъската се характеризира с:
 * <ul>
 * <li>форма
 * <li>брой полета по един ръб
 * <li>размер на едно поле (радиус на вписаната окръжност)
 * </ul>
 * <p>
 * Върху всяко поле от дъската може да бъде разположена само една фигура (или
 * никаква).
 * <p>
 * Формата и размерите на дъската и полетата не могат да бъдат променяни.
 * Единствено могат да бъдат променяни разположените върху полетата фигури - да
 * бъдат добавяни, местени или премахвани.
 * <p>
 * Полетата са номерирани по редове и колони, като първото поле в най-горната
 * колона е с координати (0, 0). Първата координата съответства на номера на
 * реда (по Y), втората - на номера полето в съответния му ред (по X).
 * <p>
 * Полетата от дъската и разположените върху поле от дъската фигури могат да
 * бъдат достъпвани (адресирани) чрез координатите на полето.
 *
 * @author iliyan-kostov <https://github.com/iliyan-kostov/>
 */
public final class Board extends javafx.scene.Group {

    /**
     * тип на мрежата
     */
    public static enum SHAPE {
        /**
         * триъгълна
         */
        TRIANGLE,
        /**
         * квадратна
         */
        SQUARE,
        /**
         * шестоъгълна
         */
        HEXAGON
    }

    /**
     * форма на дъската (и полетата)
     */
    private final Board.SHAPE shape;

    /**
     * брой полета по един ръб
     */
    private final int segments;

    /**
     * размер на едно поле (радиус на вписаната окръжност)
     */
    private final double cellSize;

    /**
     * масив с полетата на дъската
     */
    private final Cell[][] cells;

    /**
     * масив с фигурите, разположени върху дъската
     */
    private final Figure[][] figures;

    /**
     * Конструктор. Създава дъска по зададена форма, брой полета по един ръб и
     * размер на едно поле (радиус на вписаната окръжност). Дъската се създава
     * празна (без разположени върху нея фигури). За всички полета се задават
     * еднакви начални дебелина на линията на контура и цвят на контура и на
     * вътрешността.
     *
     * @param shape форма на дъската (и полетата)
     *
     * @param segments брой полета по един ръб
     *
     * @param cellSize размер на едно поле (радиус на вписаната окръжност)
     *
     * @param borderWidth дебелина на линията на контура
     *
     * @param borderColor цвят на контура
     *
     * @param fillColor цвят на вътрешността
     */
    public Board(Board.SHAPE shape, int segments, double cellSize, double borderWidth, Color borderColor, Color fillColor) {
        super();
        this.shape = shape;
        this.segments = segments;
        this.cellSize = cellSize;
        switch (this.shape) {
            // триъгълна дъска
            case TRIANGLE: {
                this.figures = new Figure[this.segments][2 * this.segments + 1];
                this.cells = new Cell[this.segments][2 * this.segments + 1];
                // нулиране на масивите
                for (int i = 0; i < this.segments; i++) {
                    for (int j = 0; j < 2 * this.segments + 1; j++) {
                        this.figures[i][j] = null;
                        this.cells[i][j] = null;
                    }
                }
                // изчисляване на координати на модулите на мрежата
                double a = this.cellSize * Math.sqrt(3.);
                double b = this.cellSize;
                double xspacing = 2 * a;
                double yspacing = 3 * b;
                double[] coordsUp = new double[]{ // триъгълник с връх отгоре
                    0.0 + 0 * a, 0.0 - 2 * b, // връх - горе
                    0.0 - 1 * a, 0.0 + 1 * b, // връх - ляво
                    0.0 + 1 * a, 0.0 + 1 * b // връх - дясно
                };
                double[] coordsDown = new double[]{ // триъгълник с връх отдолу
                    0.0 - 1 * a, 0.0 - 1 * b, // връх - ляво
                    0.0 + 0 * a, 0.0 + 2 * b, // връх - долу
                    0.0 + 1 * a, 0.0 - 1 * b // връх - дясно
                };
                // създаване на полетата
                double ycenterUp = 0.0 - 2 * this.segments * b + 2 * b;
                double ycenterDown = 0.0 - 2 * this.segments * b + 1 * b;
                double xcenterUp;
                double xcenterDown;
                double xcenterFirst = 0.0;
                for (int i = 0; i < this.segments; i++) {
                    xcenterUp = xcenterFirst;
                    xcenterDown = xcenterUp + a;
                    for (int j = 0; j < i; j++) {
                        {
                            // триъгълник с връх отгоре
                            this.cells[i][2 * j + 0] = new Cell(this, i, 2 * j + 0, xcenterUp, ycenterUp, borderWidth, borderColor, fillColor, coordsUp);
                            this.getChildren().add(this.cells[i][2 * j + 0]);
                            this.cells[i][2 * j + 0].setTranslateX(xcenterUp);
                            this.cells[i][2 * j + 0].setTranslateY(ycenterUp);
                            this.cells[i][2 * j + 0].setTranslateZ(0);
                            xcenterUp += xspacing;
                        }
                        {
                            // триъгълник с връх отдолу
                            this.cells[i][2 * j + 1] = new Cell(this, i, 2 * j + 1, xcenterDown, ycenterDown, borderWidth, borderColor, fillColor, coordsDown);
                            this.getChildren().add(this.cells[i][2 * j + 1]);
                            this.cells[i][2 * j + 1].setTranslateX(xcenterDown);
                            this.cells[i][2 * j + 1].setTranslateY(ycenterDown);
                            this.cells[i][2 * j + 1].setTranslateZ(0);
                            xcenterDown += xspacing;
                        }
                    }
                    {
                        // триъгълник с връх отгоре
                        this.cells[i][2 * i] = new Cell(this, i, 2 * i, xcenterUp, ycenterUp, borderWidth, borderColor, fillColor, coordsUp);
                        this.getChildren().add(this.cells[i][2 * i]);
                        this.cells[i][2 * i].setTranslateX(xcenterUp);
                        this.cells[i][2 * i].setTranslateY(ycenterUp);
                        this.cells[i][2 * i].setTranslateZ(0);
                        xcenterUp += xspacing;
                    }
                    xcenterFirst -= 1 * a;
                    ycenterUp += yspacing;
                    ycenterDown += yspacing;
                }
            }
            break;
            // квадратна дъска
            case SQUARE: {
                this.figures = new Figure[this.segments][this.segments];
                this.cells = new Cell[this.segments][this.segments];
                // нулиране на масивите
                for (int i = 0; i < this.segments; i++) {
                    for (int j = 0; j < this.segments; j++) {
                        this.figures[i][j] = null;
                        this.cells[i][j] = null;
                    }
                }
                // изчисляване на координати на модулите на мрежата
                double a = this.cellSize;
                double b = this.cellSize;
                double xspacing = 2 * a;
                double yspacing = 2 * b;
                double[] coords = new double[]{ // квадрат
                    0.0 - 1 * a, 0.0 - 1 * b, // връх - горе ляво
                    0.0 - 1 * a, 0.0 + 1 * b, // връх - долу ляво
                    0.0 + 1 * a, 0.0 + 1 * b, // връх - долу дясно
                    0.0 + 1 * a, 0.0 - 1 * b, // връх - горе дясно
                };
                // създаване на полетата
                double ycenter = 0.0 - this.segments * b + 1 * b;
                double xcenter;
                double xcenterFirst = 0.0 - this.segments * a + 1 * a;
                for (int i = 0; i < this.segments; i++) {
                    xcenter = xcenterFirst;
                    for (int j = 0; j < this.segments; j++) {
                        {
                            // квадрат
                            this.cells[i][j] = new Cell(this, i, j, xcenter, ycenter, borderWidth, borderColor, fillColor, coords);
                            this.getChildren().add(this.cells[i][j]);
                            this.cells[i][j].setTranslateX(xcenter);
                            this.cells[i][j].setTranslateY(ycenter);
                            this.cells[i][j].setTranslateZ(0);
                            xcenter += xspacing;
                        }
                    }
                    xcenterFirst -= 0 * a;
                    ycenter += yspacing;
                }
            }
            break;
            // шестоъгълна дъска
            case HEXAGON: {
                this.figures = new Figure[2 * this.segments + 1][2 * this.segments + 1];
                this.cells = new Cell[2 * this.segments + 1][2 * this.segments + 1];
                // нулиране на масивите
                for (int i = 0; i < 2 * this.segments + 1; i++) {
                    for (int j = 0; j < 2 * this.segments + 1; j++) {
                        this.figures[i][j] = null;
                        this.cells[i][j] = null;
                    }
                }
                // изчисляване на координати на модулите на мрежата
                double a = this.cellSize;
                double b = this.cellSize / Math.sqrt(3.);
                double xspacing = 2 * a;
                double yspacing = 3 * b;
                double[] coords = new double[]{ // правилен шестоъгълник
                    0.0 + 0 * a, 0.0 - 2 * b, // връх - горе
                    0.0 - 1 * a, 0.0 - 1 * b, // връх - ляво горе
                    0.0 - 1 * a, 0.0 + 1 * b, // връх - ляво долу
                    0.0 + 0 * a, 0.0 + 2 * b, // връх - долу
                    0.0 + 1 * a, 0.0 + 1 * b, // връх - дясно долу
                    0.0 + 1 * a, 0.0 - 1 * b, // връх - дясно горе
                };
                // създаване на полетата
                double ycenter = 0.0 - 3 * this.segments * b + 3 * b;
                double xcenter;
                double xcenterFirst = 0.0 - 1 * this.segments * a + 1 * a;
                int rowsize = this.segments;
                for (int i = 0; i < 2 * this.segments - 1; i++) {
                    xcenter = xcenterFirst;
                    for (int j = 0; j < rowsize; j++) {
                        {
                            // правилен шестоъгълник
                            this.cells[i][j] = new Cell(this, i, j, xcenter, ycenter, borderWidth, borderColor, fillColor, coords);
                            this.getChildren().add(this.cells[i][j]);
                            this.cells[i][j].setTranslateX(xcenter);
                            this.cells[i][j].setTranslateY(ycenter);
                            this.cells[i][j].setTranslateZ(0);
                            xcenter += xspacing;
                        }
                    }
                    if (i >= this.segments - 1) {
                        xcenterFirst += a;
                        rowsize -= 1;
                    } else {
                        xcenterFirst -= a;
                        rowsize += 1;
                    }
                    ycenter += yspacing;
                }
            }
            break;
            default: {
                throw new NullPointerException("Board shape not properly defined!");
            }
        }
    }

    /**
     * Връща формата на дъската (и полетата).
     *
     * @return формата на дъската (и полетата)
     */
    public final Board.SHAPE getType() {
        return this.shape;
    }

    /**
     * Връща броя полета по един ръб.
     *
     * @return броя полета по един ръб
     */
    public final int getSegments() {
        return this.segments;
    }

    /**
     * Връща размера на едно поле (радиус на вписаната окръжност).
     *
     * @return размера на едно поле (радиус на вписаната окръжност)
     */
    public final double getCellSize() {
        return this.cellSize;
    }

    /**
     * Връща полето със зададените координати.
     *
     * @param row ред на полето
     *
     * @param col колона на полето
     *
     * @return полето със зададените координати
     */
    public final Cell getCell(int row, int col) {
        return this.cells[row][col];
    }

    /**
     * Връща фигурата, разположена в полето със зададените координати.
     *
     * @param row ред на полето
     *
     * @param col колона на полето
     *
     * @return фигурата, разположена в полето със зададените координати
     */
    public final Figure getFigure(int row, int col) {
        return this.figures[row][col];
    }
}
