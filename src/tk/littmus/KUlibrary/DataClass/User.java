package tk.littmus.KUlibrary.DataClass;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

public class User {
	private int idNum = 0;
	private String lastName = null;
	private String resource_uri = null;
	private String username = null;	
	private ArrayList<Library> ownLibary = null;

	User(){
		idNum = 0;
		lastName = "";
		resource_uri = "";
		username = "";
	}
	public User(JSONObject jso){
		try {
			idNum = jso.getInt("id");
			lastName = jso.getString("last_name");
			resource_uri = jso.getString("resource_uri");
			username = jso.getString("username");
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
