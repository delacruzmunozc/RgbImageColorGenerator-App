package com.Supermunch.rgbcolorgenerator;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity {
	int[] colors = new int[16777216];
	int[] black = new int[16777216];
	ImageView imageview;
	Bitmap bitmap;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		fillArray();
		createImage();
		fillPixels();
		displayImage();
	}
	public void fillArray()
	{
		for (int i = 0; i < 16777216; i++)
		{
			colors[i] = i;
		}
		for (int j = 0; j < 16777216; j++)
		{
			black[j] = 0;
		}
	}
	public void createImage()
	{
		bitmap = Bitmap.createBitmap(4096, 4096, Bitmap.Config.ARGB_8888);
	}
	public void fillPixels()
	{
		for (int y = 0; y < 4096; y++)
		{
			for (int x = 0; x < 4096; x++)
			{
				int color = colors[x+y*4096];
				bitmap.setPixel(x, y, color);
				System.out.println(color);
			}
		}
	}
	public void displayImage()
	{
		imageview = (ImageView)findViewById(R.id.imageView1);
		imageview.setImageBitmap(bitmap);
	}
}
