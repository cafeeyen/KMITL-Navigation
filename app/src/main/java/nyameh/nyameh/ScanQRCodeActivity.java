package nyameh.nyameh;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ScanQRCodeActivity extends AppCompatActivity {
    TextView scanResultView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_qrcode);

        scanResultView = (TextView) findViewById(R.id.scanResultView);

        Intent qrintent = getIntent();
        String scanResult = qrintent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        scanResultView.setText(scanResult);
    }
}
