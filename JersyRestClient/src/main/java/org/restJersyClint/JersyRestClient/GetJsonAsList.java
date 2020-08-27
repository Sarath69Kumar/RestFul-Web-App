package org.restJersyClint.JersyRestClient;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.restJersyClint.JersyRestClient.modal.Employee;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class GetJsonAsList 
{
	public static void main(String[] args)
	{
		ClientConfig clientConfig = new DefaultClientConfig();
		
		Client client = Client.create(clientConfig);
		
		WebResource webResourse = client.resource("http://localhost:8080/RestFulCRUD/rest/employee");
		
		Builder builder = webResourse.accept(MediaType.APPLICATION_JSON)//
					.header("content-type", MediaType.APPLICATION_JSON);
		
		ClientResponse response = builder.get(ClientResponse.class);
		
		//Status 200 is successful
		if(response.getStatus()!=200)
		{
			System.out.println("Failed with HTTP Error Code: " + response.getStatus());
			String error = response.getEntity(String.class);
			System.out.println("Error: " + error);
			return;
		}
		
		GenericType<List<Employee>> generic = new GenericType<List<Employee>>()
		{
			//nothing
		};
		
		//https://stackoverflow.com/questions/6427478/error-when-trying-to-convert-json-to-pojo-using-jersey
		List<Employee> list = response.getEntity(generic);
		
		System.out.println("Output from server... \n");
		
		for(Employee emp : list)
		{
			System.out.println("---");
			System.out.println("Emp No..." + emp.getEmpNo());
			System.out.println("Emp Name..." + emp.getEmpName());
			System.out.println("Position..." + emp.getPosition());
		}
	}
}
