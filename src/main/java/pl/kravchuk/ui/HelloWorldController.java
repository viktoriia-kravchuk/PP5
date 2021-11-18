package pl.kravchuk.ui;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kravchuk.creditcard.CardApi;

import java.util.List;

@RestController
public class HelloWorldController {
    CardApi cardApi;

    public HelloWorldController(CardApi cardApi) {
        this.cardApi = cardApi;
    }

    @RequestMapping("/hello")
    public String helloWorld(){
        return "Hello World";
    }

    @RequestMapping("/cards")
    public List<String> cards(){
        return cardApi.cards();
    }
}
