package boardNew02.messages;

/**
 * <p>
 * Съобщение за започнала нова игра, в която потребителят участва.
 *
 * @author iliyan-kostov <https://github.com/iliyan-kostov/>
 */
public final class Ingame_GameStarted extends MessageIngame {

    public final int boardShape;
    public final String[] playerNames;

    public Ingame_GameStarted(String username, int boardId, int boardShape, String[] playerNames) {
        super(username, Message.MESSAGETYPE.LOBBY_GAMESTARTED, boardId);
        this.boardShape = boardShape;
        this.playerNames = new String[playerNames.length];
        System.arraycopy(playerNames, 0, this.playerNames, 0, playerNames.length);
    }
}
