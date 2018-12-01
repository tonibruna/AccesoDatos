//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2018.12.01 a las 07:18:51 PM CET 
//


package generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated package. 
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

    private final static QName _Listareproduccion_QNAME = new QName("", "Listareproduccion");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ListaType }
     * 
     */
    public ListaType createListaType() {
        return new ListaType();
    }

    /**
     * Create an instance of {@link DatosCanc }
     * 
     */
    public DatosCanc createDatosCanc() {
        return new DatosCanc();
    }

    /**
     * Create an instance of {@link ListaReproduccion }
     * 
     */
    public ListaReproduccion createListaReproduccion() {
        return new ListaReproduccion();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListaType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Listareproduccion")
    public JAXBElement<ListaType> createListareproduccion(ListaType value) {
        return new JAXBElement<ListaType>(_Listareproduccion_QNAME, ListaType.class, null, value);
    }

}
