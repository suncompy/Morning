package com.pussinboots.morning.os.common.util;

import org.apache.shiro.crypto.hash.Md5Hash;

import com.pussinboots.morning.common.util.RandomUtils;

/**
 * 
* 项目名称：morning-cms-biz   
* 类名称：PasswordUtils   
* 类描述：工具类：提供一些密码加密的方法   
* 创建人：陈星星   
* 创建时间：2017年2月5日 下午9:09:37
 */
public class PasswordUtils {
	
	/** 迭代次数 */
	private static final int ITERATIONS = 6;
	/** 盐值数位 */
	private static final int SALT_NUMBER = 6;
	
	private PasswordUtils() { }
	
	/**
	 * 字符串加密函数MD5实现
	 * @param password 密码
	 * @param userNumber 用户编号
	 * @param salt 盐值
	 * @return
	 */
	public static String getMd5(String password, Long userNumber, String salt) {
		return new Md5Hash(password, getCredentialsSalt(userNumber, salt), ITERATIONS).toString();
	}

	/** 证书凭证 */
	public static String getCredentialsSalt(Long userNumber, String salt) {
		return userNumber + salt;
	}
	
	/** 获得密码盐值 */
	public static String getSalt() {
		return RandomUtils.getString(SALT_NUMBER);
	}
	
}
