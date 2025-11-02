package lotto.Controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.Service.LottoService;
import lotto.View.InputView;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public int inputPurchaseMoneyAmount(){
        InputView.inputMoneyAmount();
        return Integer.parseInt(Console.readLine());
    }
}
