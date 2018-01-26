import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
	static public void main(String...strings ) {
		Result result = JUnitCore.runClasses(StudentUtilTest.class);
	      
	      for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
	      
	      System.out.println(result.wasSuccessful());
	}

}
