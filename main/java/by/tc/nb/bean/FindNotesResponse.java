package by.tc.nb.bean;

import java.util.ArrayList;
import java.util.List;

import by.tc.nb.bean.entity.Note;

public class FindNotesResponse extends Response {
	private List<Note> findBook = new ArrayList<Note>();

	public List<Note> getFindBook() {
		return findBook;
	}

	public void setFindBook(List<Note> findBook) {
		this.findBook = findBook;
	}
}

