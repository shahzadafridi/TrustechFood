package offical.com.trustechfood.Customer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;

import java.util.List;

import offical.com.trustechfood.Adapter.CustFoodAdapter;
import offical.com.trustechfood.Adapter.CustRestaurnantAdapter;
import offical.com.trustechfood.Adapter.FoodAdapter;
import offical.com.trustechfood.Model.Food;
import offical.com.trustechfood.R;
import offical.com.trustechfood.SQLite.SQLiteAdapter;

public class CustomerFoodActivity extends AppCompatActivity {

    String id, name, address, contact, ratting, description;
    RecyclerView recyclerView;
    CustFoodAdapter foodAdapter;
    List<Food> foodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_food);
        id = getIntent().getStringExtra("id");
        name = getIntent().getStringExtra("name");
        address = getIntent().getStringExtra("address");
        contact = getIntent().getStringExtra("contact");
        ratting = getIntent().getStringExtra("ratting");
        description = getIntent().getStringExtra("description");

        recyclerView = (RecyclerView) findViewById(R.id.customer_food_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        foodAdapter = new CustFoodAdapter(CustomerFoodActivity.this,foodList);
        recyclerView.setAdapter(foodAdapter);
        getRestaurnants();
    }

    private void getRestaurnants() {
        SQLiteAdapter adapter = new SQLiteAdapter(CustomerFoodActivity.this);
        foodList = adapter.getRestaurnantFoods(name);
        foodAdapter.setFoodList(foodList);
    }
}
