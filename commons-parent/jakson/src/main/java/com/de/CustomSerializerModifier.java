package com.de;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;

public class CustomSerializerModifier extends BeanSerializerModifier {

	private final JsonSerializer<Object> nullBooleanSerializer;
	private final JsonSerializer<Object> nullNumberSerializer;
	private final JsonSerializer<Object> nullListSerializer;
	private final JsonSerializer<Object> nullStringSerializer;
	private final JsonSerializer<Object> nullObjectSerializer;

	public CustomSerializerModifier() {
		nullBooleanSerializer = new NullBooleanSerializer();
		nullNumberSerializer = new NullNumberSerializer();
		nullListSerializer = new NullListJsonSerializer();
		nullStringSerializer = new NullStringSerializer();
		nullObjectSerializer = new NullObjectJsonSerializer();
	}

	@Override
	public List<BeanPropertyWriter> changeProperties(SerializationConfig config, BeanDescription beanDesc,
			List<BeanPropertyWriter> beanProperties) {
		for (BeanPropertyWriter writer : beanProperties) {
			final JavaType javaType = writer.getType();
			final Class<?> rawClass = javaType.getRawClass();
			if (javaType.isArrayType() || javaType.isCollectionLikeType()) {
				writer.assignNullSerializer(nullListSerializer);
			} else if (Number.class.isAssignableFrom(rawClass) && rawClass.getName().startsWith("java.lang")) {
				writer.assignNullSerializer(nullNumberSerializer);
			} else if (Boolean.class.equals(rawClass)) {
				writer.assignNullSerializer(nullBooleanSerializer);
			} else if (String.class.equals(rawClass)) {
				writer.assignNullSerializer(nullStringSerializer);
			} else if (Map.class.isAssignableFrom(rawClass)) {
				writer.assignNullSerializer(nullObjectSerializer);
			} else {
				writer.assignNullSerializer(nullObjectSerializer);
			}
		}
		return beanProperties;
	}

	private static class NullListJsonSerializer extends JsonSerializer<Object> {
		@Override
		public void serialize(Object value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
			if (value == null) {
				jgen.writeStartArray();
				jgen.writeEndArray();
			}
		}
	}

	private static class NullNumberSerializer extends JsonSerializer<Object> {
		@Override
		public void serialize(Object value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
			if (value == null) {
				jgen.writeNumber(0);
			}
		}
	}

	private static class NullBooleanSerializer extends JsonSerializer<Object> {
		@Override
		public void serialize(Object value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
			if (value == null) {
				jgen.writeBoolean(false);
			}
		}
	}

	private static class NullStringSerializer extends JsonSerializer<Object> {
		@Override
		public void serialize(Object value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
			if (value == null) {
				jgen.writeString("");
			}
		}
	}

	private static class NullObjectJsonSerializer extends JsonSerializer<Object> {
		@Override
		public void serialize(Object value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
			if (value == null) {
				jgen.writeStartObject();
				jgen.writeEndObject();
			}
		}
	}
}
