package coursera.usuarios;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText inputName, inpuTelephone,inputEmail,inputDescription;
    static TextView txtbirthday;
    private Button btnDetal, btnSetDate;


   public static int year;
    public static int month;
    public static int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputName = (EditText) findViewById(R.id.input_name);
        inpuTelephone = (EditText) findViewById(R.id.input_telephone);
        inputEmail = (EditText) findViewById(R.id.input_email);
        inputDescription = (EditText) findViewById(R.id.input_description);

        txtbirthday = (TextView) findViewById(R.id.selected_date);

        btnDetal = (Button) findViewById(R.id.btn_next);
        btnDetal.setOnClickListener(this);
        btnSetDate = (Button) findViewById(R.id.btn_Set_Date);
        btnSetDate.setOnClickListener(this);


    }
    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {


        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            if( year == 0) {
                year = c.get(Calendar.YEAR);
            }
            if(month == 0){
                month = c.get(Calendar.MONTH);
            }
            if( day == 0){
                day = c.get(Calendar.DAY_OF_MONTH);
            }

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year1, int month1, int day1) {
            year = year1;
            month = month1;
            day = day1;
            txtbirthday.setText("Selected Date: " + (month + 1) + "-" + day + "-" + year);
        }
    }

    @Override
    public void onClick(View view) {
        int y = view.getId();
        int h = R.id.btn_Set_Date;
        if (view.getId() == R.id.btn_Set_Date) {
            DialogFragment newFragment = new DatePickerFragment();
            newFragment.show(getSupportFragmentManager(), "datePicker");
        } else {
            //if(view.getTransitionName())
            Intent detailIntent = new Intent(this, DetailActivity.class);
            //
            Person objPersom = new Person(inputName.getText().toString(), txtbirthday.getText().toString(), inpuTelephone.getText().toString(),
                    inputEmail.getText().toString(), inputDescription.getText().toString());

            detailIntent.putExtra("objPersona", objPersom);
            startActivity(detailIntent);
        }
    }
}
