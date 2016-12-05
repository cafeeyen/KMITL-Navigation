package com.nyameh.kmitlnavi;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.Result;

import listener.ScanNavigateClickListener;
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
        if(result.getText().substring(0, 19).equals("for app QRNS KMITL:"))
        {
            final Dialog qrPassDialog = new Dialog(ScanActivity.this);
            qrPassDialog.setCanceledOnTouchOutside(true);
            qrPassDialog.setContentView(R.layout.qr_pass_dialogbox_fragment);
            qrPassDialog.setTitle("Scan Result");
            String dataToShow = "";
            String placeCode = "";
            Boolean isCanNavigate = false;

            NyaMehDatabase mHelper = new NyaMehDatabase(ScanActivity.this);
            SQLiteDatabase mDb = mHelper.getReadableDatabase();
            if(result.getText().length() < 24) {} //can't substring
            else if(result.getText().substring(20, 24).equals("news")) //&& .substring(24) < last of TABLE_NAME2 : do this
            {
                Cursor mCursor = mDb.rawQuery(String.format("SELECT * FROM " + NyaMehDatabase.TABLE_NAME2)
                        + " WHERE " + NyaMehDatabase.COL_ID + "='" + result.getText().substring(24) + "'", null);
                mCursor.moveToFirst();
                dataToShow = (mCursor.getString(mCursor.getColumnIndex(NyaMehDatabase.COL_TITLE))
                        + "\n\nDate: "+mCursor.getString(mCursor.getColumnIndex(NyaMehDatabase.COL_DATE))
                        + "\n\nDescription: "+mCursor.getString(mCursor.getColumnIndex(NyaMehDatabase.COL_CONTENT)));
                placeCode = mCursor.getString(mCursor.getColumnIndex(NyaMehDatabase.COL_POSITION));
                isCanNavigate = true;
            }
            //if want to scan place too using placecode like "for app QRNS KMITL: placeL004"
            else if(result.getText().substring(20, 25).equals("place")) //&& .substring(25) < last of TABLE_NAME : do this
            {
                Cursor mCursor = mDb.rawQuery(String.format("SELECT * FROM " + NyaMehDatabase.TABLE_NAME)
                        + " WHERE " + NyaMehDatabase.COL_CODE + "='" + result.getText().substring(25) + "'", null);
                mCursor.moveToFirst();
                dataToShow = mCursor.getString(mCursor.getColumnIndex(NyaMehDatabase.COL_NAME));
                placeCode = result.getText().substring(25);
                isCanNavigate = true;
            }

            TextView diaShortDecpt = (TextView) qrPassDialog.findViewById(R.id.qrpass_desc_text);
            diaShortDecpt.setText(dataToShow);

            Button diaCloseButton = (Button) qrPassDialog.findViewById(R.id.qrpass_close);
            diaCloseButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    qrPassDialog.dismiss();
                    mScannerView.resumeCameraPreview(ScanActivity.this);
                }
            });

            Button diaNavigateButton = (Button) qrPassDialog.findViewById(R.id.qrpass_navigate);
            if(isCanNavigate) {
                diaNavigateButton.setOnClickListener(new ScanNavigateClickListener(ScanActivity.this, placeCode));
            }
            else {
                TextView diaHeader = (TextView) qrPassDialog.findViewById(R.id.qrpass_header_text);
                diaHeader.setText("Couldn't find data from this QR Code");
                diaNavigateButton.setClickable(false);
                diaNavigateButton.setBackgroundColor(0xAAAAAA);
            }
            qrPassDialog.show();
        }

        else
        {
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
