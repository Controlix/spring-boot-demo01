package demo01;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import feign.Logger;
import feign.Logger.Level;

@Controller
@EnableAutoConfiguration
@EnableFeignClients
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
    protected DefaultQuotes defaultQuotes() {
    	return new DefaultQuotes();
    }
    
    @Bean
    protected Logger.Level feignLogLevel() {
    	return Level.FULL;
    }
}

