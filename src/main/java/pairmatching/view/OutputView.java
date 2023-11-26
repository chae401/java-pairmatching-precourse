package pairmatching.view;

import java.util.List;
import pairmatching.constants.ServiceConstants;

public class OutputView {
    private static final String SEPARATOR = " : ";
    public void printMatchInfo(List<String> crewNames) {
        System.out.println(ServiceConstants.RESULT_OF_PAIRMATCHING);
        for (int i = 0; i < crewNames.size(); i+=2) {
            if (i+1 == crewNames.size()) {
                System.out.print(SEPARATOR + crewNames.get(i));
                break;
            }
            System.out.println();
            System.out.print(crewNames.get(i) + SEPARATOR + crewNames.get(i+1));
        }
        System.out.println();
    }
}
