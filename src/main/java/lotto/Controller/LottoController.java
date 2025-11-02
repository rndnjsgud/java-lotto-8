package lotto.Controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.Service.LottoService;
import lotto.View.InputView;
import lotto.View.OutputView;

import java.util.Arrays;
import java.util.List;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public int inputPurchaseMoneyAmount() {
        InputView.inputMoneyAmount();
        return Integer.parseInt(Console.readLine());
    }

    public void createLottos(int moneyAmount) {
        int amountOfLottos = lottoService.calculateAmountOfLottos(moneyAmount);

        for (int i = 0; i < amountOfLottos; i++) {
            lottoService.creatLotto();
        }
    }

    public List<Integer> inputWinningNumbers(){
        InputView.inputWinningNumbers();
        String winningNumbersInput = Console.readLine();

        List<Integer> winningNumbers = Arrays.stream(winningNumbersInput.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();

        return winningNumbers;
    }
}
