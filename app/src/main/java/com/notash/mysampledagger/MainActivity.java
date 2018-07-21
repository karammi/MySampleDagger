package com.notash.mysampledagger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.notash.mysampledagger.models.City;
import com.notash.mysampledagger.models.User;

import java.lang.reflect.Type;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {

    User user;

    Button button;
    TextView textView;
    JsonArray jsonArray;

    Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);



//        ApiInterface apiInterface = AppConstants.createService(ApiInterface.class);
//        Observable<City> call = apiInterface.getCities();
//        call.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<City>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(City city) {
//                        Log.e("ERR", "onNext: "+city.name );
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });




//        Observable<JsonObject> call = apiInterface.getCities();
//        call.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<JsonObject>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(JsonObject object) {
//                        Log.e("RES", "onNext: "+object.toString() );
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e("ERR", "onError: "+e.getMessage() );
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.e("DONE", "onComplete: " );
//                    }
//                });















//        Call<JsonObject> call = apiInterface.getCities();
//        call.enqueue(new Callback<JsonObject>() {
//            @Override
//            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
//                Log.e("RES", "onResponse: " + response.body());
//                if (response.code() == 200)
//                    setData(response.body().get("data").getAsJsonArray());
//            }
//
//            @Override
//            public void onFailure(Call<JsonObject> call, Throwable t) {
//                Log.e("ERR", "onFailure: " + t.getMessage());
//            }
//        });
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                doSomeWork();
//            }
//        });

//        ApiInterface apiInterface = AppConstants.createService(ApiInterface.class);


//       Observer<City> cityObserver = apiInterface.getCities()
//               .subscribeOn(Schedulers.io())
//               .observeOn(AndroidSchedulers.mainThread())
//               .subscribeWith(new


//        UserComponent userComponent = DaggerUserComponent.builder().userModule(new UserModule()).build();
//        user = userComponent.provideUser();
//
//        user.setUserContact("asad.karammi@gamil.com");
//        Toast.makeText(this, user.getUserContact(), Toast.LENGTH_SHORT).show();

    }

    private void setData(JsonArray array) {
        jsonArray = array;
        Type type = new TypeToken<List<City>>() {
        }.getType();

        List<City> list = new Gson().fromJson(array, type);
        Log.e("LIST", "setData: " + list.size());

    }


    private void doConvert() {
//        getObservable()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .map(new Function<JsonArray, List<City>>() {
//
//                    @Override
//                    public List<City> apply(JsonArray array) throws Exception {
////                        return AppConstants.getCities(array);
//                        List<City> list =new ArrayList<>();
//                        return list;
//                    }
//
//                })
//                .subscribe(new Observer<List<City>>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(List<City> cities) {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });

    }


    private void doSomeWork() {
        getObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getObserver());
    }

    private Observable<Integer> getObservable() {


        return Observable.just(1, 2, 3, 4, 5, 6, 7, 9, 10);

//        return Observable.fromArray(array);

//        return Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
//                emitter.onNext(1);
//                emitter.onNext(2);
//                emitter.onNext(3);
//                emitter.onNext(4);
//                emitter.onNext(5);
//                emitter.onNext(6);
//                emitter.onNext(7);
//                emitter.onComplete();
//            }
//        });
    }

    private Observer<Integer> getObserver() {
        return new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {
                textView.append(" new Line " + String.valueOf(integer) + " ");
                Log.e("RES", "onNext: " + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("ERR", "onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.e("RES", "onComplete: ");
            }
        };
    }
}
