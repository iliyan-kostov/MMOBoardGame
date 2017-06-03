package boardNew02;

import boardNew02.messages.MessageIngame;

/**
 * <p>
 * Базов абстрактен клас за дъската.
 *
 * @author iliyan-kostov <https://github.com/iliyan-kostov/>
 */
public abstract class Board {

    /**
     * <p>
     * Брой страни на дъската.
     */
    public final int boardShape;

    /**
     * <p>
     * Идентификатор на дъската (играта) в рамките на системата.
     */
    public final int boardId;

    public Board(int boardShape, int boardId) {
        if ((boardShape != 3) && (boardShape != 4) && (boardShape != 6)) {
            throw new IllegalArgumentException();
        } else {
            this.boardShape = boardShape;
            this.boardId = boardId;
        }
    }

    /**
     * <p>
     * Описва как дъската реагира на получено съобщение, носещо данни за
     * развитие на определена игра.
     *
     * @param messageIngame получено съобщение, носещо данни за развитие на
     * определена игра
     */
    public abstract void messageHandle(MessageIngame messageIngame);

    /**
     * <p>
     * Описва как дъската изпраща съобщение към другата страна (сървъра или
     * клиента), носещо данни за развитието на играта.
     *
     * @param messageIngame съобщение към другата страна (сървъра или клиента),
     * носещо данни за развитието на играта
     */
    public abstract void messageSend(MessageIngame messageIngame);
}
