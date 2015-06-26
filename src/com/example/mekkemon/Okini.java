/**
 *
 */
package com.example.mekkemon;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

/**
 * @author student
 *
 */
public class Okini extends Activity {

	private SQLiteDatabase sqlDB;
	DBManager dbm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(savedInstanceState);
		setContentView(R.layout.okini);
	}
}
