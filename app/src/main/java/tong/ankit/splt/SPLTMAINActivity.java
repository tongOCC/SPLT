package tong.ankit.splt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SPLTMAINActivity extends AppCompatActivity {

    private EditText mUsernameEditText;
    private EditText mPasswordEditText;
    private Button mLoginButton;
    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spltmain);
        mUsernameEditText = (EditText) findViewById(R.id.editTextUsername);
        mPasswordEditText = (EditText) findViewById(R.id.editTextPassword);
        mLoginButton = (Button) findViewById(R.id.CredentialCheckButton);


        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());
    }
    public void signInClick(View view) {
        if(mUsernameEditText.getText().toString().equals("yes") &&
                mPasswordEditText.getText().toString().equals("yes"))
        {
            Intent toHomePage = new Intent(this, HomePageActivity.class);
            startActivity(toHomePage);
        }
    }
    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}


