package offical.com.trustechfood.Registration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import offical.com.trustechfood.R;
import offical.com.trustechfood.SQLite.SQLiteAdapter;

public class AdminRegistration extends AppCompatActivity {

    EditText name, email,password,confirmPassword;
    String TAG = "AdminRegistration";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_registration);
        InitUI();
    }

    private void InitUI() {
        name = (EditText) findViewById(R.id.admin_name);
        email = (EditText) findViewById(R.id.admin_email);
        password = (EditText) findViewById(R.id.admin_password);
        confirmPassword = (EditText) findViewById(R.id.admin_confirmPassowrd);
    }


    public void Register(View view) {
        String str_name = name.getText().toString();
        String str_email = email.getText().toString();
        String str_password = password.getText().toString();
        String str_confirm_password = confirmPassword.getText().toString();

        if (Validation(str_name,str_email,str_password,str_confirm_password)){
            SQLiteAdapter adapter = new SQLiteAdapter(AdminRegistration.this);
            adapter.insertAdmin(str_name,str_email,str_password,"admin");
        }else {
            Toast.makeText(this,"Invalid detail entered",Toast.LENGTH_SHORT).show();
        }
    }

    private boolean Validation(String str_name, String str_email, String str_password, String str_confirm_password) {
        boolean isValid = true;
        if (TextUtils.isEmpty(str_name)){
            isValid = false;
            name.setError("Enter name");
        }

        if (TextUtils.isEmpty(str_email)){
            isValid = false;
            email.setError("Enter email");
        }

        if (TextUtils.isEmpty(str_password)){
            isValid = false;
            password.setError("Enter Password");
        }

        if (TextUtils.isEmpty(str_confirm_password)){
            isValid = false;
            confirmPassword.setError("Enter Confirm Password");
        }

        if (!str_password.contentEquals(str_confirm_password)){
            isValid = false;
            confirmPassword.setError("Password doesn't match");
        }

        return isValid;
    }

}
