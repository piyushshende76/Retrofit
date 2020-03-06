package com.campus.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText username,password;
    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);



        apiInterface = APIClient.getClient().create(APIInterface.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                Call<loginresponsegson> loginresponsegsonCall = apiInterface.LOGINRESPONSEGSON_CALL(user,pass);
                loginresponsegsonCall.enqueue(new Callback<loginresponsegson>() {
                    @Override
                    public void onResponse(Call<loginresponsegson> call, Response<loginresponsegson> response) {
                        loginresponsegson loginresponsegson = response.body();
                     //   Toast.makeText(getApplicationContext(),""+loginresponsegson.getResponse(),Toast.LENGTH_SHORT).show();
                        Toast.makeText(getApplicationContext(),""+loginresponsegson.getObject().get(2).getFullName(),Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onFailure(Call<loginresponsegson> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),""+t.getMessage(),Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });

    }


}
