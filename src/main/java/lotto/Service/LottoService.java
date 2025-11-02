package lotto.Service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Domain.Lotto;
import lotto.Domain.LottoRank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoService {
    public int calculateAmountOfLottos(int amountOfMoney) {
        return amountOfMoney / 1000;
    }

    public Lotto creatLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(randomNumbers);
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

    public LottoRank checkLottoWinningPrize(Lotto lotto, List<Integer> winningNumber, int bonusNumber) {
        int lottoNumberMatchingCount = matchLottoNumberWithWinningNumber(lotto, winningNumber);
        boolean isBonusNumberInLotto = checkBonusNumber(lotto, bonusNumber);

        if (lottoNumberMatchingCount == 6) return LottoRank.FIRST;
        if (lottoNumberMatchingCount == 5 && isBonusNumberInLotto) return LottoRank.SECOND;
        if (lottoNumberMatchingCount == 5) return LottoRank.THIRD;
        if (lottoNumberMatchingCount == 4) return LottoRank.FOURTH;
        if (lottoNumberMatchingCount == 3) return LottoRank.FIFTH;

        return LottoRank.FAIL;
    }
}
