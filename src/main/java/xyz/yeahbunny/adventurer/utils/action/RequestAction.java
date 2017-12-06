package xyz.yeahbunny.adventurer.utils.action;

public class RequestAction<DATA> extends Action<DATA> {

    private String characterId;

    public String getCharacterId() {
        return characterId;
    }

    public void setCharacterId(String characterId) {
        this.characterId = characterId;
    }

}
