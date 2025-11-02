package lotto.Service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Domain.Lotto;
import lotto.Domain.LottoRank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {
    private LottoService lottoService;

    @BeforeEach
    public void beforeEach(){
        lottoService = new LottoService();
    }

    @DisplayName("입력받은 금액을 이용하여 구매할 로또의 갯수를 계산하는 기능")
    @Test
    void 입력받은_금액을_이용하여_구매할_로또의_갯수_계산() {
        //given
        int amountOfMoney = 8430;
        //when
        int amountOfLottos = lottoService.calculateAmountOfLottos(amountOfMoney);
        //then
        assertThat(amountOfLottos).isEqualTo(8);
    }

    @DisplayName("랜덤한 숫자를 이용하여 로또를 생성하는 기능")
    @Test
    void 랜덤한_숫자를_이용하여_로또를_생성() {
        //given
        //when
        lottoService.creatLotto();
        //then
        assertThat(lottoService.getLottos().size()).isEqualTo(1);
    }

    /*
    @DisplayName("로또 번호와 당첨번호의 일치 갯수를 확인하는 기능")
    @Test
    void 로또_번호와_당첨_번호의_일치_갯수를_확인하는_기능(){
        //given
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        //when
        List<Integer> firstPrizeWinningNumber = new ArrayList<>(List.of(1,2,3,4,5,6));
        List<Integer> secondPrizeWinningNumber = new ArrayList<>(List.of(1,2,3,4,5,7));
        List<Integer> thirdPrizeWinningNumber = new ArrayList<>(List.of(1,2,3,4,5,8));
        List<Integer> fourthPrizeWinningNumber = new ArrayList<>(List.of(1,2,3,4,8,9));
        List<Integer> fifthPrizeWinningNumber = new ArrayList<>(List.of(1,2,3,8,9,10));
        //then
        assertThat(lottoService.matchLottoNumberWithWinningNumber(lotto, firstPrizeWinningNumber)).isEqualTo(6);
        assertThat(lottoService.matchLottoNumberWithWinningNumber(lotto, secondPrizeWinningNumber)).isEqualTo(5);
        assertThat(lottoService.matchLottoNumberWithWinningNumber(lotto, thirdPrizeWinningNumber)).isEqualTo(5);
        assertThat(lottoService.matchLottoNumberWithWinningNumber(lotto, fourthPrizeWinningNumber)).isEqualTo(4);
        assertThat(lottoService.matchLottoNumberWithWinningNumber(lotto, fifthPrizeWinningNumber)).isEqualTo(3);
    }

    @DisplayName("보너스 번호 일치 여부 확인하는 기능")
    @Test
    void 보너스_번호_일치_여부_확인하는_기능(){
        //given
        Lotto lotto1 = new Lotto(List.of(1,2,3,4,5,6));
        Lotto lotto2 = new Lotto(List.of(2,3,4,5,6,7));
        int bonusNumber = 1;
        //when
        boolean isBonusNumberInLotto1 = lottoService.checkBonusNumber(lotto1, bonusNumber);
        boolean isBonusNumberInLotto2 = lottoService.checkBonusNumber(lotto2, bonusNumber);

        //then
        assertThat(isBonusNumberInLotto1).isEqualTo(true);
        assertThat(isBonusNumberInLotto2).isEqualTo(false);
    }
    */

    @DisplayName("로또 당첨 액수를 확인하는 기능")
    @Test
    void 로또_당첨_액수를_확인하는_기능() {
        //given
        List<Integer> winningNumber = new ArrayList<Integer>(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        int winningPrizeAmount = 0;

        lottoService.addLottos(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottoService.addLottos(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        lottoService.addLottos(new Lotto(List.of(1, 2, 3, 4, 5, 8)));
        lottoService.addLottos(new Lotto(List.of(1, 2, 3, 4, 8, 9)));
        lottoService.addLottos(new Lotto(List.of(1, 2, 3, 8, 9, 10)));

        //when
        winningPrizeAmount = lottoService.checkLottoWinningPrize(winningNumber, bonusNumber);

        //then
        assertThat(winningPrizeAmount).isEqualTo(2_031_555_000);
    }

    @DisplayName("수익률을 계산하는 기능")
    @Test
    void 수익률을_계산하는_기능() {
        //given
        int amountOfMoney = 5_000;
        int winningPrizeAmount =1_555_000;
        //when
        double earningRate = lottoService.calculateEarningRate(winningPrizeAmount, amountOfMoney);
        //then
        assertThat(earningRate).isEqualTo(31100);
    }
}