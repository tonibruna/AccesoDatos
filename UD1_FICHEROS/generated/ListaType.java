//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2018.12.01 a las 07:18:51 PM CET 
//


package generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ListaType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ListaType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cancion" type="{}DatosCanc"/&gt;
 *         &lt;element name="lista" type="{}ListaReproduccion"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListaType", propOrder = {
    "cancion",
    "lista"
})
public class ListaType {

    @XmlElement(required = true)
    protected DatosCanc cancion;
    @XmlElement(required = true)
    protected ListaReproduccion lista;

    /**
     * Obtiene el valor de la propiedad cancion.
     * 
     * @return
     *     possible object is
     *     {@link DatosCanc }
     *     
     */
    public DatosCanc getCancion() {
        return cancion;
    }

    /**
     * Define el valor de la propiedad cancion.
     * 
     * @param value
     *     allowed object is
     *     {@link DatosCanc }
     *     
     */
    public void setCancion(DatosCanc value) {
        this.cancion = value;
    }

    /**
     * Obtiene el valor de la propiedad lista.
     * 
     * @return
     *     possible object is
     *     {@link ListaReproduccion }
     *     
     */
    public ListaReproduccion getLista() {
        return lista;
    }

    /**
     * Define el valor de la propiedad lista.
     * 
     * @param value
     *     allowed object is
     *     {@link ListaReproduccion }
     *     
     */
    public void setLista(ListaReproduccion value) {
        this.lista = value;
    }

}
