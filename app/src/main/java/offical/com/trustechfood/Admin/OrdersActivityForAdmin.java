package offical.com.trustechfood.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import offical.com.trustechfood.Adapter.OrderAdapter;
import offical.com.trustechfood.Adapter.OrderAdapterForAdmin;
import offical.com.trustechfood.Model.Food;
import offical.com.trustechfood.Model.Order;
import offical.com.trustechfood.Model.OrderModel;
import offical.com.trustechfood.Model.Restaurnant;
import offical.com.trustechfood.R;
import offical.com.trustechfood.SQLite.SQLiteAdapter;

public class OrdersActivityForAdmin extends AppCompatActivity {
    RecyclerView recyclerView;
    OrderAdapterForAdmin orderAdapter;
    List<OrderModel> orderModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders_for_admin);
        recyclerView = (RecyclerView) findViewById(R.id.orderForAdmin_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SQLiteAdapter sqLiteAdapter = new SQLiteAdapter(this);
        List<Order> orders = sqLiteAdapter.getOrders();
        for (Order order: orders) {
            String id = order.getId();
            String restId = order.getRest_id();
            String foodId = order.getFood_id();
            String status = order.getStatus();

            Restaurnant restaurnant = sqLiteAdapter.searchRestaurnant(restId);
            Food food = sqLiteAdapter.searchFood(foodId);

            OrderModel orderModel = new OrderModel();
            orderModel.setId(id);
            orderModel.setStatus(status);
            orderModel.setRestaurnant(restaurnant);
            orderModel.setFood(food);
            orderModels.add(orderModel);
        }

        orderAdapter = new OrderAdapterForAdmin(this,orderModels,orders);
        recyclerView.setAdapter(orderAdapter);
    }
}
