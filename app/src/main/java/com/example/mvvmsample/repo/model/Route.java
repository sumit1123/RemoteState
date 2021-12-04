package com.example.mvvmsample.repo.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "companyId",
        "truckTypeId",
        "truckSizeId",
        "truckNumber",
        "transporterId",
        "trackerType",
        "imeiNumber",
        "simNumber",
        "name",
        "password",
        "createTime",
        "deactivated",
        "breakdown",
        "lastWaypoint",
        "lastRunningState",
        "durationInsideSite",
        "fuelSensorInstalled",
        "externalTruck"
})

public class Route {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("companyId")
    private Integer companyId;
    @JsonProperty("truckTypeId")
    private Integer truckTypeId;
    @JsonProperty("truckSizeId")
    private Integer truckSizeId;
    @JsonProperty("truckNumber")
    private String truckNumber;
    @JsonProperty("transporterId")
    private Integer transporterId;
    @JsonProperty("trackerType")
    private Integer trackerType;
    @JsonProperty("imeiNumber")
    private String imeiNumber;
    @JsonProperty("simNumber")
    private String simNumber;
    @JsonProperty("name")
    private String name;
    @JsonProperty("password")
    private String password;
    @JsonProperty("createTime")
    private Long createTime;
    @JsonProperty("deactivated")
    private Boolean deactivated;
    @JsonProperty("breakdown")
    private Boolean breakdown;
    @JsonProperty("lastWaypoint")
    private LastWaypoint lastWaypoint;
    @JsonProperty("lastRunningState")
    private LastRunningState lastRunningState;
    @JsonProperty("durationInsideSite")
    private Integer durationInsideSite;
    @JsonProperty("fuelSensorInstalled")
    private Boolean fuelSensorInstalled;
    @JsonProperty("externalTruck")
    private Boolean externalTruck;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("companyId")
    public Integer getCompanyId() {
        return companyId;
    }

    @JsonProperty("companyId")
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @JsonProperty("truckTypeId")
    public Integer getTruckTypeId() {
        return truckTypeId;
    }

    @JsonProperty("truckTypeId")
    public void setTruckTypeId(Integer truckTypeId) {
        this.truckTypeId = truckTypeId;
    }

    @JsonProperty("truckSizeId")
    public Integer getTruckSizeId() {
        return truckSizeId;
    }

    @JsonProperty("truckSizeId")
    public void setTruckSizeId(Integer truckSizeId) {
        this.truckSizeId = truckSizeId;
    }

    @JsonProperty("truckNumber")
    public String getTruckNumber() {
        return truckNumber;
    }

    @JsonProperty("truckNumber")
    public void setTruckNumber(String truckNumber) {
        this.truckNumber = truckNumber;
    }

    @JsonProperty("transporterId")
    public Integer getTransporterId() {
        return transporterId;
    }

    @JsonProperty("transporterId")
    public void setTransporterId(Integer transporterId) {
        this.transporterId = transporterId;
    }

    @JsonProperty("trackerType")
    public Integer getTrackerType() {
        return trackerType;
    }

    @JsonProperty("trackerType")
    public void setTrackerType(Integer trackerType) {
        this.trackerType = trackerType;
    }

    @JsonProperty("imeiNumber")
    public String getImeiNumber() {
        return imeiNumber;
    }

    @JsonProperty("imeiNumber")
    public void setImeiNumber(String imeiNumber) {
        this.imeiNumber = imeiNumber;
    }

    @JsonProperty("simNumber")
    public String getSimNumber() {
        return simNumber;
    }

    @JsonProperty("simNumber")
    public void setSimNumber(String simNumber) {
        this.simNumber = simNumber;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    @JsonProperty("createTime")
    public Long getCreateTime() {
        return createTime;
    }

    @JsonProperty("createTime")
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    @JsonProperty("deactivated")
    public Boolean getDeactivated() {
        return deactivated;
    }

    @JsonProperty("deactivated")
    public void setDeactivated(Boolean deactivated) {
        this.deactivated = deactivated;
    }

    @JsonProperty("breakdown")
    public Boolean getBreakdown() {
        return breakdown;
    }

    @JsonProperty("breakdown")
    public void setBreakdown(Boolean breakdown) {
        this.breakdown = breakdown;
    }

    @JsonProperty("lastWaypoint")
    public LastWaypoint getLastWaypoint() {
        return lastWaypoint;
    }

    @JsonProperty("lastWaypoint")
    public void setLastWaypoint(LastWaypoint lastWaypoint) {
        this.lastWaypoint = lastWaypoint;
    }

    @JsonProperty("lastRunningState")
    public LastRunningState getLastRunningState() {
        return lastRunningState;
    }

    @JsonProperty("lastRunningState")
    public void setLastRunningState(LastRunningState lastRunningState) {
        this.lastRunningState = lastRunningState;
    }

    @JsonProperty("durationInsideSite")
    public Integer getDurationInsideSite() {
        return durationInsideSite;
    }

    @JsonProperty("durationInsideSite")
    public void setDurationInsideSite(Integer durationInsideSite) {
        this.durationInsideSite = durationInsideSite;
    }

    @JsonProperty("fuelSensorInstalled")
    public Boolean getFuelSensorInstalled() {
        return fuelSensorInstalled;
    }

    @JsonProperty("fuelSensorInstalled")
    public void setFuelSensorInstalled(Boolean fuelSensorInstalled) {
        this.fuelSensorInstalled = fuelSensorInstalled;
    }

    @JsonProperty("externalTruck")
    public Boolean getExternalTruck() {
        return externalTruck;
    }

    @JsonProperty("externalTruck")
    public void setExternalTruck(Boolean externalTruck) {
        this.externalTruck = externalTruck;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
