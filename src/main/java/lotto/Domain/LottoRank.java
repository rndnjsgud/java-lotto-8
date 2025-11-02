package lotto.Domain;

public enum LottoRank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    FAIL(2, false, 0);

    private final int lottoNumberMatchingCount;
    private final boolean isBonusNumberInLotto;
    private final int prize;

    LottoRank(int lottoNumberMatchingCount, boolean isBonusNumberInLotto, int prize) {
        this.lottoNumberMatchingCount = lottoNumberMatchingCount;
        this.isBonusNumberInLotto = isBonusNumberInLotto;
        this.prize = prize;
    }

    public int getLottoNumberMatchingCount() {
        return lottoNumberMatchingCount;
    }

    public boolean isBonusNumberInLotto() {
        return isBonusNumberInLotto;
    }

    public int getPrize() {
        return prize;
    }
}
