package offical.com.trustechfood.Util;

import android.content.Context;
import android.content.SharedPreferences;

public class AppConstant {

    public static String DB_NAME = "trustechfood.db";
    public static int DB_VERSION = 3;

    //Table names
    public static String ADMIN_TABLE_NAME = "ADMIN";

    //Create queries
    public static String ADMIN_TABLE = "CREATE TABLE ADMIN (\n" +
            "    id int AUTO_INCREMENT,\n" +
            "    name varchar(255) NOT NULL,\n" +
            "    email varchar(255) NOT NULL,\n" +
            "    password varchar(255) NOT NULL,\n" +
            "    role varchar(255) NOT NULL,\n" +
            "    PRIMARY KEY (id));";

    //Select querires
    public static String ADMINS = "select * from "+ADMIN_TABLE_NAME;

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
