package action;

import java.util.Set;

public class ShowAction<DATA> extends Action<DATA> {

    private Set<String> usersToNotify;

    public Set<String> getUsersToNotify() {
        return usersToNotify;
    }

    public void setUsersToNotify(Set<String> usersToNotify) {
        this.usersToNotify = usersToNotify;
    }
}
