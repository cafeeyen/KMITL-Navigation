package com.nyameh.kmitlnavi;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
    private String dataToShow;
    private String placeCode;

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

        if(findData(result.getText()))
        {
            final Dialog qrPassDialog = new Dialog(ScanActivity.this);
            qrPassDialog.setCanceledOnTouchOutside(true);
            qrPassDialog.setContentView(R.layout.qr_pass_dialogbox_fragment);
            qrPassDialog.setTitle("Scan Result");

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
            diaNavigateButton.setOnClickListener(new ScanNavigateClickListener(ScanActivity.this, placeCode));
            qrPassDialog.show();
        }
        else
        {
            Toast.makeText(this, "Couldn't find data from this QR Code", Toast.LENGTH_SHORT).show();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable()
            {
                @Override
                public void run()
                {
                    mScannerView.resumeCameraPreview(ScanActivity.this);
                }
            }, 2000);
        }

    }

    private boolean findData(String result)
    {
        if(result.contains("for app QRNS KMITL:"))
        {
            if(result.contains("news"))
            {
                NyaMehDatabase mHelper = new NyaMehDatabase(ScanActivity.this);
                SQLiteDatabase mDb = mHelper.getReadableDatabase();
                Cursor mCursor = mDb.rawQuery(String.format("SELECT * FROM " + NyaMehDatabase.TABLE_NAME2)
                        + " WHERE " + NyaMehDatabase.COL_ID + "=" + result.substring(24), null);
                if(mCursor.moveToFirst())
                {
                    dataToShow = (
                            mCursor.getString(mCursor.getColumnIndex(NyaMehDatabase.COL_TITLE))
                                    + "\n\nDate: "+mCursor.getString(mCursor.getColumnIndex(NyaMehDatabase.COL_DATE))
                                    + "\n\nDescription: "+mCursor.getString(mCursor.getColumnIndex(NyaMehDatabase.COL_CONTENT)));
                    placeCode = mCursor.getString(mCursor.getColumnIndex(NyaMehDatabase.COL_POSITION));
                    return true;
                }
            }
            else if(result.contains("place"))
            {
                NyaMehDatabase mHelper = new NyaMehDatabase(ScanActivity.this);
                SQLiteDatabase mDb = mHelper.getReadableDatabase();
                Cursor mCursor = mDb.rawQuery(String.format("SELECT * FROM " + NyaMehDatabase.TABLE_NAME)
                        + " WHERE " + NyaMehDatabase.COL_CODE + "='" + result.substring(25) + "'", null);
                if(mCursor.moveToFirst())
                {
                    dataToShow = mCursor.getString(mCursor.getColumnIndex(NyaMehDatabase.COL_NAME));
                    placeCode = result.substring(25);
                    return true;
                }
                return true;
            }
        }
        return false;
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
