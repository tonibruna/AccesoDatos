//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2018.12.02 a las 12:20:04 PM CET 
//


package JAXB_Clases_ListaRepr;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cancion" maxOccurs="unbounded"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *                   &lt;element name="anyo" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *                   &lt;element name="titulo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="artista" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="cancion_espana" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "cancion"
})
@XmlRootElement(name = "Listareproduccion")
public class Listareproduccion {

    @XmlElement(required = true)
    protected List<Listareproduccion.Cancion> cancion;

    /**
     * Gets the value of the cancion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cancion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCancion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Listareproduccion.Cancion }
     * 
     * 
     */
    public List<Listareproduccion.Cancion> getCancion() {
        if (cancion == null) {
            cancion = new ArrayList<Listareproduccion.Cancion>();
        }
        return this.cancion;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
     *         &lt;element name="anyo" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
     *         &lt;element name="titulo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="artista" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="cancion_espana" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "id",
        "anyo",
        "titulo",
        "artista",
        "cancionEspana"
    })
    public static class Cancion {

        @XmlElement(required = true)
        protected BigInteger id;
        @XmlElement(required = true)
        protected BigInteger anyo;
        @XmlElement(required = true)
        protected String titulo;
        @XmlElement(required = true)
        protected String artista;
        @XmlElement(name = "cancion_espana")
        protected boolean cancionEspana;

        /**
         * Obtiene el valor de la propiedad id.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getId() {
            return id;
        }

        /**
         * Define el valor de la propiedad id.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setId(BigInteger value) {
            this.id = value;
        }

        /**
         * Obtiene el valor de la propiedad anyo.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getAnyo() {
            return anyo;
        }

        /**
         * Define el valor de la propiedad anyo.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setAnyo(BigInteger value) {
            this.anyo = value;
        }

        /**
         * Obtiene el valor de la propiedad titulo.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTitulo() {
            return titulo;
        }

        /**
         * Define el valor de la propiedad titulo.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTitulo(String value) {
            this.titulo = value;
        }

        /**
         * Obtiene el valor de la propiedad artista.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getArtista() {
            return artista;
        }

        /**
         * Define el valor de la propiedad artista.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setArtista(String value) {
            this.artista = value;
        }

        /**
         * Obtiene el valor de la propiedad cancionEspana.
         * 
         */
        public boolean isCancionEspana() {
            return cancionEspana;
        }

        /**
         * Define el valor de la propiedad cancionEspana.
         * 
         */
        public void setCancionEspana(boolean value) {
            this.cancionEspana = value;
        }

    }

}
