//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5.1 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.06.04 at 09:52:23 PM CEST 
//


package model.akt;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the rs.ac.uns.ftn.xml package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _TackaAlineja_QNAME = new QName("http://www.ftn.uns.ac.rs/XML", "Alineja");
    private final static QName _TackaSadrzaj_QNAME = new QName("http://www.ftn.uns.ac.rs/XML", "Sadrzaj");
    private final static QName _ClanStav_QNAME = new QName("http://www.ftn.uns.ac.rs/XML", "Stav");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: rs.ac.uns.ftn.xml
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Clan }
     * 
     */
    public Clan createClan() {
        return new Clan();
    }

    /**
     * Create an instance of {@link Odredba }
     * 
     */
    public Odredba createOdredba() {
        return new Odredba();
    }

    /**
     * Create an instance of {@link Tacka }
     * 
     */
    public Tacka createTacka() {
        return new Tacka();
    }

    /**
     * Create an instance of {@link Akt }
     * 
     */
    public Akt createAkt() {
        return new Akt();
    }

    /**
     * Create an instance of {@link Clan.Stav }
     * 
     */
    public Clan.Stav createClanStav() {
        return new Clan.Stav();
    }

    /**
     * Create an instance of {@link Glava }
     * 
     */
    public Glava createGlava() {
        return new Glava();
    }

    /**
     * Create an instance of {@link Odredba.Predmet }
     * 
     */
    public Odredba.Predmet createOdredbaPredmet() {
        return new Odredba.Predmet();
    }

    /**
     * Create an instance of {@link Odredba.ObimPrimene }
     * 
     */
    public Odredba.ObimPrimene createOdredbaObimPrimene() {
        return new Odredba.ObimPrimene();
    }

    /**
     * Create an instance of {@link Tacka.Alineja }
     * 
     */
    public Tacka.Alineja createTackaAlineja() {
        return new Tacka.Alineja();
    }

    /**
     * Create an instance of {@link Akt.UvodniDeo }
     * 
     */
    public Akt.UvodniDeo createAktUvodniDeo() {
        return new Akt.UvodniDeo();
    }

    /**
     * Create an instance of {@link Akt.GlavniDeo }
     * 
     */
    public Akt.GlavniDeo createAktGlavniDeo() {
        return new Akt.GlavniDeo();
    }

    /**
     * Create an instance of {@link Akt.ZavrsniDeo }
     * 
     */
    public Akt.ZavrsniDeo createAktZavrsniDeo() {
        return new Akt.ZavrsniDeo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Tacka.Alineja }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/XML", name = "Alineja", scope = Tacka.class)
    public JAXBElement<Tacka.Alineja> createTackaAlineja(Tacka.Alineja value) {
        return new JAXBElement<Tacka.Alineja>(_TackaAlineja_QNAME, Tacka.Alineja.class, Tacka.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/XML", name = "Sadrzaj", scope = Tacka.class)
    public JAXBElement<String> createTackaSadrzaj(String value) {
        return new JAXBElement<String>(_TackaSadrzaj_QNAME, String.class, Tacka.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Clan.Stav }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/XML", name = "Stav", scope = Clan.class)
    public JAXBElement<Clan.Stav> createClanStav(Clan.Stav value) {
        return new JAXBElement<Clan.Stav>(_ClanStav_QNAME, Clan.Stav.class, Clan.class, value);
    }

}
