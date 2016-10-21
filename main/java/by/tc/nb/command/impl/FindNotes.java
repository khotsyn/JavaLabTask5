package by.tc.nb.command.impl;

import by.tc.nb.bean.FindNotesRequest;
import by.tc.nb.bean.FindNotesResponse;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.bean.entity.Note;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.service.NoteBookService;
import by.tc.nb.service.ServiceFactory;
import by.tc.nb.service.exception.ServiceException;
import java.util.List;

public class FindNotes implements Command {

	@Override
	public Response execute(Request request) throws CommandException {
		FindNotesResponse res = new FindNotesResponse();
		FindNotesRequest req;
		if (request instanceof FindNotesRequest) {
			req = (FindNotesRequest) request;
		} else {
			throw new CommandException("Wrong request");
		}
		List<Note> list = null;
		String noteRec = req.getFindString();
		ServiceFactory service = ServiceFactory.getInstance();
		NoteBookService nbService = service.getNoteBookService();
		try {
			list = nbService.findByNote(noteRec, req.getUserId());
		} catch (ServiceException e) {
			throw new CommandException(e.getMessage());
		}

		res.setErrorStatus(true);
		if (list.isEmpty()) {
			res.setResultMessage("There is no notes matched your request");
		} else {
			res.setFindBook(list);
			res.setResultMessage("All OK!");
		}
		return res;
	}
}

