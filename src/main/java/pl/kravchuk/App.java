package pl.kravchuk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.kravchuk.creditcard.CardApi;
import pl.kravchuk.creditcard.CreditCardMemory;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World");
        SpringApplication.run(App.class, args);
    }

    @Bean
    CardApi createBankingSystem() {
        return new CardApi((new CreditCardMemory()));
    }
}
