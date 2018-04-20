package com.logos.rest.premium;

public class PremiumBeans {
	
	public static PremiumResponse positiveResponse(){
		PremiumResponse p = new PremiumResponse();
		p.setMessage("L'utilisateur est désormais premium");
		p.setOk(true);
		return p;
	}
	
	public static PremiumResponse nagativeResponse(){
		PremiumResponse p = new PremiumResponse();
		p.setMessage("ECHEC, l'utlisateur n'est pas premuim");
		p.setOk(false);
		return p;
	}
	
	public static class PremiumRequest {
		private int id;
		private String cle;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getCle() {
			return cle;
		}
		public void setCle(String cle) {
			this.cle = cle;
		}
		
		
		
		
	}
	
	public static class PremiumResponse {
		private boolean ok;
		private String message;
		
		
		
		public boolean isOk() {
			return ok;
		}
		public void setOk(boolean ok) {
			this.ok = ok;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		
		
		
	}

}
