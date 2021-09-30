package com.example.assignment;

import java.util.List;

public class Response {

    String Message = "";
    String Status = "";

    List<PostOffice> PostOffice = null;

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public List<com.example.assignment.PostOffice> getPostOffice() {
        return PostOffice;
    }

    public void setPostOffice(List<com.example.assignment.PostOffice> postOffice) {
        PostOffice = postOffice;
    }
}