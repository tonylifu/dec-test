package com.example.test.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;

/**
 *
 * @author Lifu
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Data implements Comparable<Data>{
    public int id;
    public String username;
    public String about;
    public int submitted;
    public Date updated_at;
    public int submission_count;
    public int comment_count;
    public int created_at;

    @Override
    public String toString() {
        return "Data{" + "id=" + id + ", username=" + username + ", about=" + about + ", submitted=" + submitted + ", updated_at=" + updated_at + ", submission_count=" + submission_count + ", comment_count=" + comment_count + ", created_at=" + created_at + '}';
    }
    
    @Override
    public int compareTo(Data o) {
        return new Integer(this.created_at).compareTo(o.created_at);
    }
}
