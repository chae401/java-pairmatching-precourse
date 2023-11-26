package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.constants.ErrorConstants;
import pairmatching.constants.ServiceConstants;
import pairmatching.model.Feature;
import pairmatching.model.MatchInfo;
import pairmatching.validator.InputValidator;

public class InputView {
    private final InputValidator inputValidator;
    public InputView() {
        inputValidator = new InputValidator();
    }
    public Feature readFeature() {
        System.out.println(ServiceConstants.FEATURES);
        while (true) {
            try {
                int feature = inputValidator.validateFeature(Console.readLine());
                return Feature.from(feature);
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorConstants.INVALID_NUMBER);
            }
        }
    }

    public MatchInfo readMatchInfo() {
        System.out.println(ServiceConstants.COURSES);
        System.out.println(ServiceConstants.CHOOSE_COURSE_LEVEL_MISSION);
        while (true) {
            try {
                return inputValidator.validateMatchInfo(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorConstants.INVALID_MATCH_INFO);
            }
        }
    }

    public boolean readRecreate() {
        System.out.println(ServiceConstants.EXIST_MATHCHING_INFO);
        while (true) {
            try {
                return inputValidator.validateBool(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorConstants.INVALID_BOOLEAN);
            }
        }
    }
}
