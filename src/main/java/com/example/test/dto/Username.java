package com.example.test.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 *
 * @author Lifu
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Username {
    public String page;
    public int per_page;
    public int total;
    public int total_pages;
    public List<Data> data;

    @Override
    public String toString() {
        return "Username{" + "page=" + page + ", per_page=" + per_page + ", total=" + total + ", total_pages=" + total_pages + ", data=" + data + '}';
    }
    
    
}
