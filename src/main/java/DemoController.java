import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
}

