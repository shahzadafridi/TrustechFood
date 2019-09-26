package offical.com.trustechfood;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import offical.com.trustechfood.Model.Admin;
import offical.com.trustechfood.SQLite.SQLiteAdapter;

public class LoginActivity extends AppCompatActivity {

    EditText email,password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        InitUI();
    }

    private void InitUI() {
        email = (EditText) findViewById(R.id.login_email);
        password = (EditText) findViewById(R.id.login_password);
    }

    public void Login(View view) {
        String str_email = email.getText().toString();
        String str_password = password.getText().toString();

        if (Validation(str_email,str_password)){
            SQLiteAdapter adapter = new SQLiteAdapter(LoginActivity.this);
            Admin admin = adapter.getAdmin(str_email,str_password);
            if (admin != null){
                Log.e("Login", admin.getName());
                Log.e("Login","User successfully login");
            }else {
                Log.e("Login","User failed to login");
            }
        }else {
            Toast.makeText(LoginActivity.this,"Enter email and password",Toast.LENGTH_SHORT).show();
        }
    }


    private boolean Validation(String str_email, String str_password) {
        boolean isValid = true;

        if (TextUtils.isEmpty(str_email)){
            isValid = false;
            email.setError("Enter email");
        }

        if (TextUtils.isEmpty(str_password)){
            isValid = false;
            password.setError("Enter Password");
        }

        return isValid;
    }
}
