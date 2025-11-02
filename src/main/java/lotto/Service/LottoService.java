package lotto.Service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoService {
    public int calculateAmountOfLottos(int amountOfMoney){
        return amountOfMoney/1000;
    }
}
