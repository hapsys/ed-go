/**
 * 
 */
package org.c3s.edgo.utils.crypto;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author admin
 *
 */
public class DESAlgorithm implements CryptoAlgorithm {

	public final static String ALGORYTHM = "DES";
	public final static String CIPHER_ALGORYTHM = "DES/ECB/NoPadding";
	
	private SecretKey key = null;
	
	Cipher ecipher = null;
	Cipher dcipher = null;
	/**
	 * 
	 */
	public DESAlgorithm(String key) {
		byte[] decodedKey = Base64.getDecoder().decode(key); 
		this.key = new SecretKeySpec(decodedKey, 0, decodedKey.length, ALGORYTHM);
	}

	/* (non-Javadoc)
	 * @see org.c3s.edgo.utils.crypto.CryptoAlgorithm#encode(java.lang.String)
	 */
	@Override
	public String encode(String source) {
		
		if (ecipher == null) {
			try {
				ecipher = Cipher.getInstance(CIPHER_ALGORYTHM);
				ecipher.init(Cipher.ENCRYPT_MODE, key);
			} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e) {
				throw new RuntimeException(e);
			}
		}
		
		byte[] enc;
		
		try {
			byte[] utf8 = source.getBytes("UTF8");
		    enc = ecipher.doFinal(utf8);		
		} catch (UnsupportedEncodingException | IllegalBlockSizeException | BadPaddingException e) {
			throw new RuntimeException(e);
		}
		
		String result = Base64.getEncoder().encodeToString(enc);
		
		return result;
	}

	/* (non-Javadoc)
	 * @see org.c3s.edgo.utils.crypto.CryptoAlgorithm#decode(java.lang.String)
	 */
	@Override
	public String decode(String source) {
		
		if (dcipher == null) {
			try {
				dcipher = Cipher.getInstance(CIPHER_ALGORYTHM);
				dcipher.init(Cipher.DECRYPT_MODE, key);
			} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e) {
				throw new RuntimeException(e);
			}
		}
		
		String result;
		
		byte[] dec = Base64.getDecoder().decode(source);
		try {
			byte[] utf8 = dcipher.doFinal(dec);
			result = new String(utf8, "UTF-8");
			//System.out.println(result);
		} catch (IllegalBlockSizeException | BadPaddingException | UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}		
		
		return result;
	}

	public static String generateKey() {
		
		SecretKey secretKey;
		try {
			secretKey = KeyGenerator.getInstance(ALGORYTHM).generateKey();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		return Base64.getEncoder().encodeToString(secretKey.getEncoded());
		
	}
}
