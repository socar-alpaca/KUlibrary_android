package tk.littmus.KUlibrary;

import tk.littmus.KUlibrary.DataClass.User;



public class MyData {
	private static MyData myData = new MyData();
	private User myUser;

	public static MyData getInstance() {
		return myData;
	}

	
	private MyData() {
	}
	
	public void setUser(User u){
		this.myUser = u;
	}


	public static void init() {
	}
}
