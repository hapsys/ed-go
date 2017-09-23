/**
 * 
 */
package org.c3s.edgo.utils.crypto;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

/**
 * @author admin
 *
 */
public class RSAAlgorithmPublicKey extends RSAAlgorithm {

	public RSAAlgorithmPublicKey(String key) {

		KeyFactory keyFactory;
		try {
			keyFactory = KeyFactory.getInstance("RSA");
			PKCS8EncodedKeySpec pubSpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(key));
			PublicKey publicKey = (PublicKey) keyFactory.generatePublic(pubSpec);
			this.setKey(publicKey);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			throw new RuntimeException(e);
		}
		
	}
}
