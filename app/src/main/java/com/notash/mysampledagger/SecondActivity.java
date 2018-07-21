package com.notash.mysampledagger;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.notash.mysampledagger.di.ActivityComponent;
import com.notash.mysampledagger.di.ActivityModule;
import com.notash.mysampledagger.di.DaggerActivityComponent;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SecondActivity extends AppCompatActivity {

    Button button;
    TextView textView;


//    @Inject
//    ApiInterface apiInterface;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);

        ApiInterface apiInterface2 = (App.get(this).component).getApiInterface();



        ActivityComponent component = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(App.get(this).getComponent())
                .build();


        component.inject(SecondActivity.this);

//        if (apiInterface != null) {
//            Call<JsonObject> call = apiInterface.getCitiesFromCall();
//            call.enqueue(new Callback<JsonObject>() {
//                @Override
//                public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
//                    Log.e("RES", "onResponse: " + response.body());
//                }
//
//                @Override
//                public void onFailure(Call<JsonObject> call, Throwable t) {
//                    Log.d("ERR", "onFailure: ");
//                }
//            });
//        }

        apiInterface2.getCities()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonObject>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JsonObject object) {
                        Log.e("RES", "onNext: " + object.toString());
                        textView.setText(object.get("data").getAsJsonArray().toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("ERR", "onError: ");
                    }

                    @Override
                    public void onComplete() {
                        Log.e("COMPLETE", "onComplete: " );
                    }
                });


    }
}
