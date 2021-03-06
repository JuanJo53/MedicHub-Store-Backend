package bo.ucb.edu.medichub.bl;

import bo.ucb.edu.medichub.dao.ProductDao;
import bo.ucb.edu.medichub.dao.TransactionDao;
import bo.ucb.edu.medichub.dto.ProductRequest;
import bo.ucb.edu.medichub.dto.ProductResponse;
import bo.ucb.edu.medichub.model.Pharmacy;
import bo.ucb.edu.medichub.model.Product;
import bo.ucb.edu.medichub.model.Transaction;
import bo.ucb.edu.medichub.util.ImageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductBl {
    private ProductDao productDao;
    private TransactionDao transactionDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductBl.class);

    @Autowired
    public ProductBl(ProductDao productDao, TransactionDao transactionDao) {
        this.productDao = productDao;
        this.transactionDao = transactionDao;
    }

    public ProductRequest createProduct(ProductRequest productRequest, Transaction transaction){
        Product product = new Product();
        product.setSubsidiaryId(productRequest.getSubsidiaryId());
        product.setBrandId(productRequest.getBrandId());
        product.setDoseTypeId(productRequest.getDoseTypeId());
        product.setName(productRequest.getName());
        product.setStock(productRequest.getStock());
        product.setPrice(productRequest.getPrice());
        product.setType(productRequest.getType());
        product.setDose(productRequest.getDose());
        product.setDescription(productRequest.getDescription());
        product.setTransaction(transaction);
        productDao.createProduct(product);
        return productRequest;
    }


    public ProductRequest updateProduct(ProductRequest productRequest, Transaction transaction){
        Product product = new Product();
        product.setProductId(productRequest.getProductId());
        product.setSubsidiaryId(productRequest.getSubsidiaryId());
        product.setBrandId(productRequest.getBrandId());
        product.setDoseTypeId(productRequest.getDoseTypeId());
        product.setName(productRequest.getName());
        product.setStock(productRequest.getStock());
        product.setPrice(productRequest.getPrice());
        product.setType(productRequest.getType());
        product.setDose(productRequest.getDose());
        product.setDescription(productRequest.getDescription());
        product.setTransaction(transaction);
        productDao.updateProduct(product);
        return productRequest;
    }

    public void deleteProduct(Integer idProduct, Transaction transaction){
        Product product= new Product();
        product.setStatus(0);
        product.setProductId(idProduct);
        product.setTransaction(transaction);
        productDao.deleteProduct(product);
    }

    public ProductResponse findProductById(Integer productId){
        ProductResponse product = productDao.findProductById(productId);
        return  product;
    }

    public List<ProductResponse> productList(Integer subsidiaryId, Integer page, Integer size, Boolean asc, String value,String typevalue){

        List<ProductResponse> products = new ArrayList<>();
        LOGGER.error(String.valueOf(page));
        LOGGER.error(String.valueOf(size));
        LOGGER.error(asc.toString());
        LOGGER.error(value);
        LOGGER.error(typevalue);
        if(typevalue.equals("price") && asc){
            if (value.equals("")){
                products = productDao.productListOrderByAll(subsidiaryId, page, size,value);
            }else{  products = productDao.productListOrderByPrice(subsidiaryId, page, size,value); }
        }
        if(typevalue.equals("price") && !asc){
            if (value.equals("")){
                products = productDao.productListOrderByAll(subsidiaryId, page, size,value);
            }else{  products = productDao.productListOrderByPriceDesc(subsidiaryId, page, size,value);}
        }
        if(typevalue.equals("name") && asc){
            if (value.equals("")){
                products = productDao.productListOrderByAll(subsidiaryId, page, size,value);
            }else{ products = productDao.productListOrderByName(subsidiaryId, page, size,value);}
        }
        if(typevalue.equals("name") && !asc){
            if (value.equals("")){
                products = productDao.productListOrderByAll(subsidiaryId, page, size,value);
            }else{ products = productDao.productListOrderByNameDesc(subsidiaryId, page, size,value);}
        }
        if(typevalue.equals("type") && asc){
            if (value.equals("")){
                products = productDao.productListOrderByAll(subsidiaryId, page, size,value);
            }else{ products = productDao.productListOrderByMedic(subsidiaryId, page, size,value);}
        }
        if(typevalue.equals("type") && !asc){
            if (value.equals("")){
                products = productDao.productListOrderByAll(subsidiaryId, page, size,value);
            }else{ products = productDao.productListOrderByMedicDesc(subsidiaryId, page, size,value);}
        }
        if(typevalue.equals("dose") && asc){
            if (value.equals("")){
                products = productDao.productListOrderByAll(subsidiaryId, page, size,value);
            }else{ products = productDao.productListOrderByDose(subsidiaryId, page, size,value);}
        }
        if(typevalue.equals("dose") && !asc){
            if (value.equals("")){
                products = productDao.productListOrderByAll(subsidiaryId, page, size,value);
            }else{ products = productDao.productListOrderByDoseDesc(subsidiaryId, page, size,value);}
        }
        if(typevalue.equals("brand") && asc){
            if (value.equals("")){
                products = productDao.productListOrderByAll(subsidiaryId, page, size,value);
            }else{ products = productDao.productListOrderByBrands(subsidiaryId, page, size,value);}
        }
        if(typevalue.equals("brand") && !asc){
            if (value.equals("")){
                products = productDao.productListOrderByAll(subsidiaryId, page, size,value);
            }else{ products = productDao.productListOrderByBrandsDesc(subsidiaryId, page, size,value);}
        }
        if(typevalue.equals("all") && asc){
            products = productDao.productListOrderByAll(subsidiaryId, page, size,value);
        }
        if(typevalue.equals("all") && !asc){
            products = productDao.productListOrderByAllDesc(subsidiaryId, page, size,value);
        }
        if (products.size()==0){
            return null;
        }
        else{
            return products;
        }
    }

    /*
    public List<ProductResponse> productList(Integer subsidiaryId, Integer page, Integer size, String order, Boolean asc, String value,String typevalue){

        List<ProductResponse> products = new ArrayList<>();
        LOGGER.error(String.valueOf(page));
        LOGGER.error(String.valueOf(size));
        LOGGER.error(order);
        LOGGER.error(asc.toString());

        if(order.equals("id") && asc ){
            products = productDao.productListOrderById(subsidiaryId, page, size,price,brand);
        }
        if(order.equals("id") && !asc){
            products = productDao.productListOrderByIdDesc(subsidiaryId, page, size ,price,brand);
        }
        if(order.equals("brand") && asc){
            products = productDao.productListOrderByBrand(subsidiaryId, page, size,price,brand);
        }
        if(order.equals("brand") && !asc){
            products = productDao.productListOrderByBrandDesc(subsidiaryId, page, size,price,brand);
        }
        if(order.equals("name") && asc){
            products = productDao.productListOrderByProduct(subsidiaryId, page, size,price,brand);
        }
        if(order.equals("name") && !asc){
            products = productDao.productListOrderByProductDesc(subsidiaryId, page, size,price,brand);
        }

        return products;
    }
     */

    public Integer getProductTotalBySubsidiary(Integer subsidiaryId){
        Integer total = productDao.getProductTotalBySubsidiary(subsidiaryId);
        return total;
    }

    public void uploadImage(MultipartFile image, Integer productId, Transaction transaction) {
        ImageUtil imageUtil = new ImageUtil();
        Product product = new Product();
        String newImageName = imageUtil.uploadImage(image,"images/productImage","Product",productId);
        product.setProductId(productId);
        product.setPicture(newImageName);
        product.setTransaction(transaction);
        productDao.updateImage(product);
    }
}
