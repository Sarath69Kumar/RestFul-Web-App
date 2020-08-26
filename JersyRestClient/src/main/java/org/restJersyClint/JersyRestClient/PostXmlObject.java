package org.restJersyClint.JersyRestClient;

import org.restJersyClint.JersyRestClient.modal.Employee;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class PostXmlObject 
{
	public static void main(String[] args) 
	{
        Client client = Client.create();
 
        WebResource webResource = client.resource("http://localhost:8080/RESTfulCRUD/rest/employees");
 
        // This object will be automatically converted into XML
        Employee newEmp = new Employee("E05", "PstXmlObj", "Manager");
 
        // Send XML and receive XML
        ClientResponse response = webResource.type("application/xml")//
                .accept("application/xml") //
                .post(ClientResponse.class, newEmp);
 
        if (response.getStatus() != 200) 
        {
            System.out.println("Failed : HTTP error code : " + response.getStatus());
 
            String error = response.getEntity(String.class);
            System.out.println("Error: " + error);
            return;
        }
 
        System.out.println("Output from Server .... \n");
 
        String output = response.getEntity(String.class);
 
        System.out.println(output);
	}
}
