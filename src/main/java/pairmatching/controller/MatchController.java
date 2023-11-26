package pairmatching.controller;

import java.math.MathContext;
import pairmatching.model.Feature;
import pairmatching.model.MatchService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchController {
    private final MatchService matchService;
    public MatchController() {
        matchService = new MatchService();
    }

    public void selectFeature(InputView inputView) {
        Feature feature = inputView.selectFeature();
        matchService.execute(feature);
    }

}
