package com.dj.applite.aspects;

import javax.ws.rs.Path;

public aspect SubResourceExecutionAspect {

    /**
     * The execution of any method that has the @Path annotation
     */
    pointcut subResourceExecution(Path path):
           execution(* *(..)) && @annotation(path);

    /**
     * Place holder for implementing @Path
     */
    before(Path path): subResourceExecution(path) {

        System.out.println("Advises methods having @Path annotation");
        String pathValue = path.value();
        // If required, one can check the value of the @Path here
        System.out.println("Path : " + pathValue);

    }

}
