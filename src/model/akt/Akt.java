//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5.1 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.06.04 at 09:52:23 PM CEST 
//


package model.akt;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *         &lt;element name="Preambula" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UvodniDeo">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://www.ftn.uns.ac.rs/XML}Glava" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="GlavniDeo">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://www.ftn.uns.ac.rs/XML}Glava"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ZavrsniDeo">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://www.ftn.uns.ac.rs/XML}Glava"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="PrilogAkta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Naziv" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "preambula",
    "uvodniDeo",
    "glavniDeo",
    "zavrsniDeo",
    "prilogAkta"
})
@XmlRootElement(name = "Akt")
public class Akt {

    @XmlElement(name = "Preambula")
    protected String preambula;
    @XmlElement(name = "UvodniDeo", required = true)
    protected Akt.UvodniDeo uvodniDeo;
    @XmlElement(name = "GlavniDeo", required = true)
    protected Akt.GlavniDeo glavniDeo;
    @XmlElement(name = "ZavrsniDeo", required = true)
    protected Akt.ZavrsniDeo zavrsniDeo;
    @XmlElement(name = "PrilogAkta")
    protected String prilogAkta;
    @XmlAttribute(name = "Naziv", required = true)
    protected String naziv;

    /**
     * Gets the value of the preambula property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreambula() {
        return preambula;
    }

    /**
     * Sets the value of the preambula property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreambula(String value) {
        this.preambula = value;
    }

    /**
     * Gets the value of the uvodniDeo property.
     * 
     * @return
     *     possible object is
     *     {@link Akt.UvodniDeo }
     *     
     */
    public Akt.UvodniDeo getUvodniDeo() {
        return uvodniDeo;
    }

    /**
     * Sets the value of the uvodniDeo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Akt.UvodniDeo }
     *     
     */
    public void setUvodniDeo(Akt.UvodniDeo value) {
        this.uvodniDeo = value;
    }

    /**
     * Gets the value of the glavniDeo property.
     * 
     * @return
     *     possible object is
     *     {@link Akt.GlavniDeo }
     *     
     */
    public Akt.GlavniDeo getGlavniDeo() {
        return glavniDeo;
    }

    /**
     * Sets the value of the glavniDeo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Akt.GlavniDeo }
     *     
     */
    public void setGlavniDeo(Akt.GlavniDeo value) {
        this.glavniDeo = value;
    }

    /**
     * Gets the value of the zavrsniDeo property.
     * 
     * @return
     *     possible object is
     *     {@link Akt.ZavrsniDeo }
     *     
     */
    public Akt.ZavrsniDeo getZavrsniDeo() {
        return zavrsniDeo;
    }

    /**
     * Sets the value of the zavrsniDeo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Akt.ZavrsniDeo }
     *     
     */
    public void setZavrsniDeo(Akt.ZavrsniDeo value) {
        this.zavrsniDeo = value;
    }

    /**
     * Gets the value of the prilogAkta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrilogAkta() {
        return prilogAkta;
    }

    /**
     * Sets the value of the prilogAkta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrilogAkta(String value) {
        this.prilogAkta = value;
    }

    /**
     * Gets the value of the naziv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * Sets the value of the naziv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNaziv(String value) {
        this.naziv = value;
    }


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
     *         &lt;element ref="{http://www.ftn.uns.ac.rs/XML}Glava"/>
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
        "glava"
    })
    public static class GlavniDeo {

        @XmlElement(name = "Glava", required = true)
        protected Glava glava;

        /**
         * Gets the value of the glava property.
         * 
         * @return
         *     possible object is
         *     {@link Glava }
         *     
         */
        public Glava getGlava() {
            return glava;
        }

        /**
         * Sets the value of the glava property.
         * 
         * @param value
         *     allowed object is
         *     {@link Glava }
         *     
         */
        public void setGlava(Glava value) {
            this.glava = value;
        }

    }


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
     *         &lt;element ref="{http://www.ftn.uns.ac.rs/XML}Glava" maxOccurs="unbounded"/>
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
        "glava"
    })
    public static class UvodniDeo {

        @XmlElement(name = "Glava", required = true)
        protected List<Glava> glava;

        /**
         * Gets the value of the glava property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the glava property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getGlava().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Glava }
         * 
         * 
         */
        public List<Glava> getGlava() {
            if (glava == null) {
                glava = new ArrayList<Glava>();
            }
            return this.glava;
        }

    }


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
     *         &lt;element ref="{http://www.ftn.uns.ac.rs/XML}Glava"/>
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
        "glava"
    })
    public static class ZavrsniDeo {

        @XmlElement(name = "Glava", required = true)
        protected Glava glava;

        /**
         * Gets the value of the glava property.
         * 
         * @return
         *     possible object is
         *     {@link Glava }
         *     
         */
        public Glava getGlava() {
            return glava;
        }

        /**
         * Sets the value of the glava property.
         * 
         * @param value
         *     allowed object is
         *     {@link Glava }
         *     
         */
        public void setGlava(Glava value) {
            this.glava = value;
        }

    }

}
