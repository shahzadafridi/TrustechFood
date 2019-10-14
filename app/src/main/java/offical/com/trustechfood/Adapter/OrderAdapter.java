package offical.com.trustechfood.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import offical.com.trustechfood.Model.Food;
import offical.com.trustechfood.Model.Order;
import offical.com.trustechfood.Model.OrderModel;
import offical.com.trustechfood.Model.Restaurnant;
import offical.com.trustechfood.R;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.MyViewHolder> {

    Context context;
    List<OrderModel> orderList;

    public OrderAdapter(Context context, List<OrderModel> orderList) {
        this.context = context;
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.order_item_layout,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        OrderModel orderModel = orderList.get(position);
        Restaurnant restaurnant = orderModel.getRestaurnant();
        Food food = orderModel.getFood();
        String status = orderModel.getStatus();

        holder.restName.setText("Restaurnant Name:"+restaurnant.getName());
        holder.foodName.setText("Food Name:"+food.getName());
        holder.status.setText("Status:"+status);
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView restName, foodName, status;
        Button detail;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            restName = (TextView) itemView.findViewById(R.id.order_rest_name);
            foodName = (TextView) itemView.findViewById(R.id.order_food_name);
            status = (TextView) itemView.findViewById(R.id.order_status);
            detail = (Button) itemView.findViewById(R.id.order_detail);
            detail.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    OrderModel orderModel = orderList.get(pos);
                    Restaurnant restaurnant = orderModel.getRestaurnant();
                    Food food = orderModel.getFood();

                    Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.order_detail_layout);
                    TextView restName = dialog.findViewById(R.id.order_detail_restName);
                    TextView restAddress = dialog.findViewById(R.id.order_detail_restAddress);
                    TextView restRatting = dialog.findViewById(R.id.order_detail_restRatting);
                    TextView foodName = dialog.findViewById(R.id.order_detail_foodName);
                    TextView foodPrice = dialog.findViewById(R.id.order_detail_foodPrice);
                    TextView foodRatting = dialog.findViewById(R.id.order_detail_ratting);
                    TextView status = dialog.findViewById(R.id.order_detail_status);

                    restName.setText("Rest name:"+restaurnant.getName());
                    restAddress.setText("Rest Address:"+restaurnant.getAddress());
                    restRatting.setText("Rest Ratting:"+restaurnant.getRatting());
                    foodName.setText("Food Name:"+food.getName());
                    foodPrice.setText("Food Price"+food.getPrice());
                    foodRatting.setText("Food Ratting:"+food.getRatting());

                    if (status.equals("pending")){
                        status.setBackground(context.getResources().getDrawable(R.drawable.status_pending_bg));
                    }
                    dialog.setCancelable(true);
                    dialog.show();

                }
            });
        }
    }
}
