package tk.littmus.KUlibrary;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.util.Log;

class ApiAsyncTask extends AsyncTask<String, String, String> {
	private String TAG = "KULibrary";
	StringBuilder jsonhtml = new StringBuilder();
	String resultStr = null;
	Fragment mFragment = null;

	public ApiAsyncTask(Fragment f) {
		mFragment = f;
	}
	
	@Override
	protected String doInBackground(String... urls) {
		try {
			URL url = new URL(urls[0]);
			HttpURLConnection conn = (HttpURLConnection) url
					.openConnection();
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(5000);
			conn.connect();
			BufferedReader br = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), "UTF-8"));

			for (;;) {
				String line = br.readLine();
				if (line == null)
					break;
				jsonhtml.append(line);
			}
			br.close();
			conn.disconnect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.i(TAG, "API NetWork Error");
		}
		return jsonhtml.toString();
	}

	protected void onPostExecute(String result) {
		JSONObject jObj;
		JSONArray jArray = null;
		try{
			jObj = new JSONObject(jsonhtml.toString());
			jArray = jObj.getJSONArray("objects");
		}
		catch(Exception e){
			
			
		}
		if(mFragment instanceof LoginFragment){
			((LoginFragment)mFragment).getJsonObject(jArray);
		}
	}
}

