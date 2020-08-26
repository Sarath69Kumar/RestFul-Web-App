package org.restJersyClint.JersyRestClient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class PostXmlString 
{
	public static void main(String[] args)
	{
		Client client = Client.create();
		
		//Data Sent to web service
		WebResource webResource = client.resource("http://localhost:8080/RestFulCRUD/rest/employee/");
		
		String input = "<employee>"//
				+"<empNo>E05</empNo>"//
				+"<empName>Pisces</empName>"//
				+"<position>Dev</position>"//
				+"</employee>";
		
		//Send XML and receive XML
		ClientResponse response = webResource.type("application/xml")//
				.accept("application/xml")//
				.post(ClientResponse.class, input);
		
		if(response.getStatus()!=200)
		{
			System.out.println("Failed HTTP error code: " + response.getStatus());
			String error = response.getEntity(String.class);
			System.out.println("Error: " + error);
			return;
		}
		
		System.out.println("Output from Server .... \n");
		
		String output = response.getEntity(String.class);
		
		System.out.println(output);
	}
}
