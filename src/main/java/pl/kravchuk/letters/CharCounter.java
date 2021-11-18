package pl.kravchuk.letters;

public class CharCounter {
    public int count(String charToBeCounted, String inputStr) {
        return inputStr.length() - inputStr.toLowerCase().replace(charToBeCounted.toLowerCase(), "").length();
    }
}
