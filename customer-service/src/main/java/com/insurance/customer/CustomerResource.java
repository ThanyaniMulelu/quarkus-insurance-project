package com.insurance.customer;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {

    @GET
    public List<Customer> getAllCustomers() {
        return Customer.listAll();
    }

    @GET
    @Path("/{id}")
    public Customer getCustomerById(@PathParam("id") Long id) {
        return Customer.findById(id);
    }

    @POST
    @Transactional
    public Response createCustomer(Customer customer) {
        customer.persist();
        return Response.ok(customer).status(201).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response updateCustomer(@PathParam("id") Long id, Customer customer) {
        Customer entity = Customer.findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        entity.name = customer.name;
        entity.email = customer.email;
        entity.phoneNumber = customer.phoneNumber;
        return Response.ok(entity).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response deleteCustomer(@PathParam("id") Long id) {
        Customer entity = Customer.findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        entity.delete();
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}

