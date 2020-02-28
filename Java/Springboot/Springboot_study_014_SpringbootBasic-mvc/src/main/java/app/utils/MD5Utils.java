package app.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.tomcat.util.buf.HexUtils;

public class MD5Utils {
	private static final String SALT = "steven";
	private static final String ALGORIHT_NAME = "MD5";
	
	public static String encrypt(String username, String password) throws NoSuchAlgorithmException {
		return HexUtils.toHexString(MessageDigest.getInstance(ALGORIHT_NAME).digest((username+password+SALT).getBytes()));
	}
	
/*	public static void main(String[] args) throws NoSuchAlgorithmException {
		String username = "Admin";
		String password = "admin";
		
		System.out.println(encrypt(username, password));
	}*/
}
