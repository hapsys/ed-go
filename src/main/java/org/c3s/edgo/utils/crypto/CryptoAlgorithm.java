package org.c3s.edgo.utils.crypto;

public interface CryptoAlgorithm {

	public String encode(String source);
	public String decode(String source);
	
}
