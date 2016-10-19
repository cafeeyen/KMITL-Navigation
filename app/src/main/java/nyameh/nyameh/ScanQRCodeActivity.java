package nyameh.nyameh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.journeyapps.barcodescanner.CaptureActivity;

public class ScanQRCodeActivity extends AppCompatActivity {

    public static final int REQUEST_QR_SCAN = 0; //varible for compare
    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent qrintent = getIntent(); //if want some message from previous page
        setContentView(R.layout.activity_scan_qrcode);
        Button scanButton = (Button)findViewById(R.id.scanButton);
        scanButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CaptureActivity.class);
                startActivityForResult(intent, REQUEST_QR_SCAN);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == REQUEST_QR_SCAN && resultCode == RESULT_OK) {
            String content = intent.getStringExtra("CONTENT");
            String format = intent.getStringExtra("FORMAT");
            String type = intent.getStringExtra("TYPE");
            textView1.setText(content + "\n" + format + "\n" + type);
        } else if(requestCode == REQUEST_QR_SCAN && resultCode == RESULT_CANCELED) {
            textView1.setText("scan failed");
        }
    }
}
