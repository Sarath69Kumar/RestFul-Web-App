package org.restJersyClint.JersyRestClient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class PostJsonString 
{
	public static void main(String[] args)
	{
//		ClientResponce cr=new ClientResponce();
		Client client = Client.create();
		
		WebResource webResource = client.resource("http://localhost:8080/RestFulCRUD/rest/employee");
		
		//Data sent to web service
		String input = "{\"empNo\":\"E02\",\"empName\":\" KER_BAS\",\"position\":\"MD\"}";
		
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);
		
//		cr.clientResponse(response);
		
		if(response.getStatus()!=200) 
		{
			System.out.println("Failed Http error code : " + response.getStatus());
			String error = response.getEntity(String.class); System.out.println("Error: "
			+ error); return; 
		}
		 
		
		System.out.println("Output from server... \n");
		
		String output = response.getEntity(String.class);
		
		System.out.println(output);
	}
}
