package boardNew02.messages;

/**
 * <p>
 * Съобщение, носещо данни за развитие на определена игра.
 *
 * @author iliyan-kostov <https://github.com/iliyan-kostov/>
 */
public abstract class MessageIngame extends Message {

    public final int boardId;

    public MessageIngame(String username, MESSAGETYPE messageType, int boardId) {
        super(username, messageType);
        this.boardId = boardId;
    }
}
