package com.example.erafmak.product.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.erafmak.enums.Dimension;
import com.example.erafmak.enums.Granulation;
import com.example.erafmak.enums.Nozzle;
import com.example.erafmak.enums.Size;
import com.example.erafmak.enums.Weigth;
import com.example.erafmak.product.entity.GranulationQty;
import com.example.erafmak.product.entity.NozzleQty;
import com.example.erafmak.product.entity.Product;
import com.example.erafmak.product.entity.ProductDimension;
import com.example.erafmak.product.entity.ProductWeight;
import com.example.erafmak.product.entity.SizeQty;
import com.example.erafmak.product.repository.GranulationQtyRepository;
import com.example.erafmak.product.repository.NozzleQtyRepository;
import com.example.erafmak.product.repository.ProductDimensionRepository;
import com.example.erafmak.product.repository.ProductWeightRepository;
import com.example.erafmak.product.repository.SizeQtyRepository;

@Service
public class EnumClassesService {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	GranulationQtyRepository granRepository;
	
	@Autowired
	NozzleQtyRepository nozzleRepository;
	
	@Autowired
	ProductWeightRepository weightRepository;
	
	@Autowired
	SizeQtyRepository sizeRepository;
	
	@Autowired
	ProductDimensionRepository dimensionRepository;
	

	public SizeQty findSizeById(Long id) {
		return sizeRepository.findById(id).get();
	}
	
	public NozzleQty findNozzleById(Long id) {
		return nozzleRepository.findById(id).get();
	}
	
	public GranulationQty findGranulationById(Long id) {
		return granRepository.findById(id).get();
	}
	
	public List<GranulationQty> findGranulationByProductId(Long id) {
		if(granRepository.existsByProductId(id)) {
			return granRepository.findByProductId(id);
		}
		return null;
	}
	
	public GranulationQty newGranulationQty(Granulation granulation ,Product newProduct) {
		GranulationQty granulationQty = new GranulationQty();
		granulationQty.setProduct(newProduct);
		granulationQty.setGranulation(granulation);
		granulationQty.setDiscountedPrice(null);
		granulationQty.setIsAvailable(false);
		granulationQty.setPrice(0.00);
		granulationQty.setStock(0);
		return granRepository.save(granulationQty);
	}
	
	public void deleteGranulationQty(GranulationQty granulationQty) {
		granulationQty.setProduct(null);
		granRepository.delete(granulationQty);
	}
	
	
	
	public List<NozzleQty> findNozzleByProductId(Long id) {
		if(nozzleRepository.existsByProductId(id)) {
			return nozzleRepository.findByProductId(id);
		}
		return null;
	}
	
	public NozzleQty newNozzleQty(Nozzle nozzle, Product newProduct) {
		NozzleQty newNq = new NozzleQty();
		newNq.setIsAvailable(false);
		newNq.setNozzle(nozzle);
		newNq.setProduct(newProduct);
		newNq.setStock(0);
		return nozzleRepository.save(newNq);
	}
	
	public void updateProductNozzle(Long id, Long sid, Nozzle nozzle) {
		NozzleQty nozzleQty = nozzleRepository.findById(sid).get();
		nozzleQty.setNozzle(nozzle);
		nozzleRepository.save(nozzleQty);
	}

	public void updateProductNozzleAvailability(Long id, Long sid) {
		NozzleQty nozzleQty = nozzleRepository.findById(sid).get();
		nozzleQty.setIsAvailable(!nozzleQty.getIsAvailable());
		nozzleRepository.save(nozzleQty);
	}

	public void updateProductNozzleStock(Long id, Long sid, Integer stock) {
		NozzleQty nozzleQty = nozzleRepository.findById(sid).get();
		nozzleQty.setStock(nozzleQty.getStock() + stock);
		nozzleRepository.save(nozzleQty);
	}
	
	public void deleteNozzleQty(NozzleQty nozzleQty) {
		nozzleQty.setProduct(null);
		nozzleRepository.delete(nozzleQty);
	}
	
	public ProductDimension findDimensionByProductId(Long id) {
		if(dimensionRepository.existsByProductId(id)) {
			return dimensionRepository.findByProductId(id);
		}
		return null;
	}
	
	public ProductDimension newProductDimension(Dimension dimension, Product newProduct) {
		ProductDimension newPd = new ProductDimension();
		newPd.setDimension(dimension);
		newPd.setProduct(newProduct);
		return dimensionRepository.save(newPd);
	}
	
	public void updateProductDimension(Long id, Dimension dimension) {
		ProductDimension forUpdate = findDimensionByProductId(id);
		forUpdate.setDimension(dimension);
		dimensionRepository.save(forUpdate);
	}

	public void deleteProductDimension(ProductDimension dimension) {
		dimensionRepository.delete(dimension);
	}
	
	public ProductWeight findWeightByProductId(Long id) {
		if(weightRepository.existsByProductId(id)) {
			return weightRepository.findByProductId(id);
		}
		return null;
	}
	
	public ProductWeight newProductWeight(Weigth weight, Product newProduct) {
		ProductWeight newPw = new ProductWeight();
		newPw.setProduct(newProduct);
		newPw.setWeigth(weight);
		return weightRepository.save(newPw);
	}

	public void deleteProductWeight(ProductWeight weight) {
		weightRepository.delete(weight);
	}
	
    public void updateProductWeigth(Long id, Weigth weigth) {
		ProductWeight weight = findWeightByProductId(id);
		weight.setWeigth(weigth);
		weightRepository.save(weight);
	}
	
	public List<SizeQty> findSizeByProductId(Long id) {
		if(sizeRepository.existsByProductId(id)) {
			return sizeRepository.findByProductId(id);
		}
		return null;
	}
	
	public SizeQty newSizeQty(Size size, Product newProduct) {
		SizeQty newSq = new SizeQty();
		newSq.setIsAvailable(false);
		newSq.setProduct(newProduct);
		newSq.setSize(size);
		newSq.setStock(0);
		return sizeRepository.save(newSq);
	}
	

	public void deleteSizeQty(SizeQty sizeQty) {
		sizeQty.setProduct(null);
		sizeRepository.delete(sizeQty);
	}

	public void updateProductSize(Long id, Long sid, Size size) {
		SizeQty sizeQty = sizeRepository.findById(sid).get();
		sizeQty.setSize(size);
		sizeRepository.save(sizeQty);
	}

	public void updateProductSizeAvailability(Long id, Long sid) {
		SizeQty sizeQty = sizeRepository.findById(sid).get();
		sizeQty.setIsAvailable(!sizeQty.getIsAvailable());
		sizeRepository.save(sizeQty);
    }

	public void updateProductSizeStock(Long id, Long sid, Integer stock) {
		SizeQty sizeQty = sizeRepository.findById(sid).get();
		sizeQty.setStock(sizeQty.getStock() + stock);
		sizeRepository.save(sizeQty);
    }

	public List<Size> getAllRemainingSizes (Long id){
		List<Size> allSizes = new ArrayList<>(Arrays.asList(Size.values()));
		List<Size> sizes = new ArrayList<>();
		for (Size size : allSizes) {
				if(!sizeRepository.existsByProductIdAndSize(id, size)) {
					sizes.add(size);
				}
			}
		return sizes;
	}

	public void addNewSizesToProduct(Long id, List<Size> allSizes) {
		for (Size size : allSizes) {
			newSizeQty(size, productService.findProductById(id));
		}
	}

	public List<Nozzle> getAllRemainingNozzles(Long id) {
		List<Nozzle> allNozzles = new ArrayList<>(Arrays.asList(Nozzle.values()));
		List<Nozzle> nozzles = new ArrayList<>();
		for (Nozzle nozzle : allNozzles) {
				if(!nozzleRepository.existsByProductIdAndNozzle(id, nozzle)) {
					nozzles.add(nozzle);
				}
			}
		return nozzles;
	}

	public void addNewNozzlesToProduct(Long id, List<Nozzle> allNozzles) {
		for (Nozzle nozzle : allNozzles) {
			newNozzleQty(nozzle, productService.findProductById(id));
		}
	}

	public void updateGranulationAvailability(Long sid) {
		GranulationQty gran = findGranulationById(sid);
		gran.setIsAvailable(!gran.getIsAvailable());
		granRepository.save(gran);
	}

	public void updateGranulationPrice(Long sid, Double price) {
		GranulationQty gran = findGranulationById(sid);
		gran.setPrice(price);
		granRepository.save(gran);
	}

	public void updateGranulationStock(Long sid, Integer stock) {
		GranulationQty gran = findGranulationById(sid);
		gran.setStock(gran.getStock()+ stock);
		granRepository.save(gran);
    }

	public List<Granulation> getAllRemainingGranulations(Long id) {
		List<Granulation> allGranulations = new ArrayList<>(Arrays.asList(Granulation.values()));
		List<Granulation> granulations = new ArrayList<>();
		for (Granulation granulation : allGranulations) {
				if(!granRepository.existsByProductIdAndGranulation(id, granulation)) {
					granulations.add(granulation);
				}
			}
	return granulations;
	}

	public void addNewGranulationsToProduct(Long id, List<Granulation> allGranulations) {
          for (Granulation granulation : allGranulations) {
	            newGranulationQty(granulation, productService.findProductById(id));
           }		
	}

 
}

