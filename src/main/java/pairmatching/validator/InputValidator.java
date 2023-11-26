package pairmatching.validator;

public class InputValidator {

    public int validateFeatureInput(String s) {
        if (s.equals("Q")) {
            return 0;
        }
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
