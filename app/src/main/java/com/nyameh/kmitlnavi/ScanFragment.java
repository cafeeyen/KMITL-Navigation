package com.nyameh.kmitlnavi;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScanFragment extends Fragment implements ZXingScannerView.ResultHandler
{
    private ZXingScannerView mScannerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        mScannerView = new ZXingScannerView(getActivity());
        return mScannerView;
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
    public void handleResult(Result result)
    {
        if(result.getText().substring(0, 19).equals("for app QRNS KMITL:")){
            Dialog QrPPassDialog = new Dialog(getContext());
            QrPPassDialog.setContentView(R.layout.qr_pass_dialogbox_fragment);
        }
        else{
            Toast.makeText(getActivity(), "Contents = " + result.getText() +
                    ", Format = " + result.getBarcodeFormat().toString(), Toast.LENGTH_SHORT).show();
        }
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mScannerView.resumeCameraPreview(ScanFragment.this);
            }
        }, 2000);
    }
}

