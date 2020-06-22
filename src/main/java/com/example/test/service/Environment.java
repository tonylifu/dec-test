package com.example.test.service;

import javax.ejb.Stateless;

/**
 *
 * @author Lifu
 */
@Stateless
public class Environment {
    
    public String getAuthorsURL(String pageNumber){
        return "https://jsonmock.hackerrank.com/api/article_users/search?page="+pageNumber;
    }
    
    
}
