package everytasc.nineleaps.com.hackaton;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;

public class MainActivity extends AppCompatActivity {

    LinearLayout messageFromServer, answerOptions;
    String[] answers={
            "Career Guidance",
            "Personal Assistant",
            "Entertainment"
    };

    ScrollView scrollView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        messageFromServer = (LinearLayout)findViewById(R.id.messageFromServer);
        answerOptions = (LinearLayout)findViewById(R.id.answerOptions);

        scrollView=(ScrollView)findViewById(R.id.scrollView);

        scrollView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                scrollView.post(new Runnable() {
                    public void run() {
                        scrollView.fullScroll(View.FOCUS_DOWN);
                    }
                });
            }
        });


        addMessageFromServer("Hey Guys, How can I help you?");

        for (int i = 0; i < answers.length; i++) {
            showAnswerOptions(answers[i]);

        }

    }

    private void showAnswerOptions(final String answer) {
        LayoutInflater layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View block = layoutInflater.inflate(R.layout.answer_block, null);

        block.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAnswerToView(answer);
            }
        });

        TextView answerOptionsText= (TextView)block.findViewById(R.id.optionsFromServer);
        answerOptionsText.setText(answer);

        CircularImageView wiki=(CircularImageView)findViewById(R.id.wikipedia);
        answerOptions.addView(block);

    }

    private void addAnswerToView(String answer) {
        LayoutInflater layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View block = layoutInflater.inflate(R.layout.chat_answer_block, null);
        LinearLayout parentLayout=(LinearLayout)block.findViewById(R.id.parentLayout);
        parentLayout.setGravity(Gravity.END);
        TextView answerText= (TextView)block.findViewById(R.id.answer);
        answerText.setText(answer);
        messageFromServer.addView(block);
    }

    private void addMessageFromServer(String s) {
        LayoutInflater layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View block = layoutInflater.inflate(R.layout.chat_block, null);

        TextView question=(TextView)block.findViewById(R.id.question);
        question.setText(s);

        messageFromServer.addView(block);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
