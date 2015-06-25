package com.example.mekkemon;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class Misetuika extends Activity {

	private SQLiteDatabase sqlDB;
	DBManager dbm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(savedInstanceState);
		setContentView(R.layout.misetuika);
	}

	protected void onResume() {
		super.onResume();
		dbm = new DBManager(this);
		sqlDB = dbm.getWritableDatabase();
	}

	protected void onPause() {
		super.onPause();
		sqlDB.close();
	}
}
