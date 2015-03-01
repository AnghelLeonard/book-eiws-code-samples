package net.lkrnac.book.eiws;

import java.util.function.BiFunction;

/**
 * Class responsible to retrying operations of {@link BiFunction} instance.
 * 
 * @author Lubos Krnac
 *
 * @param <T>
 *          first parameter for retry operation (function)
 * @param <U>
 *          second parameter for retry operation (function)
 * @param <R>
 *          return type of retry operation (function)
 */
public class BiFunctionRetryHandler<T, U, R> {
  private static final int RETRY_TIMEOUT = 50;

  /**
   * Tries to execute given function in loop and ignore errors. Returns after
   * first successful call.
   * 
   * @param function
   *          method to execute
   * @param parameter1
   *          first parameter to pass into method
   * @param parameter2
   *          second parameter to pass into method
   * @param timeout
   *          timeout of retry loop
   * @return return value from function
   */
  @SuppressWarnings({ "checkstyle:emptyblock", "PMD.AvoidCatchingThrowable",
      "PMD.EmptyCatchBlock" })
  public final R retry(BiFunction<T, U, R> function, T parameter1,
      U parameter2, int timeout) {
    long start = System.currentTimeMillis();
    while ((System.currentTimeMillis() - start) < timeout) {
      try {
        Thread.sleep(RETRY_TIMEOUT);
        return function.apply(parameter1, parameter2);
      } catch (Throwable throwable) {
        // ignore errors
      }
    }
    return null;
  }
}
