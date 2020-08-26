package org.restJersyClint.JersyRestClient;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class GetXmlAsList 
{
	public static void main(String[] args)
	{
		ClientConfig clientConfig = new DefaultClientConfig();
		
		Client client = Client.create(clientConfig);
		
		WebResource webResource = client.resource("http://localhost:8080/http://localhost:8080/RestFulCRUD/rest/employee");
		
		Builder builder = webResource.accept(MediaType.APPLICATION_XML)//
					.header("content-type", MediaType.APPLICATION_XML);
		
		ClientResponse response = builder.get(ClientResponse.class);
		
		//Status 200 is successful
		if(response.getStatus()!=200)
		{
			System.out.println("Failed with HTTP error code	:" + response.getStatus());
			String error = response.getEntity(String.class);
			System.out.println("Error : " + error);
			return;
		}
	}
}
