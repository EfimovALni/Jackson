package cz.firstapp.jackson_3;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {
    @FormUrlEncoded
    @POST("DAN/ajaxData.php")
    Call<DataResponse> getData(@FieldMap Map<String, String> fields);
}
