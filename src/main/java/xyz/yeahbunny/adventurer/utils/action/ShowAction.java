package xyz.yeahbunny.adventurer.utils.action;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ShowAction<DATA> extends Action<DATA> {

    private Set<String> usersToNotify;

    public Set<String> getUsersToNotify() {
        return usersToNotify;
    }

    public void setUsersToNotify(Set<String> usersToNotify) {
        this.usersToNotify = usersToNotify;
    }

    public void setUsersToNotify(String ...usersToNotify) {
        this.usersToNotify = new HashSet<>(Arrays.asList(usersToNotify));
    }
}
