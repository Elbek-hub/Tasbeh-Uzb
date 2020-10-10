package uz.elmuslim.tasbeehuz;

//Assalomu Aleykum Rahmatullohu va BArokatuh
/* Bu Mobil Dastur: Raximov Elbek va Anvar Ziyodov tomonidan yaratilgan!!!*/

/* MBM IT COMPANY DEVELOPER TEAM */

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class AboutActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_about, menu);
        return true;
    }

    
}
