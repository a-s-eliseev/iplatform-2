package space.eliseev.core.api.module;

import java.io.InputStream;
import java.lang.Thread.State;

public interface Module {
    /**
     * Download configuration from the resource specified.
     * @param in
     *      Input Stream containing configurations
     */
    void onLoadConfig(InputStream in);

    /**
     * Use the input queue of messages
     * @param input
     *      Blocking Queue containing messages
     */
    void onSetInputQueue(BlockingQueue<AbstractMessage> input);

    /**
     * Use the output queue of messages
     * @param out
     *      Blocking Queue containing messages
     */
    void onSetOutputQueue(BlockingQueue<AbstractMessage> out);

    /**
     * Set a new name for a module(will be used in inner structures)
     * @param name
     *        String containing new module name
     */
    void onSetName(String name);

    /**
     * Start processing messages
     * @return Boolean result of the operation
     * @throws Exception Error while processing messages
     */
    boolean onStart() throws Exception;

    /**
     * Stop processing messages, stop the internal threads
     * @return Boolean result of the operation
     */
    boolean onStop();

    /**
     * Inform the core of its current state
     * @return the state of the core
     */

    State onGetState();
}
