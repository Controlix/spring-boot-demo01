import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "quotes", fallback = DefaultQuotes.class)
public interface QuoteClient {

	@RequestMapping(method = RequestMethod.POST, value = "/greetings")
	String greeting();
}
