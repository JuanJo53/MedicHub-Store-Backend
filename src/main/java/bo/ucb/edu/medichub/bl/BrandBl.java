package bo.ucb.edu.medichub.bl;

import bo.ucb.edu.medichub.dao.BrandDao;
import bo.ucb.edu.medichub.dao.TransactionDao;
import bo.ucb.edu.medichub.dto.BrandListRequest;
import bo.ucb.edu.medichub.dto.BrandRequest;
import bo.ucb.edu.medichub.model.Brand;
import bo.ucb.edu.medichub.model.Pharmacy;
import bo.ucb.edu.medichub.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandBl {
    private BrandDao brandDao;
    private TransactionDao transactionDao;

    @Autowired
    public BrandBl(BrandDao brandDao, TransactionDao transactionDao) {
        this.brandDao = brandDao;
        this.transactionDao = transactionDao;
    }

    public BrandRequest createBrand(BrandRequest brandRequest, Transaction transaction){
        Brand brand = new Brand();

        brand.setName(brandRequest.getName());
        brand.setPhone(brandRequest.getPhone());
        brand.setEmail(brandRequest.getEmail());
        brand.setTransaction(transaction);
        brandDao.createBrand(brand);

        return brandRequest;
    }

    public BrandRequest updateBrand(BrandRequest brandRequest, Transaction transaction){
        Brand brand = new Brand();
        brand.setBrandId(brandRequest.getBrandId());
        brand.setName(brandRequest.getName());
        brand.setPhone(brandRequest.getPhone());
        brand.setEmail(brandRequest.getEmail());
        brand.setTransaction(transaction);
        brandDao.updateBrand(brand);
        return brandRequest;
    }

    public void deletePharmacy(Integer brandId, Transaction transaction) {
        Brand brand = new Brand();
        brand.setStatus(0);
        brand.setBrandId(brandId);
        brand.setTransaction(transaction);
        brandDao.deleteBrand(brand);
    }



    public List<BrandListRequest> getBrands(){
        List<BrandListRequest> brands = brandDao.getBrands();
        return brands;
    }

    public BrandRequest findBrandById(Integer brandId){
        BrandRequest brand = brandDao.findBrandById(brandId);
        return brand;
    }


}
