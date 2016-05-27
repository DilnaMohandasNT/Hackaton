package mockapi;



import java.io.IOException;

import everytasc.nineleaps.com.hackaton.BuildConfig;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by Kokila on 23/03/16.
 */
public class CategoryInterceptor implements Interceptor {

    private final static String TEACHER_ID_1 = "{\"id\":1,\"age\":28,\"name\":\"Victor Apoyan\"}";
    private final static String CATEGORY  = "{\"status\": \"success\", \"data\": [{\"id\": 1, \"categoryname\": \"Aerial Equipment\", \"categoryurl\": \"http://www.ovenden.biz/images/earth_01.jpg\"  },{ \"id\": 2, \"categoryname\": \"Air Tool\", \"categoryurl\":\"http://www.worldhighways.com/EasysiteWeb/getresource.axd?AssetID=88900&type=custom&servicetype=Inline&customSizeId=14\" },{ \"id\": 3,\"categoryname\": \"Compaction & Paving\",\"categoryurl\": \"http://www.ovenden.biz/images/earth_01.jpg\"}, {\"id\": 4, \"categoryname\": \"Concrete & Masonry\",\"categoryurl\": \"http://www.ironwolf.com/wp-content/uploads/2012/03/ejection-scraper.jpg\" }, { \"id\": 5,\"categoryname\": \"Earth Moving\", \"categoryurl\": \"http://www.ovenden.biz/images/earth_01.jpg\" }, {\"id\": 6,\"categoryname\": \"Facility Maintenance\",\"categoryurl\":\"http://www.worldhighways.com/EasysiteWeb/getresource.axd?AssetID=88900&type=custom&servicetype=Inline&customSizeId=14\"},{\"id\": 7, \"categoryname\": \"Jumping Jack\",\"categoryurl\":\"http://www.ironwolf.com/wp-content/uploads/2012/03/ejection-scraper.jpg\"},{\"id\": 8, \"categoryname\": \"Pavers\", \"categoryurl\": \"http://www.worldhighways.com/EasysiteWeb/getresource.axdAssetID=88900&type=custom&servicetype=Inline&customSizeId=14\" }, {\"id\": 9, \"categoryname\": \"Scrappers\", \"categoryurl\":\"http://www.accuratetiles.com/gallery/P399027.jpg\" }, { \"id\": 10,\"categoryname\": \"Rollers\", \"categoryurl\": \"http://www.accuratetiles.com/gallery/P399027.jpg\"}]}";

    @Override
    public Response intercept(Chain chain) throws IOException {

        Response response = null;

            String teacher = "{\"id\":1,\"age\":28,\"name\":\"Victor Apoyan\"}";
        if(BuildConfig.DEBUG) {
            String responseString;
            responseString = CATEGORY;

            response = new Response.Builder()
                    .code(200)
                    .message(responseString)
                    .request(chain.request())
                    .protocol(Protocol.HTTP_1_0)
                    .body(ResponseBody.create(MediaType.parse("application/json"), responseString.getBytes()))
                    .addHeader("content-type", "application/json")
                    .build();
        } else {
            response = chain.proceed(chain.request());
        }
        return  response;
    }
}
