package com.example.sentimentanalysis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RetryPolicy;
import com.android.volley.toolbox.Volley;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    Button submit_btn;
    final String url = "https://fake-news-detection-aiml.herokuapp.com/predict";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ConstraintLayout layout = findViewById(R.id.layout1);
        final EditText input = findViewById(R.id.input);
        final TextView output =  findViewById(R.id.result);
        submit_btn = findViewById(R.id.sub_btn);

        submit_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String url = "https://fake-news-detection-aiml.herokuapp.com/predict";

                StringRequest sr = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String x = "";
                        try {
                            JSONObject obj = new JSONObject(response);
                            x = obj.getString("result");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if(x.equals("true")){
                            layout.setBackgroundColor(getResources().getColor(R.color.Positive));
                            output.setText(getResources().getString(R.string.positive));
                        }
                        else {
                            layout.setBackgroundColor(getResources().getColor(R.color.Negative));
                            output.setText(getResources().getString(R.string.negative));
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        output.setText(error.getMessage());
                    }
                }) {
                    @Override
                    protected Map<String,String> getParams() {
                        HashMap<String, String> params2 = new HashMap<>();
                        params2.put("text", input.getText().toString());
                        return params2;
                    }

                };
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                queue.add(sr).setRetryPolicy(new RetryPolicy() {
                    @Override
                    public int getCurrentTimeout() {
                        return 5000;
                    }

                    @Override
                    public int getCurrentRetryCount() {
                        return 0;
                    }

                    @Override
                    public void retry(VolleyError error) throws VolleyError {

                    }
                });

            }
        });
    }
}