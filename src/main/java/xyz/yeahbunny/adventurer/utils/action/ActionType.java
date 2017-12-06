package xyz.yeahbunny.adventurer.utils.action;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ActionType {
    INVALID("invalid"),
    REQUEST_CHARACTER("request_character"),
    RESPONSE_CHARACTER("response_character"),
    REQUEST_MY_CHARACTER("request_my_character"),
    RESPONSE_MY_CHARACTER("response_my_character"),
    CHARACTER_MOVED("character_moved"),
    SHOW_CHARACTER("show_characters"),
    SHOW_NPC("show_npc"),
    ATTACK_AREA("attack_area"),
    ATTACK_CHARACTERS("attack_characters");

    private final String name;

    ActionType(String s) {
        name = s;
    }

    public static ActionType byName(String name) {
        for (ActionType actionType : values()) {
            if (actionType.name.equals(name)) {
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