package cz.zcu.kiv.fjp.core.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import cz.zcu.kiv.fjp.core.entities.Edge;
import cz.zcu.kiv.fjp.core.entities.EdgeAttributeObj;

import java.io.IOException;

public class EdgeSerializer extends StdSerializer<Edge> {

    public EdgeSerializer() {
        this(null);
    }

    public EdgeSerializer(Class<Edge> t) {
        super(t);
    }

    @Override
    public void serialize(
            Edge value, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {

        jgen.writeStartObject();
        jgen.writeNumberField("archetype", Integer.parseInt(value.getArchetype()));
        jgen.writeNumberField("from", value.getFrom());
        jgen.writeObjectField("attributes", new EdgeAttributeObj(value.getAttributes().get(0).getValue()));
        jgen.writeNumberField("id", value.getId());
        jgen.writeNumberField("to", value.getTo());
        jgen.writeStringField("text", value.getText());
        jgen.writeEndObject();
    }
}
