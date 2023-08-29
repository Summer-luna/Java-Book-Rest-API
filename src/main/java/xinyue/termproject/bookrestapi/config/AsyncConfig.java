/**
 * Class: AsyncConfig
 * AuthorName: Xinyue Chen
 * Description:
 *     To configure multi-thread.
 *     It has methods taskExecutor and getAsyncExecutor.
 */
package xinyue.termproject.bookrestapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig {

  /**
   * to customize threads.
   *
   * @return CompletableFuture<List<Book>>
   */
  @Bean
  public ThreadPoolTaskExecutor taskExecutor() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(2);
    executor.setMaxPoolSize(2);
    executor.setThreadNamePrefix("Thread-");
    executor.initialize();
    return executor;
  }

  /**
   * to get async executor configured object.
   * @return Executor
   */
  public Executor getAsyncExecutor() {
    return taskExecutor();
  }
}
