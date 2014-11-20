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

import org.hibernate.validator.constraints.NotEmpty;

import ru.nvd.andr.calcmvc.validation.CalcArgument;

@Entity
@Table(name = "TABLE_CALC_OPERATIONS", uniqueConstraints = {@UniqueConstraint(columnNames = "OBJID")})
public class TableCalcOperations {

    @Id
    @Column(name = "OBJID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "calc_oper_seq")
    @SequenceGenerator(name = "calc_oper_seq", sequenceName = "calc_oper_seq")
    protected long objid;

    @Column(name = "FIRSTARG", unique = false, nullable = false, length = 255)
    @CalcArgument
    @NotEmpty(message = "firstarg can not be empty")
    protected String firstarg;

    @Column(name = "SECONDARG", unique = false, nullable = false, length = 255)
    @CalcArgument
    @NotEmpty(message = "secondarg can not be empty")
    protected String secondarg;

    @Column(name = "OPERATION", unique = false, nullable = false, length = 255)
    protected String operation;

    @Column(name = "RESULT", unique = false, nullable = false, length = 255)
    protected String result;

    @Column(name = "CREATE_DATE")
    protected Date createDate;

    @Column(name = "USER_NAME", unique = false, nullable = false, length = 255)
    protected String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

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

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

}
