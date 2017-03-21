package ie.sumitdawar.app.simplex;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class FrontViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_view);
        final Button bRegister = (Button) findViewById(R.id.bRegisterNew);
        final Button bLogin = (Button) findViewById(R.id.bLogin);
        final TextView tvExchangeRate = (TextView) findViewById(R.id.tvExchangeRate);
        


        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    String conversionAmount = (String) jsonResponse.get("conversion");
                    tvExchangeRate.setText(conversionAmount);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        ExchangeRequest exchangeRequest = new ExchangeRequest("1", "EUR", "INR", responseListener);
        RequestQueue queue = Volley.newRequestQueue(FrontViewActivity.this);
        queue.add(exchangeRequest);

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(FrontViewActivity.this, RegisterActivity.class);
                FrontViewActivity.this.startActivity(registerIntent);
            }
        });

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(FrontViewActivity.this, LoginActivity.class);
                FrontViewActivity.this.startActivity(loginIntent);
            }
        });

    }
}
