package Models.Exceptions;

public class ExceptionNoFoundMovie extends Exception
{
    @Override
    public String getMessage() {
        return "No encontré esa pelicula";
    }
}
