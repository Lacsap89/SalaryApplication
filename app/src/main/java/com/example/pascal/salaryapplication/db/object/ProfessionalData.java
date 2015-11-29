package com.example.pascal.salaryapplication.db.object;

/**
 * Created by Pascal on 19.11.2015.
 */
public class ProfessionalData {

    private int postId;
    private String post;
    private int salaryClass;
    private String boss;
    private int salaryId;

    public int getPostId() {return postId;}
    public void setPostId(int postId){this.postId=postId;}

    public String getPost() {return post;}
    public void setPost(String post) {this.post=post;}

    public int getSalaryClass() {return salaryClass;}
    public void setSalaryClass (int salaryClass) {this.salaryClass=salaryClass;}

    public String getBoss() {return boss;}
    public void setBoss(String boss) {this.boss=boss;}

    public int getSalaryId() {return salaryId;}
    public void setSalaryId(int salaryId) {this.salaryId=salaryId;}




}
