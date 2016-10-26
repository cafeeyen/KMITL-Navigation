package nyameh.nyameh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.view.Window;

import com.google.zxing.Result;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class QRScanActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler
{
    public final static String EXTRA_MESSAGE = "Nyameh.MESSAGE";
    private ZXingScannerView mScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        mScannerView = new ZXingScannerView(this); // Programmatically initialize the scanner view
        setContentView(mScannerView);
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera(); // Start camera
    }

    @Override
    public void handleResult(Result rawResult)
    {
        String result = rawResult.getText();
        if(result != null)
        {
            if(QRScanActivity.checkQRResult(result))
            { //can pass to next page
                Intent showText = new Intent(this, ScanQRCodeActivity.class);
                showText.putExtra(EXTRA_MESSAGE, result);
                startActivity(showText);
            }
            else
            { //pop up alert
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Wrong QR Code");
                builder.setMessage("Result of This code is \n" + result);
                AlertDialog alert1 = builder.create();
                alert1.show();
                mScannerView.resumeCameraPreview(this);
            }
        }
    }

    @Override
    public void onPause()
    {
        super.onPause();
        mScannerView.stopCamera(); // Stop camera on pause
    }

    private static boolean checkQRResult(String qrContent)
    {
        if (qrContent.length() > 4 && qrContent.substring(0, 4).compareTo("geo:") == 0
                && (qrContent.length()-qrContent.replaceAll(",", "").length()==1))
        {
            if(getTitude(qrContent, true) != 9999 && getTitude(qrContent, false) != 9999)
                return true;
        }
        return false;
    }

    private static double getTitude(String qrContent, Boolean isLatitude){
        if(isLatitude)
        {
            try
            {
                double titudeResult = Double.parseDouble(qrContent.split(",")[0].substring(4));
                return titudeResult;
            }
            catch (Exception ex){return 9999;}
        }
        else
        { //longitude
            try
            {
                double titudeResult = Double.parseDouble(qrContent.split(",")[1]);
                return titudeResult;
            }
            catch (Exception ex){return 9999;}
        }
    }
}

