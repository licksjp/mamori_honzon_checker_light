package mamori.honzon.checker.light;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class bosatsu_list4 extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bosatsu_list4);
        setTitle(R.string.Bosatu_list4);
        Button backBtn = (Button)findViewById(R.id.back_bt);
        backBtn.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				finish();
			}});
    }
}