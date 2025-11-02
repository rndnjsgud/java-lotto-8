package lotto.Domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class LottoRanks {
    private final Map<LottoRank, Integer> lottoRanks = new EnumMap<>(LottoRank.class);

    public void addRank(LottoRank lottoRank){
        lottoRanks.put(lottoRank, lottoRanks.getOrDefault(lottoRank, 0) + 1);
    }

    public int getRankCount(LottoRank lottoRank){
        return lottoRanks.getOrDefault(lottoRank, 0);
    }

    public Map<LottoRank, Integer> getLottoRanks(){
        return Collections.unmodifiableMap(lottoRanks);
    }
}
