package com.example.pascal.salaryapplication.db.object;

/**
 * Created by Pascal on 19.11.2015.
 */
public class SalaryData {


    private int id;
    private double brutSalary;
    private double avsaiapgac;
    private double lpp;
    private double laa;
    private double familyTaxes;
    private double netSalary;
    private double advance;
    private double withholdingTaxes;
    private double other;
    private double finalSalary;

    public int getId() {return id;}
    public void setId(int id){this.id=id;}

    public double getBrutSalary() {return brutSalary;}
    public void setBrutSalary(double brutSalary) {this.brutSalary=brutSalary;}

    public double getAvsaiapgac() {return avsaiapgac;}
    public void setAvsaiapgac(double avsaiapgac){this.avsaiapgac=avsaiapgac;}

    public double getLpp() {return lpp;}
    public void setLpp(double lpp) {this.lpp=lpp;}

    public double getLaa() {return laa;}
    public void setLaa(double laa) {this.laa=laa;}

    public double getFamilyTaxes() {return familyTaxes;}
    public void setFamilyTaxes(double familyTaxes) {this.familyTaxes=familyTaxes;}

    public double getNetSalary() {return netSalary;}
    public void setNetSalary(double netSalary) {this.netSalary=netSalary;}

    public double getAdvance(){return advance;}
    public void setAdvance(double advance) {this.advance=advance;}

    public double getWithholdingTaxes() {return withholdingTaxes;}
    public void setWithholdingTaxes(double withholdingTaxes) {this.withholdingTaxes=withholdingTaxes;}

    public double getOther() {return other;}
    public void setOther(double other) {this.other=other;}

    public double getFinalSalary() {return finalSalary;}
    public void setFinalSalary(double finalSalary) {this.finalSalary=finalSalary;}

}
