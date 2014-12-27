package com.wilis.gallery;
 
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
 
public class gallery extends Activity
{    
    //---the images to display---
    Integer[] imageIDs = {
            R.drawable.bandung1,
            R.drawable.bandung2,
            R.drawable.bandung3,
            R.drawable.bandung4,
            R.drawable.bandung5,
            R.drawable.bandung6,
            R.drawable.bandung7,                    
    };
 
    @Override    
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displayview);
 
        Gallery gallery = (Gallery) findViewById(R.id.gallery1);
 
        gallery.setAdapter(new ImageAdapter(this));        
        gallery.setOnItemClickListener(new OnItemClickListener() 
        {
            public void onItemClick(AdapterView parent, 
            View v, int position, long id) 
            {                
            	ImageView imageView = (ImageView) findViewById(R.id.image1);                
            	imageView.setImageResource(imageIDs[position]);
            }
        });
    }
 
    public class ImageAdapter extends BaseAdapter 
    {
        private Context context;
        private int itemBackground;
 
        public ImageAdapter(Context c) 
        {
            context = c;
            //---setting the style---
                         
        }
 
        //---returns the number of images---
        public int getCount() {
            return imageIDs.length;
        }
 
        //---returns the ID of an item--- 
        public Object getItem(int position) {
            return position;
        }            
 
        public long getItemId(int position) {
            return position;
        }
 
        //---returns an ImageView view---
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(imageIDs[position]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setLayoutParams(new Gallery.LayoutParams(150, 120));
            imageView.setBackgroundResource(itemBackground);
            return imageView;
        }
    }    
    
}