package boardNew02.messages;

import boardNew02.PlayerStat;

/**
 * <p>
 * Клас за съобщения, съдържащи игрални статистики - име на играч и
 * съответстващите му статистики за различните режими на игра.
 *
 * @author iliyan-kostov <https://github.com/iliyan-kostov/>
 */
public final class Lobby_PlayerStats extends Message {

    public final String playerName;
    public PlayerStat[] playerStats;    // попълва се от сървъра

    public Lobby_PlayerStats(String username, String playerName) {
        super(username, Message.MESSAGETYPE.LOBBY_PLAYERSTATS);
        this.playerName = playerName;
        this.playerStats = null;
    }
}
