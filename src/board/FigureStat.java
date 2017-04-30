package board;

/**
 * <p>
 * Всяка фигура има набор от свойства, които са измерими чрез двойки целочислени
 * стойности - стойност по подразбиране (default) и текуща стойност (current) -
 * в рамките на хода и/или играта. Обикновено началната текуща стойност на
 * свойствата се задава равна на стойността по подразбиране.
 * <p>
 * Стойността по подразбиране може да бъде зададена за текуща чрез метода
 * {@link FigureStat#resetToDefault()}.
 *
 * @author iliyan-kostov <https://github.com/iliyan-kostov/>
 */
public class FigureStat {

    /**
     * стойността на свойството - по подразбиране
     */
    private int defaultValue;

    /**
     * стойността на свойството - текуща
     */
    private int currentValue;

    /**
     * Конструктор.
     *
     * @param defaultValue стойността на свойството - по подразбиране
     *
     * @param currentValue стойността на свойството - текуща
     */
    public FigureStat(int defaultValue, int currentValue) {
        this.defaultValue = defaultValue;
        this.currentValue = currentValue;
    }

    /**
     * Задава стойността на свойството - по подразбиране.
     *
     * @param defaultValue стойността на свойството - по подразбиране
     *
     * @return новополучената стойност
     */
    public int setDefaultValue(int defaultValue) {
        this.defaultValue = defaultValue;
        return this.defaultValue;
    }

    /**
     * Задава стойността на свойството - текуща.
     *
     * @param currentValue стойността на свойството - текуща
     *
     * @return новополучената стойност
     */
    public int setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
        return this.currentValue;
    }

    /**
     * Задава стойността по подразбиране за текуща.
     *
     * @return новополучената стойност
     */
    public int resetToDefault() {
        return this.setCurrentValue(this.getDefaultValue());
    }

    /**
     * Връща стойността на свойството - по подразбиране.
     *
     * @return стойността на свойството - по подразбиране
     */
    public int getDefaultValue() {
        return this.defaultValue;
    }

    /**
     * Връща стойността на свойството - текуща.
     *
     * @return стойността на свойството - текуща
     */
    public int getCurrentValue() {
        return this.currentValue;
    }
}
