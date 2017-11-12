package action;

public class RequestAction<DATA> extends Action<DATA> {

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
