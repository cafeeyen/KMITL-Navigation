package com.nyameh.kmitlnavi;

import android.app.Dialog;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScanActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler
{

    private ZXingScannerView mScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    public void handleResult(Result result)
    {
        if(result.getText().substring(0, 19).equals("for app QRNS KMITL:")){
            final Dialog qrPassDialog = new Dialog(ScanActivity.this);
            qrPassDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            qrPassDialog.setCanceledOnTouchOutside(true);
            qrPassDialog.setContentView(R.layout.qr_pass_dialogbox_fragment);
            qrPassDialog.setTitle("Scan Result");

            TextView diaShortDecpt = (TextView) qrPassDialog.findViewById(R.id.qrpass_desc_text);
            //diaShortDecpt.setText();

            Button diaCloseButton = (Button) qrPassDialog.findViewById(R.id.qrpass_close);
            diaCloseButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    qrPassDialog.dismiss();
                    mScannerView.resumeCameraPreview(ScanActivity.this);
                }
            });

            Button diaNavigateButton = (Button) qrPassDialog.findViewById(R.id.qrpass_navigate);
            diaNavigateButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //get latlng from db go to map activity
                }
            });

            qrPassDialog.show();
        }
        else{
            Toast.makeText(this, "Contents = " + result.getText() +
                    ", Format = " + result.getBarcodeFormat().toString(), Toast.LENGTH_SHORT).show();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mScannerView.resumeCameraPreview(ScanActivity.this);
                }
            }, 2000);
        }

    }

    @Override
    public void onResume()
    {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    public void onPause()
    {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    public void onBackPressed()
    {
        finish();
    }
}
