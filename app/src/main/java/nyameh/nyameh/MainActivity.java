package nyameh.nyameh;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.Result;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MainActivity extends Activity implements ZXingScannerView.ResultHandler {
    public final static String EXTRA_MESSAGE = "Nyameh.MESSAGE";
    private ZXingScannerView mScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Typeface fontPspimpdeed = Typeface.createFromAsset(getAssets(), "fonts/Pspimpdeed.ttf");
        TextView title = (TextView) findViewById(R.id.title);
        title.setText("Navigation System");
        title.setTypeface(fontPspimpdeed);

        TextView title2 = (TextView) findViewById(R.id.title2);
        title2.setText("QR Code");
        title2.setTypeface(fontPspimpdeed);
    }

    public void toScanQRCode(View view)
    {
        mScannerView = new ZXingScannerView(this); // Programmatically initialize the scanner view
        setContentView(mScannerView);
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera(); // Start camera
    }

    @Override
    public void handleResult(Result rawResult)
    {
        String result = rawResult.getText();
        if(result != null){
            if(QRCode.checkQRResult(result)){ //can pass to next page
                Intent showText = new Intent(this, ScanQRCodeActivity.class);
                showText.putExtra(EXTRA_MESSAGE, result);
                startActivity(showText);
            }
            else{ //pop up alert
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Wrong QR Code");
                builder.setMessage("Result of This code is \n" + result);
                AlertDialog alert1 = builder.create();
                alert1.show();
            }
        }
    }
    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera(); // Stop camera on pause
    }
}
