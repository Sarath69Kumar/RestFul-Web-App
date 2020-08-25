package org.restJersyClint.JersyRestClient;


import javax.ws.rs.core.MediaType;

import org.restJersyClint.JersyRestClient.modal.Employee;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class GetJsonToObject 
{
	public static void main(String[] args)
	{
		ClientConfig clientConfig = new DefaultClientConfig();
		
		//Create client based on config
		Client client = Client.create(clientConfig);
		
		WebResource webResource = client.resource("http://localhost:8080/RestFulCRUD/rest/employee/E02");
		
		Builder builder = webResource.accept(MediaType.APPLICATION_JSON)//
						.header("content-type",MediaType.APPLICATION_JSON);
		//MediaType can be imported from
		//import javax.ws.rs.core.MediaType;(Recommended)
		//import java.awt.PageAttributes.MediaType;
		//Builder should be imported from
		//import com.sun.jersey.api.client.WebResource.Builder;
		
		ClientResponse response = builder.get(ClientResponse.class);
		
		//Status 200 is successful
		if(response.getStatus()!=200)
		{
			System.out.println("Failed with HTTP Error code: "+response.getStatus());
			String error = response.getEntity(String.class);
			System.out.println("Error : "+error);
			return;
		}
		
		System.out.println("Output from Server ... \n");
		
		Employee employee = (Employee)response.getEntity(Employee.class);
		
		System.out.println("Emp No..." + employee.getEmpNo());
		System.out.println("Emp Name..." + employee.getEmpName());
		System.out.println("Position..." + employee.getPosition());
	}
}
