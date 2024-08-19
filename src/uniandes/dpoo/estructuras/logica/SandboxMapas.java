package uniandes.dpoo.estructuras.logica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre mapas.
 *
 * Todos los métodos deben operar sobre el atributo mapaCadenas que se declara como un Map.
 * 
 * En este mapa, las llaves serán cadenas y los valores serán también cadenas. La relación entre los dos será que cada llave será igual a la cadena del valor, pero invertida.
 * 
 * El objetivo de usar el tipo Map es que sólo puedan usarse métodos de esa interfaz y no métodos adicionales provistos por la implementación concreta (HashMap).
 * 
 * No pueden agregarse nuevos atributos.
 */
public class SandboxMapas
{
    /**
     * Un mapa de cadenas para realizar varias de las siguientes operaciones.
     * 
     * Las llaves del mapa son cadenas, así como los valores.
     * 
     * Las llaves corresponden a invertir la cadena que aparece asociada a cada llave.
     */
    private Map<String, String> mapaCadenas;

    /**
     * Crea una nueva instancia de la clase con las dos listas inicializadas pero vacías
     */
    public SandboxMapas( )
    {
        mapaCadenas = new HashMap<String, String>( );
    }

    /**
     * Retorna una lista con las cadenas del mapa (los valores) ordenadas lexicográficamente
     * @return Una lista ordenada con las cadenas que conforman los valores del mapa
     */
    public List<String> getValoresComoLista( )
    {
    	Collection <String> valores= this.mapaCadenas.values();
    	List<String> valoresLista= new ArrayList<String>(valores);
    	Collections.sort(valoresLista);
        return valoresLista;
    }

    /**
     * Retorna una lista con las llaves del mapa ordenadas lexicográficamente de mayor a menor
     * @return Una lista ordenada con las cadenas que conforman las llaves del mapa
     */
    public List<String> getLlavesComoListaInvertida( )
    {
    	Collection <String> llaves= this.mapaCadenas.keySet();
    	List<String> llavesLista= new ArrayList<String>(llaves);
    	Collections.sort(llavesLista, Collections.reverseOrder());
        return llavesLista;
    }

    /**
     * Retorna la cadena que sea lexicográficamente menor dentro de las llaves del mapa .
     * 
     * Si el mapa está vacío, debe retornar null.
     * @return
     */
    public String getPrimera( )
    {
    	List<String> lista = getLlavesComoListaInvertida();
    	if (lista.isEmpty()) {
    		return null;
    	}
    	else
    	{
    		String cad = lista.get(lista.size() - 1);
            return cad;	
    	}
    	
    }

    /**
     * Retorna la cadena que sea lexicográficamente mayor dentro de los valores del mapa
     * 
     * Si el conjunto está vacío, debe retornar null.
     * @return
     */
    public String getUltima( )
    {
    	List<String> lista = getValoresComoLista();
    	if (lista.isEmpty()) {
    		return null;
    	}
    	else
    	{
    		String cad = lista.get(lista.size() - 1);
            return cad;	
    	}
    	
    }

    /**
     * Retorna una colección con las llaves del mapa, convertidas a mayúsculas.
     * 
     * El orden de las llaves retornadas no importa.
     * @return Una lista de cadenas donde todas las cadenas están en mayúsculas
     */
    public Collection<String> getLlaves( )
    {
    	Collection <String> llaves= new LinkedList<String>();
    	
    	Iterator<String> it =this.mapaCadenas.keySet().iterator();
        
    	while (it.hasNext()) 
    	{
    		llaves.add(it.next().toUpperCase());
    	}
    	
    	return llaves;
    }

    /**
     * Retorna la cantidad de *valores* diferentes en el mapa
     * @return
     */
    public int getCantidadCadenasDiferentes( )
    {
    	Collection <String> valores = this.mapaCadenas.values();
    	Map<String, String> mapaValores = new HashMap<String, String>( );
    	Iterator<String> it = valores.iterator();
    	
    	while (it.hasNext()) 
    	{
    		mapaValores.put(it.next(), " ");
    	}
    	
        return mapaValores.size();
    }

    /**
     * Agrega un nuevo valor al mapa de cadenas: el valor será el recibido por parámetro, y la llave será la cadena invertida
     * 
     * Este método podría o no aumentar el tamaño del mapa, dependiendo de si ya existía la cadena en el mapa
     * 
     * @param cadena La cadena que se va a agregar al mapa
     */
    public void agregarCadena( String cadena )
    {
    	String cadInv ="";
    	
    	for (int i=0; i<cadena.length(); i++)
        {
          char character= cadena.charAt(i); 
          cadInv= character+cadInv; 
        }
    	
    	this.mapaCadenas.put(cadInv, cadena);

    }

    /**
     * Elimina una cadena del mapa, dada la llave
     * @param cadena La llave para identificar el valor que se debe eliminar
     */
    public void eliminarCadenaConLLave( String llave )
    {
    	this.mapaCadenas.remove(llave);
    }

    /**
     * Elimina una cadena del mapa, dado el valor
     * @param cadena El valor que se debe eliminar
     */
    public void eliminarCadenaConValor( String valor )
    {
    	Collection<Map.Entry<String, String>> parejas= this.mapaCadenas.entrySet();
    	Iterator<Map.Entry<String, String>> it = parejas.iterator();
    	String key = "";
    	
    	while (it.hasNext())
    	{
    		Map.Entry<String, String> pareja = it.next();
    		if (pareja.getValue().equals(valor))
    		{
    			key=pareja.getKey();
    			break;
    		}
    	}
    	
    	this.mapaCadenas.remove(key);
    }

    /**
     * Reinicia el mapa de cadenas con las representaciones como Strings de los objetos contenidos en la lista del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Una lista de objetos
     */
    public void reiniciarMapaCadenas( List<Object> objetos )
    {
    	this.mapaCadenas.clear();
    	Iterator<Object> it = objetos.iterator();
    	
    	while (it.hasNext()) 
    	{
    		String cad = it.next().toString();
    		agregarCadena(cad);
    	}
    	
    }

    /**
     * Modifica el mapa de cadenas reemplazando las llaves para que ahora todas estén en mayúsculas pero sigan conservando las mismas cadenas asociadas.
     */
    public void volverMayusculas( )
    {
    	Map<String, String> nuevoMap = new HashMap<String, String>( );
    	Collection<Map.Entry<String, String>> parejas= this.mapaCadenas.entrySet();
    	Iterator<Map.Entry<String, String>> it = parejas.iterator();
    	
    	while (it.hasNext())
    	{
    		Map.Entry<String, String> pareja = it.next();
    		nuevoMap.put(pareja.getKey().toUpperCase(), pareja.getValue());
    	}
    	
    	this.mapaCadenas=nuevoMap;
    }

    /**
     * Verifica si todos los elementos en el arreglo de cadenas del parámetro hacen parte del mapa de cadenas (de los valores)
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si todos los elementos del arreglo están dentro de los valores del mapa
     */
    public boolean compararValores( String[] otroArreglo )
    {
    	boolean contienen = true;
    	int i =0;
    	
    	while (contienen && i<otroArreglo.length)
    	{
    		if (!this.mapaCadenas.containsValue(otroArreglo[i]))
    		{
    			contienen=false;
    		}
    		i+=1;
    	}
        return contienen;
    }

}
