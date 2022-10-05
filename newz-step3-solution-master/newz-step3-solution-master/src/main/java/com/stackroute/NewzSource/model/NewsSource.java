package com.stackroute.NewzSource.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;

@Document
public class NewsSource  {
	@Id
	 private String newssourceId;
	 private String newssourceName;    
	 private String newssourceDesc;            
	 private String newssourceCreatedBy;
     
	public NewsSource(String newssourceId, String newssourceName, String newssourceDesc, String newssourceCreatedBy) {
		this.newssourceId = newssourceId;
		this.newssourceName = newssourceName;
		this.newssourceDesc = newssourceDesc;
		this.newssourceCreatedBy = newssourceCreatedBy;
	}
	public NewsSource() {
		super();
	}
	public String getNewssourceId() {
		return newssourceId;
	}
	public String getNewssourceName() {
		return newssourceName;
	}
	public void setNewssourceName(String newssourceName) {
		this.newssourceName = newssourceName;
	}
	public String getNewssourceDesc() {
		return newssourceDesc;
	}
	public void setNewssourceDesc(String newssourceDesc) {
		this.newssourceDesc = newssourceDesc;
	}
	public String getNewssourceCreatedBy() {
		return newssourceCreatedBy;
	}
	public void setNewssourceCreatedBy(String newssourceCreatedBy) {
		this.newssourceCreatedBy = newssourceCreatedBy;
	}
	@Override
	public String toString() {
		return "News [newssourceId=" + newssourceId + ", newssourceName=" + newssourceName + ", newssourceDesc="
				+ newssourceDesc + ", newssourceCreatedBy=" + newssourceCreatedBy + "]";
	}
     
     

}
