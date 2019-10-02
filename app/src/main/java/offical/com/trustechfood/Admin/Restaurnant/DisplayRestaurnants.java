package offical.com.trustechfood.Admin.Restaurnant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import offical.com.trustechfood.Adapter.RestaurnantAdapter;
import offical.com.trustechfood.Model.Restaurnant;
import offical.com.trustechfood.R;
import offical.com.trustechfood.SQLite.SQLiteAdapter;

public class DisplayRestaurnants extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Restaurnant> restaurnants = new ArrayList<>();
    RestaurnantAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_restaurnants);
        recyclerView = (RecyclerView)findViewById(R.id.display_restuanants_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RestaurnantAdapter(this,restaurnants);
        recyclerView.setAdapter(adapter);
        getRestaurnantsFromDB();
    }

    private void getRestaurnantsFromDB() {
        SQLiteAdapter sqLiteAdapter = new SQLiteAdapter(this);
        restaurnants = sqLiteAdapter.getRestaurnants();
        adapter.setRestaurnantsList(restaurnants);
    }
}
