package lotto.Service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {
    private LottoService lottoService = new LottoService();

    @DisplayName("입력받은 금액을 이용하여 구매할 로또의 갯수를 계산하는 기능")
    @Test
    void 입력받은_금액을_이용하여_구매할_로또의_갯수_계산(){
        //given
        int amountOfMoney = 8430;
        //when
        int amountOfLottos = lottoService.calculatrAmountOfLottos(amountOfMoney);
        //then
        Assertions.assertThat(amountOfLottos).isEqualTo(8);
    }
}