

/*CompletableFuture is a class that implements two interface.

First, this is the Future interface.
Second, this is the CompletionStage interface.*/

/*In the CompletableFuture API, a task has a state which was not really the case in the Executor and Future API.
This state may be:
1. running

  It means that this task is currently running as any task.

2. completed normally.

   This is a task that run normally and produced a result in a certain way. This result can be anything including, by the way, Void that is no result.

3.completed exceptionally

   This happens if a task encountered a problem and raised an exception while running.*/

public class CompletableFutureExample2 {

}
