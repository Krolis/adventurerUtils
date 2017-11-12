package xyz.yeahbunny.adventurer.utils.action;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ActionType {
    INVALID("invalid"),
    PLAYER_MOVED("player_moved"),
    SHOW_PLAYER("show_player_moved");

    private final String name;

    ActionType(String s) {
        name = s;
    }

    public static ActionType byName(String name){
        for(ActionType actionType: values()){
            if(actionType.name.equals(name)){
                return actionType;
            }
        }
        return INVALID;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.name;
    }

}