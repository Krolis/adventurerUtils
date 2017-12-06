package xyz.yeahbunny.adventurer.utils.action;

import com.fasterxml.jackson.annotation.JsonValue;

public enum QueueType {
    INVALID("invalid"),
    API("apiQueue"),
    DISPATCHER("dispatcherQueue"),
    CHARACTER_QUEUE("characterQueue"),
    POSITION_QUEUE("positionQueue");

    private final String name;

    QueueType(String s) {
        name = s;
    }

    public static QueueType byName(String name) {
        for (QueueType actionType : values()) {
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
