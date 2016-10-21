package by.tc.nb.bean;

public class AuthenticationRequest extends Request {

    private String login;
    private String password;

    public AuthenticationRequest() {

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}