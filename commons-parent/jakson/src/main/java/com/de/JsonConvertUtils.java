package com.de;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;


public class JsonConvertUtils {
	
	private final static ObjectMapper objectMapper = new ObjectMapper();
	private final static ObjectMapper prettyMapper = new ObjectMapper();
	
	static {
		prettyMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		prettyMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		prettyMapper.setSerializerFactory(prettyMapper.getSerializerFactory().withSerializerModifier(new CustomSerializerModifier()));   
		prettyMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>()  
        {  
            @Override  
            public void serialize(Object value,  JsonGenerator jg,  SerializerProvider sp) throws IOException, JsonProcessingException  
            {  
                jg.writeString("");  
            }  
        });  
		
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.setSerializerFactory(objectMapper.getSerializerFactory().withSerializerModifier(new CustomSerializerModifier()));   
		objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>()  
		{  
			@Override  
			public void serialize(Object value,  JsonGenerator jg,  SerializerProvider sp) throws IOException, JsonProcessingException {  
				System.out.println();
				jg.writeString("");  
			}  
		});  
	}
	
	public static String toBeautifyJson(Object object) {
		try {
			return prettyMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} 
		return "{}";
	}
	
	public static String toJson(Object objectt) {
		try {
			return objectMapper.writeValueAsString(objectt);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} 
		return "{}";
	}
	
	public static <T> T toObject(String json, Class<T> t ) {
        try {
            return objectMapper.readValue(json, t);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return null;
    }
	
	public static <T> T toObject(String json, TypeReference<T> typeReference ) {
		try {
			return objectMapper.readValue(json, typeReference);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}