package by.tc.nb.bean;

public class AddNoteRequest extends Request {

	private String note;
	private int userId;

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
