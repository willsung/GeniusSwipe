package com.willsung.GeniusSwipe;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Main extends Activity {
	private boolean isExit = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		menu.add(0, 1, 0, R.string.exit);
		menu.add(0, 2, 0, R.string.test);
		menu.add(0, 3, 0, R.string.about);
		return super.onCreateOptionsMenu(menu);
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == 1) {
			Toast.makeText(getApplicationContext(), "Exit", Toast.LENGTH_SHORT)
					.show();
			finish();
		}
		if (item.getItemId() == 2) {
			Toast.makeText(getApplicationContext(), "Test", Toast.LENGTH_SHORT)
					.show();
		}
		if (item.getItemId() == 3) {
			Toast.makeText(getApplicationContext(), "About", Toast.LENGTH_SHORT)
					.show();
		}
		return super.onOptionsItemSelected(item);
	}

	public boolean onKeyDown(int keycode, KeyEvent event) {
		if (keycode == KeyEvent.KEYCODE_BACK) {
			if (event.getAction() == KeyEvent.ACTION_DOWN
					&& event.getRepeatCount() == 0) {
				exitBy2Click();
			}
		}
		return false;
	}

	public void exitBy2Click() {
		Timer exitb2c = null;
		if (isExit == false) {
			isExit = true;
			Toast.makeText(this, "�ٵ��һ���˳�!", Toast.LENGTH_SHORT).show();
			exitb2c = new Timer();
			exitb2c.schedule(new TimerTask() {
				@Override
				public void run() {
					isExit = false;
				}
			}, 1500);
		} else {
			finish();
			System.exit(0);
		}
	}
}
