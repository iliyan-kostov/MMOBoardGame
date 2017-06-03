package boardNew02.messages;

import boardNew02.PlayerStat;

/**
 * <p>
 * Съобщение с данни за класация за определен режим на игра и горна/долна
 * граница.
 *
 * @author iliyan-kostov <https://github.com/iliyan-kostov/>
 */
public final class Lobby_Ranking extends Message {

    public final int boardShape;
    public final int minRanking;
    public final int maxRanking;
    public PlayerStat[] playerStats;    // попълва се от сървъра

    public Lobby_Ranking(String username, int boardShape, int minRanking, int maxRanking) {
        super(username, Message.MESSAGETYPE.LOBBY_RANKING);
        this.boardShape = boardShape;
        this.minRanking = minRanking;
        this.maxRanking = maxRanking;
        this.playerStats = null;
    }
}
