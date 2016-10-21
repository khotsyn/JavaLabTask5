package by.tc.nb.bean;

public class FindNotesRequest extends Request {

    private String findString;
    private int userId;

    public String getFindString() {
        return findString;
    }

    public void setFindString(String findString) {
        this.findString = findString;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}