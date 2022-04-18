package com.example.rentcar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rentcar.api.ApiService;
import com.example.rentcar.model.Employee;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    private EditText editName;
    private EditText editPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editName = findViewById(R.id.name);
        editPass = findViewById(R.id.password);
        Button btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }
    private void login() {
        String username = editName.getText().toString().trim();
        String password = editPass.getText().toString().trim();

        if(username.isEmpty()) {
            editName.setError("Username is required");
            editName.requestFocus();
            return;
        }
        if(password.isEmpty()) {
            editPass.setError("Password is required");
            editPass.requestFocus();
            return;
        }

        Employee employee = new Employee(username,password);

        ApiService.apiService.login(employee).enqueue(new Callback<Employee>() {
            @Override
            public void onResponse(Call<Employee> call, Response<Employee> response) {
                Toast.makeText(Login.this, "Login success", Toast.LENGTH_SHORT).show();
                Employee employeeResult = response.body();

                if(employeeResult.getUsername() != null) {
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<Employee> call, Throwable t) {
                Toast.makeText(Login.this, "Username or password incorrect", Toast.LENGTH_SHORT).show();
            }
        });
    }
}