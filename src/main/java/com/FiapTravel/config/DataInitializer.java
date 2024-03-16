//package com.FiapTravel.config;
//
//
//
//import java.util.UUID;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import com.FiapTravel.model.Cliente;
//import com.FiapTravel.model.User;
//import com.FiapTravel.model.enums.UserRole;
//import com.FiapTravel.repository.UserRepository;
//import com.FiapTravel.service.ClienteService;
//
//@Component
//public class DataInitializer implements CommandLineRunner {
//
//    private final ClienteService clienteService;
//    
//    @Autowired
//    private UserRepository userService;
// 
//
//
//    public DataInitializer(ClienteService clienteService) {
//        this.clienteService = clienteService;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//
////    	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//
////    	User user = (User) userService.findByLogin("jeferson");
//
//    	if (user == null) {
//    	    user = new User();
//    	    user.setId(UUID.randomUUID().toString());
//    	    user.setLogin("jeferson");
//    	    
//    	    // Codificar a senha usando BCrypt
//    	    String encodedPassword = passwordEncoder.encode("senha123");
//    	    user.setPassword(encodedPassword);
//    	    
//    	    user.setRole(UserRole.USER);
//    	    userService.save(user);
//    	}
//    	
////    	
////        Cliente cliente1 = new Cliente();
////        cliente1.setId(UUID.randomUUID());
////
////        cliente1.setUser(user); 
////        cliente1.setPaisOrigemCliente("Brasil");
////        cliente1.setCpfCliente("123.456.789-00");
////        cliente1.setPassaporteCliente("AB123456");
////        cliente1.setNomeCliente("jeferson");
////        cliente1.setDataNascimentoCliente("1990-01-01");
////        cliente1.setLogradouroEnderecoCliente("Rua Exemplo, 123");
////        cliente1.setCodigoPostalEnderecoCliente("12345-678");
////        cliente1.setCidadeEnderecoCliente("São Paulo");
////        cliente1.setBairroEnderecoCliente("Centro");
////        cliente1.setUfEnderecoCliente("SP");
////
////        
////
////        System.out.println("ID: " + cliente1.getId());
////        System.out.println("País de Origem: " + cliente1.getPaisOrigemCliente());
////        System.out.println("CPF: " + cliente1.getCpfCliente());
////        System.out.println("Passaporte: " + cliente1.getPassaporteCliente());
////        System.out.println("Nome: " + cliente1.getNomeCliente());
////        System.out.println("Data de Nascimento: " + cliente1.getDataNascimentoCliente());
////        System.out.println("Logradouro: " + cliente1.getLogradouroEnderecoCliente());
////        System.out.println("Código Postal: " + cliente1.getCodigoPostalEnderecoCliente());
////        System.out.println("Cidade: " + cliente1.getCidadeEnderecoCliente());
////        System.out.println("Bairro: " + cliente1.getBairroEnderecoCliente());
////        System.out.println("UF: " + cliente1.getUfEnderecoCliente());
////        
////        System.out.println(user.getId());
////        clienteService.save(cliente1);
//    }
//}
