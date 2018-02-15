package com.stingersof.lab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.class_schedule);

        Course course;

        ArrayList<Course> courses = new ArrayList<>();

        course = new Course();
        course.setCourseName("Programming I");
        course.setCourseNumber("CSCI 220");
        course.setProfessor("Dr. Leclerc");
        courses.add(course);

        course = new Course();
        course.setCourseName("Programming II");
        course.setCourseNumber("CSCI 221");
        course.setProfessor("Dr. Buhler");
        courses.add(course);

        //String[] listItems = {"CSCI 230", "CSCI 490", "MUSC 101"};
        //ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, courses);

        CourseAdapter adapter = new CourseAdapter(this, courses);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "Short click", Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "Loooooooooooooong click", Toast.LENGTH_SHORT).show();

                // The following line would allow other events, such as a regular click
                // return false;

                return true;
            }
        });
    }
}
