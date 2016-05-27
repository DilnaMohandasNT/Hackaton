package Utility;


import java.util.HashMap;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Created by Kokila on 23/03/16.
 */
public interface APIInterface {

    /*@POST("user/register")
    Call<ForgotPassword>register(@Body HashMap<String, String> hashMap);

    @POST("user/login")
    Call<RegisterModel>login(@Body HashMap<String, String> hashMap);

    @POST("user/forgotPassword")
    Call<ForgotPassword>forgotPassword(@Body HashMap<String, String> hashMap);

    @GET("category/getParentCategories")
    Call<CategoryResponseModel> getCategory();

    @GET("category/getSubCategories")
    Call<CategoryResponseModel> getSubCategory(@Query("parentCategoryId") String parentCategoryId);

    @POST("address/create")
    Call<AddAddressResponseModel>createAddress(@Header("Authorization") String token, @Body HashMap<String, String> hashMap);

    @GET("address/list")
    Call<AddressListResponseModel>getAddress(@Header("Authorization") String token);

    @PUT("address/update")
    Call<AddAddressResponseModel>updateAddress(@Header("Authorization") String token, @Body HashMap<String, String> hashMap);

    @HTTP(method = "DELETE", path = "address/delete", hasBody = true)
    Call<ForgotPassword>deleteAddress(@Header("Authorization") String token, @Body HashMap<String, String> addressReferenceId);

    @POST("address/setDefaultAddress")
    Call<AddAddressResponseModel>setDefaultAddress(@Header("Authorization") String token, @Body HashMap<String, String> hashMap);

    @GET("user/getProfile")
    Call<UserResponseModel>getUserProfile(@Header("Authorization") String token);

    @PUT("user/update")
    Call<UserResponseModel>updateUserProfile(@Header("Authorization") String token, @Body HashMap<String, String> hashMap);

    @Multipart
    @POST("user/uploadProfilePicture")
    Call<UserResponseModel>setUserProfilePicture(@Header("Authorization") String token, @Part MultipartBody.Part file);

    @POST("tool/my/addNew")
    Call<CreateNewToolModel>createNewTool(@Header("Authorization") String token);

    @GET("manufacturer/list")
    Call<ManufacturerModel>getManufacturerList();

    @PUT("/tool/my/{referenceId}/save")
    Call<AddAddressResponseModel>updateMyTool(@Header("Authorization") String token, @Body HashMap<String, String> hashMap);*/
}
