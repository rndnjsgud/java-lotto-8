package lotto.Service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {
    private LottoService lottoService = new LottoService();

    @DisplayName("입력받은 금액을 이용하여 구매할 로또의 갯수를 계산하는 기능")
    @Test
    void 입력받은_금액을_이용하여_구매할_로또의_갯수_계산(){
        //given
        int amountOfMoney = 8430;
        //when
        int amountOfLottos = lottoService.calculateAmountOfLottos(amountOfMoney);
        //then
        assertThat(amountOfLottos).isEqualTo(8);
    }

    @DisplayName("랜덤한 숫자를 이용하여 로또를 생성하는 기능")
    @Test
    void 랜덤한_숫자를_이용하여_로또를_생성(){
        //given
        //when
        Lotto lotto = createLotto();
        //then
        assertThat(lotto).isNotNull();
    }
}