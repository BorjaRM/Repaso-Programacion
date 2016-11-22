import java.util.Scanner;

//No esta terminado

public class CajaRegistradora {
	int opcionMenu=0;
	//static boolean opcionValida;
	int cantidadTotalArticulos;
	int totalOperaciones;
	int totalArticulosPorOperacion=0;
	double importeTotalDia=0;

	public static void main(String[] args) {
		CajaRegistradora caja = new CajaRegistradora();
		
		do{
			menu();
			caja.opcionMenu = eligeOpcion("Elige una opcion");
			//compruebaOpcion(caja.opcionMenu, caja.opcionValida);
			ejecutaOpcion(caja);
		}while(caja.opcionMenu!=3);
	}

	public static void menu(){
		System.out.println("****CAJA REGISTRADORA****");
		System.out.println("1- Nueva Venta");
		System.out.println("2- Ganancias Día");
		System.out.println("3- Salir");
		System.out.println("*************************");
	}
	public static int eligeOpcion(String msj){
		System.out.println(msj);
		Scanner scanner=new Scanner(System.in);
		int opcion=scanner.nextInt();
		return opcion;		
	}
	public boolean compruebaOpcion(int opcionElegida, boolean opcionValida){
		System.out.println("opcion no vcalida");

		if (opcionElegida<3 && opcionElegida>0){
			CajaRegistradora.opcionValida=true;
		}
		return opcionValida;		
	}
	
	public static void ejecutaOpcion(CajaRegistradora caja){
		switch(caja.opcionMenu){
			case 1: nuevaVenta(caja);
					break;
			case 2: gananciasDia(caja.totalOperaciones,caja.importeTotalDia);
					break;
			case 3: break;			
		}		
	}
	public static void nuevaVenta(CajaRegistradora caja){
		int finalizarCompra=0;
		double precioUnidades=0;
		double precioTotalTicket=0;

		//String lineaTicket ="";
		
		do{
			System.out.println("Introduce nombre del producto");
			//String nombreProducto= introduceNombre();
			//lineaTicket(nombreProducto,lineaTicket);
			int cantidadComprada = eligeOpcion("¿Cuántas unidades?");
			caja.totalArticulosPorOperacion=sumaArticulos(cantidadComprada,caja.totalArticulosPorOperacion);
			//lineaTicket(String.valueOf(cantidadComprada),lineaTicket);
			double precioUnidad = introducePrecio();
			precioUnidades=precioXUnidades(precioUnidad,cantidadComprada);
			precioTotalTicket=importeTicket(precioUnidades,precioTotalTicket);			
			//System.out.println("cantidad total objetos" +caja.totalArticulosPorOperacion);
			//System.out.println("precio objetos" +precioUnidades);
			//System.out.println("total ticket" +precioTotalTicket);


			//lineaTicket(String.valueOf(precioUnidad),lineaTicket);
			finalizarCompra= eligeOpcion("¿Continuar compra? \nPulse 0 para CONTINUAR o -1 para TERMINAR");			
		}while (finalizarCompra!=-1);
		
		ticket(caja.totalArticulosPorOperacion,precioTotalTicket);
		caja.importeTotalDia=caja.importeTotalDia+precioTotalTicket;
		
		if (caja.totalArticulosPorOperacion!=0)
		caja.totalOperaciones=calculaOperaciones(caja.totalOperaciones);
	}	
	public static String introduceNombre(){
		//no lo uso sino hago el ticket con nombres
		Scanner scanner=new Scanner(System.in);
		String nombre=scanner.next().toUpperCase();
		return nombre;		
	}
	
	public static double introducePrecio(){
		System.out.println("Intoduce precio unitario");
		Scanner scanner=new Scanner(System.in);
		double precio=scanner.nextDouble();
		return precio;		
	}
	
	public static int calculaOperaciones(int totalOperaciones){
		totalOperaciones++;
		return totalOperaciones;				
	}
	
	public static int sumaArticulos(int cantidadComprada, int total){
		total+=cantidadComprada;
		return total;		
	}
	
	public static double precioXUnidades(double precio, int cantidad){
		double precioTotal=0;
		precioTotal=precio*cantidad;		
		return precioTotal;		
	}
	
	public static double importeTicket(double precio, double importeTicket){
		importeTicket+=precio;
		return importeTicket;		
	}
	
	public static String lineaTicket(String nuevoItem, String lineaTicket){
		//por ahora no funciona
		System.out.println(lineaTicket);
		System.out.println(nuevoItem);
		lineaTicket+=nuevoItem;
		return lineaTicket;
	}
	
	public static void ticket(int articulos,double precioTotal){
		System.out.println("********************************");
		System.out.println("*************TICKET*************");
		System.out.println("********************************");
		System.out.println("*Usted ha comprado " +articulos +" articulos*");
		System.out.println("*                              *");
		System.out.println("******Importe Total= " +precioTotal +"€******");
		System.out.println("********************************");
		System.out.println("********************************");
		System.out.println("");

	}
	
	public static void gananciasDia(int operaciones,double ventas){
		System.out.println("Has realizado un total de " +operaciones);		
		System.out.println("Importe total ventas " +ventas);

	}
	
	
	
}
