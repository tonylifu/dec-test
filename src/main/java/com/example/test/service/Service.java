package com.example.test.service;

import com.example.test.dto.Data;
import com.example.test.dto.Username;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Lifu
 */
@Stateless
public class Service {

    @Inject
    private Environment env;

    private static final Logger logger = LoggerFactory.getLogger(Service.class);

    public Username getUsernames(int threshold, String pageNumber) {
        String url = env.getAuthorsURL(pageNumber);
        logger.info("Get usernames URL: {}", url);

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        Username usernames = target.request(MediaType.APPLICATION_JSON)
                .get(Username.class);
        
        List<Data> dataResult = new ArrayList<>();
        List<Data> data = usernames.data;
        for(Data datum : data){
            if(datum.submission_count >= threshold){
                dataResult.add(datum);
            }
        }
        
        usernames.data = dataResult;

        return usernames;
    }
    
    public String getAuthorHighestComment(String pageNumber) {
        String url = env.getAuthorsURL(pageNumber);
        logger.info("Get usernames URL: {}", url);

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        Username usernames = target.request(MediaType.APPLICATION_JSON)
                .get(Username.class);
        
        List<Data> data = usernames.data;
        int size = data.size();
        int maxIndex = 0;
        for(int i = 0; i < size; i++){
            if(data.get(i).comment_count > data.get(maxIndex).comment_count){
                maxIndex = i;
            }
        }
        
        String user = data.get(maxIndex).username;
        
        return user;
    }
    
    public Username getUsernamesSorted(int threshold, String pageNumber) {
        String url = env.getAuthorsURL(pageNumber);
        logger.info("Get usernames URL: {}", url);

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        Username usernames = target.request(MediaType.APPLICATION_JSON)
                .get(Username.class);
        
        List<Data> dataResult = new ArrayList<>();
        List<Data> data = usernames.data;
        for(Data datum : data){
            if(datum.submission_count >= threshold){
                dataResult.add(datum);
            }
        }
        
        Collections.sort(dataResult);
        
        usernames.data = dataResult;

        return usernames;
    }
    
}
