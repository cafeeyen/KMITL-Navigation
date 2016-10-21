package nyameh.nyameh;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends Activity {
    public final static String EXTRA_MESSAGE = "Nyameh.MESSAGE";

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
        new IntentIntegrator(this).initiateScan();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent)
    {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if(result != null)
        {
            if(result.getContents() == null)
            {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            }
            else
            {
                if (QRCode.checkQRResult(result.getContents()))
                {
                    Intent showText = new Intent(this, ScanQRCodeActivity.class);
                    showText.putExtra(EXTRA_MESSAGE, result.getContents());
                    startActivity(showText);
                }
                else
                {

                }
            }
        }
        else
        {
            super.onActivityResult(requestCode, resultCode, intent);
        }
    }
}
