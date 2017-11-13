package xyz.yeahbunny.adventurer.utils.action;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ActionType {
    INVALID("invalid"),
    REQUEST_PLAYER("request_player_state"),
    RESPONSE_PLAYER("show_player_state"),
    REQUEST_MY_PLAYER("request_my_player"),
    RESPONSE_MY_PLAYER("show_my_player"),
    PLAYER_MOVED("player_moved"),
    SHOW_PLAYER("show_player_moved"),
    SHOW_NPC("show_npc");

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