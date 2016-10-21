package by.tc.nb.service.impl;


import by.tc.nb.bean.entity.Note;
import by.tc.nb.dao.DAOFactory;
import by.tc.nb.dao.exception.DAOException;
import by.tc.nb.service.NoteBookService;
import by.tc.nb.service.exception.ServiceException;
import java.util.List;

public class NoteBookServiceImpl implements NoteBookService {

	@Override
	public void addNote(String note, int userId) throws ServiceException {
		if (note == null || "".equals(note)){
			throw new ServiceException("Wrong parameter!");
		}

		try {
			DAOFactory.getInstance().getNoteBookDAO().addNote(new Note(note, userId));
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public void clearNote(int userId) throws ServiceException {
		try {
			DAOFactory.getInstance().getNoteBookDAO().clearNoteBook(userId);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public List<Note> findByDate(int day, int month, int year, int userId) throws ServiceException {
		try {
			return DAOFactory.getInstance().getNoteBookDAO().findByDate(day, month, year, userId);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public List<Note> findByNote(String note, int userId) throws ServiceException {
		if(note == null || note.equals("") || userId < 0) {
			throw new ServiceException("Illegal parameters");
		}

		try {
			return DAOFactory.getInstance().getNoteBookDAO().findNotesByContent(note, userId);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public List<Note> showNotebook(int userID) throws ServiceException {
		try {
			return DAOFactory.getInstance().getNoteBookDAO().showAllNotes(userID);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

}
