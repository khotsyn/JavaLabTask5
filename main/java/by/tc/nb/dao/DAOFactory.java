package by.tc.nb.dao;

import by.tc.nb.dao.impl.NoteBookDAOImpl;
import by.tc.nb.dao.impl.UserDAOImpl;

public class DAOFactory {

    private final static DAOFactory instance = new DAOFactory();

    private final NoteBookDAO noteBookDAO = new NoteBookDAOImpl();
    private final UserDAO userDAO = new UserDAOImpl();

    private DAOFactory() {

    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public NoteBookDAO getNoteBookDAO() {
        return noteBookDAO;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }
}
