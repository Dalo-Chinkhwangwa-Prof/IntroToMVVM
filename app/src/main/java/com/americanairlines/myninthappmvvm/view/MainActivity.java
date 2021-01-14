package com.americanairlines.myninthappmvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory;

import android.os.Bundle;
import android.widget.TextView;

import com.americanairlines.myninthappmvvm.R;
import com.americanairlines.myninthappmvvm.viewmodel.GitViewModel;

import java.util.concurrent.atomic.AtomicBoolean;

public class MainActivity extends AppCompatActivity {

    private GitViewModel gitViewModel;



    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.main_textview);

        gitViewModel = new ViewModelProvider(this,
                AndroidViewModelFactory.getInstance(this.getApplication()))
                .get(GitViewModel.class);

        gitViewModel.getCount().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(s);
                    }
                });
            }
        });
    }
}









