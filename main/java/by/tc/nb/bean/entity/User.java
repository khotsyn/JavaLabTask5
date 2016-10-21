package by.tc.nb.bean.entity;

public class User {

    private final int id;
    private final String login;

    public User(int id, String login) {
        this.id = id;
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        return login != null ? login.equals(user.login) : user.login == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "[id=" + id + ", login=" + login + "]\n";
    }
}
