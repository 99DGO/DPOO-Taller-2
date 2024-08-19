package uniandes.dpoo.estructuras.logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre listas de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos listaEnteros y listaCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre listas (ie., no haga cosas como construir arreglos para evitar la manipulación de listas).
 * 
 * Intente usar varias formas de recorrer las listas (while, for, for each, iteradores ... )
 */
public class SandboxListas
{
    /**
     * Una lista de enteros para realizar varias de las siguientes operaciones.
     */
    private List<Integer> listaEnteros;

    /**
     * Una lista de cadenas para realizar varias de las siguientes operaciones
     */
    private List<String> listaCadenas;

    /**
     * Crea una nueva instancia de la clase con las dos listas inicializadas pero vacías
     */
    public SandboxListas( )
    {
        listaEnteros = new ArrayList<Integer>( );
        listaCadenas = new LinkedList<String>( );
    }

    /**
     * Retorna una copia de la lista de enteros, es decir una nueva lista del mismo tamaño que contiene copias de los valores de la lista original
     * @return Una copia de la lista de enteros
     */
    public List<Integer> getCopiaEnteros( )
    {
    	List<Integer> Copia = new ArrayList<Integer>(this.listaEnteros);
        return Copia;
    }

    /**
     * Retorna una copia de la lista de cadenas, es decir una nueva lista del mismo tamaño que contiene copias de los valores de la lista original
     * @return Una copia de la lista de cadenas
     */
    public List<String> getCopiaCadenas( )
    {
    	List<String> Copia = new LinkedList<String>(this.listaCadenas);
        return Copia;
    }

    /**
     * Retorna un arreglo con los valores de la lista de enteros, es decir un arreglo del mismo tamaño que contiene copias de los valores de la lista
     * @return Una arreglo de enteros
     */
    public int[] getEnterosComoArreglo( )
    {
    	int[] arr = new int[this.listaEnteros.size()];
    	Iterator<Integer> it = this.listaEnteros.iterator();
    	int i =0;

        while (it.hasNext()) 
        {
            arr[i]=it.next();
            i+=1;
        }
        return arr;
    }

    /**
     * Retorna la cantidad de valores en la lista de enteros
     * @return
     */
    public int getCantidadEnteros( )
    {
        return this.listaEnteros.size();
    }

    /**
     * Retorna la cantidad de valores en la lista de cadenas
     * @return
     */
    public int getCantidadCadenas( )
    {
        return this.listaCadenas.size();
    }

    /**
     * Agrega un nuevo valor al final de la lista de enteros. Es decir que este método siempre debería aumentar en 1 el tamaño de la lista.
     * 
     * @param entero El valor que se va a agregar.
     */
    public void agregarEntero( int entero )
    {
    	this.listaEnteros.add(entero);
    }

    /**
     * Agrega un nuevo valor al final de la lista de cadenas. Es decir que este método siempre debería aumentar en 1 la capacidad de la lista.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena( String cadena )
    {
    	this.listaCadenas.add(cadena);
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro de la lista de enteros
     * @param valor El valor que se va eliminar
     */
    public void eliminarEntero( int valor )
    {
    	//USA EN EL FUTURO SOLAMENTE REMOVEALL
    	Iterator<Integer> it1 = this.listaEnteros.iterator();
    	int i =0;
    	int deficit =0;
    	ArrayList<Integer> toRemove = new ArrayList<Integer>();

        while (it1.hasNext()) 
        {
        	if (it1.next()==valor)
        	{
        		toRemove.add(Integer.valueOf(i));
        	}
            i+=1;
        }
        
        Iterator<Integer> it2 = toRemove.iterator();
        
        while (it2.hasNext()) 
        {
        	listaEnteros.remove(it2.next()-deficit);
        	deficit+=1;
        }
        
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro de la lista de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena( String cadena )
    {
    	Iterator<String> it1 = this.listaCadenas.iterator();
    	int i =0;
    	int deficit =0;
    	ArrayList<Integer> toRemove = new ArrayList<Integer>();

        while (it1.hasNext()) 
        {
        	if (it1.next().equals(cadena))
        	{
        		toRemove.add(Integer.valueOf(i));
        	}
            i+=1;
        }
        
        Iterator<Integer> it2 = toRemove.iterator();
        
        while (it2.hasNext()) 
        {
        	listaCadenas.remove(it2.next()-deficit);
        	deficit+=1;
        }
    }

    /**
     * Inserta un nuevo entero en la lista de enteros
     * 
     * @param entero El nuevo valor que debe agregarse
     * @param posicion La posición donde debe quedar el nuevo valor en la lista aumentada. Si la posición es menor a 0, se inserta el valor en la primera posición. Si la
     *        posición es mayor que el tamaño de la lista, se inserta el valor en la última posición.
     */
    public void insertarEntero( int entero, int posicion )
    {
    	if (posicion<0)
    	{
    		posicion=0;
    		this.listaEnteros.add(posicion, entero);
    	}
    	else if (posicion>=this.listaEnteros.size())
    	{
    		this.listaEnteros.add(entero);
    	}
    	else
    	{
        	this.listaEnteros.add(posicion, entero);
    	}
    	
    }

    /**
     * Elimina un valor de la lista de enteros dada su posición.
     * @param posicion La posición donde está el elemento que debe ser eliminado. Si el parámetro posicion no corresponde a ninguna posición de la lista de enteros, el método
     *        no debe hacer nada.
     */
    public void eliminarEnteroPorPosicion( int posicion )
    {
    	if (!(posicion<0) && !(posicion>=this.listaEnteros.size()))
    	{
    		this.listaEnteros.remove(posicion);
    	}
    }

    /**
     * Reinicia la lista de enteros con los valores contenidos en el parámetro 'valores', pero truncados.
     * 
     * Es decir que si el valor fuera 3.67, en la nueva lista debería quedar el entero 3.
     * @param valores Un arreglo de valores decimales.
     */
    public void reiniciarArregloEnteros( double[] valores )
    {
    	List<Integer> nuevaLista = new ArrayList<Integer>( ); 
    	
    	for (int i=0; i<valores.length; i++)
    	{
    		int num= (int)valores[i];
    		nuevaLista.add(num);
    	}
    	
    	this.listaEnteros=nuevaLista;
    }

    /**
     * Reinicia la lista de cadenas con las representaciones como Strings de los objetos contenidos en la lista del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Una lista de objetos
     */
    public void reiniciarArregloCadenas( List<Object> objetos )
    {
    	List<String> nuevaLista = new LinkedList<String>( ); 
    	
    	for (int i=0; i<objetos.size(); i++)
    	{
    		String cad= objetos.get(i).toString();
    		nuevaLista.add(cad);
    	}
    	
    	this.listaCadenas=nuevaLista;
    }

    /**
     * Modifica la lista de enteros para que todos los valores sean positivos.
     * 
     * Es decir que si en una posición había un valor negativo, después de ejecutar el método debe quedar el mismo valor muliplicado por -1.
     */
    public void volverPositivos( )
    {
    	Iterator<Integer> it = this.listaEnteros.iterator();
    	int i =0;

        while (it.hasNext()) 
        {
        	Integer num = it.next();
        	
        	if (num<0)
        	{
        		num=num*-1;
        		this.listaEnteros.set(i, num);
        	}
            i+=1;
        }
    }

    /**
     * Modifica la lista de enteros para que todos los valores queden organizados de MAYOR a MENOR.
     */
    public void organizarEnteros( )
    {
    	Collections.sort(this.listaEnteros, Collections.reverseOrder());

    }

    /**
     * Modifica la lista de cadenas para que todos los valores queden organizados lexicográficamente.
     */
    public void organizarCadenas( )
    {
    	Collections.sort(this.listaCadenas);
    }

    /**
     * Cuenta cuántas veces aparece el valor recibido por parámetro en la lista de enteros
     * @param valor El valor buscado
     * @return La cantidad de veces que aparece el valor
     */
    public int contarApariciones( int valor )
    {
    	Iterator<Integer> it = this.listaEnteros.iterator();
    	int tot=0;

        while (it.hasNext()) 
        {
        	if (it.next().equals(Integer.valueOf(valor)))
        	{
        		tot+=1;
        	}
        }
        return tot;
    }

    /**
     * Cuenta cuántas veces aparece la cadena recibida por parámetro en la lista de cadenas.
     * 
     * La búsqueda no debe diferenciar entre mayúsculas y minúsculas.
     * @param cadena La cadena buscada
     * @return La cantidad de veces que aparece la cadena
     */
    public int contarApariciones( String cadena )
    {
    	Iterator<String> it = this.listaCadenas.iterator();
    	int tot=0;

        while (it.hasNext()) 
        {
        	if (it.next().equalsIgnoreCase(cadena))
        	{
        		tot+=1;
        	}
        }
        return tot;
    }

    /**
     * Cuenta cuántos valores dentro de la lista de enteros están repetidos.
     * @return La cantidad de enteos diferentes que aparecen más de una vez
     */
    public int contarEnterosRepetidos( )
    {
    	int tot=0;
    	HashMap<Integer, Integer> Histo = new HashMap<Integer, Integer>();
    	
    	for (int i=0; i<this.listaEnteros.size(); i++)
    	{
    		Integer key= this.listaEnteros.get(i);
    		Integer veces= Histo.get(key);
    		
    		if (veces==null)
    		{
    			Histo.put(key, 1);
    		}
    		else
    		{
    			Histo.put(key, veces+1);
    		}
    	}
    	
    	Iterator<Entry<Integer, Integer>> it = Histo.entrySet().iterator();
    	
        while (it.hasNext()) 
        {
        	Map.Entry<Integer, Integer> element = (Map.Entry<Integer, Integer>)it.next();
        
            if (element.getValue()>Integer.valueOf(1))
            {
            	tot+=1;
            }
        }
    	
        return tot;
    }

    /**
     * Compara la lista de enteros con un arreglo de enteros y verifica si contienen los mismos elementos exactamente en el mismo orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los elementos son los mismos y en el mismo orden y false de lo contrario
     */
    public boolean compararArregloEnteros( int[] otroArreglo )
    {
    	int i = 0;
    	boolean igual =true;
    	
    	if (otroArreglo.length!=this.listaEnteros.size())
    	{
    		igual=false;
    	}
    	
    	while (igual && i<this.listaEnteros.size())
    	{
    		if (otroArreglo[i]!=this.listaEnteros.get(i))
    		{
    			igual=false;
    		}
    		i+=1;
    	}
    	
        return igual;
    }

    /**
     * Cambia los elementos de la lista de enteros por una nueva serie de valores generada de forma aleatoria.
     * 
     * Para generar los valores se debe partir de una distribución uniforme usando Math.random().
     * 
     * Los números en la lista deben quedar entre el valor mínimo y el máximo.
     * @param cantidad La cantidad de elementos que debe haber en la lista
     * @param minimo El valor mínimo para los números generados
     * @param maximo El valor máximo para los números generados
     */
    public void generarEnteros( int cantidad, int minimo, int maximo )
    {
    	int rango = maximo - minimo +1;
    	List<Integer> nuevaLista = new ArrayList<Integer>();
    	
    	for (int i=0; i<cantidad; i++)
    	{
    		int rand = (int)(Math.random() * rango) + minimo;
    		nuevaLista.add(rand);
    	}
    	
    	this.listaEnteros=nuevaLista;
    }

}
