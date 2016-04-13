package model;

import java.util.Date;

/**
 * Created by lobrochu on 2016-04-12.
 */
public class PolicyInfo {
    private String postalCode;

    private Integer homeConstructedInYear;

    private Long rebuildingCost;

    private Date dateMovedIn;

    private Date birthDate;

    private String name;

    private Boolean creditConsent;

    private CodeValue numberOfMortgageOnHome;

    private CodeValue numberOfYearsPreviouslyInsured;

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getHomeConstructedInYear() {
        return homeConstructedInYear;
    }

    public void setHomeConstructedInYear(Integer homeConstructedInYear) {
        this.homeConstructedInYear = homeConstructedInYear;
    }

    public Long getRebuildingCost() {
        return rebuildingCost;
    }

    public void setRebuildingCost(Long rebuildingCost) {
        this.rebuildingCost = rebuildingCost;
    }

    public Date getDateMovedIn() {
        return dateMovedIn;
    }

    public void setDateMovedIn(Date dateMovedIn) {
        this.dateMovedIn = dateMovedIn;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getCreditConsent() {
        return creditConsent;
    }

    public void setCreditConsent(Boolean creditConsent) {
        this.creditConsent = creditConsent;
    }

    public CodeValue getNumberOfMortgageOnHome() {
        return numberOfMortgageOnHome;
    }

    public void setNumberOfMortgageOnHome(CodeValue numberOfMortgageOnHome) {
        this.numberOfMortgageOnHome = numberOfMortgageOnHome;
    }

    public CodeValue getNumberOfYearsPreviouslyInsured() {
        return numberOfYearsPreviouslyInsured;
    }

    public void setNumberOfYearsPreviouslyInsured(CodeValue numberOfYearsPreviouslyInsured) {
        this.numberOfYearsPreviouslyInsured = numberOfYearsPreviouslyInsured;
    }
}
