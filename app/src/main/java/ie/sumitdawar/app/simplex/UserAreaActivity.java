package ie.sumitdawar.app.simplex;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

public class UserAreaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        TextView tvWelcomeMsg = (TextView) findViewById(R.id.tvWelcomeMsg);

        // Display user details
        String message = "Welcome " + name;
        tvWelcomeMsg.setText(message);

    }
}
