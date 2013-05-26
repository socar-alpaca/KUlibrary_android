package tk.littmus.KUlibrary;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class LoginFragment extends Fragment{
	
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View v = inflater.inflate(R.layout.login_fragment, container, false);
		
		EditText editID = (EditText)v.findViewById(R.id.idText);
		EditText editPW = (EditText)v.findViewById(R.id.passwordText);
		Button loginButton = (Button)v.findViewById(R.id.LoginButton);
		Button joinButton = (Button)v.findViewById(R.id.joinButton);
		
		
		loginButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				((MainActivity)getActivity()).changeFragment();
			}
		});
		return v;
	}


	@Override
	public void onSaveInstanceState(Bundle savedInstatnaceState) {
		super.onSaveInstanceState(savedInstatnaceState);
	}

}