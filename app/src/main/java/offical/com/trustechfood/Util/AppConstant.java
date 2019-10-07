package offical.com.trustechfood.Util;

import android.content.Context;
import android.content.SharedPreferences;

public class AppConstant {

    public static String DB_NAME = "trustechfood.db";
    public static int DB_VERSION = 3;

    //Table names
    public static String ADMIN_TABLE_NAME = "ADMIN";
    public static String RESTAU_TABLE_NAME = "RESTAURANANTS";
    public static String FOOD_TABLE_NAME = "FOOD";

    //Create queries
    public static String ADMIN_TABLE = "CREATE TABLE ADMIN (\n" +
            "    id int AUTO_INCREMENT,\n" +
            "    name varchar(255) NOT NULL,\n" +
            "    email varchar(255) NOT NULL,\n" +
            "    password varchar(255) NOT NULL,\n" +
            "    role varchar(255) NOT NULL,\n" +
            "    PRIMARY KEY (id));";

    public static String RESTU_TABLE = "CREATE TABLE RESTAURANANTS (\n" +
            "    id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
            "    name varchar(255) NOT NULL,\n" +
            "    address varchar(255) NOT NULL,\n" +
            "    ratting varchar(255) NOT NULL,\n" +
            "    contact varchar(255) NOT NULL,\n" +
            "    description varchar(400) NOT NULL);";

    public static String FOOD_TABLE = "CREATE TABLE FOOD(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,restName  varchar(255), name varchar(255) NOT NULL,category varchar(255) NOT NULL,ratting varchar(255) NOT NULL,price varchar(400) NOT NULL);";


    //Select querires
    public static String ADMINS = "select * from "+ADMIN_TABLE_NAME;
    public static String RESTAURNANTS = "select * from "+RESTAU_TABLE_NAME;
    public static String FOODS = "select * from "+FOOD_TABLE_NAME;

    //Sharedprefrences

    public static SharedPreferences getSharedPref(Context context, String Name){
        SharedPreferences sharedPreferences = context.getSharedPreferences(Name,Context.MODE_PRIVATE);
        return sharedPreferences;
    }

    public static SharedPreferences.Editor getSharedPrefEditor(Context context, String Name){
        SharedPreferences.Editor editor = getSharedPref(context,Name).edit();
        return editor;
    }

}
