package org.restJersyClint.JersyRestClient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class GetXmlAsString
{
	public static void main(String[] args)
	{
		Client client = Client.create();
		
		WebResource webResource = client.resource("http://localhost:8080/http://localhost:8080/RestFulCRUD/rest/employee");
		
		ClientResponse response = webResource.accept("application/xml").get(ClientResponse.class);
		
		if(response.getStatus()!=200)
		{
			System.out.println("Failed with HTTP error: " + response.getStatus());
			String error = response.getEntity(String.class);
			System.out.println("Error: " + error);
			return;
		}
		
		String output = response.getEntity(String.class);
		
		System.out.println("Output from server... \n");
		System.out.println(output);
	}
}
