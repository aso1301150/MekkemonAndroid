package com.example.mekkemon;

import jp.co.yahoo.android.maps.GeoPoint;
import jp.co.yahoo.android.maps.MapController;
import jp.co.yahoo.android.maps.MapView;
import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Map extends Activity implements LocationListener{
	LocationManager mLocationMaganer = null;
	MapView mMapView = null;
	int lastLatitude = 0;
	int lastLongitude =0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
	}
	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();
		mMapView = new MapView(this,"dj0zaiZpPThDdGw3UTdJaXIxVCZzPWNvbnN1bWVyc2VjcmV0Jng9MGY-");
		mMapView.setBuiltInZoomControls(true);
		mMapView.setScalebar(true);
		double lat = 35.658517;
		double lon = 139.701334;
		GeoPoint gp = new GeoPoint((int)(lat * 1000000),(int)(lon * 1000000));
		MapController c =mMapView.getMapController();
		c.setCenter(gp);
		c.setZoom(3);
		setContentView(mMapView);

		//ここからGPSの使用
		//LocationManagerを取得
		mLocationMaganer = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
		//位置情報の為のGPS精度や使用消費電力を設定する
		Criteria criteria = new Criteria();
		//Accuracy(低輝度)
		criteria.setAccuracy(Criteria.ACCURACY_COARSE);
		//PowerRequirement(低消費電力)
		criteria.setPowerRequirement(Criteria.POWER_LOW);
		//位置情報を伝達してくれるロケーションプロバイダの取得
		String provider = mLocationMaganer.getBestProvider(criteria, true);
		//位置情報のイベントリスナーであるLocationListenerを登録
		mLocationMaganer.requestLocationUpdates(provider, 0, 0, this);
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

	@Override
	public void onLocationChanged(Location location) {
		// TODO 自動生成されたメソッド・スタブ

		//緯度の取得
		double lat = location.getLatitude();
		int latitude = (int)(lat * 1000000);
		//経度の取得
		double lon = location.getLongitude();
		int longitude = (int)(lon * 1000000);

		//緯度と経度のいずれかが直前の値と誤差があれば、画面を更新
		//1000で割って、細かい数値を切り捨て＝誤差を吸収する
		if(latitude / 1000 != this.lastLatitude /1000 ||
				longitude / 1000 != this.lastLongitude /1000){
			//緯度経度情報（GeoPoint）の生成
			GeoPoint gp = new GeoPoint(latitude, longitude);
			//地図本体を取得
			MapController c = mMapView.getMapController();
			//地図本体にGeoPointを設定
			c.setCenter(gp);

			//今回の緯度経度を覚える
			this.lastLatitude = latitude;
			this.lastLongitude = longitude;
		}
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO 自動生成されたメソッド・スタブ

	}
}
