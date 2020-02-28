package app.utils;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class MD5Utils {
	private static final String SALT = "steven";
	
	private static final String ALGORIHT_NAME = "md5";
	
	private static final int HASH_ITERATIONS = 2;
	
	public static String encrypt(String password) {
		String newPassword = new SimpleHash(ALGORIHT_NAME, password, ByteSource.Util.bytes(SALT), HASH_ITERATIONS).toHex();
		return newPassword;
	}
	
	public static String encrypt(String username, String password) {
		String newPassword = new SimpleHash(ALGORIHT_NAME, password, ByteSource.Util.bytes(username + SALT), HASH_ITERATIONS).toHex();
		return newPassword;
	}
	
	public static void main(String[] args) {
		String username = "Admin";
		String password = "admin";
		System.out.println(MD5Utils.encrypt(username, password));
		
		String key = "What The Hell";
		byte[] keyByte = key.getBytes(StandardCharsets.UTF_8);
		for (byte b : keyByte) {
			System.out.print(b + " ");
		}
		System.out.println();
		System.out.println(Base64.encodeToString(keyByte));
		System.out.println(keyByte.length);
		System.out.println(Base64.encodeToString(keyByte).length());
		System.out.println(Base64.encodeToString(Arrays.copyOf(keyByte, 16)));
		System.out.println(Base64.encodeToString(Arrays.copyOf(keyByte, 16)).length());
		for (byte b : Base64.decode("V2hhdCBUaGUgSGVsbAAAAA==")) {
			System.out.print(b + " ");
		}
	}
}
