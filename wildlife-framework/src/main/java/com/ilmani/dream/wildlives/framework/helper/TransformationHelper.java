package com.ilmani.dream.wildlives.framework.helper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TransformationHelper {

	private static final String REGEX_FOR_CLEAN_CHARACTERE = "[^a-zA-Z, _]";

	public static String cleanAllSpecialsCharacters(String text) {
		String result;
		result = text.replaceAll("[ , ']", "_");
		result = result.replaceAll(REGEX_FOR_CLEAN_CHARACTERE, "");
		return result;
	}

	public static String checksumStringWithSHA1(String text) throws NoSuchAlgorithmException {

		MessageDigest algorithmSha1 = MessageDigest.getInstance("SHA1");

		byte[] textBytes = algorithmSha1.digest(text.getBytes());

		StringBuffer result = new StringBuffer();
		for (int i = 0; i < textBytes.length; i++) {
			result.append(Integer.toString((textBytes[i] & 0xff) + 0x100, 16).substring(1));
		}
		return result.toString();
	}

}
