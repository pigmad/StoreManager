package Exception;

/**
 *
 * @author laste
 */
public class ObjectNotFound extends Exception {
    private static final long serialVersionUID = 1L;

    public ObjectNotFound(Object resourId) {
        super(resourId != null ? resourId.toString() : null);
    }
}