package pl.kravchuk.letters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharCounterTest {
    @Test
    public void itCountsCharsInInputString() {
        //Arrange
        String inputStr = "Ala ma kota a kot ma mysz";
        CharCounter charCounter = new CharCounter();
        //Act
        int charsCount = charCounter.count("a", inputStr);
        //Assert
        assertEquals(6, charsCount);
    }
}
