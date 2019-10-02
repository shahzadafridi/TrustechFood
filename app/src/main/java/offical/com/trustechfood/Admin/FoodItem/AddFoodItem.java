package offical.com.trustechfood.Admin.FoodItem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import offical.com.trustechfood.R;

public class AddFoodItem extends AppCompatActivity implements View.OnClickListener {

    EditText name,category,ratting,price;
    Button addFoodItem;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food_item);
        InitUI();
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

    @Override
    public void onClick(View view) {
        String str_name = name.getText().toString();
        String str_category = category.getText().toString();
        String str_price = price.getText().toString();
        String str_ratting = ratting.getText().toString();
    }
}
