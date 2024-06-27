package Models;

import java.util.ArrayList;
import java.util.List;

public class ListMovies
{
    private final List<Movie> listMovies;

    public ListMovies()
    {
        listMovies = new ArrayList<>();
    }

    //Lista de peliculas (la cual usaremos para luego pasarla a JSON)
    //Esto lo heremos con la biblioteca Gson (Serielización y Deserialización)

    public List getListMovies()
    {
        return listMovies;
    }

    public void Agregar(Movie movie){
        listMovies.add(movie);
    }
}
