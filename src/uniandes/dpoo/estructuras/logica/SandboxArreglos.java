package uniandes.dpoo.estructuras.logica;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/** 38
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre arreglos de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos arregloEnteros y arregloCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre arreglos (ie., no haga cosas como construir listas para evitar la manipulación de arreglos).
 */
public class SandboxArreglos
{
    /**
     * Un arreglo de enteros para realizar varias de las siguientes operaciones.
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private int[] arregloEnteros;

    /**
     * Un arreglo de cadenas para realizar varias de las siguientes operaciones
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private String[] arregloCadenas;

    /**
     * Crea una nueva instancia de la clase con los dos arreglos inicializados pero vacíos (tamaño 0)
     */
    public SandboxArreglos( )
    {
        arregloEnteros = new int[]{};
        arregloCadenas = new String[]{};
    }

    /**
     * Retorna una copia del arreglo de enteros, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de enteros
     */
    public int[] getCopiaEnteros( )
    {
    	int[] copiaEnteros  = new int[this.arregloEnteros.length];
    	
    	for (int i=0; i<this.arregloEnteros.length; i++)
    	{
    		copiaEnteros[i] = this.arregloEnteros[i];
    	}
		
        return copiaEnteros;
    }

    /**
     * Retorna una copia del arreglo de cadenas, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de cadenas
     */
    public String[] getCopiaCadenas( )
    {
    	String [] copiaCadenas  = new String [this.arregloCadenas.length];
    	
    	for (int i=0; i<this.arregloCadenas.length; i++)
    	{
    		copiaCadenas[i] = this.arregloCadenas[i];
    	}
		
        return copiaCadenas;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de enteros
     * @return
     */
    public int getCantidadEnteros( )
    {
    	/*
    	 * CAMBIOS CROW :)
    	 */
        return arregloEnteros.length;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de cadenas
     * @return
     */
    public int getCantidadCadenas( )
    {
    	/*
    	 * CAMBIOS CROW :)
    	 */
        return arregloCadenas.length;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param entero El valor que se va a agregar.
     */
    public void agregarEntero( int entero )
    {
    	int[] nuevoEnteros  = new int[this.arregloEnteros.length+1];
    	
    	for (int i=0; i<this.arregloEnteros.length; i++)
    	{
    		nuevoEnteros[i] = this.arregloEnteros[i];
    	}
		
    	nuevoEnteros[this.arregloEnteros.length]=entero;
    	this.arregloEnteros=nuevoEnteros;

    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena( String cadena )
    {
    	String[] nuevasCadenas  = new String[this.arregloCadenas.length+1];
    	
    	for (int i=0; i<this.arregloCadenas.length; i++)
    	{
    		nuevasCadenas[i] = this.arregloCadenas[i];
    	}
		
    	nuevasCadenas[this.arregloCadenas.length]=cadena;
    	this.arregloCadenas=nuevasCadenas;
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de enteros
     * @param valor El valor que se va eliminar
     */
    public void eliminarEntero( int valor )
    {
    	/*
    	 * CAMBIOS CROW :)
    	 */
    	
    	int size=0;
    	int [] nuevosEnteros;
    	int deficit =0;
    	
    	for (int i=0; i<this.arregloEnteros.length; i++)
    	{
    		if ((this.arregloEnteros[i]==valor))
    		{
    			size+=1;	
    		}
    	}
    	
    	nuevosEnteros= new int [this.arregloEnteros.length-size];
    	
    	for (int i=0; i<this.arregloEnteros.length; i++)
    	{
    		if (!(this.arregloEnteros[i]==valor))
    		{
    			nuevosEnteros[i-deficit]=arregloEnteros[i];
    			deficit+=1;
    		}
    	}
    	this.arregloEnteros=nuevosEnteros;
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena( String cadena )
    {
    	/*
    	 * CAMBIOS CROW :)
    	 */
    	
    	int size=0;
    	String [] nuevasCadenas;
    	int deficit =0;
    	
    	for (int i=0; i<this.arregloCadenas.length; i++)
    	{
    		if ((this.arregloCadenas[i]==cadena))
    		{
    			size+=1;	
    		}
    	}
    	
    	nuevasCadenas= new String [this.arregloCadenas.length-size];
    	
    	for (int i=0; i<this.arregloCadenas.length; i++)
    	{
    		if (!(this.arregloCadenas[i]==cadena))
    		{
    			nuevasCadenas[i-deficit]=arregloCadenas[i];
    			deficit+=1;
    		}
    	}
    	this.arregloCadenas=nuevasCadenas;
    }

    /**
     * Inserta un nuevo entero en el arreglo de enteros.
     * 
     * @param entero El nuevo valor que debe agregarse
     * @param posicion La posición donde debe quedar el nuevo valor en el arreglo aumentado. Si la posición es menor a 0, se inserta el valor en la primera posición. Si la
     *        posición es mayor que el tamaño del arreglo, se inserta el valor en la última posición.
     */
    public void insertarEntero( int entero, int posicion )
    {
    	/*
    	 * CAMBIOS CROW :)
    	 */
    	
    	if (posicion<0) 
    	{
    		posicion=0;
    	}
    	else if (posicion>this.arregloEnteros.length)
    	{
    		posicion=this.arregloEnteros.length;
    	}
    	
    	int [] nuevosEnteros = new int [this.arregloEnteros.length + 1];
    	int pos= 0;
    	
    	for (int i=0; i<(this.arregloEnteros.length+1); i++)
    	{
    		if (i==posicion)
    		{
    			nuevosEnteros[i]=entero;
    			pos-=1;
    		}
    		else 
    		{
    			nuevosEnteros[i]=arregloEnteros[pos];
    		}
    		pos+=1;
    	}
    	
    	this.arregloEnteros=nuevosEnteros;

    }

    /**
     * Elimina un valor del arreglo de enteros dada su posición.
     * @param posicion La posición donde está el elemento que debe ser eliminado. Si el parámetro posicion no corresponde a ninguna posición del arreglo de enteros, el método
     *        no debe hacer nada.
     */
    public void eliminarEnteroPorPosicion( int posicion )
    {
    	//CAMBIOS CROW

    	
    	if (!(posicion<0 || posicion>=(this.arregloEnteros.length))) 
    	{
    		int [] nuevosEnteros = new int [this.arregloEnteros.length - 1];
        	int pos = 0;
        	
        	for (int i=0; i<(this.arregloEnteros.length); i++)
        	{
        		if (!(i==posicion))
        		{
        			nuevosEnteros[pos]=this.arregloEnteros[i];
        			pos+=1;
        		}
        	}
        	
        	this.arregloEnteros=nuevosEnteros;
    	}
    	
    }

    /**
     * Reinicia el arreglo de enteros con los valores contenidos en el arreglo del parámetro 'valores' truncados.
     * 
     * Es decir que si el valor fuera 3.67, en el nuevo arreglo de enteros debería quedar el entero 3.
     * @param valores Un arreglo de valores decimales.
     */
    public void reiniciarArregloEnteros( double[] valores )
    {
    	//CAMBIOS CROW

    	
    	int [] nuevosEnteros = new int [valores.length];
    	
    	for (int i=0; i<(nuevosEnteros.length); i++)
    	{
    		int num= (int)(valores[i]);
    		nuevosEnteros[i]=num;
    	
    	}
    	
    	this.arregloEnteros=nuevosEnteros;
    }

    /**
     * Reinicia el arreglo de cadenas con las representaciones como Strings de los objetos contenidos en el arreglo del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Un arreglo de objetos
     */
    public void reiniciarArregloCadenas( Object[] objetos )
    {
    	//CAMBIOS CROW

    	String [] nuevasCadenas = new String [objetos.length];
    	
    	for (int i=0; i<(nuevasCadenas.length); i++)
    	{
    		String hilo= objetos[i].toString();
    		nuevasCadenas[i]=hilo;
    	
    	}
    	
    	this.arregloCadenas=nuevasCadenas;
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores sean positivos.
     * 
     * Es decir que si en una posición había un valor negativo, después de ejecutar el método debe quedar el mismo valor muliplicado por -1.
     */
    public void volverPositivos( )
    {
    	//CAMBIOS CROW

    	int [] nuevosEnteros = new int [this.arregloEnteros.length];
    	
    	for (int i=0; i<(this.arregloEnteros.length); i++)
    	{
    		if (arregloEnteros[i]<0)
    		{
    			nuevosEnteros[i]=(arregloEnteros[i]*-1);
    		}
    		else
    		{
    			nuevosEnteros[i]=arregloEnteros[i];
    		}
    	
    	}
    	
    	this.arregloEnteros=nuevosEnteros;
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores queden organizados de menor a mayor.
     */
    public void organizarEnteros( )
    {
    	//CAMBIOS CROW

    	Arrays.sort(this.arregloEnteros);
    }

    /**
     * Modifica el arreglo de cadenas para que todos los valores queden organizados lexicográficamente.
     */
    public void organizarCadenas( )
    {
    	//CAMBIOS CROW
    	
    	Arrays.sort(this.arregloCadenas);
    }

    /**
     * Cuenta cuántas veces aparece el valor recibido por parámetro en el arreglo de enteros
     * @param valor El valor buscado
     * @return La cantidad de veces que aparece el valor
     */
    public int contarApariciones( int valor )
    {
    	//CAMBIOS CROW
    	
    	int tot=0;
    	
    	for (int i=0; i<this.arregloEnteros.length; i++)
    	{
    		if (this.arregloEnteros[i]==valor)
    		{
    			tot+=1;
    		}
    	}
    	
        return tot;
    }

    /**
     * Cuenta cuántas veces aparece la cadena recibida por parámetro en el arreglo de cadenas.
     * 
     * La búsqueda no debe diferenciar entre mayúsculas y minúsculas.
     * @param cadena La cadena buscada
     * @return La cantidad de veces que aparece la cadena
     */
    public int contarApariciones( String cadena )
    {
    	int tot=0;
    	
    	for (int i=0; i<this.arregloCadenas.length; i++)
    	{
    		if (this.arregloCadenas[i].equalsIgnoreCase(cadena))
    		{
    			tot+=1;
    		}
    	}
    	
        return tot;
    }

    /**
     * Busca en qué posiciones del arreglo de enteros se encuentra el valor que se recibe en el parámetro
     * @param valor El valor que se debe buscar
     * @return Un arreglo con los números de las posiciones del arreglo de enteros en las que se encuentra el valor buscado. Si el valor no se encuentra, el arreglo retornado
     *         es de tamaño 0.
     */
    public int[] buscarEntero( int valor )
    {
    	int [] posiciones;
    	int size =0;
    	int sizePosiciones =0;
    	
    	for (int i=0; i<this.arregloEnteros.length; i++)
    	{
    		if (this.arregloEnteros[i]==valor)
    		{
    			size+=1;
    		}
    	}
    	
    	posiciones = new int[size];
    	
    	for (int i=0; i<this.arregloEnteros.length; i++)
    	{
    		if (this.arregloEnteros[i]==valor)
    		{
    			posiciones[sizePosiciones]=i;
    			sizePosiciones+=1;
    		}
    		
    	}
    	
        return posiciones;
    }

    /**
     * Calcula cuál es el rango de los enteros (el valor mínimo y el máximo).
     * @return Un arreglo con dos posiciones: en la primera posición, debe estar el valor mínimo en el arreglo de enteros; en la segunda posición, debe estar el valor máximo
     *         en el arreglo de enteros. Si el arreglo está vacío, debe retornar un arreglo vacío.
     */
    public int[] calcularRangoEnteros( )
    {
    	//CROW
    
    	int [] rango= {};
    	int mayor = -999999;
    	int menor = 9999999;
    	
    	if (this.arregloEnteros.length!=0)
    	{
    		rango= new int[2];
    	}
    	
    	for (int i=0; i<this.arregloEnteros.length; i++)
    	{
    		if (this.arregloEnteros[i]>mayor)
    		{
    			rango[1]=this.arregloEnteros[i];
    			mayor=this.arregloEnteros[i];
    		}
    		if (this.arregloEnteros[i]<menor)
    		{
    			rango[0]=this.arregloEnteros[i];
    			menor=this.arregloEnteros[i];
    		}
    	}
    	
        return rango;
    }

    /**
     * Calcula un histograma de los valores del arreglo de enteros y lo devuelve como un mapa donde las llaves son los valores 
     *	 	del arreglo y los valores son la cantidad de veces que aparece cada uno en el arreglo de enteros.
     * @return Un mapa con el histograma de valores.
     */
    public HashMap<Integer, Integer> calcularHistograma( )
    {
    	//CROW
    	
    	HashMap<Integer, Integer> Histo = new HashMap<Integer, Integer>();
    	
    	for (int i=0; i<this.arregloEnteros.length; i++)
    	{
    		Integer key= Integer.valueOf(this.arregloEnteros[i]);
    		Integer veces= (Integer) Histo.get(key);
    		
    		if (veces==null)
    		{
    			Histo.put(key, 1);
    		}
    		else
    		{
    			Histo.put(key, veces+1);
    		}
    	}
    	
        return Histo;
    }

    /**
     * Cuenta cuántos valores dentro del arreglo de enteros están repetidos.
     * @return La cantidad de enteos diferentes que aparecen más de una vez
     */
    public int contarEnterosRepetidos( )
    {
    	//CROW
    	int tot=0;
    	Integer uno=Integer.valueOf(1);
    	
    	HashMap<Integer, Integer> Histo=calcularHistograma();
    	
    	Iterator<Entry<Integer, Integer>> it = Histo.entrySet().iterator();
    	
        while (it.hasNext()) 
        {
        	Map.Entry<Integer, Integer> element = (Map.Entry<Integer, Integer>)it.next();
        
            if (element.getValue()>uno)
            {
            	tot+=1;
            }
        }
    	
        return tot;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica si son iguales, es decir que contienen 
     * los mismos elementos exactamente en el mismo orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los arreglos son idénticos y false de lo contrario
     */
    public boolean compararArregloEnteros( int[] otroArreglo )
    {
    	//CROW
    	int i = 0;
    	boolean igual =true;
    	
    	if (otroArreglo.length!=this.arregloEnteros.length)
    	{
    		igual=false;
    	}
    	
    	while (igual && i<this.arregloEnteros.length)
    	{
    		if (otroArreglo[i]!=this.arregloEnteros[i])
    		{
    			igual=false;
    		}
    		i+=1;
    	}
    	
        return igual;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica que tengan los mismos elementos, aunque podría ser en otro orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los elementos en los dos arreglos son los mismos
     */
    public boolean mismosEnteros( int[] otroArreglo )
    {
    	boolean iguales=true;
    	HashMap<Integer, Integer> Histo1=calcularHistograma();
    	HashMap<Integer, Integer> Histo2 = new HashMap<Integer, Integer>();
    	
    	for (int i=0; i<otroArreglo.length; i++)
    	{
    		Integer key= Integer.valueOf(otroArreglo[i]);
    		Integer veces= (Integer) Histo2.get(key);
    		
    		if (veces==null)
    		{
    			Histo2.put(key, 1);
    		}
    		else
    		{
    			Histo2.put(key, veces+1);
    		}
    	}
    	
    	if (otroArreglo.length==0) 
    	{
    		if (this.arregloEnteros.length!=0)
    		{
    			iguales=false;	
    		}
    		return iguales;
    	}
    	
    	
    	for (Map.Entry<Integer, Integer> pareja : Histo1.entrySet()) 
    	{  
    	    Integer key1 = pareja.getKey();  
    	    Integer veces1 = pareja.getValue();
    	    
    	    if (!Histo2.containsKey(key1)) 
    	    {  
    	    	iguales = false;  
    	        break;  
    	    }
    	    else if (!Histo2.get(key1).equals(veces1)) 
	    	{
    	    	iguales = false;  
    	        break;  
	    	}
    	        
    	     
    	}  
    	
    	if (iguales) 
    	{  
    	    for (Map.Entry<Integer, Integer> pareja1 : Histo2.entrySet()) 
    	    {  
    	        Integer key2 = pareja1.getKey();  
    	        Integer veces2 = pareja1.getValue();  
    	        
    	        if (!Histo1.containsKey(key2)) 
        	    {  
        	    	iguales = false;  
        	        break;  
        	    }
        	    else if (!Histo1.get(key2).equals(veces2)) 
    	    	{
        	    	iguales = false;  
        	        break;  
    	    	}
    	    }  
    	}
    	
        return iguales;
    }

    /**
     * Cambia los elementos del arreglo de enteros por una nueva serie de valores generada de forma aleatoria.
     * 
     * Para generar los valores se debe partir de una distribución uniforme usando Math.random().
     * 
     * Los números en el arreglo deben quedar entre el valor mínimo y el máximo.
     * @param cantidad La cantidad de elementos que debe haber en el arreglo
     * @param minimo El valor mínimo para los números generados
     * @param maximo El valor máximo para los números generados
     */
    public void generarEnteros( int cantidad, int minimo, int maximo )
    {
    	int rango = maximo - minimo +1;
    	int [] nuevoArreglo = new int[cantidad];
    	
    	for (int i=0; i<nuevoArreglo.length; i++)
    	{
    		int rand = (int)(Math.random() * rango) + minimo;
    		nuevoArreglo[i]=rand;
    	}
    	
    	this.arregloEnteros=nuevoArreglo;
    	
    }

}
