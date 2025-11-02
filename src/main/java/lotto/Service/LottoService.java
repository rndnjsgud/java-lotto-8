package lotto.Service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Domain.Lotto;
import lotto.Domain.LottoRank;
import lotto.Domain.LottoRanks;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

public class LottoService {
    private final List<Lotto> lottos = new ArrayList<>();

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

    public LottoRanks checkLottoWinningResult(List<Integer> winningNumber, int bonusNumber) {
        LottoRanks lottoRanks = new LottoRanks();
        for(Lotto lotto : lottos) {
            int lottoNumberMatchingCount = matchLottoNumberWithWinningNumber(lotto, winningNumber);
            boolean isBonusNumberInLotto = checkBonusNumber(lotto, bonusNumber);

            if (lottoNumberMatchingCount == 6)  lottoRanks.addRank(LottoRank.FIRST);
            else if (lottoNumberMatchingCount == 5 && isBonusNumberInLotto) lottoRanks.addRank(LottoRank.SECOND);
            else if (lottoNumberMatchingCount == 5) lottoRanks.addRank(LottoRank.THIRD);
            else if (lottoNumberMatchingCount == 4) lottoRanks.addRank(LottoRank.FOURTH);
            else if (lottoNumberMatchingCount == 3) lottoRanks.addRank(LottoRank.FIFTH);
        }
        return lottoRanks;
    }

    public int calculateLottoWinningPrize(List<Integer> winningNumber, int bonusNumber){
        LottoRanks lottoRanks = checkLottoWinningResult(winningNumber, bonusNumber);
        int winningPrizeAmount = 0;

        winningPrizeAmount = lottoRanks.getLottoRanks()
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 0)
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();

        return winningPrizeAmount;
    }

    public double calculateEarningRate(int winningPrizeAmount, int amountOfMoney){
        return (double) winningPrizeAmount /amountOfMoney*100;
    }
}
