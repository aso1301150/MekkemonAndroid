/**
 *
 */
package com.example.mekkemon;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author student
 *
 */
public class DBManager extends SQLiteOpenHelper {

	/* (非 Javadoc)
	 * @see android.database.sqlite.SQLiteOpenHelper#onCreate(android.database.sqlite.SQLiteDatabase)
	 */
	/**
	 * @param context 呼び出し元（自分自身）
	 * @param name    利用者DB名
	 * @param factory
	 * @param version DBバージョン（1~）
	 */
	public DBManager(Context context) {
		super(context,"mekkemon.sqlite3",null,1);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO 自動生成されたメソッド・スタブ

		db.execSQL("CPEAT TABLE IF NOT EXISTS"+
		"mekkemon(shopid INTEGER PRIMARY KEY AUTOINCREMENT,shopname TEXT,photo BLOB,genreid INTEGER,price INTEGER,comment TEXT)");

	}

	/* (非 Javadoc)
	 * @see android.database.sqlite.SQLiteOpenHelper#onUpgrade(android.database.sqlite.SQLiteDatabase, int, int)
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO 自動生成されたメソッド・スタブ
		db.execSQL("DROP TABLE mekkemon");
		onCreate(db);

	}


}
