package be.mobyus.ie5.dao;

import java.util.List;

import be.mobyus.ie5.entities.Eshop;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopDao {

	List<Eshop> listAllShops();
	Eshop loadShop(Long shopId);
}
