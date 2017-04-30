package board;

import java.util.HashMap;
import java.util.Set;

/**
 * <p>
 * Абстрактен клас за фигурите в играта.
 * <p>
 * Всяка фигура има набор от свойста от класа {@link FigureStat}. Различните
 * свойства се разпознава по имената си. На ниво фигура достъпът до определено
 * свойство се осъществява чрез задаване на името му.
 * <p>
 * Целесъобразно е имената и стойностите по подразбиране на свойствата за
 * различните фигури се задават в съответствие с информацията в база данни,
 * което да позволява създаване и поддържане на набор от различни, независещи от
 * програмния код фигури - в зависимост от конкретно моделираната игра. Текущите
 * стойности на свойствата следва да бъдат контролирани от сървъра по време на
 * изпълнение - съобразно логиката на играта.
 * <p>
 * Възможно и препоръчително е при описание на логиката на играта чрез
 * класове-наследници да бъде реализирана концепцията за свързани и ограничени
 * свойства.
 *
 * @author iliyan-kostov <https://github.com/iliyan-kostov/>
 */
public abstract class Figure {

    /**
     * Набор от свойствата, присъщи на фигурата - двойки от:
     * <li>
     * стойност на името на свойството ({@link String})
     * <li>
     * съпоставена на името конкретна стойност ({@link FigureStat}).
     */
    private final HashMap<String, FigureStat> stats;

    /**
     * Конструктор без параметри.
     */
    public Figure() {
        this.stats = new HashMap<>();
    }

    /**
     * Добавя свойство към фигурата - под зададеното име и със зададените
     * подразбираща се и текуща стойност. Ако за фигурата вече е дефинирано
     * свойство под същото име, не се извършва добавяне.
     *
     * @param statName името на свойството
     *
     * @param defaultValue стойността на свойството - по подразбиране
     *
     * @param currentValue стойността на свойството - текуща
     *
     * @return дали добавянето на свойството е успешно: true (да), false (не)
     */
    public boolean addStat(String statName, int defaultValue, int currentValue) {
        if (this.stats.get(statName) == null) {
            this.stats.put(statName, new FigureStat(defaultValue, currentValue));
            return true;
        } else {
            return false;
        }
    }

    /**
     * По името на свойството, задава стойността на свойството - по
     * подразбиране.
     *
     * @param statName името на свойството
     *
     * @param defaultValue стойността на свойството - по подразбиране
     *
     * @return новополучената стойност
     *
     * @throws NullPointerException ако за фигурата не е дефинирано свойство със
     * зададеното име.
     */
    public int setStatDefaultValue(String statName, int defaultValue) throws NullPointerException {
        FigureStat figureStat = this.stats.get(statName);
        if (figureStat != null) {
            return figureStat.setDefaultValue(defaultValue);
        } else {
            throw new NullPointerException("Не е определено свойство със зададеното име: " + statName);
        }
    }

    /**
     * По името на свойството, задава стойността на свойството - текуща.
     *
     * @param statName името на свойството
     *
     * @param currentValue стойността на свойството - текуща
     *
     * @return новополучената стойност
     *
     * @throws NullPointerException ако за фигурата не е дефинирано свойство със
     * зададеното име.
     */
    public int setStatCurrentValue(String statName, int currentValue) {
        FigureStat figureStat = this.stats.get(statName);
        if (figureStat != null) {
            return figureStat.setCurrentValue(currentValue);
        } else {
            throw new NullPointerException("Не е определено свойство със зададеното име: " + statName);
        }
    }

    /**
     * По името на свойството, връща стойността на свойството - по подразбиране.
     *
     * @param statName името на свойството
     *
     * @return стойността на свойството - по подразбиране
     *
     * @throws NullPointerException ако за фигурата не е дефинирано свойство със
     * зададеното име.
     */
    public int getStatDefaultValue(String statName) {
        FigureStat figureStat = this.stats.get(statName);
        if (figureStat != null) {
            return figureStat.getDefaultValue();
        } else {
            throw new NullPointerException("Не е определено свойство със зададеното име: " + statName);
        }
    }

    /**
     * По името на свойството, връща стойността на свойството - текуща.
     *
     * @param statName името на свойството
     *
     * @return стойността на свойството - текуща
     *
     * @throws NullPointerException ако за фигурата не е дефинирано свойство със
     * зададеното име.
     */
    public int getStatCurrentValue(String statName) {
        FigureStat figureStat = this.stats.get(statName);
        if (figureStat != null) {
            return figureStat.getCurrentValue();
        } else {
            throw new NullPointerException("Не е определено свойство със зададеното име: " + statName);
        }
    }

    /**
     * По името на свойството, задава стойността по подразбиране за текуща.
     *
     * @param statName името на свойството
     *
     * @return новополучената стойност
     *
     * @throws NullPointerException ако за фигурата не е дефинирано свойство със
     * зададеното име.
     */
    public int resetStatToDefault(String statName) {
        FigureStat figureStat = this.stats.get(statName);
        if (figureStat != null) {
            return figureStat.setCurrentValue(figureStat.getDefaultValue());
        } else {
            throw new NullPointerException("Не е определено свойство със зададеното име: " + statName);
        }
    }

    /**
     * Връща списък от имената на дефинираните за фигурата свойства.
     *
     * @return списък от имената на дефинираните за фигурата свойства
     */
    public Set<String> getStatList() {
        return this.stats.keySet();
    }
}
