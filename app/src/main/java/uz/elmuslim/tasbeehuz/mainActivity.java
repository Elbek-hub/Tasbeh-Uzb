package uz.elmuslim.tasbeehuz;
//Assalomu Aleykum Rahmatullohu va BArokatuh
/* Bu Mobil Dastur: Raximov Elbek va Anvar Ziyodov tomonidan yaratilgan!!!*/

/* MBM IT COMPANY DEVELOPER TEAM */

import android.os.Bundle;
import android.os.Vibrator;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class mainActivity extends Activity {
	private ImageView count;
	private ImageView res;
	private TextView h;
	private EditText su;
	int angka=0;
	int max=33;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        angakho();
    }

    public void angakho()
    {
    	 count=(ImageView)findViewById (R.id.c);
         res=(ImageView)findViewById(R.id.r);
         h=(TextView)findViewById(R.id.hum);
         count.setOnClickListener(cListener);
         res.setOnClickListener(rListener);
         
    }
    
  //sanash metodi
 private View.OnClickListener cListener = new View.OnClickListener() {
		
		
		public void onClick(View v) {
			// TODO Avtomatik Ravishda Aniqlash mumkin
			h.setText(String.valueOf(++angka));

			
			if (angka==max)

			{
				stopActivity();
				Vibrator v1= (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
				v1.vibrate(300);
				Toast.makeText(mainActivity.this, ""+max+"-marta bo'ldi (Yana Zikr Qiling)", Toast.LENGTH_LONG).show();
				
			}
		}
	};

	//qayta yuklash metodi
	private View.OnClickListener rListener = new View.OnClickListener() {
		
		
		public void onClick(View v) {
			// TODO Avtomatik Ravishda Aniqlash mumkin
			h.setText(String.valueOf(angka=0));
			count.setOnClickListener(cListener);
		}
	};
	
	//Sanashni to'xtatish
	public void stopActivity()
	{
		count.setOnClickListener(null);
	}

	//menu
	public boolean onCreateOptionsMenu(Menu menu)
	   {
		SubMenu subMenu = menu.addSubMenu("Zikr Soni");
		subMenu.add(1,1,0,"33 marta");
		   Toast.makeText(mainActivity.this, "Salom "+max+" Yaxshimi", Toast.LENGTH_LONG).show();subMenu.add(1,2,0, "7 marta").setChecked (true);
		subMenu.add(1,3,0, "100 marta");
		subMenu.add(1,4,0,"Zikr Soni Qo'shish ");
		menu.add(0,5,0,"Ma'lumot");
		menu.add(0,6,0, "Chiqish").setIcon(android.R.drawable.btn_minus);
		return true;
		
	   }
	
	//options menu
	 public boolean onOptionsItemSelected(MenuItem item)
	   {
		   switch (item.getItemId()){
		   case 1:
			   max=33;
			   return (true);
		   case 2:
			   max=7;
			   return (true);
		   case 3:
			   max=100;
			   return (true);
		   case 4:
			  others();  
			   return (true);
		   case 5:
			   info();
			   return (true);
		   case 6:
			   onBackPressed();
			   return (true);
		   }
		   return false;
	   }
	 
	 //layout bowqalar
	 public void others()
	 {
		 this.setContentView(R.layout.others);
		 su=(EditText)findViewById(R.id.huum);
		 su.setText(String.valueOf(max));
	 }
	 
	 //bowqalar layout metodi
	 public void om_mput(View view)
		{
			max=Integer.valueOf(su.getText().toString()).intValue();
			this.setContentView(R.layout.activity_main);
			angakho();
		}
	 
	//orqaga qaytish metodi
	 public void onBackPressed()
	  {
		    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
		    localBuilder.setTitle("TasbehUz");
		    localBuilder.setMessage("Siz Dasturdan Chiqmoqchimisiz?");
		    localBuilder.setPositiveButton("Ha", new OnClickListener(){
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					exit();
				}});
		    localBuilder.setNegativeButton("Yo'q", new OnClickListener(){
		    	public void onClick(DialogInterface dialog, int which){	
		    	}});
		    localBuilder.show();
	  }
	 
	 public void info()
	 {
		 startActivity(new Intent(this,AboutActivity.class));
	 }
	 
	 public void exit()
		{
			this.finish();
		}
}
