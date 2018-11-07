<?xml version="1.0" encoding='ISO-8859-1'?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
 <xsl:template match='/'>
   <html><xsl:apply-templates /></html>
 </xsl:template>
 <xsl:template match='Canciones'>
    <head><title>LISTA CANCIONES</title></head>
    <body> 
    <h1>LISTA CANCIONES</h1>
    <table border='1'>
    <tr><th>id</th><th>anyo</th><th>titulos</th>
	<th>artista</th>	<th>cancion_española</th></tr>
      <xsl:apply-templates select='Cancion' />
    </table>
    </body>
 </xsl:template>
 <xsl:template match='Cancion'>
   <tr><xsl:apply-templates /></tr>
 </xsl:template>
 <xsl:template match='id|anyo|titulos|artista|cancion_española'>
   <td><xsl:apply-templates /></td>
 </xsl:template>
</xsl:stylesheet>