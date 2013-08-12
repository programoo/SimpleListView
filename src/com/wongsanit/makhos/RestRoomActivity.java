package com.wongsanit.makhos;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class RestRoomActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                                WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		String[] players  = new String[] 
				{ "Leonel Messi",
					"Gareth Bale",
					"Neymar",
					"Zlatan Ibrahimovich" };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, players);
        setListAdapter(adapter);
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		Intent it = new Intent(RestRoomActivity.this,MainActivity.class);
		startActivity(it);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		String item = (String) getListAdapter().getItem(position);
		
		Toast.makeText(this, item + " selected", Toast.LENGTH_LONG).show();

		
	}


}
