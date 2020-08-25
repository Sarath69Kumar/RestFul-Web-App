package org.restJersyClint.JersyRestClient;

import javax.print.attribute.standard.Media;
import javax.ws.rs.core.MediaType;

import org.restJersyClint.JersyRestClient.modal.Employee;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class GetXmlAsObject 
{
	public static void main(String[] args)
	{
		ClientConfig clientConfig = new DefaultClientConfig();
		
		//create client basd on client
		
		Client client = Client.create(clientConfig);
		
		WebResource webResource = client.resource("http://localhost:8080/http://localhost:8080/RestFulCRUD/rest/employee");
		
		Builder builder = webResource.accept(MediaType.APPLICATION_XML)
				.header("content-type", MediaType.APPLICATION_XML);
		
		ClientResponse response = builder.get(ClientResponse.class);
		
		//status 200 is successful
		if(response.getStatus()!=200)
		{
			System.out.println("Error message from GetXmlAsObject: " + response.getStatus());
			String error = response.getEntity(String.class);
			System.out.println("Error: " + error);
			return;
		}
		
		System.out.println("Output from server... \n");
		
		Employee employee = (Employee)response.getEntity(Employee.class);
				
		System.out.println("Emp No..." + employee.getEmpNo());
		System.out.println("Emp Name..." + employee.getEmpName());
		System.out.println("Posision..." + employee.getPosition());
	}
}
