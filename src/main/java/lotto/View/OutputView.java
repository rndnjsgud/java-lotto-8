package lotto.View;

import lotto.Domain.Lotto;
import lotto.Domain.LottoRanks;

import java.util.List;

public class OutputView {
    public static void purchaseResultOutput(int amountOfLottos, List<Lotto> lottos){
        System.out.println(amountOfLottos + "개를 구매했습니다.");
        lottos.forEach(lotto -> {
            System.out.println(lotto.getNumbers());
        });
    }

    public static void TotalResultOutput(LottoRanks lottoRanks){
        System.out.println("당첨 통계\n" + "---");

        lottoRanks.getLottoRanks()
                .forEach((lottoRank, count) -> {
                    if(count > 2) {
                        System.out.println(lottoRank.getLottoNumberMatchingCount() + "개 일치 ("
                                +String.format("%,d", lottoRank.getPrize()) + "원) - " +count + "개");
                    }
                });
    }
}
