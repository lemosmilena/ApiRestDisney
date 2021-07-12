# CRUD Disney

## Objetivo:

### . Crear un sistema AMBC (CRUD) para explorar el mundo Disney
### . Se pueden crear personajes, peliculas, generos y usuarios
### . Proveer un sistema de búsqueda por nombre, edad, peso, ID
### . Permitir registrar usuarios


## Base de datos: 

#### Tabla personajes: 
    character_id, image_url, name, age, history, weight. 

#### Tabla peliculas: 
    movie_id, image_url, title, year, score.

#### Tabla de generos: 
    genre_id, name, image_url. 

#### Tabla personajes por pelicula:     
    character_id, movie_id. 

#### Tabla generos por pelicula: 
     genre_id, movie_id. 


## Entidades en Java: 

     @Entity CharacterEntity
     @Entity MovieEntity 
     @Entity GenreEntity
     @Entity UserEntity

## Repositorios en Java: 

     @Repository public interface CharacterRepository extends JpaRepository<CharacterEntity, Integer>
     @Repository public interface MovieRepository extends JpaRepository<MovieEntity, Integer>
     @Repository public interface GenreRepository extends JpaRepository<GenreEntity, Integer>
     @Repository public interface UserRepository extends JpaRepository<UserEntity, Integer>

## Servicios en Java: 

     @Service CharacterService
     @Service MovieService
     @Service GenreService
     @Service UserService

     Inyectando en cada uno su respectivo repositorio con @Autowired

## Controladores en Java: 

     @RestController CharacterController
     @RestController MovieController 
     @RestController GenreController
     @RestController UserController 

     Inyectando en cada uno su respectivo servicio con @Autowired

### Endpoints: 

#### Personajes: 

     GET /characters
          Lista todos los personajes.
     GET /characters/name/{name}
          Busca por nombres que contengan ese valor.
     GET /characters/id/{id}
          Busca un personaje por el número de ID. 
     GET /characters/weight/{weight}
          Lista personajes que contengan ese valor. 
     GET /characters/age/{age}
          Lista personajes que contengan ese valor. 
     POST /characters/guardar
          Guarda o actualiza un personaje (según ID). 
     DELETE /characters/delete
          Elimina un personaje según ID. 
          
          
#### Peliculas: 

     GET /movies
          Lista todas las peliculas.
     GET /movies/title/{title}
          Busca por titulos que contengan ese valor.
     GET /movies/id/{id}
          Busca una pelicula por el número de ID. 
     POST /movies/guardar
          Guarda o actualiza una pelicula (según ID). 
     DELETE /movies/delete
          Elimina una pelicula según ID. 
          
          
#### Usuarios: 

     POST /auth/register
          Permite registrar un usuario devolviendole un token.
