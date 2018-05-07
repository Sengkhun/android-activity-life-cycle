package com.example.sengkhunlim.lifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg;
    EditText nameInput;
    ImageView image;
    CheckBox checkBox;
    int currentImageId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Lifecycle", "onCreate Called");

        rg = findViewById(R.id.radioGroup);
        image = findViewById(R.id.image);
        nameInput = findViewById(R.id.nameInput);
        checkBox = findViewById(R.id.checkbox1);

        rg.check(R.id.haruno);

    }

    public void radioClick(View view) {

        currentImageId = view.getId();
        setImage(currentImageId);

    }

    public void setImage(int id) {

        switch ( id ) {

            case R.id.haruno:
                image.setImageResource(R.drawable.haruno);
                break;

            case R.id.hatake:
                image.setImageResource(R.drawable.hatake);
                break;

            case R.id.rocklee:
                image.setImageResource(R.drawable.rocklee);
                break;

            case R.id.uchiha:
                image.setImageResource(R.drawable.uchiha);
                break;
        }

    }

    public void sendBtn(View view) {

        Toast.makeText(this, nameInput.getText(),
                Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Lifecycle", "onStart Called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lifecycle", "onResume Called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Lifecycle", "onPause Called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lifecycle", "onStop Called");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("Lifecycle", "onSaveInstanceState Called");

        outState.putInt("RadioButton", rg.getCheckedRadioButtonId());
        outState.putInt("Image", currentImageId);
        outState.putString("EditText", nameInput.getText().toString());
        outState.putBoolean("Checkbox", checkBox.isChecked());

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("Lifecycle", "onRestoreInstanceState Called");

        currentImageId = savedInstanceState.getInt("Image");

        setImage(currentImageId);
        rg.check(savedInstanceState.getInt("RadioButton"));
        nameInput.setText(savedInstanceState.getString("EditText"));
        checkBox.setChecked(savedInstanceState.getBoolean("Checkbox"));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Lifecycle", "onDestroy Called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Lifecycle", "onRestart Called");
    }

}
