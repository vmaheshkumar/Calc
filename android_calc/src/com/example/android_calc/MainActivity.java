package com.example.android_calc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class MainActivity extends Activity implements OnClickListener {
	Button one;
	Button two;
	Button three;
	Button four;
	Button five;
	Button six;
	Button seven;
	Button eight;
	Button nine;
	Button zero;
	Button plus;
	Button minus;
	Button div;
	Button mul;
	Button point;
	Button equal;
	EditText calc;
	
	boolean clear;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		one = (Button)findViewById(R.id.one);
		two = (Button)findViewById(R.id.two);
		three = (Button)findViewById(R.id.three);
		four = (Button)findViewById(R.id.four);
		five = (Button)findViewById(R.id.five);
		six = (Button)findViewById(R.id.six);
		seven = (Button)findViewById(R.id.seven);
		eight = (Button)findViewById(R.id.eight);
		nine = (Button)findViewById(R.id.nine);
		zero = (Button)findViewById(R.id.zero);
		plus = (Button)findViewById(R.id.plus);
		minus = (Button)findViewById(R.id.minus);
		div = (Button)findViewById(R.id.div);
		mul = (Button)findViewById(R.id.mul);
		point = (Button)findViewById(R.id.point);
		equal = (Button)findViewById(R.id.equal);
		calc = (EditText)findViewById(R.id.calc_screen);
		
		calc.setText("");
		
		one.setOnClickListener(this);
		two.setOnClickListener(this);
		three.setOnClickListener(this);
		four.setOnClickListener(this);
		five.setOnClickListener(this);
		six.setOnClickListener(this);
		seven.setOnClickListener(this);
		eight.setOnClickListener(this);
		nine.setOnClickListener(this);
		zero.setOnClickListener(this);
		
		plus.setOnClickListener(this);
		minus.setOnClickListener(this);
		div.setOnClickListener(this);
		mul.setOnClickListener(this);
		
		equal.setOnClickListener(this);
		point.setOnClickListener(this);
		
		clear = false;
		
	}

	@Override
	public void onClick(View v) {
		if(clear){
			calc.setText("");
			clear = false;
		}
		int id = v.getId();
		String addSymbol="";
		switch(id){
		case R.id.one:
			addSymbol = "1";
			break;
		case R.id.two:
			addSymbol = "2";
			break;
		case R.id.three:
			addSymbol = "3";
			break;
		case R.id.four:
			addSymbol = "4";
			break;
		case R.id.five:
			addSymbol = "5";
			break;
		case R.id.six:
			addSymbol = "6";
			break;
		case R.id.seven:
			addSymbol = "7";
			break;
		case R.id.eight:
			addSymbol = "8";
			break;
		case R.id.nine:
			addSymbol = "9";
			break;
		case R.id.zero:
			addSymbol = "0";
			break;
		case R.id.plus:
			addSymbol = "+";
			break;
		case R.id.minus:
			addSymbol = "-";
			break;
		case R.id.div:
			addSymbol = "/";
			break;
		case R.id.mul:
			addSymbol = "*";
			break;
		case R.id.point:
			addSymbol = ".";
			break;
		case R.id.equal:
			ScriptEngineManager mgr = new ScriptEngineManager();
		    ScriptEngine engine = mgr.getEngineByName("js");
		    String expres = calc.getText().toString();
		    try {
				calc.setText(((double)engine.eval(expres)) + "");
			} catch (Exception e) {
				//do nothing if theexpression is incorrect
				
			}
		    clear=true;
		    return
			break;
		}
		calc.setText(calc.getText().toString()+addSymbol);
		
	}

	
}
