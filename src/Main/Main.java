package Main;

import Models.Exceptions.ExceptionNoFoundMovie;
import Models.ListMovies;
import Models.Movie;
import Models.MovieSwapi;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws IOException, InterruptedException
    {
        var input = new Scanner(System.in);
        var numeroDePelicula = "1";
        var listOfMovies = new ListMovies();
        var desicion = 0;

        while (!numeroDePelicula.equals("0"))
        {

            System.out.print("Ingresa el numero de la pelicula :");
            numeroDePelicula = input.nextLine();

            String direccion = "https://swapi.dev/api/films/"+numeroDePelicula+"/";

            // Aqui creamos la petición y respuesta
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder().uri(URI.create(direccion)).build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                //variable que guarda la informacion de respuesta reciba
                String json = response.body();

                System.out.println(json);
                //creando mi objeto gson
                Gson gson = new Gson();

                MovieSwapi movieSwapi = gson.fromJson(json , MovieSwapi.class);

                Movie newMovie = new Movie(movieSwapi);

                System.out.println(newMovie);

                listOfMovies.Agregar(newMovie);

            }catch(Exception e){
                System.out.println("mensaje de error : "+ e.getMessage());
            }finally {
                System.out.print("""
                    Salir? 
                    0. SI
                    1. NO : """);
                numeroDePelicula = input.nextLine();
            }
        }

        System.out.println("------------------LISTA DE PELICULAS---------------------");
        listOfMovies.getListMovies().forEach(System.out::println);

        //El patron de Diseño Builder(CONSTRUCTOR), podemos contruir es decir
        // poner .setPretty o muchos metodos mas y al final siempre debemos finalizar
        // conn .create(); .
        // .setPrettyPrinting()  nos sirve para que muestre nuestro archivo JSON organizado
        // es decir que aparesca de manera vertical con las dos columnas de clave-valor

        /**
         * setPrettyPrinting : Configura Gson para generar Json que se ajuste a una página para una impresión bonita
         */
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        //Guardando en memoria , siempre al fnal hay que poner .close() para que escriba
        // los datos en memoria
        FileWriter escribirEnMemoria = new FileWriter("listMovies.json");
        escribirEnMemoria.write(gson.toJson(listOfMovies));
        escribirEnMemoria.close();

        System.out.println("The end, ¡Good Bye!");




    }
}
