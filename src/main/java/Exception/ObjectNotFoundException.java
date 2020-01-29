package Exception;

/**
 *
 * @author laste
 */
public class ObjectNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public ObjectNotFoundException(Object resourId) {
        super(resourId != null ? resourId.toString() : null);
    }
}