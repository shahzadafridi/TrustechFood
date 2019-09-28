package offical.com.trustechfood.Admin.Restaurnant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import offical.com.trustechfood.R;
import offical.com.trustechfood.SQLite.SQLiteAdapter;

public class AddRestuarnant extends AppCompatActivity implements View.OnClickListener{

    EditText name,address,contact,ratting,description;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_restuarnant);
        InitUI();
    }

    private void InitUI() {
        name = (EditText) findViewById(R.id.rest_name);
        address = (EditText) findViewById(R.id.rest_address);
        contact = (EditText) findViewById(R.id.rest_contact);
        ratting = (EditText) findViewById(R.id.rest_rating);
        description = (EditText) findViewById(R.id.rest_description);
        register = (Button) findViewById(R.id.rest_register);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String str_name = name.getText().toString();
        String str_address = address.getText().toString();
        String str_contact = contact.getText().toString();
        String str_ratting = ratting.getText().toString();
        String str_description = description.getText().toString();
        SQLiteAdapter adapter = new SQLiteAdapter(AddRestuarnant.this);
        adapter.insertRestaurnants(str_name,str_address,str_contact,str_ratting,str_description);

    }
}
