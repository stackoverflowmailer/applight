package com.dj.applite.aspects;

import javax.ws.rs.Path;

import org.aspectj.lang.Signature;

/**
 * Aspect for intercepting the initialization of Root Resource Classes.
 *
 * @author Deepak Jacob
 */
public aspect RootResourceInitializationAspect pertypewithin(@Path *){

    before(): staticinitialization(@Path *){
        Signature sig = thisJoinPointStaticPart.getSignature();
        System.out.println("Matched : " + sig.toLongString());

    }
}
