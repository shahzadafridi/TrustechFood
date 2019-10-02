package offical.com.trustechfood.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;

import offical.com.trustechfood.Admin.FoodItem.AddFoodItem;
import offical.com.trustechfood.Admin.FoodItem.DisplayFoodItem;
import offical.com.trustechfood.Admin.Restaurnant.AddRestuarnant;
import offical.com.trustechfood.Admin.Restaurnant.DisplayRestaurnants;
import offical.com.trustechfood.R;

public class Dashboard extends AppCompatActivity implements View.OnClickListener {

    CardView display,add, addFood,displayFood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        display = (CardView) findViewById(R.id.display_restuanants);
        add = (CardView) findViewById(R.id.add_restuanants);
        addFood = (CardView) findViewById(R.id.add_food_item);
        displayFood = (CardView) findViewById(R.id.display_food_item);
        display.setOnClickListener(this);
        add.setOnClickListener(this);
        addFood.setOnClickListener(this);
        displayFood.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.display_restuanants){
            Intent intent = new Intent(Dashboard.this, DisplayRestaurnants.class);
            startActivity(intent);
        }else if (view.getId() == R.id.add_restuanants){
            Intent intent = new Intent(Dashboard.this, AddRestuarnant.class);
            startActivity(intent);
        }else if (view.getId() == R.id.add_food_item){
            Intent intent = new Intent(Dashboard.this, AddFoodItem.class);
            startActivity(intent);
        }else if (view.getId() == R.id.display_food_item){
            Intent intent = new Intent(Dashboard.this, DisplayFoodItem.class);
            startActivity(intent);
        }
    }
}
