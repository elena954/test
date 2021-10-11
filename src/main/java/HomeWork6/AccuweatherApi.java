package HomeWork6;

import okhttp3.*;
import java.io.*;

public class AccuweatherApi {
    public static void main(String[] args) throws IOException {

        OkHttpClient Client = new OkHttpClient();

        String apikey = "mk32aYqtE1vJOzc0DUmzvddbcCprDLPd";
        String city = "saint Petersburg";

        HttpUrl httpUrlGetCityKey = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("locations")
                .addPathSegment("v1")
                .addPathSegment("cities")
                .addPathSegment("autocomplete")
                .addQueryParameter("apikey", apikey)
                .addQueryParameter("q", city)
                .build();

        Request requestGetCityKey = new Request.Builder()
                .url(httpUrlGetCityKey)
                .get()
                .build();

        Response checkAuthKeyResponse = Client.newCall(requestGetCityKey).execute();
        System.out.println(checkAuthKeyResponse.code());
        System.out.println(checkAuthKeyResponse.headers());

        String bodyCityKey = checkAuthKeyResponse.body().string();
        System.out.println(bodyCityKey);

        String cityKey = bodyCityKey.split(",")[1];
        cityKey = cityKey.replaceAll("\\D", "");
        System.out.println(cityKey);


        HttpUrl httpUrlGetWeatherFiveDay = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment(cityKey)
                .addQueryParameter("apikey", apikey)
                .addQueryParameter("language","ru")
                .addQueryParameter("metric","true")
                .build();

        Request requestWeatherFiveDay = new Request.Builder()
                .url(httpUrlGetWeatherFiveDay)
                .get()
                .build();

        Response weatherFiveDay = Client.newCall(requestWeatherFiveDay).execute();
        System.out.println(weatherFiveDay.code());

        String bodyWeatherFiveDay = weatherFiveDay.body().string();
        System.out.println(bodyWeatherFiveDay);

    }
}
