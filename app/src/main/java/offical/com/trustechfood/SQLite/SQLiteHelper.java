package offical.com.trustechfood.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import offical.com.trustechfood.Util.AppConstant;

public class SQLiteHelper extends SQLiteOpenHelper {

    public SQLiteHelper(@Nullable Context context) {
        super(context, AppConstant.DB_NAME,null,AppConstant.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(AppConstant.ADMIN_TABLE);
        sqLiteDatabase.execSQL(AppConstant.ORDER_TABLE);
        sqLiteDatabase.execSQL(AppConstant.FOOD_TABLE);
        sqLiteDatabase.execSQL(AppConstant.RESTU_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+AppConstant.ADMIN_TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+AppConstant.RESTAU_TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+AppConstant.FOOD_TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+AppConstant.ORDER_TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
