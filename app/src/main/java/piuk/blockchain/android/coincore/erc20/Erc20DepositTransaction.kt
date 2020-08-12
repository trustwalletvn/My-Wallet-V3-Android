package piuk.blockchain.android.coincore.erc20

import info.blockchain.balance.CryptoCurrency
import info.blockchain.balance.CryptoValue
import piuk.blockchain.android.coincore.CryptoAddress
import piuk.blockchain.android.coincore.FeeLevel
import piuk.blockchain.android.coincore.PendingTx
import piuk.blockchain.android.coincore.TxOption
import piuk.blockchain.android.coincore.TxOptionValue
import piuk.blockchain.androidcore.data.erc20.Erc20Account
import piuk.blockchain.androidcore.data.exchangerate.ExchangeRateDataManager
import piuk.blockchain.androidcore.data.fees.FeeDataManager

class Erc20DepositTransaction(
    asset: CryptoCurrency,
    erc20Account: Erc20Account,
    feeManager: FeeDataManager,
    exchangeRates: ExchangeRateDataManager,
    sendingAccount: Erc20NonCustodialAccount,
    sendTarget: CryptoAddress,
    requireSecondPassword: Boolean
) : Erc20OnChainTransaction(
    asset,
    erc20Account,
    feeManager,
    exchangeRates,
    sendingAccount,
    sendTarget,
    requireSecondPassword
) {

    override var pendingTx = PendingTx(
        amount = CryptoValue.zero(asset),
        available = CryptoValue.zero(asset),
        fees = CryptoValue.ZeroEth,
        feeLevel = FeeLevel.Regular,
        options = setOf(
            TxOptionValue.TxTextOption(
                option = TxOption.AGREEMENT
            )
        )
    )

}