package demo01;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import feign.Logger;
import feign.Logger.Level;
import feign.RequestInterceptor;
import feign.auth.BasicAuthRequestInterceptor;

@Controller
@SpringBootApplication
@EnableFeignClients
@EnableCaching
@EnableHystrix
public class DemoController {
	
	@Autowired
	private QuoteClient quoteClient;

    @RequestMapping("/")
    String home(Model model) {
    	model.addAttribute("greeting", quoteClient.greeting());
        return "index";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DemoController.class, args);
    }
    
    @Bean
    protected Logger.Level feignLogLevel() {
    	return Level.FULL;
    }
    
    @Bean
    @Autowired
    protected RequestInterceptor authenticate(@Value("${feign.user}") String username, @Value("${feign.pwd}") String password) {
    	return new BasicAuthRequestInterceptor(username, password);
    }
}

