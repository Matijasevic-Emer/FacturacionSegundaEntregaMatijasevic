package em.preentrega.preentrega;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PreentregaApplication implements CommandLineRunner {

	@Autowired
	private DaoFactory daoFactory;

	public static void main(String[] args) {
		SpringApplication.run(PreentregaApplication.class, args);
		System.out.println("Aplicación levantada");
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			//Alta de un cliente con nombre de prueba
			Cliente cliente = new Cliente("Miguel", "Mipruebita", 12345678,true,9);

			//Como se puede agregar mas de un domicilio creo 2 segun la clase del after
			Domicilio domicilioParticular = new Domicilio("Siempre Viva", 456, "w3400", "Corrientes", "1");
			Domicilio domicilioLaboral = new Domicilio("Albuquerque", 6472, "3500", "Resistencia", "2");

			//Asigno el cliente a los domicilios y viceversa
			domicilioParticular.setCliente(cliente);
			domicilioLaboral.setCliente(cliente);
			List<Domicilio> domicilios = new ArrayList<Domicilio>();
			domicilios.add(domicilioParticular);
			domicilios.add(domicilioLaboral);

			cliente.setDomicilio(domicilios);

			//USO DE DAOFACTORY
			daoFactory.create(cliente);
			//Busqueda
			Cliente clienteGuardado = daoFactory.getCliente(cliente);
			imprimirCliente(clienteGuardado, "Cliente ENCONTRADO!!: ");

			//Modifico el cliente guardado
			modificarCliente(clienteGuardado);

			//Busco el cliente modificado
			Cliente clienteModificado = daoFactory.getCliente(clienteGuardado);
			imprimirCliente(clienteModificado, "Cliente EDITADO!!: ");


		} catch (Exception e) {
			// Manejo de excepciones
			System.err.println("Error: " + e.getMessage());

		}
	}


	private void modificarCliente(Cliente clienteGuardado) {
		//Modifico un dato del cliente
		clienteGuardado.setNombre("Blue");
		clienteGuardado.setApellido("Lucky");
		daoFactory.update(clienteGuardado);
	}

	private void imprimirCliente(Cliente clienteGuardado, String s) {
		System.out.println("----------------------------");
		System.out.println(s + clienteGuardado.toString());
	}

}

