package com.mehuljoisar.timestampdemo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.joda.time.DateTime;
import org.joda.time.DurationFieldType;
import org.joda.time.Period;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

	PeriodFormatter fYear = new PeriodFormatterBuilder()
    .printZeroNever()
    .toFormatter();

	PeriodFormatter fMonth = new PeriodFormatterBuilder()
    .appendMonths().appendSuffix(" month(s) ago")
    .printZeroNever()
    .toFormatter();

	PeriodFormatter fWeek = new PeriodFormatterBuilder()
    .appendWeeks().appendSuffix(" week(s) ago")
    .printZeroNever()
    .toFormatter();
	
	PeriodFormatter fDay = new PeriodFormatterBuilder()
    .appendDays().appendSuffix(" day(s) ago")
    .printZeroNever()
    .toFormatter();
	
	PeriodFormatter fHour = new PeriodFormatterBuilder()
    .appendHours().appendSuffix(" hour(s) ago")
    .printZeroNever()
    .toFormatter();
	
	PeriodFormatter fMin = new PeriodFormatterBuilder()
    .appendMinutes().appendSuffix(" minute(s) ago")
    .printZeroNever()
    .toFormatter();
	
	
	PeriodFormatter fSec = new PeriodFormatterBuilder()
    .appendSeconds().appendSuffix(" second(s) ago")
    .printZeroNever()
    .toFormatter();
		
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		try {
			
		String elapsedTime = new String();
		SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		String today = sdf.format(new Date());
		Log.e("today", today);
		
		String timestamp = "Fri May 17 01:00:00 +0000 2013";
		
		   
		Date Today = sdf.parse(today);
		Date TimeStamp = sdf.parse(timestamp);
		DateTime Today_DT = (Today==null)?null:new DateTime(Today);
		DateTime mToday_DT = new DateTime();
		DateTime TimeStamp_DT = (TimeStamp==null)?null:new DateTime(TimeStamp);
		
		Period period = new Period(TimeStamp_DT, Today_DT);
		if(period.get(DurationFieldType.years())>0)
		{
			elapsedTime = fYear.print(period);
		}
		else if (period.get(DurationFieldType.months())>0) {
			elapsedTime = fMonth.print(period);
		}
		else if (period.get(DurationFieldType.weeks())>0) {
			elapsedTime = fWeek.print(period);
		}
		else if (period.get(DurationFieldType.days())>0) {
			elapsedTime = fDay.print(period);
		}
		else if (period.get(DurationFieldType.hours())>0) {
			elapsedTime = fHour.print(period);
		}
		else if (period.get(DurationFieldType.minutes())>0) {
			elapsedTime = fMin.print(period);
		}
		else if (period.get(DurationFieldType.seconds())>0) {
			elapsedTime = fSec.print(period);
		}
			

		Toast.makeText(MainActivity.this, elapsedTime, Toast.LENGTH_LONG).show();
		Log.e("elapsedTime", elapsedTime);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
