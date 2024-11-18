package pl.urban.tijobackend.service;

import org.springframework.stereotype.Service;
import pl.urban.tijobackend.model.Menu;
import pl.urban.tijobackend.repository.MenuRepository;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }


    public List<Menu> getRestaurantMenu(Long restaurantId) {
        List<Menu> menuItems = menuRepository.findByRestaurantId(restaurantId);
        return sortByCategory(menuItems);
    }

    public Menu addMenuItem(Menu menu) {
        return menuRepository.save(menu);
    }

    public void deleteMenuItem(Long menuItemId) {
        menuRepository.deleteById(menuItemId);
    }

    public Menu updateMenuItem(Menu menu) {
        return menuRepository.save(menu);
    }

    public List<Menu> sortByCategory(List<Menu> menuItems) {
        Map<String, List<Menu>> sortedMenu = menuItems.stream()
                .collect(Collectors.groupingBy(Menu::getCategory, TreeMap::new, Collectors.toList()));

        return sortedMenu.values().stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
}
