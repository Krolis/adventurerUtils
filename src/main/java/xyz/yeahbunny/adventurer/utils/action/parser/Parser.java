package xyz.yeahbunny.adventurer.utils.action.parser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public abstract class Parser<OUTPUT> {

    private static final Logger LOG = LoggerFactory.getLogger(Parser.class);
    private ObjectMapper mapper = new ObjectMapper();

    public OUTPUT parse(String jsonString){
        try {
            JsonNode json = mapper.readTree(jsonString);
            return parse(json);
        } catch (IOException e) {
            e.printStackTrace();
            LOG.error("invalid action: " + jsonString);
            return buildInvalidAction(jsonString);
        }
    }

    public abstract OUTPUT parse(JsonNode jsonNode);

    protected abstract OUTPUT buildInvalidAction(String receivedAction);
}
