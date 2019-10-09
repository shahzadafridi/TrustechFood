package offical.com.trustechfood.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import offical.com.trustechfood.Admin.Restaurnant.EditRestaurnant;
import offical.com.trustechfood.Customer.CustomerFoodActivity;
import offical.com.trustechfood.Model.Restaurnant;
import offical.com.trustechfood.R;
import offical.com.trustechfood.SQLite.SQLiteAdapter;

public class CustRestaurnantAdapter extends RecyclerView.Adapter<CustRestaurnantAdapter.MyViewHolder> {

    Context context;
    List<Restaurnant> restaurnants;

    public CustRestaurnantAdapter(Context context, List<Restaurnant> restaurnants) {
        this.context = context;
        this.restaurnants = restaurnants;
    }

    @NonNull
    @Override
    public CustRestaurnantAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cust_restaurnant_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustRestaurnantAdapter.MyViewHolder holder, int position) {
        Restaurnant restaurnant = restaurnants.get(position);
        holder.name.setText(restaurnant.getName());
        holder.contact.setText(restaurnant.getContact());
        holder.address.setText(restaurnant.getAddress());
        holder.ratting.setText(restaurnant.getRatting());
        holder.description.setText(restaurnant.getDescription());
    }

    @Override
    public int getItemCount() {
        return restaurnants.size();
    }

    public void setRestaurnantsList(List<Restaurnant> restaurnantsList) {
        this.restaurnants = restaurnantsList;
        notifyDataSetChanged();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name, contact, address, description, ratting;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.cust_rest_item_name);
            contact = (TextView) itemView.findViewById(R.id.cust_rest_item_contact);
            description = (TextView) itemView.findViewById(R.id.cust_rest_item_description);
            ratting = (TextView) itemView.findViewById(R.id.cust_rest_item_ratting);
            address = (TextView) itemView.findViewById(R.id.cust_rest_item_address);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
                Restaurnant restaurnant = restaurnants.get(position);
                Intent intent = new Intent(context, CustomerFoodActivity.class);
                intent.putExtra("id",restaurnant.getId());
                intent.putExtra("name",restaurnant.getName());
                intent.putExtra("address",restaurnant.getAddress());
                intent.putExtra("contact",restaurnant.getContact());
                intent.putExtra("ratting",restaurnant.getRatting());
                intent.putExtra("description",restaurnant.getDescription());
                context.startActivity(intent);
        }
    }

}
