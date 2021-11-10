package my.android.exercise.according.to.video3.jsonparsingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView titleview,descrview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        titleview=findViewById(R.id.title2id);
        descrview=findViewById(R.id.description2id);

        Intent intent=getIntent();
        String title=intent.getStringExtra("title");
        String description=intent.getStringExtra("description");

        titleview.setText(title);
        descrview.setText(description);
    }
}