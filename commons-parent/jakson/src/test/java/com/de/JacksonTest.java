package com.de;

public class JacksonTest {
	
    private static Person person = new Person();


	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		person.setAge("12");
		person.setName("lisi");
	    String str = JsonConvertUtils.toJson(person);
	    Person person = JsonConvertUtils.toObject(str, Person.class);
	    System.out.println(str);
	}

	 

}
