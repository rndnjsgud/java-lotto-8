package lotto.Service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Domain.Lotto;
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

    public int matchLottoNumberWithWinningNumber(Lotto lotto, List<Integer> winningNumbers){
        return (int)lotto.getNumbers()
                .stream()
                .filter(winningNumbers::contains)
                .count();
    }
}
