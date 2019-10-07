package offical.com.trustechfood.Admin.FoodItem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.List;

import offical.com.trustechfood.Adapter.RestSpinnerAdapter;
import offical.com.trustechfood.Model.Restaurnant;
import offical.com.trustechfood.R;
import offical.com.trustechfood.SQLite.SQLiteAdapter;

public class AddFoodItem extends AppCompatActivity implements View.OnClickListener {

    EditText name,category,ratting,price;
    Button addFoodItem;
    Spinner spinner;
    String str_rest_name;
    SQLiteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food_item);
        InitUI();
        adapter = new SQLiteAdapter(AddFoodItem.this);
        loadSpinner();
    }

    private void InitUI() {
        name = (EditText) findViewById(R.id.foodItem_name);
        category = (EditText) findViewById(R.id.foodItem_category);
        price = (EditText) findViewById(R.id.foodItem_price);
        ratting = (EditText) findViewById(R.id.foodItem_rating);
        spinner = (Spinner) findViewById(R.id.foodItem_listRestaurnants);
        addFoodItem = (Button) findViewById(R.id.addFoodItem);
        addFoodItem.setOnClickListener(this);
    }

    private void loadSpinner() {
        final List<Restaurnant> restaurnantList = adapter.getRestaurnants();
        RestSpinnerAdapter spinnerAdapter = new RestSpinnerAdapter(AddFoodItem.this,restaurnantList);
        spinner.setAdapter(spinnerAdapter);
        int i =  spinner.getSelectedItemPosition();
        str_rest_name = restaurnantList.get(i).getName();
    }

    @Override
    public void onClick(View view) {
        String str_name = name.getText().toString();
        String str_category = category.getText().toString();
        String str_price = price.getText().toString();
        String str_ratting = ratting.getText().toString();
        adapter.insertFood(str_rest_name,str_name,str_category,str_price,str_ratting);
    }
}
