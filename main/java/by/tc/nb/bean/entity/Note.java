package by.tc.nb.bean.entity;

import java.io.Serializable;
import java.util.Date;

public class Note implements Serializable {

    private String note;
    private Date date;
    private int id;

    public Note(String note, int id) {
        this.note = note;
        date = new Date();
        this.id = id;
    }

    public Note(String note, Date date, int id) {
        this.note = note;
        this.date = date;
        this.id = id;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public Date getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        String note = this.note + " " + date.toString();
        return note;
    }

}
