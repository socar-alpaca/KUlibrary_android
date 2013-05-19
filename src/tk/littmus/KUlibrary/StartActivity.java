package tk.littmus.KUlibrary;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class StartActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.start_activity, menu);
        return true;
    }

    
}
