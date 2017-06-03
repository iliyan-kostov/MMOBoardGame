package boardNew02.messages;

/**
 * <p>
 * Съобщение, известяващо край на хода на текущия играч и име на следващия
 * играч, който е на ход.
 *
 * @author iliyan-kostov <https://github.com/iliyan-kostov/>
 */
public final class Ingame_EndTurn extends MessageIngame {

    public final String playerTurnEnds;
    public final String playerTurnStarts;

    public Ingame_EndTurn(String username, int boardId, String playerTurnEnds, String playerTurnStarts) {
        super(username, Message.MESSAGETYPE.INGAME_ENDTURN, boardId);
        this.playerTurnEnds = playerTurnEnds;
        this.playerTurnStarts = playerTurnStarts;
    }
}
