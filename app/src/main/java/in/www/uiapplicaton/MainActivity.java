package in.www.uiapplicaton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText et1=(EditText)findViewById(R.id.number);
        final EditText et2=(EditText)findViewById(R.id.password);
        Button bt1=(Button)findViewById(R.id.sign);
        TextView reg=(TextView)findViewById(R.id.register);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Intent i =new Intent(MainActivity.this,DriverActivity.class);
                startActivity(i);
                finish();*/
                if( et1.getText().toString().length() == 0 )
                {
                    et1.setError( "number  value is required" );
                }
                else if( et2.getText().toString().length() == 0 )
                {
                    et2.setError( "password value is required" );
                }

                else {
                     /*  Intent i =new Intent(MainActivity.this,DriverActivity.class);
                startActivity(i);
                finish();*/
                    Fragment fragment =new DriverDetailsFragment();
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.container_layout,fragment);
                    ft.commit();
                }
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment =new RegisterFragment();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container_layout,fragment);
                ft.commit();

            }
        });

    }
}
