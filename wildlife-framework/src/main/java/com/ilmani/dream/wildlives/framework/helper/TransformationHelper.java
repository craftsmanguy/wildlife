package com.ilmani.dream.wildlives.framework.helper;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import com.ilmani.dream.wildlives.framework.enums.GenderEnum;

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

	public static String getRandomString(int randomLength) {
		byte[] array = new byte[randomLength];
		new Random().nextBytes(array);
		return new String(array, Charset.forName("UTF-8"));
	}

	public static boolean isGenderEnumContainsValue(String value) {
		for (GenderEnum vertebrateType : GenderEnum.values()) {
			if (vertebrateType.name().equals(value)) {
				return true;
			}
		}
		return false;
	}

}
