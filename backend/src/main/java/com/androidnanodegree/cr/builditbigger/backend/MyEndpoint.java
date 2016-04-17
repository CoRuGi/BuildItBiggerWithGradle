/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.androidnanodegree.cr.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.udacity.gradle.javaJokes.JokeTeller;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
  name = "myApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "backend.builditbigger.cr.androidnanodegree.com",
    ownerName = "backend.builditbigger.cr.androidnanodegree.com",
    packagePath=""
  )
)
public class MyEndpoint {

    @ApiMethod(name = "tellMeAJoke")
    public MyBean tellMeAJoke() {
        MyBean response = new MyBean();

        JokeTeller jokeTeller = new JokeTeller();
        response.setData(jokeTeller.tellMeAJoke());

        return response;
    }

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name) {
        MyBean response = new MyBean();
        response.setData("Hi, " + name);

        return response;
    }
}
