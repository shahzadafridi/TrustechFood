package offical.com.trustechfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import offical.com.trustechfood.Admin.Dashboard;
import offical.com.trustechfood.Model.Admin;
import offical.com.trustechfood.SQLite.SQLiteAdapter;
import offical.com.trustechfood.Util.AppConstant;

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
                SharedPreferences.Editor editor = AppConstant.getSharedPrefEditor(LoginActivity.this,"FoodApp");
                editor.putString("id",admin.getId());
                editor.putString("name",admin.getName());
                editor.putString("email",admin.getEmail());
                editor.putString("password",admin.getPassword());
                editor.putString("role",admin.getRole());
                editor.putBoolean("isLogin",true);
                editor.commit();
                if (admin.getRole().contentEquals("admin")){
                    Intent intent = new Intent(LoginActivity.this, Dashboard.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }else if (admin.getRole().contentEquals("customer")){

                }else if (admin.getRole().contentEquals("driver")){

                }
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

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences preferences = AppConstant.getSharedPref(LoginActivity.this,"FoodApp");
        boolean isLogin = preferences.getBoolean("isLogin",false);
        if (isLogin){
            Intent intent = new Intent(LoginActivity.this, Dashboard.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }
}
