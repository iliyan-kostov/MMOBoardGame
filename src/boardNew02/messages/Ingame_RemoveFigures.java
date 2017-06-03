package boardNew02.messages;

import boardNew.BoardCoords;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * <p>
 * Съобщение, включващо данни за премахване на фигури от дадена дъска.
 *
 * @author iliyan-kostov <https://github.com/iliyan-kostov/>
 */
public final class Ingame_RemoveFigures extends MessageIngame {

    public final ArrayList<BoardCoords> from;

    public Ingame_RemoveFigures(String username, int boardId, ArrayList<BoardCoords> from) {
        super(username, Message.MESSAGETYPE.INGAME_MOVEFIGURES, boardId);
        this.from = new ArrayList<>();
        {
            Iterator<BoardCoords> it = from.iterator();
            while (it.hasNext()) {
                this.from.add(it.next());
            }
        }
    }
}
