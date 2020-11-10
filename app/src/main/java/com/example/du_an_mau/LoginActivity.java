package com.example.du_an_mau;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.du_an_mau.Dao.UserDao;
import com.example.du_an_mau.Model.User;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
UserDao dao;
ArrayList<User> arrayList;
EditText username,password;
Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        GoogleSignInOptions gos = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN).requestEmail().build();

        final GoogleSignInClient googleSignInClient = GoogleSignIn.getClient(this,gos);
        SignInButton signInButton  = findViewById(R.id.btnSigGoogle);
        signInButton.setSize(SignInButton.SIZE_STANDARD);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = googleSignInClient.getSignInIntent();
                startActivityForResult(intent,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode ==0){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> task) {

        // get info User
//            GoogleSignInAccount acct = completedTask.getResult(ApiException.class);
//            String personName = acct.getDisplayName();
//            String personGivenName = acct.getGivenName();
//            String personFamilyName = acct.getFamilyName();
//            String personEmail = acct.getEmail();
//            String personId = acct.getId();
        //Uri personPhoto = acct.getPhotoUrl();
        // Signed in successfully, show authenticated UI.

        Toast.makeText(this, "Thanh cong", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(LoginActivity.this,MainActivity.class);

        startActivity(i);

    }

    public void init(){
        username = findViewById(R.id.edtUserName);
        password = findViewById(R.id.edtPassWord);
        login = findViewById(R.id.btnLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dao = new UserDao(LoginActivity.this);
                String tk = username.getText().toString();
                String mk = password.getText().toString();
                ArrayList<User> arrayList = new ArrayList<>();
                arrayList = dao.readAll();
                for(int i= 0;i< arrayList.size();i++){
                    if(arrayList.get(i).getUser().matches(tk) && arrayList.get(i).getPassword().matches(mk)){
                        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(intent);
                    }

                }
            }
        });
    }
}