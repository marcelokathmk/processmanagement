package br.com.softplan.domain.enums;

public enum UserType {

	ADMINITRADOR(1, "Administrador"),
	TRIADOR(2, "Triador"),
	FINALIZADOR(3, "Finalizador");
	
	private int idType;
	
	private String descriptionType;
	
	private UserType(int idType, String descriptionType) {
		this.idType = idType;
		this.descriptionType = descriptionType;
	}
	
	public int getIdType() {
		return this.idType;
	}
	
	public String getDescriptionType() {
		return this.descriptionType;
	}
	
	public static UserType toEnum(Integer idType) {
		if	(idType == null) {
			return null;
		}
		
		for	(UserType ut: UserType.values()) {
			if	(idType.equals(ut.getIdType())) {
				return ut;
			}
		}
		
		throw new IllegalArgumentException("Invalid id: "+ idType);
	}
}
