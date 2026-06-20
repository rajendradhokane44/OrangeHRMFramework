package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer
{
	private int count=0;
	private int maxRetry=2;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count<maxRetry)
		{
			count++;
			
			return false;
		}
		return false;
	}
	

}
