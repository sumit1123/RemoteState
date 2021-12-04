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
        "truckId",
        "stopStartTime",
        "truckRunningState",
        "lat",
        "lng",
        "stopNotficationSent"
})
public class LastRunningState {

    @JsonProperty("truckId")
    private Integer truckId;
    @JsonProperty("stopStartTime")
    private Long stopStartTime;
    @JsonProperty("truckRunningState")
    private Integer truckRunningState;
    @JsonProperty("lat")
    private Double lat;
    @JsonProperty("lng")
    private Double lng;
    @JsonProperty("stopNotficationSent")
    private Integer stopNotficationSent;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("truckId")
    public Integer getTruckId() {
        return truckId;
    }

    @JsonProperty("truckId")
    public void setTruckId(Integer truckId) {
        this.truckId = truckId;
    }

    @JsonProperty("stopStartTime")
    public Long getStopStartTime() {
        return stopStartTime;
    }

    @JsonProperty("stopStartTime")
    public void setStopStartTime(Long stopStartTime) {
        this.stopStartTime = stopStartTime;
    }

    @JsonProperty("truckRunningState")
    public Integer getTruckRunningState() {
        return truckRunningState;
    }

    @JsonProperty("truckRunningState")
    public void setTruckRunningState(Integer truckRunningState) {
        this.truckRunningState = truckRunningState;
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

    @JsonProperty("stopNotficationSent")
    public Integer getStopNotficationSent() {
        return stopNotficationSent;
    }

    @JsonProperty("stopNotficationSent")
    public void setStopNotficationSent(Integer stopNotficationSent) {
        this.stopNotficationSent = stopNotficationSent;
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