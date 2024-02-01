# concurrency

## Executor Frameworks

#### Definition -

The Executor Framework is a powerful and flexible tool for managing and executing tasks in Java applications. It provides a way to separate the task execution logic from the application code, allowing developers to focus on business logic rather than thread management.

The framework includes several key components, including the Executor, ExecutorService, ScheduledExecutorService, and ThreadPoolExecutor. These components enable developers to control the number of threads, manage task priorities, and handle exceptions and timeouts.

The Executor Framework is particularly useful for managing concurrent tasks in applications with a large number of threads or high levels of concurrency. It is widely used in applications such as web servers, where multiple requests must be processed simultaneously.

By providing a simple and efficient way to manage task execution, the Executor Framework can help developers improve the performance and scalability of their applications while minimizing the risk of threading errors and other concurrency issues.


#### Executor:
This interface provides a way to execute submitted Runnable tasks.

An Executor is normally used instead of explicitly creating threads.

For example, rather than invoking new Thread(new RunnableTask()).start() for each task of a set of tasks, you might use:

```
Executor executor = new ThreadPoolExecutor(1, 10,
                        0L, TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<Runnable>());
executor.execute(runnableTask);
```

execute(): This execute() method executes the given Runnable task at some time in the future. The command(task) may execute in a new thread, from the pooled thread, or in the calling thread, at the discretion of the Executor implementation (e.g. ThreadPoolExecutor).

In the above sample code runnableTask is a task created using lambda implementation of the run() method of the Runnable interface.

```
Runnable runnableTask = () -> {
    try {
        System.out.println("Run method called.");
        TimeUnit.MILLISECONDS.sleep(2000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
};
```

The Executor interface is part of java.util.concurrent package and was introduced in Java 1.5.

#### Executor Service

In Java, an ExecutorService is a higher-level concurrency utility provided by the java.util.concurrent package. It builds on top of the basic threading facilities provided by the language and offers a more flexible and manageable way of executing asynchronous tasks.

Here are the key points about ExecutorService:

Task Execution: ExecutorService abstracts the details of task execution. It manages a pool of threads and allows you to submit tasks (instances of Runnable or Callable) for execution.

Thread Pool: ExecutorService typically manages a pool of worker threads. Instead of creating and managing threads manually, you submit tasks to the ExecutorService, which then assigns them to available threads in the pool. This approach improves performance by reusing threads and reducing thread creation overhead.

Task Queuing: If all threads in the pool are busy executing tasks, ExecutorService can queue incoming tasks until a thread becomes available. This prevents tasks from being lost or discarded due to lack of resources.

Lifecycle Management: ExecutorService provides methods to start, shutdown, and await termination of the executor and its associated threads. Proper lifecycle management is essential for graceful shutdown and resource cleanup.

Concurrency Control: ExecutorService allows you to control the degree of concurrency by specifying parameters such as the size of the thread pool, task queue size, and thread creation policies.

Error Handling: ExecutorService provides mechanisms for handling exceptions that occur during task execution. You can retrieve the result of a task, handle exceptions, and perform cleanup operations as needed.

Overall, ExecutorService simplifies concurrent programming in Java by providing a higher-level abstraction for task execution and thread management. It promotes efficient resource utilization, better scalability, and improved code organization compared to low-level threading constructs.

Let’s See Some Methods of ExecutorService:
1. submit(): this method accepts a runnable or callable task and returns a Future that can be used to wait for completion and/or to cancel execution.

2. invokeAny(): this method accepts a collection of callable tasks and returns a result if any tasks are successful.

3. invokeAll(): this method accepts a collection of callable tasks and returns a List of Future, which will hold the result returned by each task when the asynchronous tasks are completed.



## Callabale

## Future Interface

## Completable Future