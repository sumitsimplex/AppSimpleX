package ie.sumitdawar.app.simplex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class FrontViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_view);
        final Button bRegister = (Button) findViewById(R.id.bRegisterNew);
        final Button bLogin = (Button) findViewById(R.id.bLogin);

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
