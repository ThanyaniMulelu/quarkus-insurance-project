package com.insurance.claims;

import com.insurance.claims.client.Customer;
import com.insurance.claims.client.CustomerService;
import com.insurance.claims.client.Policy;
import com.insurance.claims.client.PolicyService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import java.util.List;
import java.time.LocalDate;

@Path("/claims")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClaimResource {

    @Inject
    @RestClient
    CustomerService customerService;

    @Inject
    @RestClient
    PolicyService policyService;

    @GET
    public List<Claim> getAllClaims() {
        return Claim.listAll();
    }

    @GET
    @Path("/{id}")
    public Claim getClaimById(@PathParam("id") Long id) {
        return Claim.findById(id);
    }

    @POST
    @Transactional
    public Response createClaim(Claim claim) {
        // Validate customer and policy existence
        Customer customer = customerService.getCustomerById(claim.policyId); // Assuming policyId is customerId for simplicity, needs refinement
        Policy policy = policyService.getPolicyById(claim.policyId);

        if (customer == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Customer not found").build();
        }
        if (policy == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Policy not found").build();
        }

        claim.persist();
        return Response.ok(claim).status(201).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response updateClaim(@PathParam("id") Long id, Claim claim) {
        Claim entity = Claim.findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        // Validate customer and policy existence
        Customer customer = customerService.getCustomerById(claim.policyId); // Assuming policyId is customerId for simplicity, needs refinement
        Policy policy = policyService.getPolicyById(claim.policyId);

        if (customer == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Customer not found").build();
        }
        if (policy == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Policy not found").build();
        }

        entity.claimNumber = claim.claimNumber;
        entity.policyId = claim.policyId;
        entity.claimDate = claim.claimDate;
        entity.description = claim.description;
        entity.status = claim.status;
        return Response.ok(entity).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response deleteClaim(@PathParam("id") Long id) {
        Claim entity = Claim.findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        entity.delete();
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}

