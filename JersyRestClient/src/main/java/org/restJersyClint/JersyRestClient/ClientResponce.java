package org.restJersyClint.JersyRestClient;

import com.sun.jersey.api.client.ClientResponse;

public class ClientResponce 
{
	public void clientResponse(ClientResponse response)
	{
		if(response.getStatus()!=200)
		{
			System.out.println("Failed with HTTP error: " + response.getStatus());
			String error = response.getEntity(String.class);
			System.out.println("Error: " + error);
			return;
		}
	}
}
