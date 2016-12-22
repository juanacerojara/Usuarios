package coursera.usuarios;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Juan on 19/12/2016.
 */

public class DetailActivity extends Activity implements View.OnClickListener{
    private TextView name, birthday, telephone, mail, description;
    private Button btnReturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        name = (TextView) findViewById(R.id.textViewName);
        birthday = (TextView) findViewById(R.id.textViewBirthday);
        telephone = (TextView) findViewById(R.id.textViewTelephone);
        mail = (TextView) findViewById(R.id.textViewMail);
        description = (TextView) findViewById(R.id.textViewDescription);
        btnReturn = (Button) findViewById(R.id.btn_return_data);
        btnReturn.setOnClickListener(this);

        try {
    Person objPerson = getIntent().getParcelableExtra("objPersona");

    name.setText(objPerson.getNamePerson());
    birthday.setText(objPerson.getBirthday());
    telephone.setText(objPerson.getTelephone());
    mail.setText(objPerson.getEmail());
    description.setText(objPerson.getDescription());
}catch (Exception e){
    String err = e.toString();
}

    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
