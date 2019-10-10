package offical.com.trustechfood.Admin.FoodItem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

import offical.com.trustechfood.Adapter.RestSpinnerAdapter;
import offical.com.trustechfood.Admin.Restaurnant.DisplayRestaurnants;
import offical.com.trustechfood.Admin.Restaurnant.EditRestaurnant;
import offical.com.trustechfood.Model.Restaurnant;
import offical.com.trustechfood.R;
import offical.com.trustechfood.SQLite.SQLiteAdapter;

public class EditFoodItem extends AppCompatActivity {


    EditText name, category, price, ratting;
    Spinner spinner;
    SQLiteAdapter adapter;
    List<Restaurnant> restaurnantList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_food_item);
        InitUI();
        adapter = new SQLiteAdapter(EditFoodItem.this);
        loadSpinner();
    }

    private void InitUI() {
        name = (EditText) findViewById(R.id.editfoodItem_name);
        category = (EditText) findViewById(R.id.editfoodItem_category);
        price = (EditText) findViewById(R.id.editfoodItem_price);
        ratting = (EditText) findViewById(R.id.editfoodItem_rating);
        spinner = (Spinner) findViewById(R.id.editfoodItem_listRestaurnants);
        name.setText(getIntent().getStringExtra("name"));
        category.setText(getIntent().getStringExtra("category"));
        price.setText(getIntent().getStringExtra("price"));
        ratting.setText(getIntent().getStringExtra("ratting"));

    }

    private void loadSpinner() {
        restaurnantList = adapter.getRestaurnants();
        RestSpinnerAdapter spinnerAdapter = new RestSpinnerAdapter(EditFoodItem.this,restaurnantList);
        spinner.setAdapter(spinnerAdapter);
    }

    public void Update(View view) {
        int i =  spinner.getSelectedItemPosition();
        String str_rest_name = restaurnantList.get(i).getName();
        String str_name = name.getText().toString();
        String str_category = category.getText().toString();
        String str_price = price.getText().toString();
        String str_ratting = ratting.getText().toString();
        SQLiteAdapter adapter = new SQLiteAdapter(this);
        adapter.updateFoodItem(restaurnantList.get(i).getId(),getIntent().getStringExtra("id"), str_rest_name, str_name, str_category, str_price, str_ratting);
        Intent intent = new Intent(EditFoodItem.this, DisplayFoodItem.class);
        startActivity(intent);
    }
}
