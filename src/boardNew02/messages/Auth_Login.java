package boardNew02.messages;

/**
 * <p>
 * Съобщение за вход в системата - като съществуващ или като нов потребител.
 *
 * @author iliyan-kostov <https://github.com/iliyan-kostov/>
 */
public final class Auth_Login extends Message {

    public final String password;

    public Auth_Login(String username, String password) {
        super(username, Message.MESSAGETYPE.AUTH_LOGIN);
        this.password = password;
    }
}
