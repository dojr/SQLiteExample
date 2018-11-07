package edu.shamblidoregonstate.papajohnalddatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public PizzaDatabaseHelper myDb;
    private EditText mFirstName;
    private EditText mLastName;
    private EditText mGrade;
    private Button mAddData, mViewAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirstName = findViewById(R.id.first_name);
        mLastName = findViewById(R.id.last_name);
        mGrade = findViewById(R.id.grade);
        mAddData = findViewById(R.id.add_data);
        mViewAll = findViewById(R.id.view_all);

        myDb = new PizzaDatabaseHelper(this);
        mAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isInserted = myDb.insertData(
                        mFirstName.getText().toString(),
                        mLastName.getText().toString(),
                        mGrade.getText().toString()
                );
                if (isInserted)
                    Toast.makeText(MainActivity.this, "PIZZA MADE", Toast.LENGTH_SHORT);
                else
                    Toast.makeText(MainActivity.this, "PIZZA NOT MADE", Toast.LENGTH_SHORT);
            }
        });

        mViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
