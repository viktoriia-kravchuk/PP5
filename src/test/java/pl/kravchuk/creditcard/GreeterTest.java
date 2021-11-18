package pl.kravchuk.creditcard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GreeterTest {
    @Test
    public void itGreetsByName() {
        //Arrange / Given
        String name = "Viktoriia";
        Greeter greeter = new Greeter();
        //Act / When
        String greetingText = greeter.hello(name);
        //Assert / Then
        assertEquals("Hello Viktoriia", greetingText);
    }
}
