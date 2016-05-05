package com.leonhart.aopplayground.aspects;

public aspect Trace {

    pointcut tracedCall():
            call(void com.leonhart.aopplayground.api.Messenger.getMessage());

    before(): tracedCall() {
        System.out.println("Entering: " + thisJoinPoint);
    }

    /*
    pointcut publicMethodExecuted(): execution(public !static * *(..));

    after(): publicMethodExecuted() {
        System.out.println("Enters on method: " + thisJoinPoint.getSignature());

        Object[] arguments = thisJoinPoint.getArgs();
        for (int i =0; i < arguments.length; i++){
            Object argument = arguments[i];
            if (argument != null){
                System.out.println("With argument" + argument);
            }
        }
        System.out.println("Exits method: %s." + thisJoinPoint.getSignature());
    }
     */
}
