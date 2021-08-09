package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoPurchase;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.WinPrizes;
import lotto.model.WinnerLotto;
import lotto.service.PrizeStatus;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoController {

	public static void main(String[] args) {
		Money money = new Money(LottoInputView.inputLottoPurchaseMoney());

		Lottos lottos = LottoPurchase.buyLottos(money);

		LottoOutputView.printLottoCount(money);
		LottoOutputView.printLottoList(lottos);

		Lotto lastWinnerLotto = new Lotto(LottoInputView.inputLastWinningLotto());

		WinnerLotto winnerLotto = new WinnerLotto(lastWinnerLotto, LottoInputView.inputBonusNumber());

		WinPrizes winPrizes = PrizeStatus.findWinPrize(lottos, winnerLotto);
		LottoOutputView.displayLottoPrize(winPrizes);
	}
}
