//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.12.17 at 08:37:44 PM MSK 
//


package ru.nvd.andr.calcmvc.integration.producer.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="firstArg" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="secondArg" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="operation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "firstArg",
    "secondArg",
    "operation"
})
@XmlRootElement(name = "executeOperRequest")
public class ExecuteOperRequest {

    @XmlElement(required = true)
    protected String firstArg;
    @XmlElement(required = true)
    protected String secondArg;
    @XmlElement(required = true)
    protected String operation;

    /**
     * Gets the value of the firstArg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstArg() {
        return firstArg;
    }

    /**
     * Sets the value of the firstArg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstArg(String value) {
        this.firstArg = value;
    }

    /**
     * Gets the value of the secondArg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecondArg() {
        return secondArg;
    }

    /**
     * Sets the value of the secondArg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecondArg(String value) {
        this.secondArg = value;
    }

    /**
     * Gets the value of the operation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperation() {
        return operation;
    }

    /**
     * Sets the value of the operation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperation(String value) {
        this.operation = value;
    }

}
