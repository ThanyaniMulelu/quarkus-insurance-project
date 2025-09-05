package com.insurance.policy;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.time.LocalDate;

@Path("/policies")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PolicyResource {

    @GET
    public List<Policy> getAllPolicies() {
        return Policy.listAll();
    }

    @GET
    @Path("/{id}")
    public Policy getPolicyById(@PathParam("id") Long id) {
        return Policy.findById(id);
    }

    @POST
    @Transactional
    public Response createPolicy(Policy policy) {
        policy.persist();
        return Response.ok(policy).status(201).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response updatePolicy(@PathParam("id") Long id, Policy policy) {
        Policy entity = Policy.findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        entity.policyNumber = policy.policyNumber;
        entity.customerId = policy.customerId;
        entity.startDate = policy.startDate;
        entity.endDate = policy.endDate;
        entity.premium = policy.premium;
        entity.status = policy.status;
        return Response.ok(entity).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response deletePolicy(@PathParam("id") Long id) {
        Policy entity = Policy.findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        entity.delete();
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}

