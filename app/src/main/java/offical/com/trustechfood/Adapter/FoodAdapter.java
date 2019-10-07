package offical.com.trustechfood.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

import offical.com.trustechfood.Model.Food;
import offical.com.trustechfood.R;

public class FoodAdapter  extends RecyclerView.Adapter<FoodAdapter.MyViewHolder> {

    Context context;
    List<Food> foodList;

    public FoodAdapter(Context context, List<Food> foodList) {
        this.context = context;
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public FoodAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.food_item_layout,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.MyViewHolder holder, int position) {
        Food food = foodList.get(position);
        holder.restName.setText(food.getRestName());
        holder.name.setText(food.getName());
        holder.category.setText(food.getCategroy());
        holder.price.setText(food.getPrice());
        holder.ratting.setText(food.getRatting());
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public void setFoodList(List<Food> foodList){
        this.foodList = foodList;
        notifyDataSetChanged();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView restName,name,category,price,ratting;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            restName = (TextView) itemView.findViewById(R.id.food_item_rest_name);
            name = (TextView) itemView.findViewById(R.id.food_item_name);
            category = (TextView) itemView.findViewById(R.id.food_item_category);
            price = (TextView) itemView.findViewById(R.id.food_item_price);
            ratting = (TextView) itemView.findViewById(R.id.food_item_ratting);
        }
    }
}
