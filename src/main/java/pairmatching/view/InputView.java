package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.constants.ErrorConstants;
import pairmatching.constants.ServiceConstants;
import pairmatching.model.Feature;
import pairmatching.validator.InputValidator;

public class InputView {
    private final InputValidator inputValidator;
    public InputView() {
        inputValidator = new InputValidator();
    }
    public Feature selectFeature() {
        System.out.println(ServiceConstants.FEATURES);
        int feature;
        while (true) {
            try {
                feature = inputValidator.validateFeatureInput(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorConstants.INVALID_NUMBER);
            }
        }
    }
}
