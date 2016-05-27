package everytasc.nineleaps.com.hackaton.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.mikhaellopez.circularimageview.CircularImageView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import everytasc.nineleaps.com.hackaton.R;
import everytasc.nineleaps.com.hackaton.Utility.Constans;
import everytasc.nineleaps.com.hackaton.Utility.VolleySingelton;
import everytasc.nineleaps.com.hackaton.Utility.VolleySingeltonUniv;

public class MainActivity extends AppCompatActivity implements VolleySingelton.APIStringResponseListener{

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




        //getOrderInfoFromVolley();
        makeACall();
    }


    private void displayQA(String question, String[] possibleAns){
        addMessageFromServer(question);
        for (int i = 0; i < possibleAns.length; i++) {
            showAnswerOptions(possibleAns[i]);
        }

        /*for (int i = 0; i < answers.length; i++) {
            showAnswerOptions(answers[i]);
        }*/
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


    //-----------------------------------

    @Override
    public void onSuccessStringResponse(String responseString) {
        Log.i("API_RESPONSE", responseString);
        JSONObject responseObj=null;
        String code="",question="",options="";

        try {
            responseObj = new JSONObject(responseString);
            code = responseObj.getString("code");
            question= responseObj.getString("question");
            options= responseObj.getString("options");
        } catch (JSONException e) {
            Log.e("BURN_ERROR",String.valueOf(e));
        }

        Log.v("CODE",code);
        Log.v("QUESTION",question);
        Log.v("OPTIONS",options);
        String[] ansOptions = options.split(",");
        displayQA(question,ansOptions);
    }

    @Override
    public void onErrorStringResponse(VolleyError volleyError) {

    }


    //--------------

    private void makeACall() {

        JSONObject jsonProfileObject=new JSONObject();
        try {
            jsonProfileObject.put("code",1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String urlString = "http://10.0.1.55/getQuestion.php";
        Log.d("urlstring", urlString);
        VolleySingelton.getInstance().setStringRequestListener4(Request.Method.POST, jsonProfileObject, urlString, this);
    }


    /*new VolleySingelton.APIStringResponseListener() {
        @Override
        public void onSuccessStringResponse(String responseString) {
            Log.d("RESPONSE", responseString);
            JSONObject responseObj = new JSONObject(responseString);
        }

        @Override
        public void onErrorStringResponse(VolleyError volleyError) {
            System.out.print("VolleyError" + volleyError);
        }
    }*/
}
