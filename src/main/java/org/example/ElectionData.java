package org.example;

import java.util.List;

public class ElectionData {
    private String regionID;
    private String regionName;
    private String regionAddress;
    private String regionPostalCode;
    private String federalState;
    private String timestamp;
    private List<Party> countingData;

    // Getters and Setters
    public String getRegionID() { return regionID; }
    public void setRegionID(String regionID) { this.regionID = regionID; }

    public String getRegionName() { return regionName; }
    public void setRegionName(String regionName) { this.regionName = regionName; }

    public String getRegionAddress() { return regionAddress; }
    public void setRegionAddress(String regionAddress) { this.regionAddress = regionAddress; }

    public String getRegionPostalCode() { return regionPostalCode; }
    public void setRegionPostalCode(String regionPostalCode) { this.regionPostalCode = regionPostalCode; }

    public String getFederalState() { return federalState; }
    public void setFederalState(String federalState) { this.federalState = federalState; }

    public String getTimestamp() { return timestamp; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }

    public List<Party> getCountingData() { return countingData; }
    public void setCountingData(List<Party> countingData) { this.countingData = countingData; }
}
