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
        "lat",
        "lng",
        "createTime",
        "accuracy",
        "bearing",
        "truckId",
        "speed",
        "updateTime",
        "ignitionOn",
        "odometerReading",
        "batteryPower",
        "fuelLevel",
        "batteryLevel"
})

public class LastWaypoint {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("lat")
    private Double lat;
    @JsonProperty("lng")
    private Double lng;
    @JsonProperty("createTime")
    private Long createTime;
    @JsonProperty("accuracy")
    private Double accuracy;
    @JsonProperty("bearing")
    private Double bearing;
    @JsonProperty("truckId")
    private Integer truckId;
    @JsonProperty("speed")
    private Double speed;
    @JsonProperty("updateTime")
    private Long updateTime;
    @JsonProperty("ignitionOn")
    private Boolean ignitionOn;
    @JsonProperty("odometerReading")
    private Double odometerReading;
    @JsonProperty("batteryPower")
    private Boolean batteryPower;
    @JsonProperty("fuelLevel")
    private Integer fuelLevel;
    @JsonProperty("batteryLevel")
    private Integer batteryLevel;
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

    @JsonProperty("lat")
    public Double getLat() {
        return lat;
    }

    @JsonProperty("lat")
    public void setLat(Double lat) {
        this.lat = lat;
    }

    @JsonProperty("lng")
    public Double getLng() {
        return lng;
    }

    @JsonProperty("lng")
    public void setLng(Double lng) {
        this.lng = lng;
    }

    @JsonProperty("createTime")
    public Long getCreateTime() {
        return createTime;
    }

    @JsonProperty("createTime")
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    @JsonProperty("accuracy")
    public Double getAccuracy() {
        return accuracy;
    }

    @JsonProperty("accuracy")
    public void setAccuracy(Double accuracy) {
        this.accuracy = accuracy;
    }

    @JsonProperty("bearing")
    public Double getBearing() {
        return bearing;
    }

    @JsonProperty("bearing")
    public void setBearing(Double bearing) {
        this.bearing = bearing;
    }

    @JsonProperty("truckId")
    public Integer getTruckId() {
        return truckId;
    }

    @JsonProperty("truckId")
    public void setTruckId(Integer truckId) {
        this.truckId = truckId;
    }

    @JsonProperty("speed")
    public Double getSpeed() {
        return speed;
    }

    @JsonProperty("speed")
    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    @JsonProperty("updateTime")
    public Long getUpdateTime() {
        return updateTime;
    }

    @JsonProperty("updateTime")
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    @JsonProperty("ignitionOn")
    public Boolean getIgnitionOn() {
        return ignitionOn;
    }

    @JsonProperty("ignitionOn")
    public void setIgnitionOn(Boolean ignitionOn) {
        this.ignitionOn = ignitionOn;
    }

    @JsonProperty("odometerReading")
    public Double getOdometerReading() {
        return odometerReading;
    }

    @JsonProperty("odometerReading")
    public void setOdometerReading(Double odometerReading) {
        this.odometerReading = odometerReading;
    }

    @JsonProperty("batteryPower")
    public Boolean getBatteryPower() {
        return batteryPower;
    }

    @JsonProperty("batteryPower")
    public void setBatteryPower(Boolean batteryPower) {
        this.batteryPower = batteryPower;
    }

    @JsonProperty("fuelLevel")
    public Integer getFuelLevel() {
        return fuelLevel;
    }

    @JsonProperty("fuelLevel")
    public void setFuelLevel(Integer fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    @JsonProperty("batteryLevel")
    public Integer getBatteryLevel() {
        return batteryLevel;
    }

    @JsonProperty("batteryLevel")
    public void setBatteryLevel(Integer batteryLevel) {
        this.batteryLevel = batteryLevel;
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