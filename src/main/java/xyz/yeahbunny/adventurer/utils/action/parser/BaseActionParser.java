package xyz.yeahbunny.adventurer.utils.action.parser;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import xyz.yeahbunny.adventurer.utils.action.Action;
import xyz.yeahbunny.adventurer.utils.action.ActionType;
import xyz.yeahbunny.adventurer.utils.action.RequestAction;

public class BaseActionParser extends Parser<Action> {

    private static final JsonPointer typeJsonPointer = JsonPointer.valueOf("/type");
    private static final JsonPointer userIdJsonPointer = JsonPointer.valueOf("/userId");

    @Override
    public Action parse(JsonNode json) {
        ActionType actionType = extractType(json);
        switch (actionType) {
            case REQUEST_PLAYER:
            case REQUEST_MY_PLAYER:
            case PLAYER_MOVED:
                return parseBaseRequestAction(actionType, json);
            case SHOW_PLAYER:
            case RESPONSE_PLAYER:
            case RESPONSE_MY_PLAYER:
            case INVALID:
            default:
                return buildInvalid(json.asText());
        }
    }

    private RequestAction parseBaseRequestAction(ActionType actionType, JsonNode json) {
        RequestAction action = new RequestAction();
        action.setType(actionType);
        action.setUserId(json.at(userIdJsonPointer).textValue());
        return action;
    }

    private ActionType extractType(JsonNode json) {
        return ActionType.byName(json.at(typeJsonPointer).textValue());
    }

    @Override
    protected Action buildInvalid(String receivedAction) {
        Action<String> action = new Action<String>();
        action.setType(ActionType.INVALID);
        action.setData(receivedAction);
        return action;
    }

}

