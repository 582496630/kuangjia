package aop;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;

public class LoggerAfterReturning implements AfterReturningAdvice {

	private static final Logger log = Logger.getLogger(LoggerAfterReturning.class);
	
	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		// TODO Auto-generated method stub

		log.info("调用"+arg3+"的"+arg1.getName()+"方法，方法的返回值"+arg0);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
