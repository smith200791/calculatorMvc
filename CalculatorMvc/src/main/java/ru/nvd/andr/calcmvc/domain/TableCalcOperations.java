package ru.nvd.andr.calcmvc.domain;


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
public class TableCalcOperations  {
   
    @Id
    @Column(name="OBJID",  unique = true, nullable = false)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="calc_oper_seq")
    @SequenceGenerator(name="calc_oper_seq", sequenceName="calc_oper_seq"  )
    protected long objid;
    
    @Column(name="FIRSTARG",unique = false, nullable = false, length = 255)
    protected String firstarg;

    @Column(name="SECONDARG",unique = false, nullable = false, length = 255)
    protected String secondarg;

    @Column(name="OPERATION",unique = false, nullable = false, length = 255)
    protected String operaion;

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

    public String getFirstarg() {
        return firstarg;
    }

    public void setFirstarg(String firstarg) {
        this.firstarg = firstarg;
    }

    public String getSecondarg() {
        return secondarg;
    }

    public void setSecondarg(String secondarg) {
        this.secondarg = secondarg;
    }

    public String getOperaion() {
        return operaion;
    }

    public void setOperaion(String operaion) {
        this.operaion = operaion;
    }   
}
