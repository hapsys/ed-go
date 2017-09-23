/**
 * 
 */
package org.c3s.edgo.utils.crypto;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

/**
 * @author admin
 *
 */
public class RSAAlgorithmPrivateKey extends RSAAlgorithm {

	public RSAAlgorithmPrivateKey(String key) {

		KeyFactory keyFactory;
		try {
			keyFactory = KeyFactory.getInstance("RSA");
			PKCS8EncodedKeySpec privSpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(key));
			PrivateKey privateKey = (PrivateKey) keyFactory.generatePrivate(privSpec);
			this.setKey(privateKey);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			throw new RuntimeException(e);
		}
		
	}
}
