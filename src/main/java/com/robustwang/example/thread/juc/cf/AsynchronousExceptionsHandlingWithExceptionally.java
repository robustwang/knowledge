package com.robustwang.example.thread.juc.cf;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AsynchronousExceptionsHandlingWithExceptionally {
    public static void main(final String[] args) throws InterruptedException, ExecutionException {
        for (final boolean failure : new boolean[]{true}) {

            CompletableFuture<Integer> x = CompletableFuture.supplyAsync(() -> {
                if (failure) {
                    throw new RuntimeException("Oops, something went wrong");
                }
                return 42;
            });

            /**
             * Returns a new CompletableFuture that is completed when this CompletableFuture completes,
             * with the result of the given function of the exception triggering this CompletableFuture's completion
             * when it completes exceptionally; otherwise, if this CompletableFuture completes normally,
             * then the returned CompletableFuture also completes normally with the same value.
             */
            CompletableFuture<Integer> tryX = x.exceptionally(ex -> -1); // Note that tryX and x are of same type.

            // Blocks (avoid this in production code!), and either returns the promise's value
            System.out.println(tryX.get());
            System.out.println("isCompletedExceptionally = " + tryX.isCompletedExceptionally());

            // Output[failure=false]: 42
            // Output[failure=false]: isCompletedExceptionally = false

            // Output[failure=true]:  -1
            // Output[failure=true]:  isCompletedExceptionally = false
        }
    }
}
