package org.timesheet.sample.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.blogspot.ctasada.gwt.eureka.client.ui.TimeBox;

import java.util.ArrayList;
import java.util.Date;

import com.google.gwt.user.datepicker.client.CalendarUtil;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class TimesheetApp implements EntryPoint {


    private VerticalPanel mainPanel = new VerticalPanel();
    private HorizontalPanel horizontalPanel = new HorizontalPanel();
    private FlexTable mainFlexTable = new FlexTable();
    private TextBox newSymbolTextBox = new TextBox();
    private Button addSendButton = new Button("Add");
    private ArrayList<TimeBox> times = new ArrayList<TimeBox>();
    private ArrayList<Date> dates = new ArrayList<Date>();


    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {

        Grid dayTable = new Grid(416, 6);

        dayTable.setText(0, 0, "Day");
        dayTable.setText(0, 1, "Peter");
        dayTable.setText(0, 2, "Anna");
        dayTable.setText(0, 3, "Megan");
        dayTable.setText(0, 4, "Michal");

        DateTimeFormat fmt = DateTimeFormat.getFormat("dd.MM");
        Date date = new Date("01.09");

        int count = 0;
        int day = 0;
        int u = 0;
        while (day < 51) {
            for (int row = 1 + u; row < 8 + u; ++row) {
                for (int col = 1; col < 5; ++col) {
                    dates.add(new Date());
                    dates.get(count).setHours(0);
                    dates.get(count).setMinutes(0);
                    VerticalPanel s = new VerticalPanel();
                    times.add(new TimeBox(dates.get(count)));
                    s.add(times.get(count));
                    count++;
                    dates.add(new Date());
                    dates.get(count).setHours(0);
                    dates.get(count).setMinutes(0);
                    times.add(new TimeBox(dates.get(count)));
                    s.add(times.get(count));
                    dayTable.setWidget(row, col, s);
                    count++;
                }
                dayTable.setText(row, 0, fmt.format(date));

                CalendarUtil.addDaysToDate(date, 1);
            }

            Button button = new Button("Update");
            dayTable.setWidget(8 + u, 5, button);
            button.addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent event) {

                }
            });
            for (int col = 1; col < 5; ++col) {
                dayTable.setText(8 + u, col, "result");
            }
            u = u + 8;
            day++;
        }

        RootPanel.get().add(dayTable);
    }

    private class editHandler implements ClickHandler {

        public void onClick(ClickEvent event) {
            
        }
    }
}




