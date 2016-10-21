package by.tc.nb.command.impl;

import by.tc.nb.bean.AuthenticationRequest;
import by.tc.nb.bean.AuthenticationResponse;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.bean.entity.User;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.service.ServiceFactory;
import by.tc.nb.service.exception.ServiceException;
import by.tc.nb.service.impl.UserService;

public class Authentication implements Command {

    @Override
    public Response execute(Request request) throws CommandException {
        AuthenticationRequest req = null;

        if(request instanceof AuthenticationRequest) {
            req = (AuthenticationRequest) request;
        } else {
            throw new CommandException("Wrong request");
        }

        AuthenticationResponse response = new AuthenticationResponse();

        String login = req.getLogin();
        String password = req.getPassword();

        UserService userService = ServiceFactory.getInstance().getUserService();

        User currentUser = null;

        try {
            currentUser = userService.logination(login, password);
        } catch (ServiceException e) {
            response.setErrorStatus(true);
            response.setErrorMessage(e.getMessage());
            return response;
        }

        if(currentUser == null) {
            response.setErrorStatus(true);
            response.setErrorMessage("Authentication error, user does not exist!");
            return response;
        } else {
            response.setErrorStatus(false);
            response.setResultMessage("Success");
            response.setUser(currentUser);
            return response;
        }
    }
}