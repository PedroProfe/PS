package ladrones;

public class CajaFuerte
{
	private int numLingotes;
	private int numLadrones;

	private boolean haRobadoUno = false;

	public CajaFuerte(int numLingotes, int numLadrones)
	{
		this.numLingotes = numLingotes;
		this.numLadrones = numLadrones;
	}

	public synchronized boolean robar(int idLadron, int numRobar)
	{

		/*COMO TIENE QUE EMPEZAR EL LADR”N UNO, PREGUNTO SI NO HA ROBADO EL 1 Y SI EL ID != 1, EN CUYO CASO LIBERO POR SI
		 * ESTUVIERA ESPERANDO EL LADR”N 1 Y ME VOY A DORMIR HASTA QUE ROBE EL LADR”N 1, ESTO IMPLICA QUE EL BUCLE QUE LLAMA
		 * A ESTA FUNCI”N EN LA CLASE LADRON SE PARA HASTA QUE LO LIBERE EL OTRO LADR”N*/
		if(!haRobadoUno && idLadron != 1)
		{
			notify();
			try	{wait();} catch (InterruptedException e){}
			return true;
		}

		//SI ROB” EL LADR”N 1 NO ENTR” EN EL IF Y NO SE QUED” ESPERANDO. SI ES EL LADR”N 1 LO PONGO A TRUE Y SI ES EL DOS TB PQ SI FUERA
		/*EL DOS PODRÕAN DARSE DOS CIRCUNSTANCIAS, O BIEN QUE HUBIERA ROBADO EL LADR”N 1 Y NO HABER ENTRADO EN EL IF DE ARRIBA O BIEN HABER
		 * ENTRADO Y HABER SIDO LIBERADO POR EL LADR”N 1 CUANDO ESTE ROB” Y HABER HECHO EL RETURN Y VOLVER A ENTRAR EN EL M…TODO POR EL WHILE
		 * DE LLAMADA DE LA CLASE LADRON*/

		haRobadoUno = true;


		// Si hay lingotes suficientes en la caja
		if(numRobar <= numLingotes)
		{
			numLingotes -= numRobar;
			System.out.println("El ladr√≥n " + idLadron + " ha sacado " +
					numRobar + " lingotes. (Quedan " + numLingotes + ")");
			notify();/*SI SE ROB” HAY QUE LIBERAR AL QUE EST¡ ESPERANDO PARA QUE PUEDA ROBAR Y LUEGO COMPROBAR SI DEBO ECHARME O NO A DORMIR*/

			if(numLadrones > 1)//SI HAY M¡S DE UN LADR”N, UNA VEZ QUE SE ROBA HAY QUE ECHARSE A DORMIR, PARA DEJAR QUE EL OTRO ROBE
			{
				try {wait();} catch (InterruptedException e){}
			}

			return true;
		}
		else//SI NO HAY SUFICIENTES LINGOTES PARA LOS QUE QUIERE ROBAR EL LADR”N, …STE SE ELIMINA Y LIBERA AL QUE ESTUVIERA ESPERANDO...
			//ADEM¡S DEVUELVE FALSO PARA QUE FINALICE EL WHILE DEL LADR”N...
		{
			System.out.println("El ladr√≥n " + idLadron + " no puede sacar " +
					numRobar + " y finaliza. (Quedan " + numLingotes + ")");

			numLadrones--;

			notify();

			return false;
		}


	}
}
