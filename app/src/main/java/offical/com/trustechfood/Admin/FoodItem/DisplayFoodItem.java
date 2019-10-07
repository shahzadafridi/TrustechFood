package offical.com.trustechfood.Admin.FoodItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import offical.com.trustechfood.Adapter.FoodAdapter;
import offical.com.trustechfood.Adapter.RestaurnantAdapter;
import offical.com.trustechfood.Model.Food;
import offical.com.trustechfood.Model.Restaurnant;
import offical.com.trustechfood.R;
import offical.com.trustechfood.SQLite.SQLiteAdapter;

public class DisplayFoodItem extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Food> foods = new ArrayList<>();
    FoodAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_food_item);
        recyclerView = (RecyclerView)findViewById(R.id.display_foodItem_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new FoodAdapter(this,foods);
        recyclerView.setAdapter(adapter);
        getRestaurnantsFromDB();
    }

    private void getRestaurnantsFromDB() {
        SQLiteAdapter sqLiteAdapter = new SQLiteAdapter(this);
        foods = sqLiteAdapter.getFoods();
        adapter.setFoodList(foods);

    }
}
