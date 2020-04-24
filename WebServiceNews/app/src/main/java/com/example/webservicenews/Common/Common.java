package com.example.webservicenews.Common;

import com.example.webservicenews.Interface.IconBetterIdeaService;
import com.example.webservicenews.Interface.NewService;
import com.example.webservicenews.Remote.IconBetterIdeaClient;
import com.example.webservicenews.Remote.RetrofitClient;
/* Connection manager */
public class Common {
    private  static  final String BASE_URL = "https://newsapi.org/";
    public static final String API_KEY = "dcb44fc4124d4096b822365ad634a927";

    /**
     * start service of gettin data fromm newsapi.org/
     * @return
     */
    public static NewService getNewService(){
        return RetrofitClient.getClient(BASE_URL).create(NewService.class);
    }

    public static IconBetterIdeaService getIconService(){
        return IconBetterIdeaClient.getClient().create(IconBetterIdeaService.class);
    }
}
