package lotto.Controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.Domain.Lotto;
import lotto.Domain.LottoRanks;
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
        String amountOfMoneyInput = Console.readLine();
        int amountOfMoney = 0;
        if(!amountOfMoneyInput.matches("\\d+")){
            throw new IllegalArgumentException("[ERROR] 구입 금액에는 정수만 가능합니다");
        }
        amountOfMoney = Integer.parseInt(amountOfMoneyInput);
        if (amountOfMoney < 1000) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원보다 커야 합니다.");
        }
        if (amountOfMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
        return amountOfMoney;
    }

    public void createLottos(int moneyAmount) {
        int amountOfLottos = lottoService.calculateAmountOfLottos(moneyAmount);

        for (int i = 0; i < amountOfLottos; i++) {
            lottoService.creatLotto();
        }
        OutputView.purchaseResultOutput(amountOfLottos, lottoService.getLottos());
    }

    public List<Integer> inputWinningNumbers() {
        InputView.inputWinningNumbers();
        String winningNumbersInput = Console.readLine();

        List<Integer> winningNumbers = Arrays.stream(winningNumbersInput.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();

        Lotto lotto = new Lotto(winningNumbers);

        return winningNumbers;
    }

    public int inputBonusNumber(List<Integer> winningNumbers) {
        InputView.inputBonusNumber();
        int bonusNumber = Integer.parseInt(Console.readLine());
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 1~45 이내여야 합니다.");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 당첨 번호와 중복될 수 없습니다.");
        }
        return bonusNumber;
    }

    public void printLottoResult(List<Integer> winningNumber, int bonusNumber) {
        LottoRanks lottoRanks = lottoService.checkLottoWinningResult(winningNumber, bonusNumber);
        OutputView.totalResultOutput(lottoRanks);
    }

    public void printEarningRate(List<Integer> winningNumber, int bonusNumber, int amountOfMoney) {
        int winningPrizeAmount = lottoService.calculateLottoWinningPrize(winningNumber, bonusNumber);

        double earningRate = lottoService.calculateEarningRate(winningPrizeAmount, amountOfMoney);

        OutputView.earningRateOutput(earningRate);
    }
}
