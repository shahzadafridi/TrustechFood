package offical.com.trustechfood.Registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import offical.com.trustechfood.R;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }

    public void AdminRegistration(View view) {
        Intent intent = new Intent(RegistrationActivity.this,AdminRegistration.class);
        startActivity(intent);
    }

    public void CustomerRegistration(View view) {

    }

    public void DriverRegistration(View view) {

    }
}
