package com.robustwang.example.concurrent.cf;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AsynchronousExceptionsHandlingWithWhenComplete {
    public static void main(final String[] args) throws InterruptedException, ExecutionException {
        for (final boolean failure : new boolean[]{false}) {

            CompletableFuture<Integer> x = CompletableFuture.supplyAsync(() -> {
                if (failure) {
                    throw new RuntimeException("Oops, something went wrong");
                }
                return 42;
            });

            /**
             * Returns a new CompletableFuture with the same result or exception as this CompletableFuture,
             * that executes the given action when this stage completes.
             */
            CompletableFuture<Integer> tryX = x.whenComplete((value, ex) -> { // Note that tryX and x are of same type. This CompletableFuture acts as an invisible "decorator".
                if (value != null) {
                    // We get a chance to transform the result by adding 1...
                    System.out.println("Result: " + value);
                } else {
                    // ... or return an error value:
                    System.out.println("Error code: -1. Root cause: " + ex.getMessage());
                }
            });

            try {
                // Blocks (avoid this in production code!), and either returns the promise's value, or...
                System.out.println(tryX.get());
                System.out.println("isCompletedExceptionally = " + tryX.isCompletedExceptionally());
                // Output[failure=false]: Result: 42
                // Output[failure=false]: 42
                // Output[failure=false]: isCompletedExceptionally = false
            } catch (ExecutionException e) {
                // ... rethrows the RuntimeException wrapped as an ExecutionException
                System.out.println(e.getMessage());
                System.out.println("isCompletedExceptionally = " + tryX.isCompletedExceptionally());
                // Output[failure=true]:  Error code: -1. Root cause: java.lang.RuntimeException: Oops, something went wrong
                // Output[failure=true]:  Oops, something went wrong
                // Output[failure=true]:  isCompletedExceptionally = true
            }
        }
    }
}
