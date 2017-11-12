package xyz.yeahbunny.adventurer.utils.action.parser;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import xyz.yeahbunny.adventurer.utils.action.Action;
import xyz.yeahbunny.adventurer.utils.action.ActionType;
import xyz.yeahbunny.adventurer.utils.action.RequestAction;
import xyz.yeahbunny.adventurer.utils.action.parser.BaseActionParser;

@RunWith(JUnitParamsRunner.class)
public class ActionParserTest {

    private BaseActionParser baseActionParser;

    @Before
    public void init() {
        baseActionParser = new BaseActionParser();
    }


    @Test
    @Parameters({
            "invalid,{\"type\":\"action_1\"}",
            "invalid,{\"typessdas\":\"action_1\"}",
            "request_my_player,{\"type\":\"request_my_player\"}",
            "request_player_state,{\"type\":\"request_player_state\"}",
            "player_moved,{\"type\":\"player_moved\"}"

    })
    public void shouldParseActionType(String expectedActionString, String actionToParse) {

        ActionType expectedAction = ActionType.byName(expectedActionString);

        Action action = baseActionParser.parse(actionToParse);

        Assert.assertEquals(expectedAction, action.getType());
    }

    @Test
    @Parameters({
            "Action,{\"type\":\"badactionaname\"}",
            "RequestAction,{\"type\":\"request_my_player\"}",
            "RequestAction,{\"type\":\"request_player_state\"}",
            "RequestAction,{\"type\":\"player_moved\"}"
    })
    public void shouldParseCorrectActionData(String expectedActionDataType, String actionToParse) {

        Action action = baseActionParser.parse(actionToParse);

        Assert.assertEquals(expectedActionDataType, action.getClass().getSimpleName());
    }

    @Test
    public void shouldParseUserId(){
        String actionToParse = "{\"type\":\"player_moved\",\"userId\":\"UID\"}";
        RequestAction action = (RequestAction)baseActionParser.parse(actionToParse);

        Assert.assertEquals("UID", action.getUserId());
    }
}