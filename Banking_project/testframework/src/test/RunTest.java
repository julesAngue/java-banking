package test;

import logger.Logger;
import logger.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunTest {
    private static Logger logger;
    private static int tests;
    private static int testsFailed;

    public static void testClass(String className) {
        logger.debug("PROGRAM", "test " + className);

        try {
            Class<?> clazz = Class.forName(className);

            try {
                Object instance = clazz.newInstance();

                for (Method method : clazz.getDeclaredMethods()) {
                    testMethod(clazz,instance,method);
                }
            }

            catch (InstantiationException | IllegalAccessException e ) {
                logger.error("OUTPUT", clazz.getName() + "instantiation failure");
            }

        }
        catch(ClassNotFoundException e){
            logger.error("<output>",className + " not found");
        }
    }



    public static void testMethod(Class<?> clazz,Object instance, Method method){
        logger.debug("PROGRAM","launch"+clazz.getName()+"."+method.getName());

        tests++;
        boolean okOrko = true;
        long duration = 0;

        try {

            long time = System.currentTimeMillis();

            try {

                method.invoke(instance);

            } catch (IllegalAccessException e) {
                okOrko = false;
            }

            duration = System.currentTimeMillis() - time;
        }catch (InvocationTargetException e){
            okOrko = false;
        }

        if(okOrko){
            logger.info("OUTPUT",clazz.getName() + method.getName() +": OK" + duration +"ms");
        }else{
            logger.info("OUTPUT",clazz.getName() + method.getName() +": KO" + duration +"ms");
            testsFailed++;
        }
    }

    public static void main(String [] args){

        logger = LoggerFactory.getLogger();
        logger.debug("PROGRAM","tests");

        long Time = System.currentTimeMillis();
        for(String className: args) {
            testClass(className);
        }

        long finalTime = System.currentTimeMillis() - Time;

        int testsSucceeds = tests - testsFailed;
        float succeedRate = (float)testsSucceeds / tests * 100;

        logger.info("<output>","Succeed Rate: "+ succeedRate + " total duration: "+finalTime +"ms");
    }





}
