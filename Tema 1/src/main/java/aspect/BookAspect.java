package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Component
@Aspect
public class BookAspect {
    private Logger logger = Logger.getLogger(BookAspect.class.getName());

    @Around("execution(* service.BookService.addBook(..))")
    public void logMessageForAdd(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object [] arguments = joinPoint.getArgs();

        long startTime = System.currentTimeMillis();
        joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        logger.info("After executing " + methodName + " with params: " + Arrays.asList(arguments) + " Duration: " + (endTime - startTime) + "ms");
    }

    @Around("execution(* service.BookService.removeBook(..))")
    public void logMessageForRemove(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object [] arguments = joinPoint.getArgs();

        long startTime = System.currentTimeMillis();
        joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        logger.info("After executing " + methodName + " with params: " + Arrays.asList(arguments) + " Duration: " + (endTime - startTime) + "ms");
    }

    @Around("execution(* service.BookService.borrowBook(..))")
    public void logMessageForBorrow(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object [] arguments = joinPoint.getArgs();

        long startTime = System.currentTimeMillis();
        joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        logger.info("After executing " + methodName + " with params: " + Arrays.asList(arguments) + " Duration: " + (endTime - startTime) + "ms");
    }

    @Around("@annotation(MarkedForLogging)")
    public void logMessageForReturn(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object [] arguments = joinPoint.getArgs();

        long startTime = System.currentTimeMillis();
        joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        logger.info("After executing " + methodName + " with params: " + Arrays.asList(arguments) + " Duration: " + (endTime - startTime) + "ms");
    }

    @AfterThrowing(pointcut = "execution(* service.BookService.borrowBook(..))", throwing = "exception")
    public void handleException(Exception exception) throws Throwable{
        logger.info("An error occurred: " + exception.getMessage());
    }
}
