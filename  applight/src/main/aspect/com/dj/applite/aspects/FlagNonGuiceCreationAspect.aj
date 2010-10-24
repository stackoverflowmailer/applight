package com.dj.applite.aspects;

import javax.ws.rs.Path;

import org.aspectj.lang.Signature;

import com.sun.jersey.core.spi.component.ioc.IoCComponentProvider;
import com.sun.jersey.server.impl.wadl.WadlResource;
import com.sun.jersey.server.spi.component.ResourceComponentProvider;
import com.sun.jersey.spi.resource.Singleton;

public aspect FlagNonGuiceCreationAspect {

    pointcut checkResourceProviderFactory(/* PerRequestFactory prf, */Class c):
	execution(ResourceComponentProvider *.getComponentProvider(..)) 
	//&& target(PerRequestFactory) 
	//&& this(PerRequestFactory) 
	&& args(/*prf,*/ c);

    pointcut checkIOCResourceProviderFactory(/* PerRequestFactory prf, */Class c):
	execution(IoCComponentProvider *.getComponentProvider(..)) 
	//&& target(PerRequestFactory) 
	//&& this(PerRequestFactory) 
	&& args(/*prf,*/ c);

    Object around(/* PerRequestFactory prf, */Class c): checkResourceProviderFactory(/*prf,*/ c) {
        System.out.println("======================================= ");
        Signature sig = thisJoinPointStaticPart.getSignature();
        System.out.println("ComponentProviderFactory : " + sig.toLongString());
        System.out.println("Matched                  : " + c.getCanonicalName());
        System.out.println("======================================= ");
        boolean annotationPresent = c.isAnnotationPresent(Path.class) || c.isAnnotationPresent(Singleton.class);
        boolean isApplicationResource = !(c.getClass().getCanonicalName() == WadlResource.class.getCanonicalName());
        if (annotationPresent && !isApplicationResource) {
            throw new RuntimeException(new IllegalAccessException("The resource " + c.getCanonicalName()
                    + " should be constructed by Guice"));
        }
        Object object = proceed(c);
        return object;
    }

    before(/* PerRequestFactory prf, */Class c): checkIOCResourceProviderFactory(/*prf,*/ c) {
        System.out.println("======================================= ");
        Signature sig = thisJoinPointStaticPart.getSignature();
        System.out.println("ComponentProviderFactory : " + sig.toLongString());
        System.out.println("Matched                  : " + c.getCanonicalName());
        System.out.println("======================================= ");
    }

}
