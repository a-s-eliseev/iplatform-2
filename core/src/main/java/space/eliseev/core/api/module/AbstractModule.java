package space.eliseev.core.api.module;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;

@Slf4j
@Data
public abstract class AbstractModule implements Module {
    /**
     * Input queue for messages processed
     */
    protected BlockingQueue<AbstractMessage> input;
    /**
     * Output queue for messages processed
     */
    protected BlockingQueue<AbstractMessage> output;
    /**
     * Full name of a module
     */
    protected String name;

    /**
     * Method to be overridden in the child class. This method is responsible for loading configurations, state,
     * launching internal cycles of message processing, accessing external resources etc.
     *
     * @throws Exception
     */
    protected abstract void doStart() throws Exception;

    /**
     * Method to be overridden in the child class. This method is responsible for saving configurations, state,
     * stopping internal cycles of message processing, closing access to external resources etc.
     *
     * @throws Exception
     */
    protected abstract void doStop() throws Exception;

    /**
     * Checks if all the fields are initialized
     */
    protected void checkConditions() {
        if (input == null || output == null || name == null) {
            log.error("Not all fields are initialized");
        }else{
            log.info("All fields are initialized");
        }
    }
}
