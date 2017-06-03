package boardNew02.messages;

/**
 * <p>
 * Заявка за нова игра от определен режим.
 *
 * @author iliyan-kostov <https://github.com/iliyan-kostov/>
 */
public final class Lobby_NewGameRequest extends Message {

    public final int boardShape;

    public Lobby_NewGameRequest(String username, int boardShape) {
        super(username, Message.MESSAGETYPE.LOBBY_NEWGAMEREQUEST);
        this.boardShape = boardShape;
    }
}
