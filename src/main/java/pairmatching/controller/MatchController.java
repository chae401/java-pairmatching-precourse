package pairmatching.controller;

import java.math.MathContext;
import pairmatching.model.Feature;
import pairmatching.model.MatchInfo;
import pairmatching.model.MatchService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchController {
    private final InputView inputView;
    private final OutputView outputView;
    private final MatchService matchService;
    public MatchController() {
        matchService = new MatchService();
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void execute() {
        while (true) {
            Feature feature = inputView.readFeature();
            if (feature == Feature.MATCHING) {
                match(inputView.readMatchInfo());
            } else if (feature == Feature.SELECT) {
                select(inputView.readMatchInfo());
            } else if (feature == Feature.INIT) {
                init();
            } else if (feature == Feature.QUIT) {
                return;
            }
        }
    }

    private void match(MatchInfo matchInfo) {
        if (matchService.isExist(matchInfo)) {
            if (!inputView.readRecreate()) {
                match(inputView.readMatchInfo());
            }
        }
        matchService.match(matchInfo);
        select(matchInfo);
    }

    private void select(MatchInfo matchInfo) {
        outputView.printMatchInfo(matchService.getMatchInfo(matchInfo));
    }

    private void init() {
        matchService.init();
    }
}
