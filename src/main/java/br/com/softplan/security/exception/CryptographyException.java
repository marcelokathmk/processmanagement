package br.com.softplan.security.exception;

public class CryptographyException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public CryptographyException(String mensagem) {
		super(mensagem);
	}
	
	public CryptographyException(String mensagem, Throwable throwable) {
		super(mensagem, throwable);
	}
}
