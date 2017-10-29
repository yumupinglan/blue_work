/***********************************************************
 * 
 * @Copyright: 2017 One Year Studio All rights reserved. 
 *
 ***********************************************************/
package com.oneyear.bluework.util;

import java.security.SecureRandom;

/**
 * 
 * @ClassName RandomUniqueIdGenerator
 * @Description: TODO
 * @author wei
 * @Date: 2017年7月26日
 */
public class RandomUniqueIdGenerator {
	/** The array of printable characters to be used in our random string. */
    private static final char[] PRINTABLE_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ012345679"
        .toCharArray();

    /** The default maximum length. */
    private static final int DEFAULT_MAX_RANDOM_LENGTH = 32;

    /** An instance of secure random to ensure randomness is secure. */
    private static SecureRandom randomizer = new SecureRandom();

    public static String getNewString() {
        final byte[] random = getNewStringAsBytes();

        return convertBytesToString(random);
    }
    
    public static String getNewString(int length) {
        final byte[] random = getNewStringAsBytes(length);

        return convertBytesToString(random);
    }

    private static byte[] getNewStringAsBytes() {
    	return getNewStringAsBytes(DEFAULT_MAX_RANDOM_LENGTH);
    }

    private static byte[] getNewStringAsBytes(int maximumRandomLength) {
        final byte[] random = new byte[maximumRandomLength];

        randomizer.nextBytes(random);
        
        return random;
    }

    private static String convertBytesToString(final byte[] random) {
        final char[] output = new char[random.length];
        for (int i = 0; i < random.length; i++) {
            final int index = Math.abs(random[i] % PRINTABLE_CHARACTERS.length);
            output[i] = PRINTABLE_CHARACTERS[index];
        }

        return new String(output);
    }
}
