package ru.nvd.andr.calcmvc.domain;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="TABLE_CALC_OPERATIONS" ,uniqueConstraints = {
        @UniqueConstraint(columnNames = "OBJID")})
public class TableCalcOperations implements Serializable {

    private static final long serialVersionUID = 8660861638523120444L;
    @Id
    @Column(name="OBJID",  unique = true, nullable = false)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="calc_oper_seq")
    @SequenceGenerator(name="calc_oper_seq", sequenceName="calc_oper_seq"  )
    protected long objid;
    

    @Column(name="RESULT",unique = false, nullable = false, length = 255)
    protected String result;

    @Column(name="CREATE_DATE")
    protected Date createDate;

    public long getObjid() {
        return objid;
    }

    public void setObjid(long objid) {
        this.objid = objid;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    
}
