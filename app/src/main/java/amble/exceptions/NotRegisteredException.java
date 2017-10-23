package amble.exceptions;

/**
 * Created by lilien on 22.10.2017.
 */

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException (){super ("user is not registered");}
}
