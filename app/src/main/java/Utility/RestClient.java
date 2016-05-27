package Utility;



import mockapi.CategoryInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;


/**
 * Created by Kokila on 23/03/16.
 */
public class RestClient {

    public static  String ENDPOINT = "http://54.254.253.175/api/v2/";//"http:/www.everytascmock.com/";
    public static String ENDPOINT1 = "http://46.137.213.164:8081/api/v1/";


    private  static  APIInterface mCategoryService = null;

    public  static APIInterface getCategoryClient() {
        if (mCategoryService == null) {
            OkHttpClient.Builder client = new OkHttpClient.Builder();

            client.interceptors().add(new CategoryInterceptor());

            final Retrofit retrofit = new Retrofit.Builder().addConverterFactory(JacksonConverterFactory.create()).baseUrl(ENDPOINT1).build();

            mCategoryService = retrofit.create(APIInterface.class);
        }

        return  mCategoryService;
    }

}
