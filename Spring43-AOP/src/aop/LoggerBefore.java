package aop;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

public class LoggerBefore implements MethodBeforeAdvice {

	private static final Logger log = Logger.getLogger(LoggerBefore.class);
	
	
	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		// TODO Auto-generated method stub
		
		log.info("调用"+arg2+"的"+arg0.getName()+"方法，方法入参"+Arrays.toString(arg1));

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
