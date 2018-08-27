package cn.lyz.hotle.login.service;

/**
 * 应用异常
 * @author soft01
 *
 */
public class AppException extends RuntimeException {


	private static final long serialVersionUID = 4125091850145341067L;

	public AppException() {
		
	}

	public AppException(String message) {
		super(message);
		
	}
	
}
