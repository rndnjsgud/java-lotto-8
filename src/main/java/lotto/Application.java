package lotto;

import lotto.Controller.LottoController;
import lotto.Service.LottoService;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoService lottoService = new LottoService();
        LottoController lottoController = new LottoController(lottoService);

        int amountOfMoney = 0;
        List<Integer> winningNumbers;
        int bonusNumber;

        while (true) {
            try {
                amountOfMoney = lottoController.inputPurchaseMoneyAmount();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                lottoController.createLottos(amountOfMoney);
                winningNumbers = lottoController.inputWinningNumbers();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                bonusNumber = lottoController.inputBonusNumber(winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        try {
            lottoController.printLottoResult(winningNumbers, bonusNumber);
            lottoController.printEarningRate(winningNumbers, bonusNumber, amountOfMoney);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
