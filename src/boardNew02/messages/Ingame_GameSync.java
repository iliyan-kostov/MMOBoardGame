package boardNew02.messages;

/**
 * <p>
 * Съобщение за синхронизиране на игра, в която потребителят участва.
 * <p>
 * Класът ще включва данни за синхронизиране на дъската и др.
 *
 * @author iliyan-kostov <https://github.com/iliyan-kostov/>
 */
public final class Ingame_GameSync extends MessageIngame {

    public Ingame_GameSync(String username, int boardId) {
        super(username, Message.MESSAGETYPE.LOBBY_GAMESYNC, boardId);
    }
}
