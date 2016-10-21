package by.tc.nb.dao;

import by.tc.nb.bean.entity.Note;
import by.tc.nb.dao.exception.DAOException;
import java.util.List;

public interface NoteBookDAO {

	void addNote(Note note) throws DAOException;
	void clearNoteBook(int id) throws DAOException;
	List<Note> findNotesByContent(String content, int id) throws DAOException;
	List<Note> findByDate(int day, int month, int year, int userId) throws DAOException;
	List<Note> showAllNotes(int id) throws DAOException;

}
