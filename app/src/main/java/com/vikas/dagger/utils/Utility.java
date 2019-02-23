package com.vikas.dagger.utils;

import android.text.format.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import static android.provider.Settings.System.DATE_FORMAT;

public class Utility {

    public static String getDateFormatted() {
        GregorianCalendar calendar = new GregorianCalendar();
        SimpleDateFormat dateFormatter = new SimpleDateFormat(DATE_FORMAT, Locale.getDefault());
        return dateFormatter.format(calendar.getTime().getTime());
    }

    public static String getDateInFormatForComment(String stringDate) throws ParseException {
        SimpleDateFormat fromFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.getDefault());
        Date date = fromFormat.parse(stringDate);
        return DateUtils.getRelativeTimeSpanString(date.getTime()).toString();
    }
}
