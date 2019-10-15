package offical.com.trustechfood.Customer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import offical.com.trustechfood.R;

public class CustDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cust_dashboard);
    }

    public void restaurnants(View view) {
        Intent intent = new Intent(CustDashboard.this,CustomerRestaurnantsActivity.class);
        startActivity(intent);
    }

    public void orders(View view) {
        Intent intent = new Intent(CustDashboard.this,CustOrderActivity.class);
        startActivity(intent);
    }
}
