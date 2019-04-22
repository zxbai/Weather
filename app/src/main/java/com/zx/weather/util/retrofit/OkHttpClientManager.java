package com.zx.weather.util.retrofit;

import java.io.IOException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 项目名称：Weather
 * 类描述：
 * 创建人：ZX
 * 创建时间：2019/4/21 10:31
 * 修改人：ZX
 * 修改时间：2019/4/21 10:31
 * 修改备注：
 */
public class OkHttpClientManager {
    private static final String TAG = "OkHttpClientManager";
    private static OkHttpClient sInstance;


    private static final Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = new Interceptor() {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Response originalResponse = chain.proceed(chain.request());
            return originalResponse.newBuilder().removeHeader("Pragma")
                    .header("Cache-Control", String.format("max-age=%d", 60)).build();
        }
    };

    public static OkHttpClient getInstance() {
        synchronized (OkHttpClientManager.class) {
            if (sInstance == null) {
                HostnameVerifier hv = new HostnameVerifier() {
                    public boolean verify(String urlHostName, SSLSession session) {
                        return true;
                    }
                };
                SSLContext sc = null;
                try {
                    sc = SSLContext.getInstance("SSL");
                    sc.init(null, new TrustManager[]{new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public X509Certificate[] getAcceptedIssuers() {
                            //这个不能return null~
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }}, new SecureRandom());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
                builder.addInterceptor(new LoggingInterceptor())
                        .retryOnConnectionFailure(true).connectTimeout(15, TimeUnit.SECONDS)
                        .addNetworkInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR);
                builder.sslSocketFactory(sc.getSocketFactory()).hostnameVerifier(hv);
                sInstance = builder.build();
            }
        }

        return sInstance;
    }

    /**
     * see https://github.com/square/okhttp/wiki/Interceptors
     */
    static class LoggingInterceptor implements Interceptor {
        @Override
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request original = chain.request();
            Request request = original.newBuilder()
                    .method(original.method(), original.body()).build();
//            L.e(TAG, chain.proceed(request).body().string());
            Response response = chain.proceed(request);
            return response;
        }
    }
}
