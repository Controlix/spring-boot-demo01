package demo01;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "quotes", fallback = DefaultQuotes.class)
public interface QuoteClient {

	@CachePut("greetings")
	@RequestMapping(method = RequestMethod.GET, value = "/greetings")
	String greeting();
}
