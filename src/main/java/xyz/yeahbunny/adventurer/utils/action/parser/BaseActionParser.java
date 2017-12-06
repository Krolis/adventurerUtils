package xyz.yeahbunny.adventurer.utils.action.parser;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import xyz.yeahbunny.adventurer.utils.action.Action;
import xyz.yeahbunny.adventurer.utils.action.ActionType;
import xyz.yeahbunny.adventurer.utils.action.RequestAction;

public class BaseActionParser extends Parser<Action<JsonNode>> {

    private static final JsonPointer typeJsonPointer = JsonPointer.valueOf("/type");
    private static final JsonPointer characterIdJsonPointer = JsonPointer.valueOf("/characterId");
    private static final JsonPointer dataJsonPointer = JsonPointer.valueOf("/data");

    @Override
    public Action<JsonNode> parse(JsonNode json) {
        ActionType actionType = extractType(json);
        switch (actionType) {
            case REQUEST_CHARACTER:
            case REQUEST_MY_CHARACTER:
            case CHARACTER_MOVED:
            case ATTACK_AREA:
            case ATTACK_CHARACTERS:
                return parseBaseRequestAction(actionType, json);
            case SHOW_NPC:
            case SHOW_CHARACTER:
            case RESPONSE_CHARACTER:
            case RESPONSE_MY_CHARACTER:
            case INVALID:
            default:
                return buildInvalid(json);
        }
    }

    private ActionType extractType(JsonNode json) {
        return ActionType.byName(json.at(typeJsonPointer).textValue());
    }

    private RequestAction<JsonNode> parseBaseRequestAction(ActionType actionType, JsonNode json) {
        RequestAction<JsonNode> action = new RequestAction();
        action.setType(actionType);
        action.setCharacterId(json.at(characterIdJsonPointer).textValue());
        action.setData(json.at(dataJsonPointer));
        return action;
    }

    @Override
    protected Action buildInvalid(Object receivedAction) {
        Action action = new Action<String>();
        action.setType(ActionType.INVALID);
        action.setData(receivedAction);
        return action;
    }

}

