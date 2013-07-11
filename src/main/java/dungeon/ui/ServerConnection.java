package dungeon.ui;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Handles the connection to the server.
 */
public class ServerConnection {
  private static final Logger LOGGER = Logger.getLogger(ServerConnection.class.getName());

  private final Socket socket;

  private final ObjectInputStream inputStream;

  private final ObjectOutputStream outputStream;

  public ServerConnection (String host, int port) throws IOException {
    LOGGER.info("Connecting to " + host + ":" + port);

    try {
      this.socket = new Socket(host, port);
    } catch (IOException e) {
      LOGGER.log(Level.WARNING, "Error while connecting to " + host + ":" + port, e);

      throw e;
    }

    try {
      this.outputStream = new ObjectOutputStream(socket.getOutputStream());
      this.inputStream = new ObjectInputStream(socket.getInputStream());
    } catch (IOException e) {
      LOGGER.log(Level.WARNING, "Could not create in/out streams", e);

      throw e;
    }
  }

  public Object read () throws IOException, ClassNotFoundException {
    return this.inputStream.readObject();
  }

  public void write (Object object) throws IOException {
    this.outputStream.writeObject(object);
  }
}