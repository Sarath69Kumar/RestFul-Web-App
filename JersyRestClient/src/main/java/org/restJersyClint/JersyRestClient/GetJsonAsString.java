package org.restJersyClint.JersyRestClient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class GetJsonAsString 
{
	public static void main(String[] args)
	{
		//Create client
		Client client = Client.create();
		
		WebResource webResourse = client.resource("http://localhost:8080/RestFulCRUD/rest/employee/E02");
		
		ClientResponse response = webResourse.accept("application/json").get(ClientResponse.class);
		
		//Status 200 successful
		if(response.getStatus()!=200)
		{
			System.out.println("Failed with HTTP error code: "+response.getStatus());
			String error =response.getEntity(String.class);
			System.out.println("Error: "+error);
			return;
		}
		String output = response.getEntity(String.class);
		
		System.out.println("Out put from server ...\n");
		System.out.println(output);
	}
}
