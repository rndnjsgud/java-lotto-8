package lotto.View;

import lotto.Domain.Lotto;
import lotto.Domain.LottoRank;
import lotto.Domain.LottoRanks;

import java.util.Arrays;
import java.util.List;

public class OutputView {
    public static void purchaseResultOutput(int amountOfLottos, List<Lotto> lottos) {
        System.out.println(amountOfLottos + "개를 구매했습니다.");
        lottos.forEach(lotto -> {
            System.out.println(lotto.getNumbers());
        });
    }

    public static void totalResultOutput(LottoRanks lottoRanks) {
        System.out.println("당첨 통계\n" + "---");

        Arrays.stream(LottoRank.values())
                .forEach(lottoRank -> {
                    int count = lottoRanks
                            .getLottoRanks()
                            .getOrDefault(lottoRank, 0);
                    if(lottoRank.getPrize() != 30000000) {
                        System.out.printf("%d개 일치 (%,d원) - %d개,", lottoRank.getLottoNumberMatchingCount()
                                , lottoRank.getPrize(), count);
                    }
                    else if(lottoRank.getPrize() == 30000000){
                        System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개,", lottoRank.getLottoNumberMatchingCount()
                                , lottoRank.getPrize(), count);
                    }
                    System.out.println();
                });
    }

    public static void earningRateOutput(double earningRate) {
        System.out.println("총 수익률은 " + earningRate + "%입니다.");
    }
}
