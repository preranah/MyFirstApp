package com.example.prerana.myfirstapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.auth.api.Auth;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener{

//****************QUESTION and the NAME variables ***************************

    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public final static String NAME = "com.example.myfirstapp.NAME";

//*****************Google Sign in Declaration**************************
    private SignInButton btnLogin;
    private GoogleSignInOptions googleSignInOptions;
    private GoogleApiClient mGoogleApiClient;
    private static final int REQUEST_CODE_LOGIN = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//**************Google Sign in Intergration **********************************

        /** GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        // [END configure_signin]

        // [START build_client]
        // Build a GoogleApiClient with access to the Google Sign-In API and the
        // options specified by gso.
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        btnLogin = (SignInButton) findViewById(R.id.signin_button);
        btnLogin.setSize(SignInButton.SIZE_ICON_ONLY);
        btnLogin.setScopes(googleSignInOptions.getScopeArray());

        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent signin = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
                startActivityForResult(signin,REQUEST_CODE_LOGIN);
            }

        });
    }

         //**********Activity when signin button is pressed *****************
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_LOGIN){
            GoogleSignInResult googleSignInResult = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            GoogleSignInAccount account = googleSignInResult.getSignInAccount();
            String personName = account.getGivenName();
        }
        else{
            Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
        }**/
    }

    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {

        //***************Creates an Intent that sends it to another activity**********
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        EditText nameText = (EditText) findViewById(R.id.name);
        String message = editText.getText().toString();
        String name = nameText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        intent.putExtra(NAME, name);
        startActivity(intent);
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}

