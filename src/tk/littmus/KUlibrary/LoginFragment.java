package tk.littmus.KUlibrary;

import org.json.JSONArray;
import org.json.JSONObject;

import tk.littmus.KUlibrary.DataClass.User;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginFragment extends Fragment{
	
	private boolean DEBUG = true;
	private String TAG = "KULibrary";
	
	private Context mContext;
	private Fragment mFragment;
	EditText editID;
	EditText editPW;
	Button loginButton;
	Button joinButton;
	
	
	public LoginFragment(Context c) {
		mContext = c;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View v = inflater.inflate(R.layout.login_fragment, container, false);
		mFragment = this;
		
		editID = (EditText)v.findViewById(R.id.idText);
		editPW = (EditText)v.findViewById(R.id.passwordText);
		loginButton = (Button)v.findViewById(R.id.LoginButton);
		joinButton = (Button)v.findViewById(R.id.joinButton);
		
		
		loginButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new ApiAsyncTask(mFragment).execute("http://littmus.tk/api/android/user/?format=json");
			}
		});
		return v;
	}


	@Override
	public void onSaveInstanceState(Bundle savedInstatnaceState) {
		super.onSaveInstanceState(savedInstatnaceState);
	}
	
	public void getJsonObject(JSONArray obj){
		JSONObject t;
		String id;
		boolean hasID = false;
		for(int i = 0 ; i<obj.length() ; i++){
			try{
				t = (JSONObject) obj.get(i);
				id = t.getString("username");
				if(DEBUG) Log.i(TAG, ""+id);
				if(id.equals(editID.getText().toString())){
					hasID = true;
					MyData.getInstance().setUser(new User(t));
				}
			}
			catch(Exception e){
			}
		}
		
		if(hasID){
			((MainActivity)getActivity()).changeFragment();
		}
		else{
			Toast.makeText(mContext, "ID가 존재하지 않습니다" , Toast.LENGTH_LONG).show();
		}

	}

}