package demo01;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class DefaultQuotes implements QuoteClient {

	@Override
	@Cacheable("greetings")
	@HystrixCommand(fallbackMethod = "defaultGreeting")
	public String greeting() {
		throw new UnsupportedOperationException();
	}
	
	public String defaultGreeting() {
		return "Never underestimate the power of the dark side";
	}
	
}
