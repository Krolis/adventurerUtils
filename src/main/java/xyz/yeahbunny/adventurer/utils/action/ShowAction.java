package xyz.yeahbunny.adventurer.utils.action;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ShowAction<DATA> extends Action<DATA> {

    private Set<String> charactersToNotify;

    public Set<String> getCharactersToNotify() {
        return charactersToNotify;
    }

    public void setCharactersToNotify(Set<String> charactersToNotify) {
        this.charactersToNotify = charactersToNotify;
    }

    public void setCharactersToNotify(String... charactersToNotify) {
        this.charactersToNotify = new HashSet<>(Arrays.asList(charactersToNotify));
    }
}
