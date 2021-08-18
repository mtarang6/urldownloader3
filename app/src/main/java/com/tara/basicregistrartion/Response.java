package com.tara.basicregistrartion;

import com.google.gson.annotations.SerializedName;

public class Response {
    private int postId;
    private int id;
    private String name;
    private String email;
    @SerializedName("body")
    private String ankur;

    public Response(){}
    public Response(int postId, int id, String name, String email, String ankur) {
        this.postId = postId;
        this.id = id;
        this.name = name;
        this.email = email;
        this.ankur = ankur;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAnkur() {
        return ankur;
    }

    public void setAnkur(String ankur) {
        this.ankur = ankur;
    }
}
