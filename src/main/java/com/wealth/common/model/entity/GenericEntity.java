package com.wealth.common.model.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class GenericEntity implements Serializable , Cloneable {

private char recordState;
private String tenantId;
private Timestamp crtdDt;
private String crtdIp;
private int crtdBy;
private Timestamp updtDt;
private String updtIp;
private int updtBy;



public String getTenantId() {
	return tenantId;
}
public void setTenantId(String tenantId) {
	this.tenantId = tenantId;
}
public Timestamp getCrtdDt() {
	return crtdDt;
}
public void setCrtdDt(Timestamp crtdDt) {
	this.crtdDt = crtdDt;
}
public String getCrtdIp() {
	return crtdIp;
}
public void setCrtdIp(String crtdIp) {
	this.crtdIp = crtdIp;
}
public int getCrtdBy() {
	return crtdBy;
}
public void setCrtdBy(int crtdBy) {
	this.crtdBy = crtdBy;
}
public Timestamp getUpdtDt() {
	return updtDt;
}
public void setUpdtDt(Timestamp updtDt) {
	this.updtDt = updtDt;
}
public String getUpdtIp() {
	return updtIp;
}
public void setUpdtIp(String updtIp) {
	this.updtIp = updtIp;
}
public int getUpdtBy() {
	return updtBy;
}
public void setUpdtBy(int updtBy) {
	this.updtBy = updtBy;
}


public abstract String tableName();
public abstract String primaryKey();
@Override
public GenericEntity clone() {
    try {
        return (GenericEntity) super.clone();
    } catch (CloneNotSupportedException e) {
        throw new RuntimeException("Clone not supported", e);
    }
}

public String toJsonString() {
    try {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this.clone());
    } catch (JsonProcessingException e) {
        throw new RuntimeException("Error converting to JSON", e);
    }
}
public char getRecordState() {
	return recordState;
}
public void setRecordState(char recordState) {
	this.recordState = recordState;
}

}
