package com.soufun.testwcf;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.ksoap2.serialization.SoapObject;

public class MainActivity extends AppCompatActivity {
    private Button mButton1;
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton1 = (Button) findViewById(R.id.myButton1);
        text = (TextView) this.findViewById(R.id.show);

        mButton1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                new GetResult().execute();

            }
        });
    }

    class GetResult extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            HelloService service = new HelloService("");
            String restring = "";
            SoapObject result = service.LoadResult();
            if (result!=null) {
                restring = result.getProperty(0).toString();
            }
            return restring;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            text.setText("WCF返回的数据是：" + s);

        }
    }
}
