package P04_FicherosBytes;

	public class MovimientoBancario {
		
		String fecha;
		String concepto;
		int cantidad;
		boolean tipo;
		
		
		public MovimientoBancario(String fe, String co, int ca, boolean ti) {
			
			 fecha=fe;
			 
			 concepto=co;
			 
			 cantidad=ca;
			 
			 tipo=ti;
		}
		
		//getters
		
		public String getFecha() {
			return fecha;
			 
		}
		
		public String getConcepto() {
			return concepto;
		
		}
		
		public int getCantidad() {
			return cantidad;
			
		}
		
		public boolean getTipo() {
			return tipo;
			
		}
		
		//setters
		
		public void setFecha (String fe) {
		
				fecha=fe;
	    }

		public void setConcepto (String co) {
				 
				concepto=co;
		}
		
		public void setCantidad (int ca) {
			
				cantidad=ca;
		}
		
		public void setTipo (boolean ti) {
			
				tipo=ti;
		}
		
}
