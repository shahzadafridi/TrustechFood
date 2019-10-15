package offical.com.trustechfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import offical.com.trustechfood.Admin.Dashboard;
import offical.com.trustechfood.Customer.CustDashboard;
import offical.com.trustechfood.Customer.CustOrderActivity;
import offical.com.trustechfood.Customer.CustomerRestaurnantsActivity;
import offical.com.trustechfood.Registration.RegistrationActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//        startActivity(intent);
    }

    public void customer(View view) {
        Intent intent = new Intent(MainActivity.this, CustDashboard.class);
        startActivity(intent);
    }

    public void admin(View view) {
        Intent intent = new Intent(MainActivity.this, Dashboard.class);
        startActivity(intent);
    }

}
