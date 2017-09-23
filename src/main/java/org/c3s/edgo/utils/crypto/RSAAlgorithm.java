/**
 * 
 */
package org.c3s.edgo.utils.crypto;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * @author admin
 *
 */
public class RSAAlgorithm implements CryptoAlgorithm {

	private Key key;
	
	Cipher ecipher = null;
	Cipher dcipher = null;
	
	public RSAAlgorithm() {
		
	}
	
	public RSAAlgorithm(Key key) {
		this.key = key;
	}
	
	protected void setKey(Key key) {
		this.key = key;
	}
	
	/* (non-Javadoc)
	 * @see org.c3s.edgo.utils.crypto.CryptoAlgorithm#encode(java.lang.String)
	 */
	@Override
	public String encode(String source) {
		
		if (ecipher == null) {
			try {
				ecipher = Cipher.getInstance( "RSA" );
				ecipher.init(Cipher.ENCRYPT_MODE, key);
			} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e) {
				throw new RuntimeException(e);
			}
		}
		
		byte[] cipherbytes;
		
		try {
			byte[] bytesToEncrypt = source.getBytes("UTF-8");
			int outputSize = ecipher.getOutputSize(bytesToEncrypt.length);
			int inLength = outputSize - 11;
			
			int resultLength = bytesToEncrypt.length / inLength + (bytesToEncrypt.length % inLength > 0 ? 1 : 0);
			cipherbytes = new byte[resultLength * outputSize];
			
			int start = 0;
			int copyIdx = 0;
			//logger.log("Bytes length: " + bytesToEncrypt.Length);
			int length = (bytesToEncrypt.length - start) > inLength ? inLength : bytesToEncrypt.length - start;
			while (start < bytesToEncrypt.length)
			{
				//byte[] encBuffer = new byte[length];
				byte[] buffer = ecipher.doFinal(bytesToEncrypt, start, length);
				System.arraycopy(buffer, 0, cipherbytes, copyIdx, buffer.length);
				start += inLength;
				copyIdx += buffer.length;
				length = (bytesToEncrypt.length - start) > inLength ? inLength : bytesToEncrypt.length - start;
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return Base64.getEncoder().encodeToString(cipherbytes);
	}

	/* (non-Javadoc)
	 * @see org.c3s.edgo.utils.crypto.CryptoAlgorithm#decode(java.lang.String)
	 */
	@Override
	public String decode(String source) {
		
		if (dcipher == null) {
			try {
				dcipher = Cipher.getInstance( "RSA" );
				dcipher.init(Cipher.DECRYPT_MODE, key);
			} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e) {
				throw new RuntimeException(e);
			}
		}
		
		byte[] dataDecoded = Base64.getDecoder().decode(source);
		
		int chunkSize = dcipher.getOutputSize(dataDecoded.length);
		int idx = 0;
		ByteBuffer buf = ByteBuffer.allocate(dataDecoded.length);
		
		while(idx < dataDecoded.length) {
		    int len = Math.min(dataDecoded.length-idx, chunkSize);
		    byte[] buffer = Arrays.copyOfRange(dataDecoded, idx, idx + chunkSize);
		    byte[] chunk;
			try {
				chunk = dcipher.doFinal(buffer);
			} catch (IllegalBlockSizeException | BadPaddingException e) {
				throw new RuntimeException(e);
			}
		    buf.put(chunk);
		    idx += len;
		}				
		
		byte[] result = buf.array(); 

		String resultStr;
		try {
			resultStr = new String(result, "UTF-8").trim();
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		} 
		
		return resultStr;
	}

}
