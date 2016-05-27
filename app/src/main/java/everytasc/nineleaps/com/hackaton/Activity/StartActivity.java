package everytasc.nineleaps.com.hackaton.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import everytasc.nineleaps.com.hackaton.R;

public class StartActivity extends AppCompatActivity {

    Activity activity;
    Button startNow;
    TextView tagLine, introText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        activity=this;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(activity.getResources().getColor(R.color.black));
        }

        tagLine = (TextView)findViewById(R.id.tagLine);
        introText = (TextView)findViewById(R.id.introText);

        startNow=(Button)findViewById(R.id.startNow);
        startNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              // setEditTextView();

            }
        });



    }

}
