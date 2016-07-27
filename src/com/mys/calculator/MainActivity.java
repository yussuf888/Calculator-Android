package com.mys.calculator;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements OnClickListener {
	//declare the image button
	TextView txtDisplay;
	ImageButton btn0;
	ImageButton btn1;
	ImageButton btn2;
	ImageButton btn3;
	ImageButton btn4;
	ImageButton btn5;
	ImageButton btn6;
	ImageButton btn7;
	ImageButton btn8;
	ImageButton btn9;
	ImageButton btnPlus;
	ImageButton btnMin;
	ImageButton btnMul;
	ImageButton btnDiv;
	ImageButton btnDot;
	ImageButton btnClear;
	ImageButton btnBack;
	ImageButton btnSqrt;
	ImageButton btnPercent;
	ImageButton btnEqual;
	ImageButton btnPlusmin;
	ImageButton btnSqr;
	
	//find the button image by declaring id
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		txtDisplay = (TextView) findViewById(R.id.txtDisplay);
		btn0 = (ImageButton) findViewById(R.id.btn0);
		btn1 = (ImageButton) findViewById(R.id.btn1);
		btn2 = (ImageButton) findViewById(R.id.btn2);
		btn3 = (ImageButton) findViewById(R.id.btn3);
		btn4 = (ImageButton) findViewById(R.id.btn4);
		btn5 = (ImageButton) findViewById(R.id.btn5);
		btn6 = (ImageButton) findViewById(R.id.btn6);
		btn7 = (ImageButton) findViewById(R.id.btn7);
		btn8 = (ImageButton) findViewById(R.id.btn8);
		btn9 = (ImageButton) findViewById(R.id.btn9);
		btnPlus = (ImageButton) findViewById(R.id.btnPlus);
		btnMin = (ImageButton) findViewById(R.id.btnMin);
		btnMul = (ImageButton) findViewById(R.id.btnMul);
		btnDiv = (ImageButton) findViewById(R.id.btnDiv);
		btnDot = (ImageButton) findViewById(R.id.btnDot);
		btnClear = (ImageButton) findViewById(R.id.btnClear);
		btnBack = (ImageButton) findViewById(R.id.btnBack);
		btnSqrt = (ImageButton) findViewById(R.id.btnSqrt);
		btnPercent = (ImageButton) findViewById(R.id.btnPercent);
		btnEqual = (ImageButton) findViewById(R.id.btnEqual);
		btnPlusmin = (ImageButton) findViewById(R.id.btnPlusmin);
		btnSqr = (ImageButton) findViewById(R.id.btnSqr);
		
		btn0.setOnClickListener(this);
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);
		btn5.setOnClickListener(this);
		btn6.setOnClickListener(this);
		btn7.setOnClickListener(this);
		btn8.setOnClickListener(this);
		btn9.setOnClickListener(this);
		btnPlus.setOnClickListener(this);
		btnMin.setOnClickListener(this);
		btnMul.setOnClickListener(this);
		btnDiv.setOnClickListener(this);
		btnDot.setOnClickListener(this);
		btnClear.setOnClickListener(this);
		btnBack.setOnClickListener(this);
		btnSqrt.setOnClickListener(this);
		btnPercent.setOnClickListener(this);
		btnEqual.setOnClickListener(this);
		btnPlusmin.setOnClickListener(this);
		btnSqr.setOnClickListener(this);
	}
	int clear_flag=0;
	String sign_flag = "";
	Double total = 0.0;
	int last_button=0;
	
	//to clear the user input in screen
	public void shownum(String num)
	{
		if(clear_flag == 1)
		{
			txtDisplay.setText("");
			clear_flag=0;
		}
		else if(txtDisplay.getText()=="0)")
		{
			txtDisplay.setText("");
		}
		txtDisplay.setText(txtDisplay.getText() + num);
	}
	public void showsign(String sign)
	{
		if(last_button==R.id.btnPlus || last_button==R.id.btnMin || last_button==R.id.btnMul || last_button==R.id.btnDiv)
		{
			
		}
		else
		{
			clear_flag = 1;
			Double newNumber = Double.parseDouble(txtDisplay.getText().toString());
			if(sign_flag == "" || sign_flag == "=")
			{
				total = newNumber;
				txtDisplay.setText(total.toString());
			}
			else if(sign_flag == "+")
			{
				total = total + newNumber;
				txtDisplay.setText(total.toString());
			}
			else if(sign_flag == "-")
			{
				total = total - newNumber;
				txtDisplay.setText(total.toString());
			}
			else if(sign_flag == "*")
			{
				total = total * newNumber;
				txtDisplay.setText(total.toString());
			}
			else if(sign_flag == "/")
			{
				total = total / newNumber;
				txtDisplay.setText(total.toString());
			}
			
		}
		sign_flag = sign;
	}
	
	//do the button listen when the user click the image button
	@Override
	public void onClick(View v) 
	{
		// TODO Auto-generated method stub
		if (v.getId() == R.id.btn0)
		{
			shownum("0");
		}
		else if (v.getId() == R.id.btn1)
		{
			shownum("1");
		}
		else if (v.getId() == R.id.btn2)
		{
			shownum("2");
		}
		else if (v.getId() == R.id.btn3)
		{
			shownum("3");
		}
		else if (v.getId() == R.id.btn4)
		{
			shownum("4");
		}
		else if (v.getId() == R.id.btn5)
		{
			shownum("5");
		}
		else if (v.getId() == R.id.btn6)
		{
			shownum("6");
		}
		else if (v.getId() == R.id.btn7)
		{
			shownum("7");
		}
		else if (v.getId() == R.id.btn8)
		{
			shownum("8");
		}
		else if (v.getId() == R.id.btn9)
		{
			shownum("9");
		}
		
		else if (v.getId() == R.id.btnClear)
		{
			txtDisplay.setText("");
			total = 0.0;
			sign_flag = "";
		}
		else if (v.getId() == R.id.btnDot)
		{
			if(clear_flag == 1)
			{
				txtDisplay.setText("");
				clear_flag = 0;
			}
			
			if(txtDisplay.getText().toString().indexOf(".")<0)
			{
				txtDisplay.setText(txtDisplay.getText() + ".");
			}
		}
		else if (v.getId() == R.id.btnBack)
		{
			if(txtDisplay.getText().toString().length()>0)
			{
				int start = 0;
				int end = txtDisplay.getText().toString().length()-1;
				String newText = txtDisplay.getText().toString().substring(start, end);
				txtDisplay.setText(newText);
			}
			
		}
		else if(v.getId() == R.id.btnPlus)
		{
			showsign("+");
		}
		else if(v.getId() == R.id.btnMin)
		{
			showsign("-");
		}
		else if(v.getId() == R.id.btnMul)
		{
			showsign("*");
		}
		else if(v.getId() == R.id.btnDiv)
		{
			showsign("/");
		}
		//do the calculation that input by the user and get display in device
		else if(v.getId()==R.id.btnEqual)
		{
			Float newNumber = Float.parseFloat(txtDisplay.getText().toString());
			if(sign_flag == "+")
			{
				total = total + newNumber;
				txtDisplay.setText(total.toString());
			}
			else if(sign_flag == "-")
			{
				total = total - newNumber;
				txtDisplay.setText(total.toString());
			}
			else if(sign_flag == "*")
			{
				total = total * newNumber;
				txtDisplay.setText(total.toString());
			}
			else if(sign_flag == "/")
			{
				total = total / newNumber;
				txtDisplay.setText(total.toString());
			}
			else if(sign_flag == "%")
			{
				total = (total * newNumber)/100;
				txtDisplay.setText(total.toString());
			}
			sign_flag = "=";
			
		}
		else if(v.getId() == R.id.btnSqrt)
		{
			Double newNumber = Double.parseDouble(txtDisplay.getText().toString());
			total = Math.sqrt(newNumber);
			txtDisplay.setText(total.toString());
		}
		else if(v.getId() == R.id.btnSqr)
		{
			Double newNumber = Double.parseDouble(txtDisplay.getText().toString());
			total = Math.pow(newNumber, 2);
			txtDisplay.setText(total.toString());
		}
		else if(v.getId() == R.id.btnPlusmin)
		{
			Double newNumber = Double.parseDouble(txtDisplay.getText().toString());
			total = newNumber * (-1);
			txtDisplay.setText(total.toString());
		}
		else if(v.getId() == R.id.btnPercent)
		{
			sign_flag = "%";
			clear_flag = 1;
			Double newNumber = Double.parseDouble(txtDisplay.getText().toString());
			total = newNumber;
		}
		last_button = v.getId();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	
}
