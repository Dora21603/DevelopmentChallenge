package com.oracle.devops.dropwizard.service;

import com.codahale.metrics.annotation.Timed;
import com.oracle.devops.dropwizard.data.FibonacciResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;

@Path("/FibonacciService")
public class FibonacciService {

    public FibonacciService()
    {

    }

    List sequenceList;

   private FibonacciResponse fib(int count) {
        int total = 0;
        sequenceList = new ArrayList();
        if(count < 1 || count > 100)
        {
            sequenceList.add("Member count not in the range between 1 to 100");
        }
        else if(count ==  1)
        {
            total = 1;
            sequenceList.add(1);
        } else {

            int n1=1,n2=2,n3,i;

            System.out.print(n1+" "+n2);//printing 0 and 1
            sequenceList.add(n1);
            sequenceList.add(n2);
            total = n1 + n2;
            for(i=2;i<count;++i)//loop starts from 2 because 0 and 1 are already printed
            {
                n3=n1+n2;
                sequenceList.add(n3);
                total = total + n3;
                System.out.print(" "+n3);
                n1=n2;
                n2=n3;
            }
         }

       FibonacciResponse fibonacciResponse = new FibonacciResponse();
       fibonacciResponse.setSequence(sequenceList);
       fibonacciResponse.setTotal(total);
       fibonacciResponse.setMemberCount(count);

        return fibonacciResponse;

    }

    @GET
    @Timed
    @Path("/get/{memberCount}")
    @Produces(MediaType.APPLICATION_JSON)
    public FibonacciResponse getFibonacciService(@PathParam("memberCount") int memberCount) {

        FibonacciResponse fibonacciSeries = fib(memberCount);
        return fibonacciSeries;
    }

}