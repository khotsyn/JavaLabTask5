package by.tc.nb.bean;

import by.tc.nb.bean.entity.Note;

import java.util.List;

public class ShowAllNotesResponse extends Response {
    private List<Note> allBook;

    public List<Note> getAllBook() {
        return allBook;
    }

    public void setAllBook(List<Note> allBook) {
        this.allBook = allBook;
    }
}
