package com.xychan.login;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.util.TypedValue;
import android.content.Intent;
import android.content.DialogInterface;
import android.content.Context;
import android.graphics.Typeface;
import android.widget.ScrollView;
import android.net.Uri;
import android.widget.Toast;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.CheckBox;
import android.widget.TextView;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.os.Handler;
import android.widget.RelativeLayout;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.xychan.login.Auth;

public class MainActivity extends Activity { 
	String sGameActivity = "namepacknameapp";
	public Prefs prefs;
	private void Login() {
		
		
	

	    AlertDialog.Builder builder = new AlertDialog.Builder(this);
		float f = this.getResources().getDisplayMetrics().density;

		LinearLayout linearLayout = new LinearLayout(this);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
		linearLayout.setBackgroundColor(Color.parseColor("#FF000000"));

		LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.width = -1;
        layoutParams2.height = (int)(0.5f + 61.0f * f);

		android.graphics.drawable.GradientDrawable FEIIDGF = new android.graphics.drawable.GradientDrawable();
		int FEIIDGFADD[] = new int[]{ 
			Color.parseColor("#ff0000"),
			Color.parseColor("#ff7c0000") };
		FEIIDGF.setColors(FEIIDGFADD);
		FEIIDGF.setOrientation(android.graphics.drawable.GradientDrawable.Orientation.LEFT_RIGHT);
		FEIIDGF.setCornerRadii(new float[] { 3, 3, 3, 3, 3, 0, 0, 3 });

		TextView TextView = new TextView(this);
        TextView.setTextColor(-1);
        TextView.setText("DarkTeam Plus");
	    TextView.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/Blenda_Script.otf"));
        TextView.setTextSize(27.0f);
		TextView.setGravity(17);
		TextView.setBackground(FEIIDGF);
		linearLayout.addView((View)TextView);
		TextView.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);

		LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.width = -1;
		layoutParams3.bottomMargin = (int)(0.5f + f * 2.0f);
        layoutParams3.leftMargin = (int)(0.5f + f * 5.0f);
        layoutParams3.rightMargin = (int)(0.5f + f * 5.0f);


		EditText editText = new EditText(this);
		editText.setHint("Usuario");
		editText.setTextColor(Color.parseColor("#FFFFFFFF"));
        editText.setHintTextColor(Color.parseColor("#FFFFFFFF"));
		editText.setLayoutParams((ViewGroup.LayoutParams)layoutParams3);
		linearLayout.addView((View)editText);

		LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.width = -1;
        layoutParams4.leftMargin = (int)(0.5f + f * 5.0f);
        layoutParams4.rightMargin = (int)(0.5f + f * 5.0f);
		layoutParams4.bottomMargin = (int)(0.5f + f * 7.0f);

		final EditText editText2 = new EditText(this);
		editText2.setHint("Contraseña");
		editText2.setTextColor(Color.parseColor("#FFFFFFFF"));
        editText2.setHintTextColor(Color.parseColor("#FFFFFFFF"));
		editText2.setLayoutParams((ViewGroup.LayoutParams)layoutParams4);
		linearLayout.addView((View)editText2);

		final EditText editText10 = editText;
        final EditText editText20 = editText2;

		LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(dp(80), dp(26));
		layoutParams5.gravity = 5;
		layoutParams5.bottomMargin = (int)(0.5f + f * 3.0f);
		layoutParams5.rightMargin = (int)(0.5f + f * 3.0f);

		GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable.setColor(Color.TRANSPARENT);
		gradientDrawable.setStroke(2, Color.parseColor("#FF2222"));
		setCornerRadius(gradientDrawable, (float) dp(3), (float) dp(3), (float) dp(3), (float) dp(8));

		TextView textview = new TextView(this);
		textview.setText((CharSequence)"Entrar");
		textview.setTextColor(Color.parseColor("#FF2222"));
		textview.setShadowLayer(2.0f, 0.0f, 0.0f, -65536);
        textview.setGravity(17);
		textview.setTextSize(1, 13.0f);
		textview.setBackground(gradientDrawable);
		textview.setLayoutParams(layoutParams5);
		linearLayout.addView((View)textview);
		textview.setOnClickListener(new View.OnClickListener() {
				public void onClick(View view) {
					TryLoginPHP(editText10.getText().toString(), editText20.getText().toString());
				}
			});

		builder.setView((View)linearLayout);
		builder.setCancelable(false);
        builder.show();
	}

	public void AlertaVendedores() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle((CharSequence)"Aviso!");
		builder.setView(DarkVendedor(this, "+++"));
        builder.setCancelable(false);
        builder.setPositiveButton((CharSequence)"Ok", new DialogInterface.OnClickListener(){
				public void onClick(DialogInterface dialogInterface, int n) {
					Login();
				}
			});
		builder.setNegativeButton((CharSequence)"DISCORD", new DialogInterface.OnClickListener(){
				public void onClick(DialogInterface dialogInterface, int n) {

				}
			});
        AlertDialog alertDialog = builder.create();
		alertDialog.getWindow().setFlags(8192, 8192); //BlackSreen Code
        alertDialog.show();
	}

	private final String USER = "USER";
    private final String PASS = "PASS";
    private void TryLoginPHP(String mail, String pass) {
        prefs = Prefs.with(this);

		Intent i = new Intent(getApplicationContext(), Auth.class);
		i.putExtra("user", pass);

		if (!mail.isEmpty() && !pass.isEmpty()) {
			prefs.write(USER, mail);
			prefs.write(PASS, pass);
			new Auth(MainActivity.this).execute(mail, pass);
		}
		if (mail.isEmpty() && pass.isEmpty()) {

		}
	}


	public static RelativeLayout DarkVendedor(Context context, String device) {
		final Context context2 = context;
		float f = context.getResources().getDisplayMetrics().density;
		Typeface bold = Typeface.DEFAULT_BOLD;

		RelativeLayout relativeLayout = new RelativeLayout(context2);
		FrameLayout.LayoutParams frameLayoutlayoutParams = new FrameLayout.LayoutParams(-2, -2);
		frameLayoutlayoutParams.width = -1;
		frameLayoutlayoutParams.height = -1;
		frameLayoutlayoutParams.setMargins((int)(0.5f + f * 15.0f), (int)(0.5f + f * 15.0f), (int)(0.5f + f * 15.0f), (int)(0.5f + 15.0f * f));
		relativeLayout.setLayoutParams((ViewGroup.LayoutParams)frameLayoutlayoutParams);

		RelativeLayout.LayoutParams layoutparams = new RelativeLayout.LayoutParams(-2, -2);
		layoutparams.topMargin = (int) ((f * 15.0f) + 0.5f);

		TextView textview = new TextView(context2);
		textview.setTypeface(bold);
		textview.setId(1);
		textview.setText("VENDEDORES OFICIAIS");
		layoutparams.addRule(14, -1);
		relativeLayout.addView(textview);
		textview.setLayoutParams(layoutparams);

		RelativeLayout.LayoutParams layoutparams1 = new RelativeLayout.LayoutParams(-2, -2);
		layoutparams1.topMargin = (int) ((10.0f * f) + 0.5f);
		layoutparams1.leftMargin = (int) ((37.0f * f) + 0.5f);
		layoutparams1.addRule(3, textview.getId());
		layoutparams1.addRule(14, -1);

		TextView textview1 = new TextView(context2);
		textview1.setId(2);
		textview1.setText("Haga Click En EI Numero Para Entrar en Contacto");
		relativeLayout.addView(textview1);
		textview1.setLayoutParams(layoutparams1);

		return relativeLayout;
	}

	public static void clickNumero(Context context, String txtNum) {  
		String numero = txtNum.replace("+", "").replace(" ", "").replace("-", "");
		context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://wa.me/" + numero + "?text=Tenho interesse no modmenu ")));
	}



	private int dp(int i) {
		return (int) TypedValue.applyDimension(1, (float) i, getResources().getDisplayMetrics());
	}

	public static void setCornerRadius(GradientDrawable gradientDrawable, float f1, float f2, float f3, float f4) {
        gradientDrawable.setCornerRadii(new float[]{f1, f1, f2, f2, f3, f3, f4, f4});
    }
	
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		System.loadLibrary("Security-XyChan");
		//getWindow().setFlags(8192, 8192); //BlackSreen Code
		AlertaVendedores();
	}



} 
