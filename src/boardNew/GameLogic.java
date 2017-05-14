package boardNew;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;

/**
 * <p>
 * Абстрактен клас управление на логиката на играта. Описва правилата и
 * възможните действия, условията за изход, контролира състоянието на дъската,
 * реакциите на определени заявки от играчи и/или от системата и др.
 * <p>
 * Обектът-логиката е едновременно слушател и източник на събития съгласно
 * конвенцията за свързани и ограничени свойства. Обектът-логика е небходимо да
 * бъде регистриран като слушател към контролираните от него дъски, и обратно.
 *
 * @author iliyan-kostov <https://github.com/iliyan-kostov/>
 */
public abstract class GameLogic implements PropertyChangeListener, VetoableChangeListener {

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
     * Конструктор.
     */
    public GameLogic() {
        this.propertyChangeSupport = new PropertyChangeSupport(this);
        this.vetoableChangeSupport = new VetoableChangeSupport(this);
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
}
