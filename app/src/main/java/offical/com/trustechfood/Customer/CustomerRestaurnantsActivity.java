package offical.com.trustechfood.Customer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import offical.com.trustechfood.Adapter.CustRestaurnantAdapter;
import offical.com.trustechfood.Model.Restaurnant;
import offical.com.trustechfood.R;
import offical.com.trustechfood.SQLite.SQLiteAdapter;

public class CustomerRestaurnantsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CustRestaurnantAdapter restaurnantAdapter;
    List<Restaurnant> restaurnants = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_restaurnants);
        recyclerView = (RecyclerView) findViewById(R.id.customer_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        restaurnantAdapter = new CustRestaurnantAdapter(CustomerRestaurnantsActivity.this,restaurnants);
        recyclerView.setAdapter(restaurnantAdapter);
        getRestaurnants();
    }

    private void getRestaurnants() {
        SQLiteAdapter adapter = new SQLiteAdapter(CustomerRestaurnantsActivity.this);
        restaurnants = adapter.getRestaurnants();
        restaurnantAdapter.setRestaurnantsList(restaurnants);
    }
}
