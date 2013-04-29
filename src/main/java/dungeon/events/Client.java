package dungeon.events;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * A general implementation of something, that consumes and/or produces events.
 */
abstract class Client implements Runnable {
  private final EventHost eventHost;

  private final AtomicBoolean running = new AtomicBoolean(true);

  public Client (EventHost eventHost) {
    this.eventHost = eventHost;
  }

  /**
   * You should stop.
   */
  public void shutdown () {
    running.set(false);
  }

  /**
   * Should this client still run?
   */
  public boolean isRunning () {
    return running.get();
  }

  /**
   * The event host calls this to pass an event to the client.
   *
   * Beware that this method is called from the host's thread.
   */
  public void onEvent (Event event) {

  }

  public EventHost getEventHost () {
    return eventHost;
  }
}
