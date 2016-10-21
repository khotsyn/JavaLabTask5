package by.tc.nb.service;

import java.util.List;
import by.tc.nb.bean.entity.Note;
import by.tc.nb.service.exception.ServiceException;

public interface NoteBookService {
	
	void addNote(String note, int userId) throws ServiceException;
	List<Note> findByDate(int day, int month, int year, int userId) throws ServiceException;
	List<Note> findByNote(String note, int userID) throws ServiceException;
	List<Note> showNotebook(int userID) throws ServiceException;
	void clearNote(int userId) throws ServiceException;
}
