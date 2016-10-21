package by.tc.nb.bean.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class NoteBook implements Serializable {
	
	List<Note> notes = new ArrayList<Note>();

    public void addNote(Note note) {
        notes.add(note);
    }

    public void cleanNoteBook() {
        notes.clear();
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
}
