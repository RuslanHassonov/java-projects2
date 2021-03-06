package be.mobyus.ie5.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import be.mobyus.ie5.entities.Eshop;
import be.mobyus.ie5.screens.LoginScreen;
import be.mobyus.ie5.service.ShopService;

@Controller
public class EshopApplicationController {

	@Autowired
	private ShopService shopService;

	public void run() {
		String[] usernamePassword = getUsernamePassword();
		Eshop selectedShop = getEshop();

		while (true) {

			String selection = showMainScreen();

			if (selection.equals("1")) {
				// Make orders
			} else if (selection.equals("2")) {
				// List orders
			}
		}
	}

	private String[] getUsernamePassword() {
		return new LoginScreen().drawScreen();
	}

	private Eshop getEshop() {
		// ....
		return shopService.listEshops().iterator().next();
	}

	private String showMainScreen() {
		return "";
	}
}
