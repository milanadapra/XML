//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5.1 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.06.04 at 09:52:23 PM CEST 
//


package generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;
import rs.ac.uns.ftn.xml.Clan;


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
 *         &lt;element name="Obrazlozenje" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/XML}Clan"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Datum" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="BrojClana" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="VrstaAmandmana">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *             &lt;enumeration value="insert"/>
 *             &lt;enumeration value="update"/>
 *             &lt;enumeration value="delete"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "obrazlozenje",
    "clan"
})
@XmlRootElement(name = "Amandman")
public class Amandman {

    @XmlElement(name = "Obrazlozenje", required = true)
    protected String obrazlozenje;
    @XmlElement(name = "Clan", namespace = "http://www.ftn.uns.ac.rs/XML", required = true)
    protected Clan clan;
    @XmlAttribute(name = "Datum")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datum;
    @XmlAttribute(name = "BrojClana", required = true)
    protected String brojClana;
    @XmlAttribute(name = "VrstaAmandmana")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String vrstaAmandmana;

    /**
     * Gets the value of the obrazlozenje property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObrazlozenje() {
        return obrazlozenje;
    }

    /**
     * Sets the value of the obrazlozenje property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObrazlozenje(String value) {
        this.obrazlozenje = value;
    }

    /**
     * Gets the value of the clan property.
     * 
     * @return
     *     possible object is
     *     {@link Clan }
     *     
     */
    public Clan getClan() {
        return clan;
    }

    /**
     * Sets the value of the clan property.
     * 
     * @param value
     *     allowed object is
     *     {@link Clan }
     *     
     */
    public void setClan(Clan value) {
        this.clan = value;
    }

    /**
     * Gets the value of the datum property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatum() {
        return datum;
    }

    /**
     * Sets the value of the datum property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatum(XMLGregorianCalendar value) {
        this.datum = value;
    }

    /**
     * Gets the value of the brojClana property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrojClana() {
        return brojClana;
    }

    /**
     * Sets the value of the brojClana property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrojClana(String value) {
        this.brojClana = value;
    }

    /**
     * Gets the value of the vrstaAmandmana property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVrstaAmandmana() {
        return vrstaAmandmana;
    }

    /**
     * Sets the value of the vrstaAmandmana property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVrstaAmandmana(String value) {
        this.vrstaAmandmana = value;
    }

}
