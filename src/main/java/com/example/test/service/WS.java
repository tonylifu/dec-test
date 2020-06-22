package com.example.test.service;

import com.example.test.dto.Username;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Lifu
 */
@Path("authors")
public class WS {
    
    @Inject
    private Service service;
    
    @Path("active/{threshold}/{pageNumber}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Username getUsernames(@PathParam("threshold") int threshold, 
            @PathParam("pageNumber") String pageNumber){
        Username result = service.getUsernames(threshold, pageNumber);
        
        return result;
    }
    
    @Path("comments/{pageNumber}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String getUsernameWithHighestCommentCount(@PathParam("pageNumber") String pageNumber){
        String result = service.getAuthorHighestComment(pageNumber);
        
        return result;
    }
    
    @Path("sort/{threshold}/{pageNumber}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Username getUsernamesSortedByRecordDate(@PathParam("threshold") int threshold, 
            @PathParam("pageNumber") String pageNumber){
        Username result = service.getUsernamesSorted(threshold, pageNumber);
        
        return result;
    }
}
