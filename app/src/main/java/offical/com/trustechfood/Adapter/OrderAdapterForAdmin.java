package offical.com.trustechfood.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.util.Log;
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
import offical.com.trustechfood.SQLite.SQLiteAdapter;

public class OrderAdapterForAdmin extends RecyclerView.Adapter<OrderAdapterForAdmin.MyViewHolder> {

    Context context;
    List<OrderModel> orderList;
    List<Order> orders;

    public OrderAdapterForAdmin(Context context, List<OrderModel> orderList,List<Order> orders) {
        this.context = context;
        this.orderList = orderList;
        this.orders = orders;
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
                    dialog.setContentView(R.layout.order_detail_layout_admin);
                    TextView restName = dialog.findViewById(R.id.order_detail_admin_restName);
                    TextView restAddress = dialog.findViewById(R.id.order_detail_admin_restAddress);
                    TextView restRatting = dialog.findViewById(R.id.order_detail_admin_restRatting);
                    TextView foodName = dialog.findViewById(R.id.order_detail_admin_foodName);
                    TextView foodPrice = dialog.findViewById(R.id.order_detail_admin_foodPrice);
                    TextView foodRatting = dialog.findViewById(R.id.order_detail_admin_ratting);
                    TextView status = dialog.findViewById(R.id.order_detail_admin_status);
                    Button decline =dialog.findViewById(R.id.order_detail_admin_decline);
                    Button approve =dialog.findViewById(R.id.order_detail_admin_approve);
                    decline.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            SQLiteAdapter sqLiteAdaptera = new SQLiteAdapter(context);
                            int i = getAdapterPosition();
                            sqLiteAdaptera.updateOrder(orders.get(i).getId(),orders.get(i).getFood_id(),orders.get(i).getFood_id(),"rejected");
                        }
                    });
                    approve.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            SQLiteAdapter sqLiteAdaptera = new SQLiteAdapter(context);
                            int i = getAdapterPosition();
                            sqLiteAdaptera.updateOrder(orders.get(i).getId(),orders.get(i).getFood_id(),orders.get(i).getFood_id(),"accepted");
                        }
                    });
                    restName.setText("Rest name:"+restaurnant.getName());
                    restAddress.setText("Rest Address:"+restaurnant.getAddress());
                    restRatting.setText("Rest Ratting:"+restaurnant.getRatting());
                    foodName.setText("Food Name:"+food.getName());
                    foodPrice.setText("Food Price"+food.getPrice());
                    foodRatting.setText("Food Ratting:"+food.getRatting());

                    if (orders.get(getAdapterPosition()).getStatus().equals("pending") || orders.get(getAdapterPosition()).getStatus().equals("rejected")){
                        status.setBackground(context.getResources().getDrawable(R.drawable.status_pending_bg));
                        status.setText(orders.get(getAdapterPosition()).getStatus());
                        status.setTextColor(context.getResources().getColor(R.color.reject));
                    }
                    if (orders.get(getAdapterPosition()).getStatus().equals("accepted")){
                        status.setBackground(context.getResources().getDrawable(R.drawable.status_active_bg));
                        status.setText(orders.get(getAdapterPosition()).getStatus());
                        status.setTextColor(context.getResources().getColor(R.color.active));
                    }

                    dialog.setCancelable(true);
                    dialog.show();

                }
            });
        }

    }
}
