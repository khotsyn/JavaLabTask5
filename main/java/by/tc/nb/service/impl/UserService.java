package by.tc.nb.service.impl;

import by.tc.nb.bean.entity.User;
import by.tc.nb.service.exception.ServiceException;

public interface UserService {

    User logination(String login, String password) throws ServiceException;
    boolean registration(String login, String password) throws ServiceException;
}
