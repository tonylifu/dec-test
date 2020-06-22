package com.example.test.service;

import com.example.test.dto.Data;
import com.example.test.dto.Username;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kong.unirest.Unirest;

/**
 *
 * @author Lifu
 */
public class TestAuthors {
    
    public static void main(String[] args){
        List<String> usernames = getUsernames(0);
        System.out.println(usernames);
        System.out.println("================================================================");
        String user = getUsernameWithHighestCommentCount();
        System.out.println(user);
        System.out.println("================================================================");
        List<String> userSorted = getUsernamesSortedByRecordDate(0);
        System.out.println(userSorted);
        
        System.out.println("================================================================");
        System.out.println("================================================================");
        
        
        /*int numberMachineCanWash = 4;
        Integer[] cleanPile = new Integer[]{1, 1, 1, 1, 1, 1};
        Integer[] dirtyPile = new Integer[]{1, 2, 2, 1, 3, 4, 5, 2};
        int maxNumberPairs = SockLaundry.getMaximumPairOfSocks(numberMachineCanWash, cleanPile, dirtyPile);
        
        System.out.println("================================================================");
        
        System.out.println(maxNumberPairs);*/
    }
    
    public static String getAuthorsURLStatic(String pageNumber){
        return "https://jsonmock.hackerrank.com/api/article_users/search?page="+pageNumber;
    }
    
    public static List<String> getUsernames(int threshold){
        String pageNumber = "1";
        String url = getAuthorsURLStatic(pageNumber);
        
        Username usernames = Unirest.get(url)
                   .asObject(Username.class)
                   .getBody();
        
        List<Data> dataResult = new ArrayList<>();
        List<Data> data = usernames.data;
        for(Data datum : data){
            if(datum.submission_count >= threshold){
                dataResult.add(datum);
            }
        }
        
        usernames.data = dataResult;
        
        //ObjectMapper mapper = new ObjectMapper();
        //String json = mapper.writeValueAsString(usernames);
        
        List<String> list = new ArrayList<>();
        list.add(usernames.page);
        list.add(String.valueOf(usernames.per_page));
        list.add(String.valueOf(usernames.total));
        list.add(String.valueOf(usernames.total_pages));
        list.add(usernames.data.toString());
        
        return list;
    }
    
    public static String getUsernameWithHighestCommentCount() {
        String pageNumber = "1";
        String url = getAuthorsURLStatic(pageNumber);
        
        Username usernames = Unirest.get(url)
                   .asObject(Username.class)
                   .getBody();
        
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
    
    public static List<String> getUsernamesSortedByRecordDate(int threshold){
        String pageNumber = "1";
        String url = getAuthorsURLStatic(pageNumber);
        
        Username usernames = Unirest.get(url)
                   .asObject(Username.class)
                   .getBody();
        
        List<Data> dataResult = new ArrayList<>();
        List<Data> data = usernames.data;
        for(Data datum : data){
            if(datum.submission_count >= threshold){
                dataResult.add(datum);
            }
        }
        
        Collections.sort(dataResult);
        
        usernames.data = dataResult;
        
        List<String> list = new ArrayList<>();
        list.add(usernames.page);
        list.add(String.valueOf(usernames.per_page));
        list.add(String.valueOf(usernames.total));
        list.add(String.valueOf(usernames.total_pages));
        list.add(usernames.data.toString());
        
        return list;
    }
}
