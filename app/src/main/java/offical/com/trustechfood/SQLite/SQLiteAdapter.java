package offical.com.trustechfood.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import offical.com.trustechfood.Model.Admin;
import offical.com.trustechfood.Model.Food;
import offical.com.trustechfood.Model.Order;
import offical.com.trustechfood.Model.Restaurnant;
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
        String[] args = new String[]{str_email, str_password};
        Cursor cursor = database.query(AppConstant.ADMIN_TABLE_NAME, null, "email=? AND password=?", args, null, null, null);
        if (cursor.getCount() != -1) {
            while (cursor.moveToNext()) {
                String id = cursor.getString(cursor.getColumnIndex("id"));
                String email = cursor.getString(cursor.getColumnIndex("email"));
                String password = cursor.getString(cursor.getColumnIndex("password"));
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
        return null;
    }


    /*
     *  Restaurnants Operation
     * Insert
     * Get Orders
     * Update
     * Delete
     *
     * */


    public void insertRestaurnants(String name, String address, String contact, String ratting, String description) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("address", address);
        contentValues.put("contact", contact);
        contentValues.put("ratting", ratting);
        contentValues.put("description", description);
        long isInsert = database.insert(AppConstant.RESTAU_TABLE_NAME, null, contentValues);
        if (isInsert == -1) {
            Toast.makeText(context, "Restaurnant failed to register.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Restaurnant registered successfully.", Toast.LENGTH_SHORT).show();
        }
    }

    public List<Restaurnant> getRestaurnants() {
        Cursor cursor = database.rawQuery(AppConstant.RESTAURNANTS, null);
        if (cursor.getCount() != -1) {
            List<Restaurnant> restaurnants = new ArrayList<>();
            while (cursor.moveToNext()) {
                String id = String.valueOf(cursor.getInt(cursor.getColumnIndex("id")));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String address = cursor.getString(cursor.getColumnIndex("address"));
                String contact = cursor.getString(cursor.getColumnIndex("contact"));
                String ratting = cursor.getString(cursor.getColumnIndex("ratting"));
                String description = cursor.getString(cursor.getColumnIndex("description"));
                Restaurnant restaurnant = new Restaurnant();
                restaurnant.setId(id);
                restaurnant.setName(name);
                restaurnant.setAddress(address);
                restaurnant.setContact(contact);
                restaurnant.setRatting(ratting);
                restaurnant.setDescription(description);
                restaurnants.add(restaurnant);
            }
            return restaurnants;
        }
        return null;
    }

    public int updateRestaurnant(String id, String name, String address, String contact, String ratting, String description) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("address", address);
        contentValues.put("contact", contact);
        contentValues.put("ratting", ratting);
        contentValues.put("description", description);
        String[] args = new String[]{id};
        int i = database.update(AppConstant.RESTAU_TABLE_NAME, contentValues, "id=?", args);
        if (i > 0) {
            Toast.makeText(context, "Restaurnant updated successfully.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Restaurnant failed to update.", Toast.LENGTH_SHORT).show();
        }
        return i;
    }

    public int deleteRestaurnant(String id) {
        String[] args = new String[]{id};
        int i = database.delete(AppConstant.RESTAU_TABLE_NAME, "id=?", args);
        if (i > 0) {
            Toast.makeText(context, "Restaurnant deleted successfully.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Restaurnant failed to delete.", Toast.LENGTH_SHORT).show();
        }
        return i;
    }


    /*
     *  Food Operation
     * Insert
     * Get Food
     * Update
     * Delete
     *
     * */

    public void insertFood(String rest_id,String restName, String FoodName, String category, String ratting, String price) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("rest_id",rest_id);
        contentValues.put("restName", restName);
        contentValues.put("name", FoodName);
        contentValues.put("category", category);
        contentValues.put("price", price);
        contentValues.put("ratting", ratting);

        long isInsert = database.insert(AppConstant.FOOD_TABLE_NAME, null, contentValues);
        if (isInsert == -1) {
            Toast.makeText(context, "Food item failed to register.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Food item registered successfully.", Toast.LENGTH_SHORT).show();
        }
    }

    public List<Food> getFoods() {
        Cursor cursor = database.rawQuery(AppConstant.FOODS, null);
        if (cursor.getCount() != -1) {
            List<Food> foods = new ArrayList<>();
            while (cursor.moveToNext()) {
                String id = String.valueOf(cursor.getInt(cursor.getColumnIndex("id")));
                String rest_id = String.valueOf(cursor.getInt(cursor.getColumnIndex("rest_id")));
                String restName = cursor.getString(cursor.getColumnIndex("food_id"));
                String name = cursor.getString(cursor.getColumnIndex("rest_id"));
                String category = cursor.getString(cursor.getColumnIndex("status"));
                String ratting = cursor.getString(cursor.getColumnIndex("ratting"));
                String price = cursor.getString(cursor.getColumnIndex("price"));
                Food food = new Food();
                food.setId(id);
                food.setRest_id(rest_id);
                food.setRestName(restName);
                food.setCategroy(category);
                food.setName(name);
                food.setPrice(price);
                food.setRatting(ratting);
                foods.add(food);
            }
            return foods;
        }
        return null;
    }

    public int deleteFoodItem(String id) {
        String[] args = new String[]{id};
        int i = database.delete(AppConstant.FOOD_TABLE_NAME, "id=?", args);
        if (i > 0) {
            Toast.makeText(context, "Food item deleted successfully.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Food item failed to delete.", Toast.LENGTH_SHORT).show();
        }
        return i;
    }

    public int updateFoodItem(String id,String rest_id, String restName, String name, String category, String price, String ratting) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("rest_id",rest_id);
        contentValues.put("restName", restName);
        contentValues.put("name", name);
        contentValues.put("category", category);
        contentValues.put("price", price);
        contentValues.put("ratting", ratting);
        String[] args = new String[]{id};
        int i = database.update(AppConstant.FOOD_TABLE_NAME, contentValues, "id=?", args);
        if (i > 0) {
            Toast.makeText(context, "Food item updated successfully.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Food item failed to update.", Toast.LENGTH_SHORT).show();
        }
        return i;
    }

    public List<Food> getRestaurnantFoods(String rest_name) {
        Cursor cursor = database.rawQuery(AppConstant.FOODS, null);
        if (cursor.getCount() != -1) {
            List<Food> foods = new ArrayList<>();
            while (cursor.moveToNext()) {
                String id = String.valueOf(cursor.getInt(cursor.getColumnIndex("id")));
                String rest_id = String.valueOf(cursor.getInt(cursor.getColumnIndex("rest_id")));
                String restName = cursor.getString(cursor.getColumnIndex("restName"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String category = cursor.getString(cursor.getColumnIndex("category"));
                String ratting = cursor.getString(cursor.getColumnIndex("ratting"));
                String price = cursor.getString(cursor.getColumnIndex("price"));
                if (rest_name.contentEquals(restName)) {
                    Food food = new Food();
                    food.setId(id);
                    food.setRest_id(rest_id);
                    food.setRestName(restName);
                    food.setCategroy(category);
                    food.setName(name);
                    food.setPrice(price);
                    food.setRatting(ratting);
                    foods.add(food);
                }
            }
            return foods;
        }
        return null;
    }


    /*
    * Order Operation
    * Insert
    * Get Orders
    * Update
    * Delete
    *
    * */

    public void insertOrder(String food_id, String rest_id, String status) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("food_id", food_id);
        contentValues.put("rest_id", rest_id);
        contentValues.put("status", status);
        long isInsert = database.insert(AppConstant.ORDER_TABLE_NAME, null, contentValues);
        if (isInsert == -1) {
            Toast.makeText(context, "Order Created Successfully.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Order failed to create.", Toast.LENGTH_SHORT).show();
        }
    }

    public List<Order> getOrders() {
        Cursor cursor = database.rawQuery(AppConstant.ORDER, null);
        if (cursor.getCount() != -1) {
            List<Order> orders = new ArrayList<>();
            while (cursor.moveToNext()) {
                String id = String.valueOf(cursor.getInt(cursor.getColumnIndex("id")));
                String food_id = cursor.getString(cursor.getColumnIndex("food_id"));
                String rest_id = cursor.getString(cursor.getColumnIndex("rest_id"));
                String status = cursor.getString(cursor.getColumnIndex("status"));

                Order order = new Order();
                order.setId(id);
                order.setFood_id(food_id);
                order.setRest_id(rest_id);
                order.setStatus(status);

                orders.add(order);
            }
            return orders;
        }
        return null;
    }


    public int updateOrder(String id,String food_id, String rest_id, String status) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", id);
        contentValues.put("food_id", food_id);
        contentValues.put("rest_id", rest_id);
        contentValues.put("status", status);
        String[] args = new String[]{id};
        int i = database.update(AppConstant.ORDER_TABLE_NAME, contentValues, "id=?", args);
        if (i > 0) {
            Toast.makeText(context, "Order updated successfully.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Order failed to update.", Toast.LENGTH_SHORT).show();
        }
        return i;
    }


    public int deleteOrder(String id) {
        String[] args = new String[]{id};
        int i = database.delete(AppConstant.ORDER_TABLE_NAME, "id=?", args);
        if (i > 0) {
            Toast.makeText(context, "Order deleted successfully.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Order failed to delete.", Toast.LENGTH_SHORT).show();
        }
        return i;
    }

}
