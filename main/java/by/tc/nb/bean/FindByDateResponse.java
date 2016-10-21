package by.tc.nb.bean;

import by.tc.nb.bean.entity.Note;

import java.util.ArrayList;
import java.util.List;

public class FindByDateResponse extends Response {

    private List<Note> dateNotes = new ArrayList<Note>();

    public List<Note> getDateNotes() {
        return dateNotes;
    }

    public void setDateNotes(List<Note> dateNotes) {
        this.dateNotes = dateNotes;
    }
}
