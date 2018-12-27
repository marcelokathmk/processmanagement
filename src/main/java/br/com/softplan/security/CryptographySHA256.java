package br.com.softplan.security;

import java.security.MessageDigest;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.softplan.security.exception.CryptographyException;

@Service
public class CryptographySHA256 implements PasswordEncoder{

	@Override
	public String encode(CharSequence rawPassword) {
		try {
			MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
			byte messageDigest[] = algorithm.digest(rawPassword.toString().getBytes("UTF-8"));
			StringBuilder hexString = new StringBuilder();
			for (byte b : messageDigest) {
				hexString.append(String.format("%02X", 0xFF & b));
			}
			String passwordCryp = hexString.toString();
			return passwordCryp;
		} catch (Exception e) {
			throw new CryptographyException("Encryption Error.", e);
		}
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		if	(rawPassword != null && encodedPassword != null) {
			if	(this.encode(rawPassword).equals(encodedPassword)) {
				return true;
			}
			
//			if	(rawPassword.equals(encodedPassword)) {
//				return true;
//			}
		}
		return false;
	}

}
