package by.tc.nb.command.impl;

import by.tc.nb.bean.RegistrationRequest;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.service.ServiceFactory;
import by.tc.nb.service.exception.ServiceException;
import by.tc.nb.service.impl.UserService;

public class Registration implements Command {
    @Override
    public Response execute(Request request) throws CommandException {
        RegistrationRequest req = null;

        if(request instanceof RegistrationRequest) {
            req = (RegistrationRequest) request;
        } else {
            throw new CommandException("Wrong request");
        }

        Response response = new Response();

        String login = req.getLogin();
        String password = req.getPassword();

        UserService userService = ServiceFactory.getInstance().getUserService();

        try {
            userService.registration(login, password);
        } catch (ServiceException e) {
            response.setErrorStatus(true);
            response.setErrorMessage(e.getMessage());
            return response;
        }

        response.setErrorStatus(false);
        response.setResultMessage("Success!");
        return response;
    }
}