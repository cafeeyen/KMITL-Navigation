package nyameh.nyameh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "Nyameh.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toScanQRCode(View view){
        Intent qrIntent = new Intent(this, ScanQRCodeActivity.class);
        startActivity(qrIntent);
    }
}
