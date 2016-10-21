package by.tc.nb.command.impl;

import by.tc.nb.bean.ClearBookRequest;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.service.NoteBookService;
import by.tc.nb.service.ServiceFactory;
import by.tc.nb.service.exception.ServiceException;

public class ClearBook implements Command {

	@Override
	public Response execute(Request request) throws CommandException {

		ClearBookRequest req = null;

		if(request instanceof ClearBookRequest){
			req = (ClearBookRequest)request;
		}else{
			throw new CommandException("Wrong request");
		}

		Response response = new Response();

		ServiceFactory service = ServiceFactory.getInstance();
		NoteBookService nbService = service.getNoteBookService();

		try {
			nbService.clearNote(req.getUserId());
		} catch (ServiceException e) {
			response.setErrorStatus(true);
			response.setErrorMessage(e.getMessage());
			return response;
		}
		response.setErrorStatus(true);
		response.setResultMessage("User notebook is cleared!");

		return response;
	}
}