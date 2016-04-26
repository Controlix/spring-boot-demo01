package demo01;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class DefaultQuotes implements QuoteClient {

	@Override
	@Cacheable("greetings")
	public String greeting() {
		return null;
	}
	
	
}
