package com.oracle.devops.dropwizard.service;

import com.codahale.metrics.annotation.Timed;
import com.oracle.devops.dropwizard.data.HelloWorld;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/HelloWorld")
public class HelloWorldService {

    public HelloWorldService() {

    }

    @GET
    @Timed
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public HelloWorld getHelloWorld(@PathParam("id") int id) {
        HelloWorld helloWorld = new HelloWorld("Hello World:"+id);
        return helloWorld;
    }

}