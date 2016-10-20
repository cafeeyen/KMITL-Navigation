package nyameh.nyameh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class MainActivity extends Activity {
    public final static String EXTRA_MESSAGE = "Nyameh.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toScanQRCode(View view){
        new IntentIntegrator(this).initiateScan();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if(result != null) {
            if(result.getContents() == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                Intent intent1 = new Intent(this, ScanQRCodeActivity.class);
                intent1.putExtra(EXTRA_MESSAGE, result.getContents());
                startActivity(intent1);
            }
        } else {
            super.onActivityResult(requestCode, resultCode, intent);
        }
    }
}
