package com.example.sslcommerz_test

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.sslcommerz.library.payment.model.datafield.MandatoryFieldModel
import com.sslcommerz.library.payment.model.dataset.TransactionInfo
import com.sslcommerz.library.payment.model.util.CurrencyType
import com.sslcommerz.library.payment.model.util.ErrorKeys
import com.sslcommerz.library.payment.model.util.SdkCategory
import com.sslcommerz.library.payment.model.util.SdkType
import com.sslcommerz.library.payment.viewmodel.listener.OnPaymentResultListener
import com.sslcommerz.library.payment.viewmodel.management.PayUsingSSLCommerz


class MainActivity : AppCompatActivity() {
    val TAG = "TRANSACTION"
    private lateinit var mandatoryFieldModel : MandatoryFieldModel
    private lateinit var btnPay :Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnPay = findViewById(R.id.btnPay)
        mandatoryFieldModel = MandatoryFieldModel(
            "arzlt60feb76015a71",
            "arzlt60feb76015a71@ssl",
            10.toString(),
            "Your transaction id",
            CurrencyType.BDT,
            SdkType.TESTBOX,
            SdkCategory.BANK_LIST
        )

        btnPay.setOnClickListener {
            sslCommerzGateway()
        }
    }

    fun sslCommerzGateway(){
        PayUsingSSLCommerz.getInstance()
            .setData(this@MainActivity, mandatoryFieldModel, object : OnPaymentResultListener {
                override fun transactionSuccess(transactionInfo: TransactionInfo) {
                    // If payment is success and risk label is 0 get payment details from here
                    if (transactionInfo.riskLevel == "0") {
                        Log.e(TAG, transactionInfo.valId)
                        /* After successful transaction send this val id to your server and from
                         your server you can call this api
                         https://sandbox.sslcommerz.com/validator/api/validationserverAPI.php?val_id=yourvalid&store_id=yourstoreid&store_passwd=yourpassword
                         if you call this api from your server side you will get all the details of the transaction.
                         for more details visit:   www.tashfik.me
            */
                    } else {
                        Log.e(TAG, "Transaction in risk. Risk Title : " + transactionInfo.riskTitle)
                    }
                }

                override fun transactionFail(s: String) {
                    Log.e(TAG, s)
                }

                override fun error(errorCode: Int) {
                    when (errorCode) {
                        ErrorKeys.USER_INPUT_ERROR -> Log.e(TAG, "User Input Error")
                        ErrorKeys.INTERNET_CONNECTION_ERROR -> Log.e(
                            TAG,
                            "Internet Connection Error"
                        )
                        ErrorKeys.DATA_PARSING_ERROR -> Log.e(TAG, "Data Parsing Error")
                        ErrorKeys.CANCEL_TRANSACTION_ERROR -> Log.e(
                            TAG,
                            "User Cancel The Transaction"
                        )
                        ErrorKeys.SERVER_ERROR -> Log.e(TAG, "Server Error")
                        ErrorKeys.NETWORK_ERROR -> Log.e(TAG, "Network Error")
                    }
                }
            })
    }
}