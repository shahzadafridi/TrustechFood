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
import offical.com.trustechfood.Model.Restaurnant;
import offical.com.trustechfood.R;
import offical.com.trustechfood.SQLite.SQLiteAdapter;

public class RestaurnantAdapter extends RecyclerView.Adapter<RestaurnantAdapter.MyViewHolder> {

    Context context;
    List<Restaurnant> restaurnants;

    public RestaurnantAdapter(Context context, List<Restaurnant> restaurnants) {
        this.context = context;
        this.restaurnants = restaurnants;
    }

    @NonNull
    @Override
    public RestaurnantAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.restaurnant_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurnantAdapter.MyViewHolder holder, int position) {
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
        TextView name, contact, address, description, ratting, edit, delete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.rest_item_name);
            contact = (TextView) itemView.findViewById(R.id.rest_item_contact);
            description = (TextView) itemView.findViewById(R.id.rest_item_description);
            ratting = (TextView) itemView.findViewById(R.id.rest_item_ratting);
            address = (TextView) itemView.findViewById(R.id.rest_item_address);
            edit = (TextView) itemView.findViewById(R.id.rest_item_edit);
            delete = (TextView) itemView.findViewById(R.id.rest_item_delete);
            edit.setOnClickListener(this);
            delete.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();

            if (view.getId() == R.id.rest_item_edit) {
                Restaurnant restaurnant = restaurnants.get(position);
                Intent intent = new Intent(context, EditRestaurnant.class);
                intent.putExtra("id",restaurnant.getId());
                intent.putExtra("name",restaurnant.getName());
                intent.putExtra("address",restaurnant.getAddress());
                intent.putExtra("contact",restaurnant.getContact());
                intent.putExtra("ratting",restaurnant.getRatting());
                intent.putExtra("description",restaurnant.getDescription());
                context.startActivity(intent);

            } else if (view.getId() == R.id.rest_item_delete) {
                String str_id = restaurnants.get(position).getId();
                SQLiteAdapter adapter = new SQLiteAdapter(context);
                int i = adapter.deleteRestaurnant(str_id);
                if (i > 0) {
                    restaurnants.remove(position);
                    notifyDataSetChanged();
                }
            }
        }
    }

}
