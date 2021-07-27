package com.example.sslcommerz_sandbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.sslwireless.sslcommerzlibrary.model.initializer.SSLCCustomerInfoInitializer
import com.sslwireless.sslcommerzlibrary.model.initializer.SSLCProductInitializer
import com.sslwireless.sslcommerzlibrary.model.initializer.SSLCShipmentInfoInitializer
import com.sslwireless.sslcommerzlibrary.model.initializer.SSLCommerzInitialization
import com.sslwireless.sslcommerzlibrary.model.response.SSLCTransactionInfoModel
import com.sslwireless.sslcommerzlibrary.model.util.SSLCCurrencyType
import com.sslwireless.sslcommerzlibrary.model.util.SSLCSdkType
import com.sslwireless.sslcommerzlibrary.view.singleton.IntegrateSSLCommerz
import com.sslwireless.sslcommerzlibrary.viewmodel.listener.SSLCTransactionResponseListener

class MainActivity : AppCompatActivity(), SSLCTransactionResponseListener {

    private lateinit var sslCommerzInitialization: SSLCommerzInitialization
    private lateinit var sslcCustomerInfoInitializer: SSLCCustomerInfoInitializer
    private lateinit var sslcProductInitializer: SSLCProductInitializer
    private lateinit var sslcShipmentInfoInitializer: SSLCShipmentInfoInitializer
    private lateinit var btnPay :Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inIt()
        btnPay.setOnClickListener {
           IntegrateSSLCommerz
               .getInstance(this)
               .addSSLCommerzInitialization(sslCommerzInitialization)
               .addCustomerInfoInitializer(sslcCustomerInfoInitializer)
               .addProductInitializer(sslcProductInitializer)
               //.addShipmentInfoInitializer(sslcShipmentInfoInitializer)
               .buildApiCall(this);
       }
    }

    override fun transactionSuccess(p0: SSLCTransactionInfoModel?) {
        if (p0?.apiConnect=="DONE"){
            println("Status: "+p0.status)
            println("TRNID: "+p0.tranId)
            println("AMOUNT: "+p0.amount)
        }
    }

    override fun transactionFail(p0: String?) {
        println("FAIL: $p0")
    }

    override fun merchantValidationError(p0: String?) {
        println("VALIDATION ERROR: $p0")
    }

    fun inIt(){

        btnPay = findViewById(R.id.btnPay);
        sslCommerzInitialization =
            SSLCommerzInitialization(
                "arzlt60feb76015a71",
                "arzlt60feb76015a71@ssl",
                10.0,
                SSLCCurrencyType.BDT,
                "123456789098765",
                "TEST",
                SSLCSdkType.TESTBOX
            )

        sslcCustomerInfoInitializer =
            SSLCCustomerInfoInitializer(
                "RIPON",
                "MAIL",
                "ADDRESS",
                "DHAKA",
                "1204",
                "BANGLADESH",
                "01521329880"
            )

        sslcProductInitializer =
            SSLCProductInitializer(
                "FOOD",
                "FOOD",
                SSLCProductInitializer.ProductProfile.TravelVertical(
                    "Travel", "10",
                    "A", "12", "Dhk-Syl"
                )
            )

        sslcShipmentInfoInitializer =
            SSLCShipmentInfoInitializer(
                "Courier",
                2,
                SSLCShipmentInfoInitializer.ShipmentDetails(
                    "ShipName",
                    "shipAddress",
                    "shipCity",
                    "1204",
                    "Bangladesh"
                )
            )

    }
}