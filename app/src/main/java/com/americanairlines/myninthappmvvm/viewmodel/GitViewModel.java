package com.americanairlines.myninthappmvvm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.concurrent.atomic.AtomicBoolean;

public class GitViewModel extends ViewModel {

    private MutableLiveData<String> countLiveData = new MutableLiveData<>();
    private AtomicBoolean counting = new AtomicBoolean(false);

    public LiveData<String> getCount(){
        if(!counting.getAndSet(true)) {
            new Thread() {
                @Override
                public void run() {
                    super.run();

                    //count 1 to 1000
                    for (int i = 0; i < 1000; i++) {

                        try {
                            countLiveData.postValue((i + 1) + " Seconds......!!");

                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    counting.set(false);
                }
            }.start();
        }

        return  countLiveData;
    }

}
