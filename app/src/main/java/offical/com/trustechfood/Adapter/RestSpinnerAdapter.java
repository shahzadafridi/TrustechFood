package offical.com.trustechfood.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import offical.com.trustechfood.Model.Restaurnant;
import offical.com.trustechfood.R;

public class RestSpinnerAdapter extends BaseAdapter {

    Context context;
    List<Restaurnant> restaurnantList;

    public RestSpinnerAdapter(Context context, List<Restaurnant> restaurnantList) {
        this.context = context;
        this.restaurnantList = restaurnantList;
    }

    @Override
    public int getCount() {
        return restaurnantList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Restaurnant restaurnant = restaurnantList.get(i);
        View view1 = LayoutInflater.from(context).inflate(R.layout.rest_spinner_layout,viewGroup,false);
        TextView tv = (TextView) view1.findViewById(R.id.rest_spinner_layout_tv);
        tv.setText(restaurnant.getName());
        return view1;
    }
}
