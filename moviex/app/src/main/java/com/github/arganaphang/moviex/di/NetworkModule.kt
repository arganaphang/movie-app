package com.github.arganaphang.moviex.di

import android.content.Context
import coil.ImageLoader
import okhttp3.OkHttpClient

//@Module
//@InstallIn(SingletonComponent::class)
object NetworkModule {

//  @Provides
//  @Singleton
//  fun provideOkHttpClient(): OkHttpClient {
//    return OkHttpClient.Builder()
//      .addInterceptor(RequestInterceptor())
//      .build()
//  }

//  @Provides
//  @Singleton
//  fun provideImageLoader(
//      @ApplicationContext context: Context,
//      okHttpClient: OkHttpClient
//  ): ImageLoader {
//    return ImageLoader.Builder(context)
//      .okHttpClient { okHttpClient }
//      .build()
//  }

//  @Provides
//  @Singleton
//  fun provideRetrofit(okhHttpClient: OkHttpClient): Retrofit {
//    return Retrofit.Builder()
//      .client(okhHttpClient)
//      .baseUrl(Api.BASE_URL)
//      .addConverterFactory(GsonConverterFactory.create())
//      .addCallAdapterFactory(CoroutinesResponseCallAdapterFactory.create())
//      .build()
//  }

//  @Provides
//  @Singleton
//  fun provideMovieService(retrofit: Retrofit): MovieService {
//    return retrofit.create(MovieService::class.java)
//  }
}