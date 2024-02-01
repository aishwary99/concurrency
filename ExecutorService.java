import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * The ExecutorService interface does not directly provide the submit, 
 * invokeAny, invokeAll, and shutdown methods. These methods are provided 
 * by the ThreadPoolExecutor class, which is an implementation of the 
 * ExecutorService interface. 
 */

public class ExecutorService {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Create executorService using ThreadPoolExecutor implementation of ExecutorService
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);

        // Create callable tasks using lambda implementation of call method of Callable Interface
        Callable<String> callableTask = () -> {
            System.out.println("Call method called.");
            Thread.sleep(2000); // Using TimeUnit.MILLISECONDS.sleep(2000) is not necessary
            return "Task execution in call method";
        };

        // Submit single callable task to executorService, that is returning a Future
        Future<String> future = executorService.submit(callableTask);
        System.out.println(future.get());

        // Create list of callable tasks
        List<Callable<String>> callableTasks = List.of(callableTask, callableTask, callableTask);

        // Submit the list of callable tasks to invokeAny method that returns a result.
        String result = executorService.invokeAny(callableTasks);
        System.out.println(result);

        // Submit the list of callable tasks to invokeAll method that returns a list of futures representing results of asynchronous tasks.
        List<Future<String>> futures = executorService.invokeAll(callableTasks);

        // Shutdown the executorService after completing all tasks to reclaim memory.
        executorService.shutdown();
    }
}