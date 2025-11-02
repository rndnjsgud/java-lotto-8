package lotto.Service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Domain.Lotto;
import lotto.Domain.LottoRank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private List<Lotto> lottos = new ArrayList<>();

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void addLottos(Lotto lotto) {
        lottos.add(lotto);
    }

    public int calculateAmountOfLottos(int amountOfMoney) {
        return amountOfMoney / 1000;
    }

    public void creatLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(randomNumbers));
    }

    private int matchLottoNumberWithWinningNumber(Lotto lotto, List<Integer> winningNumbers) {
        return (int) lotto.getNumbers()
                .stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private boolean checkBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers()
                .contains(bonusNumber);
    }

    public int checkLottoWinningPrize(List<Integer> winningNumber, int bonusNumber) {
        int winningPrizeAmount = 0;
        for(Lotto lotto : lottos) {
            int lottoNumberMatchingCount = matchLottoNumberWithWinningNumber(lotto, winningNumber);
            boolean isBonusNumberInLotto = checkBonusNumber(lotto, bonusNumber);

            if (lottoNumberMatchingCount == 6)  winningPrizeAmount += LottoRank.FIRST.getPrize();
            else if (lottoNumberMatchingCount == 5 && isBonusNumberInLotto) winningPrizeAmount += LottoRank.SECOND.getPrize();
            else if (lottoNumberMatchingCount == 5) winningPrizeAmount += LottoRank.THIRD.getPrize();
            else if (lottoNumberMatchingCount == 4) winningPrizeAmount += LottoRank.FOURTH.getPrize();
            else if (lottoNumberMatchingCount == 3) winningPrizeAmount += LottoRank.FIFTH.getPrize();
        }
        return winningPrizeAmount;
    }

    public double calculateEarningRate(int winningPrizeAmount, int amountOfMoney){
        return (double) winningPrizeAmount /amountOfMoney*100;
    }
}
