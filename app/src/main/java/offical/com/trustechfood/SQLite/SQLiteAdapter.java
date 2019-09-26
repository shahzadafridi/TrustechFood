package offical.com.trustechfood.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import offical.com.trustechfood.Model.Admin;
import offical.com.trustechfood.Util.AppConstant;

public class SQLiteAdapter {

    Context context;
    SQLiteDatabase database;
    SQLiteOpenHelper helper;

    public SQLiteAdapter(Context context) {
        this.context = context;
        helper = new SQLiteHelper(context);
        database = helper.getWritableDatabase();
    }

    public void insertAdmin(String name, String email, String password, String role) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("password", password);
        contentValues.put("role", role);
        long isInsert = database.insert(AppConstant.ADMIN_TABLE_NAME, null, contentValues);
        if (isInsert == -1) {
            Toast.makeText(context, "Admin failed to register.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Admin registered successfully.", Toast.LENGTH_SHORT).show();
        }
    }

    public Admin getAdmin(String str_email, String str_password) {
        Cursor cursor = database.rawQuery(AppConstant.ADMINS, null);
        if (cursor.getCount() != -1) {
            while (cursor.moveToNext()) {
                String email = cursor.getString(cursor.getColumnIndex("email"));
                String password = cursor.getString(cursor.getColumnIndex("password"));
                if (email.contentEquals(str_email) && password.contentEquals(str_password)){
                    String id = cursor.getString(cursor.getColumnIndex("id"));
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    String role = cursor.getString(cursor.getColumnIndex("role"));
                    Admin admin = new Admin();
                    admin.setId(id);
                    admin.setEmail(email);
                    admin.setName(name);
                    admin.setPassword(password);
                    admin.setRole(role);
                    return admin;
                }
            }
        }
        return null;
    }


}