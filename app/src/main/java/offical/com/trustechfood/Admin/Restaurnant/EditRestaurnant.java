package offical.com.trustechfood.Admin.Restaurnant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import offical.com.trustechfood.R;
import offical.com.trustechfood.SQLite.SQLiteAdapter;

public class EditRestaurnant extends AppCompatActivity {


    EditText name, address, contact, ratting, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_restaurnant);
        InitUI();
    }

    private void InitUI() {
        name = (EditText) findViewById(R.id.edit_name);
        address = (EditText) findViewById(R.id.edit_address);
        contact = (EditText) findViewById(R.id.edit_contact);
        ratting = (EditText) findViewById(R.id.edit_rating);
        description = (EditText) findViewById(R.id.edit_description);
        name.setText(getIntent().getStringExtra("name"));
        address.setText(getIntent().getStringExtra("address"));
        contact.setText(getIntent().getStringExtra("contact"));
        ratting.setText(getIntent().getStringExtra("ratting"));
        description.setText(getIntent().getStringExtra("description"));
    }

    public void Update(View view) {
        String str_name = name.getText().toString();
        String str_address = address.getText().toString();
        String str_contact = contact.getText().toString();
        String str_ratting = ratting.getText().toString();
        String str_description = description.getText().toString();
        SQLiteAdapter adapter = new SQLiteAdapter(this);
        adapter.updateRestaurnant(getIntent().getStringExtra("id"), str_name, str_address, str_contact, str_ratting, str_description);
        Intent intent = new Intent(EditRestaurnant.this, DisplayRestaurnants.class);
        startActivity(intent);
    }
}
