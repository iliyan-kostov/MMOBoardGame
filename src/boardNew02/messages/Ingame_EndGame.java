package boardNew02.messages;

import boardNew02.PlayerStat;

/**
 * <p>
 * Съобщение, известяващо край на играта и статистики на участниците - начални
 * (преди играта) и крайни (след играта).
 *
 * @author iliyan-kostov <https://github.com/iliyan-kostov/>
 */
public final class Ingame_EndGame extends MessageIngame {

    public final PlayerStat[] playerStatsOld;
    public final PlayerStat[] playerStatsNew;

    public Ingame_EndGame(String username, int boardId, PlayerStat[] playerStatsOld, PlayerStat[] playerStatsNew) {
        super(username, Message.MESSAGETYPE.INGAME_ENDGAME, boardId);
        this.playerStatsOld = new PlayerStat[playerStatsOld.length];
        System.arraycopy(playerStatsOld, 0, this.playerStatsOld, 0, playerStatsOld.length);
        this.playerStatsNew = new PlayerStat[playerStatsNew.length];
        System.arraycopy(playerStatsNew, 0, this.playerStatsNew, 0, playerStatsNew.length);
    }
}
