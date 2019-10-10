package offical.com.trustechfood.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

import offical.com.trustechfood.Admin.FoodItem.EditFoodItem;
import offical.com.trustechfood.Admin.Restaurnant.EditRestaurnant;
import offical.com.trustechfood.Customer.CustOrderActivity;
import offical.com.trustechfood.Model.Food;
import offical.com.trustechfood.Model.Restaurnant;
import offical.com.trustechfood.R;
import offical.com.trustechfood.SQLite.SQLiteAdapter;

public class CustFoodAdapter extends RecyclerView.Adapter<CustFoodAdapter.MyViewHolder> {

    Context context;
    List<Food> foodList;

    public CustFoodAdapter(Context context, List<Food> foodList) {
        this.context = context;
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public CustFoodAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cust_food_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustFoodAdapter.MyViewHolder holder, int position) {
        Food food = foodList.get(position);
        holder.restName.setText("Restaurnant: "+food.getRestName());
        holder.name.setText("Name: "+food.getName());
        holder.category.setText("Category: "+food.getCategroy());
        holder.price.setText("Price: "+food.getPrice());
        holder.ratting.setText("Ratting: "+food.getRatting());
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
        notifyDataSetChanged();
    }


    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView restName, name, category, price, ratting;
        Button order;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            restName = (TextView) itemView.findViewById(R.id.cust_food_item_rest_name);
            name = (TextView) itemView.findViewById(R.id.cust_food_item_name);
            category = (TextView) itemView.findViewById(R.id.cust_food_item_category);
            price = (TextView) itemView.findViewById(R.id.cust_food_item_price);
            ratting = (TextView) itemView.findViewById(R.id.cust_food_item_ratting);
            order = (Button) itemView.findViewById(R.id.cust_food_item_order);
            order.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            final Food food = foodList.get(position);

            androidx.appcompat.app.AlertDialog.Builder builder = new AlertDialog.Builder(context)
                    .setTitle("Do you want to order?")
                    .setMessage("If you want to order the food then please click yes button.")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            SQLiteAdapter adapter = new SQLiteAdapter(context);
                            adapter.insertOrder(food.getId(),food.getRest_id(),"pending");
                            // Intent inten = new Intent(context, CustOrderActivity.class);
                            context.startActivity(new Intent(context, CustOrderActivity.class));
                        }
                    }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
            builder.create();
            builder.show();

//            Intent intent = new Intent(context, EditFoodItem.class);
//            intent.putExtra("id", food.getId());
//            intent.putExtra("name", food.getName());
//            intent.putExtra("category", food.getCategroy());
//            intent.putExtra("restName", food.getRestName());
//            intent.putExtra("ratting", food.getRatting());
//            intent.putExtra("price", food.getPrice());
//            context.startActivity(intent);

        }
    }
}
