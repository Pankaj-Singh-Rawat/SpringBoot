import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
public class Greeting {
    public String getGreeting() {
        return "Hello I'm in Service Layer.";
    }
}

@RestController
public class GreetingService {
    private final Greeting greetingService;

    public GreetingService(Greeting greeting) {
        this.greetingService = greeting;
    }

    @GetMapping("/greet")
    public String greet(){
        return greetingService.getGreeting();
    }
}