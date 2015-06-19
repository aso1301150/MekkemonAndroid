package com.example.mekkemon;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.kaiintouroku);
		//Viewの取得
		ImageView picture = (ImageView)findViewById(R.id.ImageView02);
		//ボタンがタップされたら
		picture.setOnClickListener(new View.OnClickListener() {

			//タップされたら指定した画面に遷移する
			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				Intent i = new Intent(MainActivity.this,Map.class);
				startActivity(i);
			}
		});

		ImageView picture2 = (ImageView)findViewById(R.id.imageView5);
		picture2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				Intent i2 = new Intent(MainActivity.this,Misetuika.class);
				startActivity(i2);

			}
		});
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
