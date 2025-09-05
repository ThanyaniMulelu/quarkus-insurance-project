package com.insurance.quote;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.time.LocalDate;

@Path("/quotes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class QuoteResource {

    @GET
    public List<Quote> getAllQuotes() {
        return Quote.listAll();
    }

    @GET
    @Path("/{id}")
    public Quote getQuoteById(@PathParam("id") Long id) {
        return Quote.findById(id);
    }

    @POST
    @Transactional
    public Response createQuote(Quote quote) {
        quote.persist();
        return Response.ok(quote).status(201).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response updateQuote(@PathParam("id") Long id, Quote quote) {
        Quote entity = Quote.findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        entity.quoteNumber = quote.quoteNumber;
        entity.customerId = quote.customerId;
        entity.policyType = quote.policyType;
        entity.quotedPremium = quote.quotedPremium;
        entity.quoteDate = quote.quoteDate;
        entity.expirationDate = quote.expirationDate;
        entity.status = quote.status;
        return Response.ok(entity).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response deleteQuote(@PathParam("id") Long id) {
        Quote entity = Quote.findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        entity.delete();
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}

