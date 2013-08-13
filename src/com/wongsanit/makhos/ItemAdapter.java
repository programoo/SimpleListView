package com.wongsanit.makhos;


import java.io.IOException;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final String[] Ids;
    private final int rowResourceId;

    public ItemAdapter(Context context, int textViewResourceId, String[] objects) {

        super(context, textViewResourceId, objects);

        this.context = context;
        this.Ids = objects;
        this.rowResourceId = textViewResourceId;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    	System.out.println("position load: "+position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(rowResourceId, parent, false);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView);
        TextView textView = (TextView) rowView.findViewById(R.id.textView);

        int id = Integer.parseInt(Ids[position]);
        String imageFile = Model.GetbyId(id).iconFile;

        textView.setText(Model.GetbyId(id).name);
        
        // load image as Drawable set image to ImageView
        try 
        {
			imageView.setImageDrawable(Drawable.createFromStream(context.getAssets().open( imageFile ) , null));
		} catch (IOException e) {
			e.printStackTrace();
		}
                
        return rowView;

    }

}
