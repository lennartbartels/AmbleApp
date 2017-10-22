package amble.exceptions;

/**
 * Created by lilien on 22.10.2017.
 */

public class NotLoggedinException extends RuntimeException{
    public NotLoggedinException (){super ("user is not logged in");}

}
