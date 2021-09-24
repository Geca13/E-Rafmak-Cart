package com.example.erafmak;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.erafmak.enums.Granulation;
import com.example.erafmak.enums.Size;
import com.example.erafmak.product.entity.Category;
import com.example.erafmak.product.entity.GranulationQty;
import com.example.erafmak.product.entity.Manufacturer;
import com.example.erafmak.product.entity.Origin;
import com.example.erafmak.product.entity.Product;
import com.example.erafmak.product.entity.SizeQty;
import com.example.erafmak.product.entity.SubCategory;
import com.example.erafmak.product.repository.CategoryRepository;
import com.example.erafmak.product.repository.GranulationQtyRepository;
import com.example.erafmak.product.repository.ManufacturerRepository;
import com.example.erafmak.product.repository.OriginRepository;
import com.example.erafmak.product.repository.ProductRepository;
import com.example.erafmak.product.repository.SizeQtyRepository;
import com.example.erafmak.product.repository.SubCategoryRepository;
import com.example.erafmak.user.entity.Role;
import com.example.erafmak.user.entity.RoleName;
import com.example.erafmak.user.entity.RoleRepository;


@SpringBootApplication
public class ERafmakApplication {
	
	
	
	@Autowired
	ManufacturerRepository manufacturerRepository;
	
	@Autowired
	OriginRepository originRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	
	@Autowired
	SizeQtyRepository sqRepository;
	
	@Autowired
	GranulationQtyRepository granulationQtyRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	SubCategoryRepository subRepository;
	

	
	private final String IMAGE_URL = "/images/";
	
	private final String DESCRIPTION = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis";
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(ERafmakApplication.class, args);
	}
	
	@PostConstruct
	public void init() {
		
		try {
			
			roleRepository.save(new Role(1L, RoleName.ROLE_ADMIN));
			roleRepository.save(new Role(2L, RoleName.ROLE_USER));
			
			originRepository.save(new Origin(1L, "Finland", IMAGE_URL));
			originRepository.save(new Origin(2L, "Nederlands", IMAGE_URL));
			originRepository.save(new Origin(3L, "Italy", IMAGE_URL));
			originRepository.save(new Origin(4L, "Belgium", IMAGE_URL));
			originRepository.save(new Origin(5L, "Germany", IMAGE_URL));
			
			manufacturerRepository.save(new Manufacturer(1L, "MIRKA",originRepository.findById(1L).get() ,"mirka@mirka.com", IMAGE_URL));
			manufacturerRepository.save(new Manufacturer(2L, "DeBeer",originRepository.findById(2L).get() ,"deBeer@deBeer.com", IMAGE_URL));
			manufacturerRepository.save(new Manufacturer(3L, "Spralac",originRepository.findById(2L).get() ,"spralac@spralac.com", IMAGE_URL));
			manufacturerRepository.save(new Manufacturer(4L, "Finixa",originRepository.findById(4L).get() ,"finixa@finixa.com", IMAGE_URL));
			manufacturerRepository.save(new Manufacturer(5L, "Sata",originRepository.findById(5L).get() ,"sata@sata.com", IMAGE_URL));
			manufacturerRepository.save(new Manufacturer(6L, "Spiralflex",originRepository.findById(3L).get() ,"spiralflex@spiralflex.com", IMAGE_URL));
		
            
            productRepository.save(new Product(1L, "Silver Disk",DESCRIPTION,null,null,null, true , IMAGE_URL + "silverDisk.jpg",null,  manufacturerRepository.findById(1L).get()));
            
            granulationQtyRepository.save(new GranulationQty(1L, true , 2300.00,null,10, Granulation.P80, productRepository.findById(1L).get()));
			granulationQtyRepository.save(new GranulationQty(2L, true , 2000.00,null,10, Granulation.P100, productRepository.findById(1L).get()));
			granulationQtyRepository.save(new GranulationQty(3L, true , 2000.00,null,10, Granulation.P120, productRepository.findById(1L).get()));
			granulationQtyRepository.save(new GranulationQty(4L, true , 2000.00,null,10,Granulation.P150, productRepository.findById(1L).get()));
			granulationQtyRepository.save(new GranulationQty(5L, true , 2000.00,null,10,Granulation.P180, productRepository.findById(1L).get()));
			granulationQtyRepository.save(new GranulationQty(6L, true , 2000.00,null,10,Granulation.P240, productRepository.findById(1L).get()));
			granulationQtyRepository.save(new GranulationQty(7L, true , 2000.00,null,10,Granulation.P320, productRepository.findById(1L).get()));
			granulationQtyRepository.save(new GranulationQty(8L, true , 2000.00,null,10,Granulation.P400, productRepository.findById(1L).get()));
			
            productRepository.save(new Product(2L, "Deflex Disk",DESCRIPTION,null,null,null,  true , IMAGE_URL + "deflexDisk.jpg",null,  manufacturerRepository.findById(1L).get()));

			granulationQtyRepository.save(new GranulationQty(9L, true , 900.00,null,10, Granulation.P40, productRepository.findById(2L).get()));
			granulationQtyRepository.save(new GranulationQty(10L, true , 850.00,null,10, Granulation.P60, productRepository.findById(2L).get()));
			granulationQtyRepository.save(new GranulationQty(11L, true , 800.00,null,10, Granulation.P80, productRepository.findById(2L).get()));
			granulationQtyRepository.save(new GranulationQty(12L, true , 750.00,null,10, Granulation.P100, productRepository.findById(2L).get()));
			granulationQtyRepository.save(new GranulationQty(13L, true , 750.00,null,10, Granulation.P120, productRepository.findById(2L).get()));
			granulationQtyRepository.save(new GranulationQty(14L, true , 750.00 ,null,10,Granulation.P150, productRepository.findById(2L).get()));
			granulationQtyRepository.save(new GranulationQty(15L, true , 750.00 ,null,10,Granulation.P180, productRepository.findById(2L).get()));
			granulationQtyRepository.save(new GranulationQty(16L, true , 750.00 ,null,10,Granulation.P240, productRepository.findById(2L).get()));
			granulationQtyRepository.save(new GranulationQty(17L, true , 750.00 ,null,10,Granulation.P320, productRepository.findById(2L).get()));
			
            productRepository.save(new Product(3L, "Microstar Disk", DESCRIPTION,null,null,null,  true ,IMAGE_URL +  "microStar.webp",null,  manufacturerRepository.findById(1L).get() ));
            
			granulationQtyRepository.save(new GranulationQty(18L, true , 1200.00,null,10, Granulation.P1200, productRepository.findById(3L).get()));
			granulationQtyRepository.save(new GranulationQty(19L, true , 1200.00,null,10, Granulation.P1500, productRepository.findById(3L).get()));
			granulationQtyRepository.save(new GranulationQty(20L, true , 1200.00,null,10, Granulation.P2000, productRepository.findById(3L).get()));
			granulationQtyRepository.save(new GranulationQty(21L, true , 1200.00 ,null,10,Granulation.P2500, productRepository.findById(3L).get()));
			
            productRepository.save(new Product(4L, "Microstar Disk", DESCRIPTION,null,null,null,  true , IMAGE_URL + "microStar80.jpg",null,  manufacturerRepository.findById(1L).get()));
  
			granulationQtyRepository.save(new GranulationQty(22L, true , 1200.00,null,10, Granulation.P1200, productRepository.findById(4L).get()));
			granulationQtyRepository.save(new GranulationQty(23L, true , 1200.00,null,10, Granulation.P1500, productRepository.findById(4L).get()));
			granulationQtyRepository.save(new GranulationQty(24L, true , 1200.00,null,10, Granulation.P2000, productRepository.findById(4L).get()));
			
            productRepository.save(new Product(5L, "Autonet Disk", DESCRIPTION,null,null,null, true , IMAGE_URL + "autonet.webp",null,  manufacturerRepository.findById(1L).get()));
            
            granulationQtyRepository.save(new GranulationQty(25L, true , 1300.00,null,10, Granulation.P80,  productRepository.findById(5L).get()));
			granulationQtyRepository.save(new GranulationQty(26L, true , 1200.00,null,10, Granulation.P120, productRepository.findById(5L).get()));
			granulationQtyRepository.save(new GranulationQty(27L, true , 1200.00 ,null,10,Granulation.P150, productRepository.findById(5L).get()));
			granulationQtyRepository.save(new GranulationQty(28L, true , 1200.00 ,null,10,Granulation.P180, productRepository.findById(5L).get()));
			granulationQtyRepository.save(new GranulationQty(29L, true , 1200.00 ,null,10,Granulation.P240, productRepository.findById(5L).get()));
			granulationQtyRepository.save(new GranulationQty(30L, true , 1200.00 ,null,10,Granulation.P320, productRepository.findById(5L).get()));
			granulationQtyRepository.save(new GranulationQty(31L, true , 1200.00 ,null,10,Granulation.P400, productRepository.findById(5L).get()));
			
            productRepository.save(new Product(6L, "Abranet Disk", DESCRIPTION,null,null,null, true , IMAGE_URL + "abranet.jpg", null, manufacturerRepository.findById(1L).get()));
            
            granulationQtyRepository.save(new GranulationQty(39L, true , 2200.00, null,10,Granulation.P80, productRepository.findById(6L).get()));
			granulationQtyRepository.save(new GranulationQty(40L, true , 1750.00, null,10,Granulation.P100, productRepository.findById(6L).get()));
			granulationQtyRepository.save(new GranulationQty(41L, true , 1750.00, null,10,Granulation.P120, productRepository.findById(6L).get()));
			granulationQtyRepository.save(new GranulationQty(42L, true , 1750.00 ,null,10,Granulation.P150, productRepository.findById(6L).get()));
			granulationQtyRepository.save(new GranulationQty(43L, true , 1750.00 ,null,10,Granulation.P180, productRepository.findById(6L).get()));
			granulationQtyRepository.save(new GranulationQty(44L, true , 1750.00 ,null,10,Granulation.P240, productRepository.findById(6L).get()));
			granulationQtyRepository.save(new GranulationQty(45L, true , 1750.00 ,null,10,Granulation.P320, productRepository.findById(6L).get()));
			granulationQtyRepository.save(new GranulationQty(46L, true , 1750.00 ,null,10,Granulation.P400, productRepository.findById(6L).get()));
			granulationQtyRepository.save(new GranulationQty(47L, true , 1750.00 ,null,10,Granulation.P500, productRepository.findById(6L).get()));
			granulationQtyRepository.save(new GranulationQty(48L, true , 1750.00 ,null,10,Granulation.P600, productRepository.findById(6L).get()));
			granulationQtyRepository.save(new GranulationQty(49L, true , 2200.00 ,null,10,Granulation.P800, productRepository.findById(6L).get()));
			granulationQtyRepository.save(new GranulationQty(50L, true , 2200.00 ,null,10,Granulation.P1000, productRepository.findById(6L).get()));
			
            productRepository.save(new Product(7L, "Abranet Disk", DESCRIPTION,null,null,null,  true , IMAGE_URL + "abranet80.webp",null, manufacturerRepository.findById(1L).get()));
        	
			granulationQtyRepository.save(new GranulationQty(51L, true , 1750.00 ,null,10,Granulation.P320, productRepository.findById(7L).get()));
			granulationQtyRepository.save(new GranulationQty(52L, true , 1750.00 ,null,10,Granulation.P400, productRepository.findById(7L).get()));
			granulationQtyRepository.save(new GranulationQty(53L, true , 1750.00 ,null,10,Granulation.P600, productRepository.findById(7L).get()));
			granulationQtyRepository.save(new GranulationQty(54L, true , 2200.00 ,null,10,Granulation.P800, productRepository.findById(7L).get()));
			
            productRepository.save(new Product(8L, "Abralon Disk", DESCRIPTION,null,null,null, true , IMAGE_URL + "abralon.jpg",null,  manufacturerRepository.findById(1L).get()));
            
            granulationQtyRepository.save(new GranulationQty(55L, true , 2400.00 ,null,10,Granulation.P180, productRepository.findById(8L).get()));
			granulationQtyRepository.save(new GranulationQty(56L, true , 2400.00 ,null,10,Granulation.P360, productRepository.findById(8L).get()));
			granulationQtyRepository.save(new GranulationQty(57L, true , 2400.00 ,null,10,Granulation.P500, productRepository.findById(8L).get()));
			granulationQtyRepository.save(new GranulationQty(58L, true , 2400.00 ,null,10,Granulation.P1000, productRepository.findById(8L).get()));
			granulationQtyRepository.save(new GranulationQty(59L, true , 2400.00 ,null,10,Granulation.P2000, productRepository.findById(8L).get()));
			granulationQtyRepository.save(new GranulationQty(60L, true , 2400.00 ,null,10,Granulation.P3000, productRepository.findById(8L).get()));
			granulationQtyRepository.save(new GranulationQty(61L, true , 2400.00 ,null,10,Granulation.P4000, productRepository.findById(8L).get()));
			
            productRepository.save(new Product(9L, "Abralon Disk", DESCRIPTION,null,null,null, true , IMAGE_URL + "abralon80.jpg",null, manufacturerRepository.findById(1L).get()));

			granulationQtyRepository.save(new GranulationQty(62L, true , 1100.00 ,null,10,Granulation.P2000, productRepository.findById(9L).get()));
			
            productRepository.save(new Product(10L, "Iridium Disk", DESCRIPTION,null,null,null, true , IMAGE_URL + "iridium.jpg",null, manufacturerRepository.findById(1L).get() ));

			granulationQtyRepository.save(new GranulationQty(76L, true , 3300.00,null,10, Granulation.P80, productRepository.findById(10L).get()));
			granulationQtyRepository.save(new GranulationQty(77L, true , 3300.00,null,10, Granulation.P120, productRepository.findById(10L).get()));
			granulationQtyRepository.save(new GranulationQty(78L, true , 3300.00 ,null,10,Granulation.P150, productRepository.findById(10L).get()));
			granulationQtyRepository.save(new GranulationQty(79L, true , 3300.00 ,null,10,Granulation.P180, productRepository.findById(10L).get()));
			granulationQtyRepository.save(new GranulationQty(80L, true , 3300.00 ,null,10,Granulation.P240, productRepository.findById(10L).get()));
			granulationQtyRepository.save(new GranulationQty(81L, true , 3300.00 ,null,10,Granulation.P320, productRepository.findById(10L).get()));
			granulationQtyRepository.save(new GranulationQty(82L, true , 3300.00 ,null,10,Granulation.P400, productRepository.findById(10L).get()));
			granulationQtyRepository.save(new GranulationQty(83L, true , 3300.00 ,null,10,Granulation.P500, productRepository.findById(10L).get()));
			
            productRepository.save(new Product(11L, "Gold Disk", DESCRIPTION,null,null,null, true , IMAGE_URL + "goldDisk.jpg",null, manufacturerRepository.findById(1L).get()));

			granulationQtyRepository.save(new GranulationQty(101L, true , 1100.00 ,null,10,Granulation.P60, productRepository.findById(11L).get()));
            
            productRepository.save(new Product(12L, "Mirlon Disk", DESCRIPTION,null,null,null, true , IMAGE_URL + "mirlonDisk.jpg",null, manufacturerRepository.findById(1L).get()));

			granulationQtyRepository.save(new GranulationQty(102L, true , 450.00 ,null,10,Granulation.P360, productRepository.findById(12L).get()));
			
            
            List<Product> discs = new ArrayList<>();
            
            discs.add(productRepository.findById(1L).get());
            discs.add(productRepository.findById(2L).get());
            discs.add(productRepository.findById(3L).get());
            discs.add(productRepository.findById(4L).get());
            discs.add(productRepository.findById(5L).get());
            discs.add(productRepository.findById(6L).get());
            discs.add(productRepository.findById(7L).get());
            discs.add(productRepository.findById(8L).get());
            discs.add(productRepository.findById(9L).get());
            discs.add(productRepository.findById(10L).get());
            discs.add(productRepository.findById(11L).get());
            discs.add(productRepository.findById(12L).get());
            
            productRepository.save(new Product(13L, "WPF", DESCRIPTION,null,null,null, true , IMAGE_URL + "wpf220.jpg",null, manufacturerRepository.findById(1L).get()));

			granulationQtyRepository.save(new GranulationQty(63L, true , 950.00 ,null,10,Granulation.P220, productRepository.findById(13L).get()));
			granulationQtyRepository.save(new GranulationQty(64L, true , 950.00 ,null,10,Granulation.P240, productRepository.findById(13L).get()));
			granulationQtyRepository.save(new GranulationQty(65L, true , 950.00 ,null,10,Granulation.P280, productRepository.findById(13L).get()));
			granulationQtyRepository.save(new GranulationQty(66L, true , 950.00 ,null,10,Granulation.P320, productRepository.findById(13L).get()));
			granulationQtyRepository.save(new GranulationQty(67L, true , 950.00 ,null,10,Granulation.P360, productRepository.findById(13L).get()));
			granulationQtyRepository.save(new GranulationQty(68L, true , 950.00 ,null,10,Granulation.P400, productRepository.findById(13L).get()));
			granulationQtyRepository.save(new GranulationQty(69L, true , 950.00 ,null,10,Granulation.P500, productRepository.findById(13L).get()));
			granulationQtyRepository.save(new GranulationQty(70L, true , 950.00 ,null,10,Granulation.P600, productRepository.findById(13L).get()));
			granulationQtyRepository.save(new GranulationQty(71L, true , 950.00 ,null,10,Granulation.P800, productRepository.findById(13L).get()));
			granulationQtyRepository.save(new GranulationQty(72L, true , 950.00 ,null,10,Granulation.P1000, productRepository.findById(13L).get()));
			granulationQtyRepository.save(new GranulationQty(73L, true , 950.00 ,null,10,Granulation.P1200, productRepository.findById(13L).get()));
			
            productRepository.save(new Product(14L, "WPF", DESCRIPTION,null,null,null, true , IMAGE_URL + "wpf1500.png",null, manufacturerRepository.findById(1L).get() ));

			granulationQtyRepository.save(new GranulationQty(74L, true , 1350.00 ,null,10,Granulation.P1500, productRepository.findById(14L).get()));
			granulationQtyRepository.save(new GranulationQty(75L, true , 1350.00 ,null,10,Granulation.P2000, productRepository.findById(14L).get()));
			
            List<Product> wpf1 = new ArrayList<>();
            
            wpf1.add(productRepository.findById(13L).get());
            wpf1.add(productRepository.findById(14L).get());
           

            productRepository.save(new Product(15L, "Autonet Block", DESCRIPTION,null,null,null, true , IMAGE_URL + "autonet70x198.jpg",null,  manufacturerRepository.findById(1L).get()));

			granulationQtyRepository.save(new GranulationQty(84L, true , 2300.00, null,10,Granulation.P80, productRepository.findById(15L).get()));
			granulationQtyRepository.save(new GranulationQty(85L, true , 2200.00, null,10,Granulation.P120, productRepository.findById(15L).get()));
			granulationQtyRepository.save(new GranulationQty(86L, true , 2200.00 ,null,10,Granulation.P150, productRepository.findById(15L).get()));
			granulationQtyRepository.save(new GranulationQty(87L, true , 2200.00 ,null,10,Granulation.P180, productRepository.findById(15L).get()));
			granulationQtyRepository.save(new GranulationQty(88L, true , 2200.00 ,null,10,Granulation.P240, productRepository.findById(15L).get()));
			granulationQtyRepository.save(new GranulationQty(89L, true , 2200.00 ,null,10,Granulation.P320, productRepository.findById(15L).get()));
			
            productRepository.save(new Product(16L, "Silver Block", DESCRIPTION,null,null,null, true , IMAGE_URL + "rashpa.jpg",null, manufacturerRepository.findById(1L).get()));

			granulationQtyRepository.save(new GranulationQty(32L, true , 1300.00,null,10, Granulation.P80, productRepository.findById(16L).get()));
			granulationQtyRepository.save(new GranulationQty(33L, true , 1200.00,null,10, Granulation.P120, productRepository.findById(16L).get()));
			granulationQtyRepository.save(new GranulationQty(34L, true , 1200.00 ,null,10,Granulation.P150, productRepository.findById(16L).get()));
			granulationQtyRepository.save(new GranulationQty(35L, true , 1200.00 ,null,10,Granulation.P180, productRepository.findById(16L).get()));
			granulationQtyRepository.save(new GranulationQty(36L, true , 1200.00 ,null,10,Granulation.P240, productRepository.findById(16L).get()));
			granulationQtyRepository.save(new GranulationQty(37L, true , 1200.00 ,null,10,Granulation.P320, productRepository.findById(16L).get()));
			granulationQtyRepository.save(new GranulationQty(38L, true , 1200.00 ,null,10,Granulation.P400, productRepository.findById(16L).get()));
			
            productRepository.save(new Product(17L, "Iridium Block", DESCRIPTION,null,null,null, true , IMAGE_URL + "iridiumRashpa.webp",null, manufacturerRepository.findById(1L).get()));
  
			granulationQtyRepository.save(new GranulationQty(90L, true , 2300.00, null,10,Granulation.P80, productRepository.findById(17L).get()));
			granulationQtyRepository.save(new GranulationQty(91L, true , 2200.00, null,10,Granulation.P120, productRepository.findById(17L).get()));
			granulationQtyRepository.save(new GranulationQty(92L, true , 2200.00 ,null,10,Granulation.P150, productRepository.findById(17L).get()));
			granulationQtyRepository.save(new GranulationQty(93L, true , 2200.00 ,null,10,Granulation.P180, productRepository.findById(17L).get()));
			granulationQtyRepository.save(new GranulationQty(94L, true , 2200.00 ,null,10,Granulation.P240, productRepository.findById(17L).get()));
			granulationQtyRepository.save(new GranulationQty(95L, true , 2200.00 ,null,10,Granulation.P320, productRepository.findById(17L).get()));
            
            List<Product> block = new ArrayList<>();
            
            block.add(productRepository.findById(15L).get());
            block.add(productRepository.findById(16L).get());
            block.add(productRepository.findById(17L).get());
            
            productRepository.save(new Product(18L, "Goldflex Soft", DESCRIPTION,null,null,null, true ,IMAGE_URL + "goldSoft.jpg",null, manufacturerRepository.findById(1L).get()));

			granulationQtyRepository.save(new GranulationQty(96L, true , 2200.00, null,10,Granulation.P240, productRepository.findById(18L).get()));
			granulationQtyRepository.save(new GranulationQty(97L, true , 2200.00 ,null,10,Granulation.P320, productRepository.findById(18L).get()));
			granulationQtyRepository.save(new GranulationQty(98L, true , 2200.00 ,null,10,Granulation.P400, productRepository.findById(18L).get()));
			granulationQtyRepository.save(new GranulationQty(99L, true , 2200.00 ,null,10,Granulation.P600, productRepository.findById(18L).get()));
			granulationQtyRepository.save(new GranulationQty(100L, true , 2200.00 ,null,10,Granulation.P800, productRepository.findById(18L).get()));
			
            List<Product> soft = new ArrayList<>();
            soft.add(productRepository.findById(18L).get());
            
            productRepository.save(new Product(19L, "Silver Roll", DESCRIPTION,null,null,null, true , IMAGE_URL + "silverRoll.webp",null, manufacturerRepository.findById(1L).get()));

			granulationQtyRepository.save(new GranulationQty(103L, true , 2250.00 ,null,10,Granulation.P80, productRepository.findById(19L).get()));
			granulationQtyRepository.save(new GranulationQty(104L, true , 1950.00 ,null,10,Granulation.P100, productRepository.findById(19L).get()));
			granulationQtyRepository.save(new GranulationQty(105L, true , 1950.00 ,null,10,Granulation.P120, productRepository.findById(19L).get()));
			granulationQtyRepository.save(new GranulationQty(106L, true , 1950.00 ,null,10,Granulation.P150, productRepository.findById(19L).get()));
			granulationQtyRepository.save(new GranulationQty(107L, true , 1950.00 ,null,10,Granulation.P180, productRepository.findById(19L).get()));
			granulationQtyRepository.save(new GranulationQty(108L, true , 1950.00 ,null,10,Granulation.P220, productRepository.findById(19L).get()));
			granulationQtyRepository.save(new GranulationQty(109L, true , 1950.00 ,null,10,Granulation.P240, productRepository.findById(19L).get()));
			granulationQtyRepository.save(new GranulationQty(110L, true , 1950.00 ,null,10,Granulation.P280, productRepository.findById(19L).get()));
			granulationQtyRepository.save(new GranulationQty(111L, true , 1950.00 ,null,10,Granulation.P320, productRepository.findById(19L).get()));
			granulationQtyRepository.save(new GranulationQty(112L, true , 1950.00 ,null,10,Granulation.P360, productRepository.findById(19L).get()));
			granulationQtyRepository.save(new GranulationQty(113L, true , 1950.00 ,null,10,Granulation.P400, productRepository.findById(19L).get()));
			
            productRepository.save(new Product(20L, "Gold Roll", DESCRIPTION,null,null,null, true , IMAGE_URL + "goldRoll.jpg",null, manufacturerRepository.findById(1L).get()));
    		
			granulationQtyRepository.save(new GranulationQty(114L, true , 2150.00 ,null,10,Granulation.P60, productRepository.findById(20L).get()));
			granulationQtyRepository.save(new GranulationQty(115L, true , 2000.00 ,null,10,Granulation.P80, productRepository.findById(20L).get()));
			granulationQtyRepository.save(new GranulationQty(116L, true , 1750.00 ,null,10,Granulation.P120, productRepository.findById(20L).get()));
			granulationQtyRepository.save(new GranulationQty(117L, true , 1750.00 ,null,10,Granulation.P150, productRepository.findById(20L).get()));
			granulationQtyRepository.save(new GranulationQty(118L, true , 1750.00 ,null,10,Granulation.P180, productRepository.findById(20L).get()));
			granulationQtyRepository.save(new GranulationQty(119L, true , 1750.00 ,null,10,Granulation.P220, productRepository.findById(20L).get()));
			granulationQtyRepository.save(new GranulationQty(120L, true , 1750.00 ,null,10,Granulation.P240, productRepository.findById(20L).get()));
			granulationQtyRepository.save(new GranulationQty(121L, true , 1750.00 ,null,10,Granulation.P320, productRepository.findById(20L).get()));
			granulationQtyRepository.save(new GranulationQty(122L, true , 1750.00 ,null,10,Granulation.P400, productRepository.findById(20L).get()));
			
            productRepository.save(new Product(21L, "Autonet Roll", DESCRIPTION,null,null,null, true , IMAGE_URL + "autonetRoll.jpg",null, manufacturerRepository.findById(1L).get()));
            
            granulationQtyRepository.save(new GranulationQty(123L, true , 1950.00 ,null,10,Granulation.P80, productRepository.findById(21L).get()));
		    granulationQtyRepository.save(new GranulationQty(124L, true , 2150.00 ,null,10,Granulation.P120, productRepository.findById(21L).get()));
			granulationQtyRepository.save(new GranulationQty(125L, true , 2000.00 ,null,10,Granulation.P150, productRepository.findById(21L).get()));
			granulationQtyRepository.save(new GranulationQty(126L, true , 1750.00 ,null,10,Granulation.P180, productRepository.findById(21L).get()));
			granulationQtyRepository.save(new GranulationQty(127L, true , 1750.00 ,null,10,Granulation.P240, productRepository.findById(21L).get()));
			granulationQtyRepository.save(new GranulationQty(128L, true , 1750.00 ,null,10,Granulation.P320, productRepository.findById(21L).get()));
			granulationQtyRepository.save(new GranulationQty(129L, true , 1750.00 ,null,10,Granulation.P400, productRepository.findById(21L).get()));
			
            productRepository.save(new Product(22L, "Mirlon Roll", DESCRIPTION,null,null,null, true , IMAGE_URL + "mirlonRoll.jpg",null, manufacturerRepository.findById(1L).get() ));

			granulationQtyRepository.save(new GranulationQty(130L, true , 1750.00 ,null,10,Granulation.P360, productRepository.findById(22L).get()));
			granulationQtyRepository.save(new GranulationQty(131L, true , 1750.00 ,null,10,Granulation.P1500, productRepository.findById(22L).get()));
			
	
            List<Product> rolls = new ArrayList<>();
            
            rolls.add(productRepository.findById(19L).get());
            rolls.add(productRepository.findById(20L).get());
            rolls.add(productRepository.findById(21L).get());
            rolls.add(productRepository.findById(22L).get());
            
            productRepository.save(new Product(23L, "SP2099 2K Hardener Medium" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "2099.png" ,null, manufacturerRepository.findById(3L).get()));
            productRepository.save(new Product(24L, "SP2299 2K Hardener Very Fast", DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "2299.png" ,null, manufacturerRepository.findById(3L).get()));
			
            List<Product> ms = new ArrayList<>();
			ms.add(productRepository.findById(23L).get());
			ms.add(productRepository.findById(24L).get());
            productRepository.save(new Product(25L, "SP4699 MS Clear Coat High Gloss" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "4699.png" , ms , manufacturerRepository.findById(3L).get()));

            
            productRepository.save(new Product(26L, "SP2501 HS Hardener Medium" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "2501.png" ,null, manufacturerRepository.findById(3L).get()));
            productRepository.save(new Product(27L, "SP2511 HS Hardener Fast" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "2511.png" ,null, manufacturerRepository.findById(3L).get()));

			List<Product> spHs = new ArrayList<>();
			spHs.add(productRepository.findById(26L).get());
			spHs.add(productRepository.findById(27L).get());

			productRepository.save(new Product(28L, "SP4501 HS Clear Coat 2:1" , DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "4501.png" , spHs , manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(29L, "SP4502 HS Anti Scratch Clear 2:1" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "4502.png" , spHs , manufacturerRepository.findById(3L).get()));
			
            productRepository.save(new Product(30L, "47-50 2K Hardener Medium" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "47-50.jpg" ,null, manufacturerRepository.findById(3L).get()));
            productRepository.save(new Product(31L, "47-40 2K Hardener Fast" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "47-40.jpg" ,null, manufacturerRepository.findById(3L).get()));
            productRepository.save(new Product(32L, "47-30 2K Hardener Very Fast" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "47-30.jpg" ,null, manufacturerRepository.findById(3L).get()));
			
            List<Product> k2 = new ArrayList<>();
			k2.add(productRepository.findById(30L).get());
			k2.add(productRepository.findById(31L).get());
			k2.add(productRepository.findById(32L).get());
			
            productRepository.save(new Product(33L, "1-103 2K Clear Coat" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "1-103.jpg" , k2 , manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(34L, "1-204 MS Clear Coat" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "1-204.jpg" , k2 , manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(35L, "1-105 MS Clear Coat Matt" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "1-105.jpg" , k2 , manufacturerRepository.findById(3L).get()));
   
            productRepository.save(new Product(36L, "8-150 HS Hardener Medium" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "8-150.jpg" ,null, manufacturerRepository.findById(3L).get()));
            productRepository.save(new Product(37L, "8-140 HS Hardener Fast" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "8-140.jpg" ,null, manufacturerRepository.findById(3L).get()));
            productRepository.save(new Product(38L, "8-130 HS Hardener Very Fast" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "8-130.jpg" ,null, manufacturerRepository.findById(3L).get()));
			
            List<Product> hs = new ArrayList<>();
			hs.add(productRepository.findById(36L).get());
			hs.add(productRepository.findById(37L).get());
			hs.add(productRepository.findById(38L).get());
			
            productRepository.save(new Product(39L, "8-104 HS Clear Coat" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "8-104.jpg" ,hs, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(40L, "8-214 HS Scratch Resistant Clear Coat" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "18-214.jpg" ,hs, manufacturerRepository.findById(3L).get()));
			
            productRepository.save(new Product(41L, "8-450 Air Dry HS420 Hardener Medium" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "8-450.jpg" ,null, manufacturerRepository.findById(3L).get()));
            productRepository.save(new Product(42L, "8-440 Air Dry HS420 Hardener Fast" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "8-440.jpg" ,null, manufacturerRepository.findById(3L).get()));

			List<Product> uhs = new ArrayList<>();
			uhs.add(productRepository.findById(41L).get());
			uhs.add(productRepository.findById(42L).get());
			
			productRepository.save(new Product(43L, "8-614 HS420 Air Dry Clear Coat" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "8-614.jpg" ,uhs, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(44L, "8-114 Scratch Resistant Fast Repair Clear" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "8-114.jpg" ,uhs, manufacturerRepository.findById(3L).get()));
			
		    productRepository.save(new Product(45L, "1-70 Epoxy Primer Hardener" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "1-70.jpg" ,null, manufacturerRepository.findById(3L).get()));
          
		    List<Product> epoxy = new ArrayList<>();
			epoxy.add(productRepository.findById(45L).get());
			productRepository.save(new Product(46L, "1-7520 Epoxy Primer Grey" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "epoxy.png" ,epoxy, manufacturerRepository.findById(3L).get()));

            productRepository.save(new Product(47L, "1-10 Washprimer Hardener" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "1-10.jpg" ,null, manufacturerRepository.findById(3L).get()));
            List<Product> washprimer = new ArrayList<>();
			washprimer.add(productRepository.findById(47L).get());
			productRepository.save(new Product(48L, "1-15 Washprimer" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "1-15.jpg" , washprimer , manufacturerRepository.findById(3L).get()));

			List<Product> filler = new ArrayList<>();
			filler.add(productRepository.findById(23L).get());
			filler.add(productRepository.findById(24L).get());
			filler.add(productRepository.findById(26L).get());
			filler.add(productRepository.findById(27L).get());
			filler.add(productRepository.findById(30L).get());
			filler.add(productRepository.findById(31L).get());
			filler.add(productRepository.findById(32L).get());
			filler.add(productRepository.findById(36L).get());
			filler.add(productRepository.findById(37L).get());
			filler.add(productRepository.findById(38L).get());
			filler.add(productRepository.findById(41L).get());
			filler.add(productRepository.findById(42L).get());
			
			productRepository.save(new Product(49L, "SP5289 Universal Primer Filler White" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "5289.png" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(50L, "SP5279 Universal Primer Filler Black" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "5279.png" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(51L, "8-14510 HS Surfacer, WHITE " ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "8-14510.jpg" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(52L, "8-14540 HS Surfacer, BLACK" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "8-14540.jpg" ,null, manufacturerRepository.findById(3L).get()));
			
			productRepository.save(new Product(53L,"SP3099 FAST THINNER" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "3099.png" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(54L,"SP3199 MEDIUM THINNER" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "3199.png" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(55L,"SP3299 SLOW THINNER" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "3299.png" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(56L,"1-151 Uni Thinner Medium" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "1-151.jpg" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(57L,"47-91 2K Spot Repair Thinner " ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "47-91.jpg" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(58L,"SP6499 SILICONE REMOVER" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "6499.png" ,null, manufacturerRepository.findById(3L).get()));
			
			productRepository.save(new Product(59L,"SP7031 BodyWorks All-In-One" , DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "7031.png" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(60L,"SP7011 BodyWorks Ultralight" , DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "7011.jpg" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(61L,"1-909 Universal Body Filler" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "1-909.png" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(62L,"6080 Spray Filler" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "6080.png" ,null, manufacturerRepository.findById(3L).get()));
			
			productRepository.save(new Product(63L, "Nozzle set for SPG 100" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "fin08.jpg" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(63L, "Nozzle set for SPG 100" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "fin08.jpg" ,null, manufacturerRepository.findById(3L).get()));

			productRepository.save(new Product(64L, "Nozzle set for SPG 500" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "fin13.jpg" ,null, manufacturerRepository.findById(3L).get()));
			
			productRepository.save(new Product(65L, "Nozzle set for SATA JET 100 RP" , DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "sata10014.jpg" ,null, manufacturerRepository.findById(3L).get()));
			
			productRepository.save(new Product(66L, "Nozzle set for SATA JET 5500 RP" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "sata5500rp15.jpg" ,null, manufacturerRepository.findById(3L).get()));
			
			productRepository.save(new Product(67L, "Nozzle set for SATA JET 5500 HVLP" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "sata5500hvlp15.jpg" ,null, manufacturerRepository.findById(3L).get()));
		
			productRepository.save(new Product(68L , "Sata Gravity Cup" , DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "sataCup.png" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(69L , "Finixa Gravity Cup" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "finixaCup.jpg" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(70L , "Finixa Regulator" , DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "gunMano.jpg" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(71L , "Spiralflex 4011" , DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "gunConnector.jpg" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(72L , "Spiralflex 4003" , DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "wallConnector.jpg" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(73L , "Spiralflex Air Purifier" , DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "airPurifierMano.gif" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(74L , "Spiralflex Air Purifier" ,  DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "airPurifier.gif" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(75L , "SPIRALFLEX SPRAYGUN HOSE" ,  DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "hose.jpg" ,null, manufacturerRepository.findById(3L).get()));
			
			List<Product> gunExtrass = new ArrayList<>();
			filler.add(productRepository.findById(68L).get());
			filler.add(productRepository.findById(69L).get());
			filler.add(productRepository.findById(70L).get());
			filler.add(productRepository.findById(71L).get());
			filler.add(productRepository.findById(72L).get());
			filler.add(productRepository.findById(73L).get());
			filler.add(productRepository.findById(74L).get());
			filler.add(productRepository.findById(75L).get());
			
			productRepository.save(new Product(76L, "Finixa SPG 100" , DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "finMini.jpg" , gunExtrass, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(77L, "Finixa SPG 500" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "finixaGun.jpg" , gunExtrass , manufacturerRepository.findById(3L).get()));
			
			productRepository.save(new Product(78L, "SATA JET 100" , DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "sata100rp.png" , gunExtrass , manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(79L, "SATA JET 5500 RP" , DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "sata5500rp.jpg" , gunExtrass , manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(80L, "SATA JET 5500 HVLP" , DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "sata5500hvlp.jpg" , gunExtrass , manufacturerRepository.findById(3L).get()));
			
			
			productRepository.save(new Product(81L, "White Lambswool Pad 150mm" , DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "belo150.jpg" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(82L, "Yellow Lambswool Pad 150mm " ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "zolto150.jpg" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(83L, "Black Waffle 150mm " , DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "blackWaffle.jpg" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(84L, "Yellow Waffle 150mm" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "yellowWaffle150.jpg" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(85L, "Yellow Waffle 85mm " , DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "yellowWaffle80.jpg" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(86L, "Twisted Wool Pad 180mm " ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "belo180.jpg" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(87L, "Yellow Lambswool Pad 80mm" , DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "krzno80.jfif" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(88L, "White Polishing Felt Pad 125x6mm " , DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "staklo.jfif" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(89L, "White Foam Pad 150mm " ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "white150.jpg" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(90L, "Black Foam Pad 150mm " ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "black150.jpg" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(91L, "Orange Foam Pad 150mm " ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "orange150.jpg" ,null, manufacturerRepository.findById(3L).get()));
			
			List<Product> first = new ArrayList<>();
			first.add(productRepository.findById(81L).get());
			first.add(productRepository.findById(82L).get());
			first.add(productRepository.findById(86L).get());
			first.add(productRepository.findById(87L).get());
			first.add(productRepository.findById(89L).get());
			first.add(productRepository.findById(91L).get());
			
			List<Product> ten = new ArrayList<>();
			ten.add(productRepository.findById(81L).get());
			ten.add(productRepository.findById(82L).get());
			ten.add(productRepository.findById(83L).get());
			ten.add(productRepository.findById(84L).get());
			ten.add(productRepository.findById(85L).get());
			ten.add(productRepository.findById(86L).get());
			ten.add(productRepository.findById(87L).get());
			ten.add(productRepository.findById(89L).get());
		
			List<Product> last = new ArrayList<>();
			last.add(productRepository.findById(83L).get());
			last.add(productRepository.findById(84L).get());
			last.add(productRepository.findById(85L).get());
			last.add(productRepository.findById(90L).get());
			
			List<Product> glass = new ArrayList<>();
			glass.add(productRepository.findById(88L).get());
			
			productRepository.save(new Product(92L, "Polarshine E3 Glass Polishing Componenet", DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "glass.jpg" ,glass, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(93L, "Polarshine 5 Finishing Component", DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "5ka.jpg" ,last, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(94L, "Polarshine 10 , 2 in 1",DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "10ka.jpg" ,ten, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(95L, "Polarshine 25 Grip 1000", DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "25ka.jpg" ,first, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(96L, "Polarshine 35 Grip 800", DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "35ka.jpg" ,first, manufacturerRepository.findById(3L).get()));
			
			productRepository.save(new Product(97L, "Mirka DEROS Central Vacuum Orbit 5,0" , DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "deros.jpg" , discs, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(98L, "Mirka DEOS Central Vacuum Orbit 3,0" , DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "deos.jpg" ,block, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(99L, "Mirka PROS Central Vacuum Orbit 5.0" , DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "pros.jpg" ,discs, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(100L, "Mirka PS 1437 Polisher 150mm" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "polish.jpg" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(101L, "Mirka Dust Extractor" , DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "vacuum.jpg" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(102L, "Finixa Orbital Palm Sander" , DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "miniSander.jpg" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(103L, "Finixa Electric Polisher" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "finPolisher.jpg" ,null, manufacturerRepository.findById(3L).get()));
			
			productRepository.save(new Product(104L, "Finixa Nitril Disposable Gloves" , DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "glovesL.jpg" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(105L, "Finixa MAS 00 Spray mask A1 P2" , DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "MAS00.jpg" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(106L, "Finixa MAS 13 Carbon Dust Mask Safety Class FFP2." ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "MAS13.jpg" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(107L, "Finixa Spray Overalls" , DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "suit.jpg" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(108L, "SATA Air Star F Spray Mask A2 P3" , DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "sataMas.jpg" ,null, manufacturerRepository.findById(3L).get()));
			
			productRepository.save(new Product(109L , "Mirka File Board Flexible Yellow" , DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "flex.jpg" ,block, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(110L , "Mirka Sanding Block 36H Grey" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "150x230.jpg" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(111L , "Mirka Sanding Block 22H Grey" , DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "70x198.jpg" ,block, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(112L , "Mirka Sanding Block 2-Sided Soft/Hard" , DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "softHard.jpg" ,wpf1, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(113L , "Mirka Rubber Sanding Block" , DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "redRubber.jpg" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(114L , "Mirka Curved Pad for 70x198mm Block 22H" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "convex.jpg" ,block, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(115L , "Finixa File Board" , DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "flat.jpg" ,block, manufacturerRepository.findById(3L).get()));
			
			
			
			sqRepository.save(new SizeQty( 1L , true, 10 , Size.L, null));
			sqRepository.save(new SizeQty( 2L , true , 10 , Size.XL, null));
			
			List<SizeQty> gloves = new ArrayList<>();
			gloves.add(sqRepository.findById(1L).get());
			gloves.add(sqRepository.findById(2L).get());
			
			sqRepository.save(new SizeQty( 3L , true ,10, Size.S , null));
			sqRepository.save(new SizeQty( 4L , true ,10,  Size.M, null));
			sqRepository.save(new SizeQty( 5L , true ,10, Size.L, null));
			sqRepository.save(new SizeQty( 6L , true ,10, Size.XL, null));
			sqRepository.save(new SizeQty( 7L , true ,10, Size.XXL, null));
			sqRepository.save(new SizeQty( 8L , true ,10, Size.XXXL, null));
			
			List<SizeQty> overalls = new ArrayList<>();
			
			overalls.add(sqRepository.findById(3L).get());
			overalls.add(sqRepository.findById(4L).get());
			overalls.add(sqRepository.findById(5L).get());
			overalls.add(sqRepository.findById(6L).get());
			overalls.add(sqRepository.findById(7L).get());
			overalls.add(sqRepository.findById(8L).get());
			
			subRepository.save(new SubCategory(1L, "Disks", null , null));
			subRepository.save(new SubCategory(2L, "Rolls", null , null));
			subRepository.save(new SubCategory(3L, "Blocks", null , null));
			subRepository.save(new SubCategory(4L, "WPF", null , null));
			subRepository.save(new SubCategory(5L, "Softs", null , null));
			
			subRepository.save(new SubCategory(6L, "Coats", null , null));
			subRepository.save(new SubCategory(7L, "Primers", null , null));
			subRepository.save(new SubCategory(8L, "Thinners", null , null));
			subRepository.save(new SubCategory(9L, "Hardeners", null , null));
			subRepository.save(new SubCategory(10L, "Putties", null , null));
			
			subRepository.save(new SubCategory(11L, "Polish", null , null));
			subRepository.save(new SubCategory(12L, "Pad", null , null));
			
			subRepository.save(new SubCategory(13L, "Hand Blocks", null , null));
			subRepository.save(new SubCategory(14L, "Tools", null , null));
			subRepository.save(new SubCategory(15L, "Safety", null , null));
			subRepository.save(new SubCategory(16L, "Extra", null , null));
			subRepository.save(new SubCategory(17L, "Spray Guns", null , null));
			
			List<SubCategory> abrazive = new ArrayList<>();
			abrazive.add(subRepository.findById(1L).get());
			abrazive.add(subRepository.findById(2L).get());
			abrazive.add(subRepository.findById(3L).get());
			abrazive.add(subRepository.findById(4L).get());
			abrazive.add(subRepository.findById(5L).get());
			
			List<SubCategory> coating = new ArrayList<>();
			abrazive.add(subRepository.findById(6L).get());
			abrazive.add(subRepository.findById(7L).get());
			abrazive.add(subRepository.findById(8L).get());
			abrazive.add(subRepository.findById(9L).get());
			abrazive.add(subRepository.findById(10L).get());
			
			List<SubCategory> polishing = new ArrayList<>();
			abrazive.add(subRepository.findById(11L).get());
			abrazive.add(subRepository.findById(12L).get());
			
			List<SubCategory> tools = new ArrayList<>();
			abrazive.add(subRepository.findById(13L).get());
			abrazive.add(subRepository.findById(14L).get());
			abrazive.add(subRepository.findById(15L).get());
			abrazive.add(subRepository.findById(16L).get());
			abrazive.add(subRepository.findById(17L).get());
			
			categoryRepository.save(new Category(1L, "Abrazive Materials" , null , abrazive));
			categoryRepository.save(new Category(2L, "Coats & Primers" , null , coating));
			categoryRepository.save(new Category(3L, "Tools & Equip" , null , tools));
			categoryRepository.save(new Category(4L, "Polishing" , null , polishing));
			
			} catch (Exception e) {
				System.out.println("Post construct NOT called");
		}
	}

}
