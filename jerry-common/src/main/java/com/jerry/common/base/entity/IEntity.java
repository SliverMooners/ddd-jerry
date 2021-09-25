package com.jerry.common.base.entity;

import java.util.Date;


/**
 * @author jerry
 */
public interface IEntity {
	String getId();

	void setId(String id);

	Integer getDr();

	void setDr(Integer dr);

	Date getTs();

	void setTs(Date ts);

	String getCreator();

	void setCreator(String creator);

	Date getCreationTime();

	void setCreationTime(Date creationTime);

	String getModifier();

	void setModifier(String modifier);

	Date getModifiedTime();

	void setModifiedTime(Date modifiedTime);

}
