package by.tc.nb.bean;

public class RegistrationRequest extends Request {
    private String login;
    private String password;

    public RegistrationRequest() {
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
