package com.example.pascal.salaryapplication.db.object;

/**
 * Created by Pascal on 19.11.2015.
 */
public class PersonalData {

    private int id;
    private String name;
    private String lastname;
    private String address;
    private String birthdate;
    private String civilStatus;
    private int nbChildren;
    private String nationality;
    private String permit;
    private String bank;
    private String login;
    private String contractBegin;
    private int percentage;
    private int hollidayLeft;
    private String password;
    private int postId;

    public int getId() {return id;}
    public void setId(int id){this.id=id;}

    public String getName() {return name;}
    public void setName(String name) {this.name=name;}

    public String getLastname() {return lastname;}
    public void setLastname(String lastname) {this.lastname=lastname;}

    public String getAddress(){return address;}
    public void setAddress(String address){this.address=address;}

    public String getBirthdate(){return birthdate;}
    public void setBirthdate(String birthdate){this.birthdate=birthdate;}

    public String getCivilStatus() {return civilStatus;}
    public void setCivilStatus(String civilStatus){this.civilStatus=civilStatus;}

    public int getNbChildren(){return nbChildren;}
    public void setNbChildren(int nbChildren){this.nbChildren=nbChildren;}

    public String getNationality() {return nationality;}
    public void setNationality(String nationality) {this.nationality=nationality;}

    public String getPermit() {return permit;}
    public void setPermit(String permit) {this.permit=permit;}

    public String getBank() {return bank;}
    public void setBank(String bank) {this.bank=bank;}


    public String getContractBegin() {return contractBegin;}
    public void setContractBegin(String contractBegin) {this.contractBegin=contractBegin;}

    public int getPercentage(){return percentage;}
    public void setPercentage(int percentage) {this.percentage=percentage;}

    public int getHollidayLeft() {return hollidayLeft;}
    public void setHollidayLeft(int hollidayLeft) {this.hollidayLeft=hollidayLeft;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password=password;}

    public int getPostId() {return postId;}
    public void setPostId(int postId) {this.postId=postId;}


}
