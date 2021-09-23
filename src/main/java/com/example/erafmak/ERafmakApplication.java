package com.example.erafmak;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.erafmak.enums.Dimension;
import com.example.erafmak.enums.Granulation;
import com.example.erafmak.product.entity.Category;
import com.example.erafmak.product.entity.GranulationQty;
import com.example.erafmak.product.entity.Manufacturer;
import com.example.erafmak.product.entity.Origin;
import com.example.erafmak.product.entity.Product;
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
			 
			
			
			
			granulationQtyRepository.save(new GranulationQty(1L, true , 2300.00,null,10, Granulation.P80,null));
			granulationQtyRepository.save(new GranulationQty(2L, true , 2000.00,null,10, Granulation.P100,null));
			granulationQtyRepository.save(new GranulationQty(3L, true , 2000.00,null,10, Granulation.P120,null));
			granulationQtyRepository.save(new GranulationQty(4L, true , 2000.00,null,10,Granulation.P150,null));
			granulationQtyRepository.save(new GranulationQty(5L, true , 2000.00,null,10,Granulation.P180,null));
			granulationQtyRepository.save(new GranulationQty(6L, true , 2000.00,null,10,Granulation.P240,null));
			granulationQtyRepository.save(new GranulationQty(7L, true , 2000.00,null,10,Granulation.P320,null));
			granulationQtyRepository.save(new GranulationQty(8L, true , 2000.00,null,10,Granulation.P400,null));
			
			granulationQtyRepository.save(new GranulationQty(9L, true , 900.00,null,10, Granulation.P40,null));
			granulationQtyRepository.save(new GranulationQty(10L, true , 850.00,null,10, Granulation.P60,null));
			granulationQtyRepository.save(new GranulationQty(11L, true , 800.00,null,10, Granulation.P80,null));
			granulationQtyRepository.save(new GranulationQty(12L, true , 750.00,null,10, Granulation.P100,null));
			granulationQtyRepository.save(new GranulationQty(13L, true , 750.00,null,10, Granulation.P120,null));
			granulationQtyRepository.save(new GranulationQty(14L, true , 750.00 ,null,10,Granulation.P150,null));
			granulationQtyRepository.save(new GranulationQty(15L, true , 750.00 ,null,10,Granulation.P180,null));
			granulationQtyRepository.save(new GranulationQty(16L, true , 750.00 ,null,10,Granulation.P240,null));
			granulationQtyRepository.save(new GranulationQty(17L, true , 750.00 ,null,10,Granulation.P320,null));
			
			granulationQtyRepository.save(new GranulationQty(18L, true , 1200.00,null,10, Granulation.P1200,null));
			granulationQtyRepository.save(new GranulationQty(19L, true , 1200.00,null,10, Granulation.P1500,null));
			granulationQtyRepository.save(new GranulationQty(20L, true , 1200.00,null,10, Granulation.P2000,null));
			granulationQtyRepository.save(new GranulationQty(21L, true , 1200.00 ,null,10,Granulation.P2500,null));
			
			granulationQtyRepository.save(new GranulationQty(22L, true , 1200.00,null,10, Granulation.P1200,null));
			granulationQtyRepository.save(new GranulationQty(23L, true , 1200.00,null,10, Granulation.P1500,null));
			granulationQtyRepository.save(new GranulationQty(24L, true , 1200.00,null,10, Granulation.P2000,null));
			
			granulationQtyRepository.save(new GranulationQty(25L, true , 1300.00,null,10, Granulation.P80,null));
			granulationQtyRepository.save(new GranulationQty(26L, true , 1200.00,null,10, Granulation.P120,null));
			granulationQtyRepository.save(new GranulationQty(27L, true , 1200.00 ,null,10,Granulation.P150,null));
			granulationQtyRepository.save(new GranulationQty(28L, true , 1200.00 ,null,10,Granulation.P180,null));
			granulationQtyRepository.save(new GranulationQty(29L, true , 1200.00 ,null,10,Granulation.P240,null));
			granulationQtyRepository.save(new GranulationQty(30L, true , 1200.00 ,null,10,Granulation.P320,null));
			granulationQtyRepository.save(new GranulationQty(31L, true , 1200.00 ,null,10,Granulation.P400,null));
			
			granulationQtyRepository.save(new GranulationQty(32L, true , 1300.00,null,10, Granulation.P80,null));
			granulationQtyRepository.save(new GranulationQty(33L, true , 1200.00,null,10, Granulation.P120,null));
			granulationQtyRepository.save(new GranulationQty(34L, true , 1200.00 ,null,10,Granulation.P150,null));
			granulationQtyRepository.save(new GranulationQty(35L, true , 1200.00 ,null,10,Granulation.P180,null));
			granulationQtyRepository.save(new GranulationQty(36L, true , 1200.00 ,null,10,Granulation.P240,null));
			granulationQtyRepository.save(new GranulationQty(37L, true , 1200.00 ,null,10,Granulation.P320,null));
			granulationQtyRepository.save(new GranulationQty(38L, true , 1200.00 ,null,10,Granulation.P400,null));
			
			granulationQtyRepository.save(new GranulationQty(39L, true , 2200.00, null,10,Granulation.P80,null));
			granulationQtyRepository.save(new GranulationQty(40L, true , 1750.00, null,10,Granulation.P100,null));
			granulationQtyRepository.save(new GranulationQty(41L, true , 1750.00, null,10,Granulation.P120,null));
			granulationQtyRepository.save(new GranulationQty(42L, true , 1750.00 ,null,10,Granulation.P150,null));
			granulationQtyRepository.save(new GranulationQty(43L, true , 1750.00 ,null,10,Granulation.P180,null));
			granulationQtyRepository.save(new GranulationQty(44L, true , 1750.00 ,null,10,Granulation.P240,null));
			granulationQtyRepository.save(new GranulationQty(45L, true , 1750.00 ,null,10,Granulation.P320,null));
			granulationQtyRepository.save(new GranulationQty(46L, true , 1750.00 ,null,10,Granulation.P400,null));
			granulationQtyRepository.save(new GranulationQty(47L, true , 1750.00 ,null,10,Granulation.P500,null));
			granulationQtyRepository.save(new GranulationQty(48L, true , 1750.00 ,null,10,Granulation.P600,null));
			granulationQtyRepository.save(new GranulationQty(49L, true , 2200.00 ,null,10,Granulation.P800,null));
			granulationQtyRepository.save(new GranulationQty(50L, true , 2200.00 ,null,10,Granulation.P1000,null));
			
			granulationQtyRepository.save(new GranulationQty(51L, true , 1750.00 ,null,10,Granulation.P320,null));
			granulationQtyRepository.save(new GranulationQty(52L, true , 1750.00 ,null,10,Granulation.P400,null));
			granulationQtyRepository.save(new GranulationQty(53L, true , 1750.00 ,null,10,Granulation.P600,null));
			granulationQtyRepository.save(new GranulationQty(54L, true , 2200.00 ,null,10,Granulation.P800,null));
			
			granulationQtyRepository.save(new GranulationQty(55L, true , 2400.00 ,null,10,Granulation.P180,null));
			granulationQtyRepository.save(new GranulationQty(56L, true , 2400.00 ,null,10,Granulation.P360,null));
			granulationQtyRepository.save(new GranulationQty(57L, true , 2400.00 ,null,10,Granulation.P500,null));
			granulationQtyRepository.save(new GranulationQty(58L, true , 2400.00 ,null,10,Granulation.P1000,null));
			granulationQtyRepository.save(new GranulationQty(59L, true , 2400.00 ,null,10,Granulation.P2000,null));
			granulationQtyRepository.save(new GranulationQty(60L, true , 2400.00 ,null,10,Granulation.P3000,null));
			granulationQtyRepository.save(new GranulationQty(61L, true , 2400.00 ,null,10,Granulation.P4000,null));
			
			granulationQtyRepository.save(new GranulationQty(62L, true , 1100.00 ,null,10,Granulation.P2000,null));
			
			granulationQtyRepository.save(new GranulationQty(63L, true , 950.00 ,null,10,Granulation.P220,null));
			granulationQtyRepository.save(new GranulationQty(64L, true , 950.00 ,null,10,Granulation.P240,null));
			granulationQtyRepository.save(new GranulationQty(65L, true , 950.00 ,null,10,Granulation.P280,null));
			granulationQtyRepository.save(new GranulationQty(66L, true , 950.00 ,null,10,Granulation.P320,null));
			granulationQtyRepository.save(new GranulationQty(67L, true , 950.00 ,null,10,Granulation.P360,null));
			granulationQtyRepository.save(new GranulationQty(68L, true , 950.00 ,null,10,Granulation.P400,null));
			granulationQtyRepository.save(new GranulationQty(69L, true , 950.00 ,null,10,Granulation.P500,null));
			granulationQtyRepository.save(new GranulationQty(70L, true , 950.00 ,null,10,Granulation.P600,null));
			granulationQtyRepository.save(new GranulationQty(71L, true , 950.00 ,null,10,Granulation.P800,null));
			granulationQtyRepository.save(new GranulationQty(72L, true , 950.00 ,null,10,Granulation.P1000,null));
			granulationQtyRepository.save(new GranulationQty(73L, true , 950.00 ,null,10,Granulation.P1200,null));
			
			granulationQtyRepository.save(new GranulationQty(74L, true , 1350.00 ,null,10,Granulation.P1500,null));
			granulationQtyRepository.save(new GranulationQty(75L, true , 1350.00 ,null,10,Granulation.P2000,null));
			
			granulationQtyRepository.save(new GranulationQty(76L, true , 3300.00,null,10, Granulation.P80,null));
			granulationQtyRepository.save(new GranulationQty(77L, true , 3300.00,null,10, Granulation.P120,null));
			granulationQtyRepository.save(new GranulationQty(78L, true , 3300.00 ,null,10,Granulation.P150,null));
			granulationQtyRepository.save(new GranulationQty(79L, true , 3300.00 ,null,10,Granulation.P180,null));
			granulationQtyRepository.save(new GranulationQty(80L, true , 3300.00 ,null,10,Granulation.P240,null));
			granulationQtyRepository.save(new GranulationQty(81L, true , 3300.00 ,null,10,Granulation.P320,null));
			granulationQtyRepository.save(new GranulationQty(82L, true , 3300.00 ,null,10,Granulation.P400,null));
			granulationQtyRepository.save(new GranulationQty(83L, true , 3300.00 ,null,10,Granulation.P500,null));
			
			granulationQtyRepository.save(new GranulationQty(84L, true , 2300.00, null,10,Granulation.P80,null));
			granulationQtyRepository.save(new GranulationQty(85L, true , 2200.00, null,10,Granulation.P120,null));
			granulationQtyRepository.save(new GranulationQty(86L, true , 2200.00 ,null,10,Granulation.P150,null));
			granulationQtyRepository.save(new GranulationQty(87L, true , 2200.00 ,null,10,Granulation.P180,null));
			granulationQtyRepository.save(new GranulationQty(88L, true , 2200.00 ,null,10,Granulation.P240,null));
			granulationQtyRepository.save(new GranulationQty(89L, true , 2200.00 ,null,10,Granulation.P320,null));
			
			granulationQtyRepository.save(new GranulationQty(90L, true , 2300.00, null,10,Granulation.P80,null));
			granulationQtyRepository.save(new GranulationQty(91L, true , 2200.00, null,10,Granulation.P120,null));
			granulationQtyRepository.save(new GranulationQty(92L, true , 2200.00 ,null,10,Granulation.P150,null));
			granulationQtyRepository.save(new GranulationQty(93L, true , 2200.00 ,null,10,Granulation.P180,null));
			granulationQtyRepository.save(new GranulationQty(94L, true , 2200.00 ,null,10,Granulation.P240,null));
			granulationQtyRepository.save(new GranulationQty(95L, true , 2200.00 ,null,10,Granulation.P320,null));
			
			granulationQtyRepository.save(new GranulationQty(96L, true , 2200.00, null,10,Granulation.P240,null));
			granulationQtyRepository.save(new GranulationQty(97L, true , 2200.00 ,null,10,Granulation.P320,null));
			granulationQtyRepository.save(new GranulationQty(98L, true , 2200.00 ,null,10,Granulation.P400,null));
			granulationQtyRepository.save(new GranulationQty(99L, true , 2200.00 ,null,10,Granulation.P600,null));
			granulationQtyRepository.save(new GranulationQty(100L, true , 2200.00 ,null,10,Granulation.P800,null));
			
			granulationQtyRepository.save(new GranulationQty(101L, true , 1100.00 ,null,10,Granulation.P60,null));
			
			granulationQtyRepository.save(new GranulationQty(102L, true , 450.00 ,null,10,Granulation.P360,null));
			
			granulationQtyRepository.save(new GranulationQty(103L, true , 2250.00 ,null,10,Granulation.P80,null));
			granulationQtyRepository.save(new GranulationQty(104L, true , 1950.00 ,null,10,Granulation.P100,null));
			granulationQtyRepository.save(new GranulationQty(105L, true , 1950.00 ,null,10,Granulation.P120,null));
			granulationQtyRepository.save(new GranulationQty(106L, true , 1950.00 ,null,10,Granulation.P150,null));
			granulationQtyRepository.save(new GranulationQty(107L, true , 1950.00 ,null,10,Granulation.P180,null));
			granulationQtyRepository.save(new GranulationQty(108L, true , 1950.00 ,null,10,Granulation.P220,null));
			granulationQtyRepository.save(new GranulationQty(109L, true , 1950.00 ,null,10,Granulation.P240,null));
			granulationQtyRepository.save(new GranulationQty(110L, true , 1950.00 ,null,10,Granulation.P280,null));
			granulationQtyRepository.save(new GranulationQty(111L, true , 1950.00 ,null,10,Granulation.P320,null));
			granulationQtyRepository.save(new GranulationQty(112L, true , 1950.00 ,null,10,Granulation.P360,null));
			granulationQtyRepository.save(new GranulationQty(113L, true , 1950.00 ,null,10,Granulation.P400,null));
			
			granulationQtyRepository.save(new GranulationQty(114L, true , 2150.00 ,null,10,Granulation.P60,null));
			granulationQtyRepository.save(new GranulationQty(115L, true , 2000.00 ,null,10,Granulation.P80,null));
			granulationQtyRepository.save(new GranulationQty(116L, true , 1750.00 ,null,10,Granulation.P120,null));
			granulationQtyRepository.save(new GranulationQty(117L, true , 1750.00 ,null,10,Granulation.P150,null));
			granulationQtyRepository.save(new GranulationQty(118L, true , 1750.00 ,null,10,Granulation.P180,null));
			granulationQtyRepository.save(new GranulationQty(119L, true , 1750.00 ,null,10,Granulation.P220,null));
			granulationQtyRepository.save(new GranulationQty(120L, true , 1750.00 ,null,10,Granulation.P240,null));
			granulationQtyRepository.save(new GranulationQty(121L, true , 1750.00 ,null,10,Granulation.P320,null));
			granulationQtyRepository.save(new GranulationQty(122L, true , 1750.00 ,null,10,Granulation.P400,null));
			
            granulationQtyRepository.save(new GranulationQty(123L, true , 1950.00 ,null,10,Granulation.P80,null));
		    granulationQtyRepository.save(new GranulationQty(124L, true , 2150.00 ,null,10,Granulation.P120,null));
			granulationQtyRepository.save(new GranulationQty(125L, true , 2000.00 ,null,10,Granulation.P150,null));
			granulationQtyRepository.save(new GranulationQty(126L, true , 1750.00 ,null,10,Granulation.P180,null));
			granulationQtyRepository.save(new GranulationQty(127L, true , 1750.00 ,null,10,Granulation.P240,null));
			granulationQtyRepository.save(new GranulationQty(128L, true , 1750.00 ,null,10,Granulation.P320,null));
			granulationQtyRepository.save(new GranulationQty(129L, true , 1750.00 ,null,10,Granulation.P400,null));
			
			granulationQtyRepository.save(new GranulationQty(130L, true , 1750.00 ,null,10,Granulation.P360,null));
			granulationQtyRepository.save(new GranulationQty(131L, true , 1750.00 ,null,10,Granulation.P1500,null));
			
			List<GranulationQty> silverDisk = new ArrayList<>();
			
			silverDisk.add(granulationQtyRepository.findById(1L).get());
			silverDisk.add(granulationQtyRepository.findById(2L).get());
			silverDisk.add(granulationQtyRepository.findById(3L).get());
			silverDisk.add(granulationQtyRepository.findById(4L).get());
			silverDisk.add(granulationQtyRepository.findById(5L).get());
			silverDisk.add(granulationQtyRepository.findById(6L).get());
			silverDisk.add(granulationQtyRepository.findById(7L).get());
			silverDisk.add(granulationQtyRepository.findById(8L).get());
			
            List<GranulationQty> deflexDisk = new ArrayList<>();
			
            deflexDisk.add(granulationQtyRepository.findById(9L).get());
            deflexDisk.add(granulationQtyRepository.findById(10L).get());
            deflexDisk.add(granulationQtyRepository.findById(11L).get());
            deflexDisk.add(granulationQtyRepository.findById(12L).get());
            deflexDisk.add(granulationQtyRepository.findById(13L).get());
            deflexDisk.add(granulationQtyRepository.findById(14L).get());
            deflexDisk.add(granulationQtyRepository.findById(15L).get());
            deflexDisk.add(granulationQtyRepository.findById(16L).get());
            deflexDisk.add(granulationQtyRepository.findById(17L).get());
            
            List<GranulationQty> microStar150 = new ArrayList<>();
            
            microStar150.add(granulationQtyRepository.findById(18L).get());
            microStar150.add(granulationQtyRepository.findById(19L).get());
            microStar150.add(granulationQtyRepository.findById(20L).get());
            microStar150.add(granulationQtyRepository.findById(21L).get());
            
            List<GranulationQty> microStar80 = new ArrayList<>();
            
            microStar80.add(granulationQtyRepository.findById(18L).get());
            microStar80.add(granulationQtyRepository.findById(19L).get());
            microStar80.add(granulationQtyRepository.findById(20L).get());
            microStar80.add(granulationQtyRepository.findById(21L).get());
            
            List<GranulationQty> autonet150 = new ArrayList<>();
            
            autonet150.add(granulationQtyRepository.findById(25L).get());
            autonet150.add(granulationQtyRepository.findById(26L).get());
            autonet150.add(granulationQtyRepository.findById(27L).get());
            autonet150.add(granulationQtyRepository.findById(28L).get());
            autonet150.add(granulationQtyRepository.findById(29L).get());
            autonet150.add(granulationQtyRepository.findById(30L).get());
            autonet150.add(granulationQtyRepository.findById(31L).get());
            
            List<GranulationQty> autonet70x198 = new ArrayList<>();
            
            autonet70x198.add(granulationQtyRepository.findById(25L).get());
            autonet70x198.add(granulationQtyRepository.findById(26L).get());
            autonet70x198.add(granulationQtyRepository.findById(27L).get());
            autonet70x198.add(granulationQtyRepository.findById(28L).get());
            autonet70x198.add(granulationQtyRepository.findById(29L).get());
            autonet70x198.add(granulationQtyRepository.findById(30L).get());
            autonet70x198.add(granulationQtyRepository.findById(31L).get());
            
            List<GranulationQty> abranetDisk150 = new ArrayList<>();
			
            abranetDisk150.add(granulationQtyRepository.findById(39L).get());
            abranetDisk150.add(granulationQtyRepository.findById(40L).get());
            abranetDisk150.add(granulationQtyRepository.findById(41L).get());
            abranetDisk150.add(granulationQtyRepository.findById(42L).get());
            abranetDisk150.add(granulationQtyRepository.findById(43L).get());
            abranetDisk150.add(granulationQtyRepository.findById(44L).get());
            abranetDisk150.add(granulationQtyRepository.findById(45L).get());
            abranetDisk150.add(granulationQtyRepository.findById(46L).get());
            abranetDisk150.add(granulationQtyRepository.findById(47L).get());
            abranetDisk150.add(granulationQtyRepository.findById(48L).get());
            abranetDisk150.add(granulationQtyRepository.findById(49L).get());
            abranetDisk150.add(granulationQtyRepository.findById(50L).get());
            
            List<GranulationQty> abranetDisk80 = new ArrayList<>();
			
            abranetDisk80.add(granulationQtyRepository.findById(51L).get());
            abranetDisk80.add(granulationQtyRepository.findById(52L).get());
            abranetDisk80.add(granulationQtyRepository.findById(53L).get());
            abranetDisk80.add(granulationQtyRepository.findById(54L).get());
            
            List<GranulationQty> abralonDisk150 = new ArrayList<>();
            
            abralonDisk150.add(granulationQtyRepository.findById(55L).get());
            abralonDisk150.add(granulationQtyRepository.findById(56L).get());
            abralonDisk150.add(granulationQtyRepository.findById(57L).get());
            abralonDisk150.add(granulationQtyRepository.findById(58L).get());
            abralonDisk150.add(granulationQtyRepository.findById(59L).get());
            abralonDisk150.add(granulationQtyRepository.findById(60L).get());
            abralonDisk150.add(granulationQtyRepository.findById(61L).get());
            
            List<GranulationQty> abralonDisk80 = new ArrayList<>();
            abralonDisk150.add(granulationQtyRepository.findById(62L).get());
            
            List<GranulationQty> wpf = new ArrayList<>();
			
            wpf.add(granulationQtyRepository.findById(63L).get());
            wpf.add(granulationQtyRepository.findById(64L).get());
            wpf.add(granulationQtyRepository.findById(65L).get());
            wpf.add(granulationQtyRepository.findById(66L).get());
            wpf.add(granulationQtyRepository.findById(67L).get());
            wpf.add(granulationQtyRepository.findById(68L).get());
            wpf.add(granulationQtyRepository.findById(69L).get());
            wpf.add(granulationQtyRepository.findById(70L).get());
            wpf.add(granulationQtyRepository.findById(71L).get());
            wpf.add(granulationQtyRepository.findById(72L).get());
            wpf.add(granulationQtyRepository.findById(73L).get());
            
            List<GranulationQty> wpf1500 = new ArrayList<>();
            
            wpf1500.add(granulationQtyRepository.findById(74L).get());
            wpf1500.add(granulationQtyRepository.findById(75L).get());
            
            List<GranulationQty> iridiumDisk = new ArrayList<>();
			
            iridiumDisk.add(granulationQtyRepository.findById(76L).get());
            iridiumDisk.add(granulationQtyRepository.findById(77L).get());
            iridiumDisk.add(granulationQtyRepository.findById(78L).get());
            iridiumDisk.add(granulationQtyRepository.findById(79L).get());
            iridiumDisk.add(granulationQtyRepository.findById(80L).get());
            iridiumDisk.add(granulationQtyRepository.findById(81L).get());
            iridiumDisk.add(granulationQtyRepository.findById(82L).get());
            iridiumDisk.add(granulationQtyRepository.findById(83L).get());
            
            List<GranulationQty> qSilver = new ArrayList<>();
			
            qSilver.add(granulationQtyRepository.findById(84L).get());
            qSilver.add(granulationQtyRepository.findById(85L).get());
            qSilver.add(granulationQtyRepository.findById(86L).get());
            qSilver.add(granulationQtyRepository.findById(87L).get());
            qSilver.add(granulationQtyRepository.findById(88L).get());
            qSilver.add(granulationQtyRepository.findById(89L).get());
            
            List<GranulationQty> qIridium = new ArrayList<>();
			
            qIridium.add(granulationQtyRepository.findById(90L).get());
            qIridium.add(granulationQtyRepository.findById(91L).get());
            qIridium.add(granulationQtyRepository.findById(92L).get());
            qIridium.add(granulationQtyRepository.findById(93L).get());
            qIridium.add(granulationQtyRepository.findById(94L).get());
            qIridium.add(granulationQtyRepository.findById(95L).get());
            
            List<GranulationQty> goldSoft = new ArrayList<>();
			
            goldSoft.add(granulationQtyRepository.findById(96L).get());
            goldSoft.add(granulationQtyRepository.findById(97L).get());
            goldSoft.add(granulationQtyRepository.findById(98L).get());
            goldSoft.add(granulationQtyRepository.findById(99L).get());
            goldSoft.add(granulationQtyRepository.findById(100L).get());
            
            List<GranulationQty> goldDisk = new ArrayList<>();
			
            goldDisk.add(granulationQtyRepository.findById(101L).get());
            
            List<GranulationQty> mirlonDisk = new ArrayList<>();
			
            mirlonDisk.add(granulationQtyRepository.findById(102L).get());
            
            List<GranulationQty> silverRoll = new ArrayList<>();
			
            silverRoll.add(granulationQtyRepository.findById(103L).get());
            silverRoll.add(granulationQtyRepository.findById(104L).get());
            silverRoll.add(granulationQtyRepository.findById(105L).get());
            silverRoll.add(granulationQtyRepository.findById(106L).get());
            silverRoll.add(granulationQtyRepository.findById(107L).get());
            silverRoll.add(granulationQtyRepository.findById(108L).get());
            silverRoll.add(granulationQtyRepository.findById(109L).get());
            silverRoll.add(granulationQtyRepository.findById(110L).get());
            silverRoll.add(granulationQtyRepository.findById(111L).get());
            silverRoll.add(granulationQtyRepository.findById(112L).get());
            silverRoll.add(granulationQtyRepository.findById(113L).get());
            
            List<GranulationQty> goldRoll = new ArrayList<>();
			
            goldRoll.add(granulationQtyRepository.findById(114L).get());
            goldRoll.add(granulationQtyRepository.findById(115L).get());
            goldRoll.add(granulationQtyRepository.findById(116L).get());
            goldRoll.add(granulationQtyRepository.findById(117L).get());
            goldRoll.add(granulationQtyRepository.findById(118L).get());
            goldRoll.add(granulationQtyRepository.findById(119L).get());
            goldRoll.add(granulationQtyRepository.findById(120L).get());
            goldRoll.add(granulationQtyRepository.findById(121L).get());
            goldRoll.add(granulationQtyRepository.findById(122L).get());
            
            
            List<GranulationQty> autonetRoll = new ArrayList<>();
			
            autonetRoll.add(granulationQtyRepository.findById(123L).get());
            autonetRoll.add(granulationQtyRepository.findById(124L).get());
            autonetRoll.add(granulationQtyRepository.findById(125L).get());
            autonetRoll.add(granulationQtyRepository.findById(126L).get());
            autonetRoll.add(granulationQtyRepository.findById(127L).get());
            autonetRoll.add(granulationQtyRepository.findById(128L).get());
            autonetRoll.add(granulationQtyRepository.findById(129L).get());
            
            List<GranulationQty> mirlonRoll = new ArrayList<>();
			
            mirlonRoll.add(granulationQtyRepository.findById(130L).get());
            mirlonRoll.add(granulationQtyRepository.findById(131L).get());
            
            
            productRepository.save(new Product(1L, "Silver Disk",DESCRIPTION,null,null,null, true , IMAGE_URL + "silverDisk.jpg",null,  manufacturerRepository.findById(1L).get()));
            productRepository.save(new Product(2L, "Deflex Disk",DESCRIPTION,null,null,null,  true , IMAGE_URL + "deflexDisk.jpg",null,  manufacturerRepository.findById(1L).get()));
            productRepository.save(new Product(3L, "Microstar Disk", DESCRIPTION,null,null,null,  true ,IMAGE_URL +  "microStar.webp",null,  manufacturerRepository.findById(1L).get() ));
            productRepository.save(new Product(4L, "Microstar Disk", DESCRIPTION,null,null,null,  true , IMAGE_URL + "microStar80.jpg",null,  manufacturerRepository.findById(1L).get()));
            productRepository.save(new Product(5L, "Autonet Disk", DESCRIPTION,null,null,null, true , IMAGE_URL + "autonet.webp",null,  manufacturerRepository.findById(1L).get()));
            productRepository.save(new Product(6L, "Autonet Block", DESCRIPTION,null,null,null, true , IMAGE_URL + "autonet70x198.jpg",null,  manufacturerRepository.findById(1L).get()));
            productRepository.save(new Product(7L, "Abranet Disk", DESCRIPTION,null,null,null, true , IMAGE_URL + "abranet.jpg", null, manufacturerRepository.findById(1L).get()));
            productRepository.save(new Product(8L, "Abranet Disk", DESCRIPTION,null,null,null,  true , IMAGE_URL + "abranet80.webp",null, manufacturerRepository.findById(1L).get()));
            productRepository.save(new Product(9L, "Abralon Disk", DESCRIPTION,null,null,null, true , IMAGE_URL + "abralon.jpg",null,  manufacturerRepository.findById(1L).get()));
            productRepository.save(new Product(10L, "Abralon Disk", DESCRIPTION,null,null,null, true , IMAGE_URL + "abralon80.jpg",null, manufacturerRepository.findById(1L).get()));
            productRepository.save(new Product(11L, "WPF", DESCRIPTION,null,null,null, true , IMAGE_URL + "wpf220.jpg",null, manufacturerRepository.findById(1L).get()));
            productRepository.save(new Product(12L, "WPF", DESCRIPTION,null,null,null, true , IMAGE_URL + "wpf1500.png",null, manufacturerRepository.findById(1L).get() ));
            productRepository.save(new Product(13L, "Iridium Disk", DESCRIPTION,null,null,null, true , IMAGE_URL + "iridium.jpg",null, manufacturerRepository.findById(1L).get() ));
            productRepository.save(new Product(14L, "Silver Block", DESCRIPTION,null,null,null, true , IMAGE_URL + "rashpa.jpg",null, manufacturerRepository.findById(1L).get()));
            productRepository.save(new Product(15L, "Iridium Block", DESCRIPTION,null,null,null, true , IMAGE_URL + "iridiumRashpa.webp",null, manufacturerRepository.findById(1L).get()));
            productRepository.save(new Product(16L, "Gold Disk", DESCRIPTION,null,null,null, true , IMAGE_URL + "goldDisk.jpg",null, manufacturerRepository.findById(1L).get()));
            productRepository.save(new Product(17L, "Mirlon Disk", DESCRIPTION,null,null,null, true , IMAGE_URL + "mirlonDisk.jpg",null, manufacturerRepository.findById(1L).get()));
            productRepository.save(new Product(18L, "Goldflex Soft", DESCRIPTION,null,null,null, true ,IMAGE_URL + "goldSoft.jpg",null, manufacturerRepository.findById(1L).get()));
            productRepository.save(new Product(19L, "Silver Roll", DESCRIPTION,null,null,null, true , IMAGE_URL + "silverRoll.webp",null, manufacturerRepository.findById(1L).get()));
            productRepository.save(new Product(20L, "Gold Roll", DESCRIPTION,null,null,null, true , IMAGE_URL + "goldRoll.jpg",null, manufacturerRepository.findById(1L).get()));
            productRepository.save(new Product(21L, "Autonet Roll", DESCRIPTION,null,null,null, true , IMAGE_URL + "autonetRoll.jpg",null, manufacturerRepository.findById(1L).get()));
            productRepository.save(new Product(22L, "Mirlon Roll", DESCRIPTION,null,null,null, true , IMAGE_URL + "mirlonRoll.jpg",null, manufacturerRepository.findById(1L).get() ));

            
            productRepository.save(new Product(1L, "SP2099 2K Hardener Medium" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "2099.png" ,null, manufacturerRepository.findById(3L).get()));
            productRepository.save(new Product(2L, "SP2299 2K Hardener Very Fast", DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "2299.png" ,null, manufacturerRepository.findById(3L).get()));
			
            productRepository.save(new Product(3L, "SP2501 HS Hardener Medium" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "2501.png" ,null, manufacturerRepository.findById(3L).get()));
            productRepository.save(new Product(4L, "SP2511 HS Hardener Fast" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "2511.png" ,null, manufacturerRepository.findById(3L).get()));
			
            productRepository.save(new Product(5L, "47-50 2K Hardener Medium" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "47-50.jpg" ,null, manufacturerRepository.findById(3L).get()));
            productRepository.save(new Product(6L, "47-40 2K Hardener Fast" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "47-40.jpg" ,null, manufacturerRepository.findById(3L).get()));
            productRepository.save(new Product(7L, "47-30 2K Hardener Very Fast" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "47-30.jpg" ,null, manufacturerRepository.findById(3L).get()));
			
            productRepository.save(new Product(8L, "8-150 HS Hardener Medium" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "8-150.jpg" ,null, manufacturerRepository.findById(3L).get()));
            productRepository.save(new Product(9L, "8-140 HS Hardener Fast" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "8-140.jpg" ,null, manufacturerRepository.findById(3L).get()));
            productRepository.save(new Product(10L, "8-130 HS Hardener Very Fast" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "8-130.jpg" ,null, manufacturerRepository.findById(3L).get()));
			
            productRepository.save(new Product(11L, "8-450 Air Dry HS420 Hardener Medium" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "8-450.jpg" ,null, manufacturerRepository.findById(3L).get()));
            productRepository.save(new Product(12L, "8-440 Air Dry HS420 Hardener Fast" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "8-440.jpg" ,null, manufacturerRepository.findById(3L).get()));
			
            productRepository.save(new Product(13L, "1-70 Epoxy Primer Hardener" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "1-70.jpg" ,null, manufacturerRepository.findById(3L).get()));
			
            productRepository.save(new Product(14L, "1-10 Washprimer Hardener" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "1-10.jpg" ,null, manufacturerRepository.findById(3L).get()));
			
			List<Product> ms = new ArrayList<>();
			ms.add(productRepository.findById(1L).get());
			ms.add(productRepository.findById(2L).get());
			
			List<Product> spHs = new ArrayList<>();
			spHs.add(productRepository.findById(3L).get());
			spHs.add(productRepository.findById(4L).get());
			
			List<Product> k2 = new ArrayList<>();
			k2.add(productRepository.findById(5L).get());
			k2.add(productRepository.findById(6L).get());
			k2.add(productRepository.findById(7L).get());
			
			List<Product> matt = new ArrayList<>();
			k2.add(productRepository.findById(5L).get());
			k2.add(productRepository.findById(6L).get());
			k2.add(productRepository.findById(7L).get());
			
			List<Product> hs = new ArrayList<>();
			hs.add(productRepository.findById(8L).get());
			hs.add(productRepository.findById(9L).get());
			hs.add(productRepository.findById(10L).get());
			
			List<Product> uhs = new ArrayList<>();
			uhs.add(productRepository.findById(11L).get());
			uhs.add(productRepository.findById(12L).get());
			
			List<Product> filler = new ArrayList<>();
			filler.add(productRepository.findById(1L).get());
			filler.add(productRepository.findById(2L).get());
			filler.add(productRepository.findById(3L).get());
			filler.add(productRepository.findById(4L).get());
			filler.add(productRepository.findById(5L).get());
			filler.add(productRepository.findById(6L).get());
			filler.add(productRepository.findById(7L).get());
			filler.add(productRepository.findById(8L).get());
			filler.add(productRepository.findById(9L).get());
			filler.add(productRepository.findById(10L).get());
			filler.add(productRepository.findById(11L).get());
			filler.add(productRepository.findById(12L).get());
			
			List<Product> epoxy = new ArrayList<>();
			epoxy.add(productRepository.findById(13L).get());
			
			List<Product> washprimer = new ArrayList<>();
			washprimer.add(productRepository.findById(14L).get());
			
			productRepository.save(new Product(1L, "SP4699 MS Clear Coat High Gloss" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "4699.png" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(2L, "SP4501 HS Clear Coat 2:1" , DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "4501.png" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(3L, "SP4502 HS Anti Scratch Clear 2:1" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "4502.png" ,null, manufacturerRepository.findById(3L).get()));
			
			productRepository.save(new Product(4L, "1-103 2K Clear Coat" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "1-103.jpg" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(5L, "1-204 MS Clear Coat" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "1-204.jpg" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(6L, "8-104 HS Clear Coat" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "8-104.jpg" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(7L, "8-214 HS Scratch Resistant Clear Coat" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "18-214.jpg" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(8L, "8-614 HS420 Air Dry Clear Coat" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "8-614.jpg" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(8L, "8-114 Scratch Resistant Fast Repair Clear" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "8-114.jpg" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(9L, "1-105 MS Clear Coat Matt" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "1-105.jpg" ,null, manufacturerRepository.findById(3L).get()));
			
			productRepository.save(new Product(1L, "8-14510 HS Surfacer, WHITE " ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "8-14510.jpg" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(2L, "8-14540 HS Surfacer, BLACK" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "8-14540.jpg" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(3L, "SP5289 Universal Primer Filler White" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "5289.png" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(4L, "SP5279 Universal Primer Filler Black" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "5279.png" ,null, manufacturerRepository.findById(3L).get()));
			
			productRepository.save(new Product(5L, "1-7520 Epoxy Primer Grey" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "epoxy.png" ,null, manufacturerRepository.findById(3L).get()));
			
			productRepository.save(new Product(6L, "1-15 Washprimer" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "1-15.jpg" ,null, manufacturerRepository.findById(3L).get()));
			
			productRepository.save(new Product(1L,"SP3099 FAST THINNER" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "3099.png" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(2L,"SP3199 MEDIUM THINNER" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "3199.png" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(3L,"SP3299 SLOW THINNER" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "3299.png" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(4L,"1-151 Uni Thinner Medium" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "1-151.jpg" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(5L,"47-91 2K Spot Repair Thinner " ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "47-91.jpg" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(5L,"SP6499 SILICONE REMOVER" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "6499.png" ,null, manufacturerRepository.findById(3L).get()));
			
			productRepository.save(new Product(1L,"SP7031 BodyWorks All-In-One" , DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "7031.png" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(2L,"SP7011 BodyWorks Ultralight" , DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "7011.jpg" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(3L,"1-909 Universal Body Filler" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "1-909.png" ,null, manufacturerRepository.findById(3L).get()));
			productRepository.save(new Product(4L,"6080 Spray Filler" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "6080.png" ,null, manufacturerRepository.findById(3L).get()));
			
			productRepository.save(new Product(1L, "Nozzle set for SPG 100" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "fin08.jpg" ,null, manufacturerRepository.findById(3L).get()));
			
			productRepository.save(new Product(3L, "Nozzle set for SPG 500" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "fin13.jpg" ,null, manufacturerRepository.findById(3L).get()));
			
			productRepository.save(new Product(9L, "Nozzle set for SATA JET 100 RP" , DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "sata10014.jpg" ,null, manufacturerRepository.findById(3L).get()));
			
			productRepository.save(new Product(10L, "Nozzle set for SATA JET 5500 RP" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "sata5500rp15.jpg" ,null, manufacturerRepository.findById(3L).get()));
			
			productRepository.save(new Product(12L, "Nozzle set for SATA JET 5500 HVLP" ,DESCRIPTION, 680.00 ,null,10, true , IMAGE_URL + "sata5500hvlp15.jpg" ,null, manufacturerRepository.findById(3L).get()));
			
			
			List<Product> f100 = new ArrayList<>();
			f100.add(productRepository.findById(1L).get());
			f100.add(productRepository.findById(2L).get());
			
			List<Product> f500 = new ArrayList<>();
			f500.add(productRepository.findById(3L).get());
			f500.add(productRepository.findById(4L).get());
			f500.add(productRepository.findById(5L).get());
			f500.add(productRepository.findById(7L).get());
			f500.add(productRepository.findById(8L).get());
			
			List<Product> sata100 = new ArrayList<>();
			sata100.add(productRepository.findById(8L).get());
			sata100.add(productRepository.findById(9L).get());
			
			List<Product> satarp = new ArrayList<>();
			satarp.add(productRepository.findById(10L).get());
			satarp.add(productRepository.findById(11L).get());
			
			List<Product> satahvlp= new ArrayList<>();
			satahvlp.add(productRepository.findById(12L).get());
			satahvlp.add(productRepository.findById(13L).get());
			
			productRepository.save(new Product(1L, "Finixa SPG 100" , "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,", 3500.00 , true , f100 , manufacturerRepository.findById(4L).get(), GUNS +  "finMini.jpg" ));
			productRepository.save(new Product(2L, "Finixa SPG 500" ,"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,", 4400.00 , true , f500 , manufacturerRepository.findById(4L).get(), GUNS +  "finixaGun.jpg" ));
			
			productRepository.save(new Product(3L, "SATA JET 100" , "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,", 1600.00 , true , sata100 , manufacturerRepository.findById(5L).get(), GUNS +  "sata100rp.png" ));
			productRepository.save(new Product(4L, "SATA JET 5500 RP" , "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,", 34000.00 , true , satarp , manufacturerRepository.findById(5L).get(), GUNS +  "sata5500rp.jpg" ));
			productRepository.save(new Product(5L, "SATA JET 5500 HVLP" , "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,", 35000.00 , true , satahvlp , manufacturerRepository.findById(5L).get(), GUNS +  "sata5500hvlp.jpg" ));
			
			productRepository.save(new Product(1L , "Sata Gravity Cup" , "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,", 3200.00 , true , manufacturerRepository.findById(5L).get(), EXTRAS + "sataCup.png"));
			productRepository.save(new Product(2L , "Finixa Gravity Cup" , "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,", 800.00 , true , manufacturerRepository.findById(4L).get(), EXTRAS + "finixaCup.jpg"));
			productRepository.save(new Product(3L , "Finixa Regulator" , "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,", 2500.00 , true , manufacturerRepository.findById(4L).get(), EXTRAS + "gunMano.jpg"));
			productRepository.save(new Product(4L , "Spiralflex 4011" , "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,", 90.00 , true , manufacturerRepository.findById(6L).get(), EXTRAS + "gunConnector.jpg"));
			productRepository.save(new Product(5L , "Spiralflex 4003" , "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,", 350.00 , true , manufacturerRepository.findById(6L).get(), EXTRAS + "wallConnector.jpg"));
			productRepository.save(new Product(6L , "Spiralflex Air Purifier" , "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,", 3700.00 , true , manufacturerRepository.findById(6L).get(), EXTRAS + "airPurifierMano.gif"));
			productRepository.save(new Product(7L , "Spiralflex Air Purifier" , "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,", 2700.00 , true , manufacturerRepository.findById(6L).get(), EXTRAS + "airPurifier.gif"));
			productRepository.save(new Product(8L , "SPIRALFLEX SPRAYGUN HOSE" , "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,", 1900.00 , true , manufacturerRepository.findById(6L).get(), EXTRAS + "hose.jpg")); 
			
			productRepository.save(new Product(1L, "White Lambswool Pad 150mm" , "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,", 460.00 , true, manufacturerRepository.findById(1L).get(), PADS + "belo150.jpg"));
			productRepository.save(new Product(2L, "Yellow Lambswool Pad 150mm " ,"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,", 1300.00 , true, manufacturerRepository.findById(1L).get(), PADS + "zolto150.jpg"));
			productRepository.save(new Product(3L, "Black Waffle 150mm " , "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,", 850.00 , true, manufacturerRepository.findById(1L).get(), PADS + "blackWaffle.jpg"));
			productRepository.save(new Product(4L, "Yellow Waffle 150mm" ,"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,", 880.00 , true, manufacturerRepository.findById(1L).get(), PADS + "yellowWaffle150.jpg"));
			productRepository.save(new Product(5L, "Yellow Waffle 85mm " , "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,", 500.00 , true, manufacturerRepository.findById(1L).get(), PADS + "yellowWaffle80.jpg"));
			productRepository.save(new Product(6L, "Twisted Wool Pad 180mm " ,"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,", 1100.00 , true, manufacturerRepository.findById(1L).get(), PADS + "belo180.jpg"));
			productRepository.save(new Product(7L, "Yellow Lambswool Pad 80mm" , "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,", 550.00 , true, manufacturerRepository.findById(1L).get(), PADS + "krzno80.jfif"));
			productRepository.save(new Product(8L, "White Polishing Felt Pad 125x6mm " , "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,", 880.00 , true, manufacturerRepository.findById(1L).get(), PADS + "staklo.jfif"));
			productRepository.save(new Product(9L, "White Foam Pad 150mm " ,"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,", 620.00 , true, manufacturerRepository.findById(4L).get(), PADS + "white150.jpg"));
			productRepository.save(new Product(10L, "Black Foam Pad 150mm " ,"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,", 620.00 , true, manufacturerRepository.findById(4L).get(), PADS + "black150.jpg"));
			productRepository.save(new Product(11L, "Orange Foam Pad 150mm " ,"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,", 620.00 , true, manufacturerRepository.findById(4L).get(), PADS + "orange150.jpg"));
			
			List<Product> first = new ArrayList<>();
			first.add(productRepository.findById(1L).get());
			first.add(productRepository.findById(2L).get());
			first.add(productRepository.findById(6L).get());
			first.add(productRepository.findById(7L).get());
			first.add(productRepository.findById(9L).get());
			first.add(productRepository.findById(11L).get());
			
			List<Product> ten = new ArrayList<>();
			ten.add(productRepository.findById(1L).get());
			ten.add(productRepository.findById(2L).get());
			ten.add(productRepository.findById(3L).get());
			ten.add(productRepository.findById(4L).get());
			ten.add(productRepository.findById(5L).get());
			ten.add(productRepository.findById(6L).get());
			ten.add(productRepository.findById(7L).get());
			ten.add(productRepository.findById(9L).get());
		
			List<Product> last = new ArrayList<>();
			last.add(productRepository.findById(3L).get());
			last.add(productRepository.findById(4L).get());
			last.add(productRepository.findById(5L).get());
			last.add(productRepository.findById(10L).get());
			
			List<Product> glass = new ArrayList<>();
			glass.add(productRepository.findById(8L).get());
			
			productRepository.save(new Product(1L, "Polarshine E3 Glass Polishing Componenet", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,", 3800.00 , true ,glass, manufacturerRepository.findById(1L).get(), POLISH + "glass.jpg" ));
			productRepository.save(new Product(2L, "Polarshine 5 Finishing Component", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,", 2350.00 , true ,last, manufacturerRepository.findById(1L).get(), POLISH + "5ka.jpg" ));
			productRepository.save(new Product(3L, "Polarshine 10 , 2 in 1","Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,", 1750.00 , true ,ten, manufacturerRepository.findById(1L).get(), POLISH + "10ka.jpg" ));
			productRepository.save(new Product(4L, "Polarshine 25 Grip 1000", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,", 1300.00 , true ,first, manufacturerRepository.findById(1L).get(), POLISH + "25ka.jpg" ));
			productRepository.save(new Product(5L, "Polarshine 35 Grip 800", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,", 1600.00 , true ,first, manufacturerRepository.findById(1L).get(), POLISH + "35ka.jpg" ));
			
			productRepository.save(new Product(1L, "Mirka DEROS Central Vacuum Orbit 5,0" , "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,", 31000.00, true, Power.ELECTRIC, manufacturerRepository.findById(1L).get(), TOOLS + "deros.jpg"));
			productRepository.save(new Product(2L, "Mirka DEOS Central Vacuum Orbit 3,0" , "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,", 31000.00, true, Power.ELECTRIC, manufacturerRepository.findById(1L).get(), TOOLS +  "deos.jpg"));
			productRepository.save(new Product(3L, "Mirka PROS Central Vacuum Orbit 5.0" , "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,", 18000.00, true, Power.PNEUMATIC, manufacturerRepository.findById(1L).get(), TOOLS +  "pros.jpg"));
			productRepository.save(new Product(4L, "Mirka PS 1437 Polisher 150mm" ,"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,", 24000.00, true, Power.ELECTRIC, manufacturerRepository.findById(1L).get(), TOOLS +  "polish.jpg"));
			productRepository.save(new Product(5L, "Mirka Dust Extractor" , "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,", 31000.00, true, Power.ELECTRIC, manufacturerRepository.findById(1L).get(), TOOLS +  "vacuum.jpg"));
			productRepository.save(new Product(6L, "Finixa Orbital Palm Sander" , "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,", 8800.00, true, Power.PNEUMATIC, manufacturerRepository.findById(4L).get(), TOOLS +  "miniSander.jpg"));
			productRepository.save(new Product(6L, "Finixa Electric Polisher" ,"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,", 18000.00, true, Power.ELECTRIC, manufacturerRepository.findById(4L).get(), TOOLS +  "finPolisher.jpg"));
			
			sizeQtyRepository.save(new SizeQuantity( 1L , true , Size.L));
			sizeQtyRepository.save(new SizeQuantity( 2L , true , Size.XL));
			
			List<SizeQuantity> gloves = new ArrayList<>();
			gloves.add(sizeQtyRepository.findById(1L).get());
			gloves.add(sizeQtyRepository.findById(2L).get());
			
			sizeQtyRepository.save(new SizeQuantity( 3L , true , Size.S));
			sizeQtyRepository.save(new SizeQuantity( 4L , true ,  Size.M));
			sizeQtyRepository.save(new SizeQuantity( 5L , true , Size.L));
			sizeQtyRepository.save(new SizeQuantity( 6L , true , Size.XL));
			sizeQtyRepository.save(new SizeQuantity( 7L , true , Size.XXL));
			sizeQtyRepository.save(new SizeQuantity( 8L , true , Size.XXXL));
			
			List<SizeQuantity> overalls = new ArrayList<>();
			
			overalls.add(sizeQtyRepository.findById(3L).get());
			overalls.add(sizeQtyRepository.findById(4L).get());
			overalls.add(sizeQtyRepository.findById(5L).get());
			overalls.add(sizeQtyRepository.findById(6L).get());
			overalls.add(sizeQtyRepository.findById(7L).get());
			overalls.add(sizeQtyRepository.findById(8L).get());
		
			productRepository.save(new Product(1L, "Finixa Nitril Disposable Gloves" , "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,", 1300.00 , true , gloves ,manufacturerRepository.findById(4L).get(), SAFETIES + "glovesL.jpg" ));
			productRepository.save(new Product(2L, "Finixa MAS 00 Spray mask A1 P2" , "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,", 2300.00 , true , null, manufacturerRepository.findById(4L).get(), SAFETIES + "MAS00.jpg" ));
			productRepository.save(new Product(3L, "Finixa MAS 13 Carbon Dust Mask Safety Class FFP2." , "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,", 250.00 , true , null, manufacturerRepository.findById(4L).get(), SAFETIES + "MAS13.jpg" ));
			productRepository.save(new Product(4L, "Finixa Spray Overalls" , "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,", 1400.00 ,true , overalls, manufacturerRepository.findById(4L).get(), SAFETIES + "suit.jpg" ));
			productRepository.save(new Product(5L, "SATA Air Star F Spray Mask A2 P3" , "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,", 5200.00 ,true , null ,manufacturerRepository.findById(5L).get(), SAFETIES + "sataMas.png" ));
			
			List <Product> d70x400 = new ArrayList<>();
			d70x400.add(productRepository.findById(14L).get());
			d70x400.add(productRepository.findById(15L).get());
			
			List <Product> d70x198 = new ArrayList<>();
			d70x198.add(productRepository.findById(14L).get());
			d70x198.add(productRepository.findById(15L).get());
			d70x198.add(productRepository.findById(20L).get());
			
			List <Product> d115x230 = new ArrayList<>();
			d115x230.add(productRepository.findById(6L).get());
			
			List <Product> wet = new ArrayList<>();
			wet.add(productRepository.findById(11L).get());
			wet.add(productRepository.findById(12L).get());
			
			List <Product> dry = new ArrayList<>();
			wet.add(productRepository.findById(19L).get());
			wet.add(productRepository.findById(20L).get());
			wet.add(productRepository.findById(21L).get());

			productRepository.save(new Product(1L , "Mirka File Board Flexible Yellow" , "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis," , 5500.00 , true , Dimension.D70X400 ,manufacturerRepository.findById(1L).get(), BLOCKS + "flex.jpg", d70x400));
			productRepository.save(new Product(2L , "Mirka Sanding Block 36H Grey" ,"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis," , 1300.00 , true , Dimension.D115X230 ,manufacturerRepository.findById(1L).get(), BLOCKS + "150x230.jpg", d115x230));
			productRepository.save(new Product(3L , "Mirka Sanding Block 22H Grey" , "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,",  1100.00 , true , Dimension.D70X198 ,manufacturerRepository.findById(1L).get(), BLOCKS + "70x198.jpg", d70x198));
			productRepository.save(new Product(4L , "Mirka Sanding Block 2-Sided Soft/Hard" , "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis," ,  500.00 , true , Dimension.D70X125 ,manufacturerRepository.findById(1L).get(), BLOCKS + "softHard.jpg", wet));
			productRepository.save(new Product(5L , "Mirka Rubber Sanding Block" , "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,",  1300.00 , true , Dimension.D70X125 ,manufacturerRepository.findById(1L).get(), BLOCKS + "redRubber.jpg",dry));
			productRepository.save(new Product(6L , "Mirka Curved Pad for 70x198mm Block 22H" ,"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,",  900.00 , true , Dimension.D70X198 ,manufacturerRepository.findById(1L).get(), BLOCKS + "convex.jpg",d70x198));
			productRepository.save(new Product(7L , "Finixa File Board" , "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis,",  3500.00 , true , Dimension.D70X400 ,manufacturerRepository.findById(4L).get(), BLOCKS + "flat.jpg",d70x400));
			
			
			} catch (Exception e) {
				System.out.println("Post construct NOT called");
		}
	}

}
