package TextViewEx;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;

public class TextViewExActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWidowFeature (Window.FEATURE_NO_TITLE);

		LinearLayout layout = new LinearLayout (this);
		layout.setBackgroundColor (Color.rgb (255, 255, 255));
		layout.setOrientation(LinearLayout.VERTICAL);
		setContentView (layout);

		TextView textview = new TextView (this);
		textview.setText ("이것은 텍스트입니다.");
		textview.setTextSize (16.0f);
		textview.setTextColor (Color.rgb (0,0,0));

		setLLParams (textview);
		layout.addView (textview);
	}

	private static void setLLParams (View view)
	{
		view.setLayoutParams (new LinearLayout.LayoutParams (
								LinearLayout.LayoutParams.WRAP_CONTENT,
								LinearLayout.LayoutParams.WRAP_CONTENT));
	}
}
