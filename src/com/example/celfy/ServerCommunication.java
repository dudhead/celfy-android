package com.example.celfy;

import java.io.File;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ServerCommunication extends Activity {
	File file;
	String result;
	Button btnupload;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_upload);
		btnupload = (Button) findViewById(R.id.btnUpload);

		btnupload.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				new LongOperation().execute();
			}
		});
	}
}

class LongOperation extends AsyncTask<String, Void, String> {

	LongOperation() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String doInBackground(String... params) {
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost("https://xicer1-h2ri.c9.io/api/photo");
		try {
			MultipartEntity entity = new MultipartEntity();

			entity.addPart("type", new StringBody("photo"));
			entity.addPart("data", new FileBody(new File(
					"/storage/sdcard1/DCIM/Camera/IMG_20150316_134003.JPG")));
			httppost.setEntity(entity);
			HttpResponse response = httpclient.execute(httppost);
		} catch (ClientProtocolException e) {
		} catch (IOException e) {
		}
		return null;
	}
}
