package com.insurance.claims.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "http://localhost:8080/policies")
@Path("/policies")
public interface PolicyService {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Policy getPolicyById(@PathParam("id") Long id);
}


