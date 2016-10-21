package by.tc.nb.dao;

import by.tc.nb.bean.entity.User;
import by.tc.nb.dao.exception.DAOException;

public interface UserDAO {

	User logination(String login, String password) throws DAOException;
	boolean registration(String login, String password) throws DAOException;
}
