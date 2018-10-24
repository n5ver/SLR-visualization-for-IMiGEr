package cz.zcu.kiv.fjp.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import cz.zcu.kiv.fjp.entities.Dummy;
import cz.zcu.kiv.fjp.entities.Node;

import java.io.IOException;
import java.util.ArrayList;

public class NodeSerializer extends StdSerializer<Node> {

    public NodeSerializer() {
        this(null);
    }

    public NodeSerializer(Class<Node> t) {
        super(t);
    }

    @Override
    public void serialize(
            Node value, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {

        jgen.writeStartObject();
        jgen.writeNumberField("archetype", value.getArchetype());
        jgen.writeObjectField("attributes", new Dummy());
        jgen.writeNumberField("id", value.getId());
        jgen.writeStringField("text", value.getText());
        jgen.writeStringField("title", value.getTitle());
        jgen.writeEndObject();
    }
}
