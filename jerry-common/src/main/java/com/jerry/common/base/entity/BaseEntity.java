package com.jerry.common.base.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * 实体类的抽象基类
 * @author jerry
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable, IEntity {
    @Id
    @Column(name = "ID")
    @Size(max = 40)
    protected String id;

    @Column(name = "DR")
    protected Integer dr = 0;

    @Column(name = "TS")
    protected Date ts;

    @Column(name = "CREATOR")
    @Size(max = 40)
    protected String creator;

    @Column(name = "CREATION_TIME")
    protected Date creationTime;

    @Column(name = "MODIFIER")
    @Size(max = 40)
    protected String modifier;

    @Column(name = "MODIFIED_TIME")
    protected Date modifiedTime;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public Integer getDr() {
        return dr;
    }

    @Override
    public void setDr(Integer dr) {
        this.dr = dr;
    }

    @Override
    public Date getTs() {
        return ts;
    }

    @Override
    public void setTs(Date ts) {
        this.ts = ts;
    }

    @Override
    public String getCreator() {
        return creator;
    }

    @Override
    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Override
    public Date getCreationTime() {
        return creationTime;
    }

    @Override
    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    @Override
    public String getModifier() {
        return modifier;
    }

    @Override
    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    @Override
    public Date getModifiedTime() {
        return modifiedTime;
    }

    @Override
    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

}
