package nyameh.nyameh;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity
{
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

    public void toQRScan(View view)
    {
        Intent intent = new Intent(this, QRScanActivity.class);
        startActivity(intent);
    }

    public void toMaps(View view)
    {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

}
