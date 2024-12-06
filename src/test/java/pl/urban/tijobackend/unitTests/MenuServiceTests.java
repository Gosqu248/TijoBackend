package pl.urban.tijobackend.unitTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import pl.urban.tijobackend.model.Menu;
import pl.urban.tijobackend.repository.MenuRepository;
import pl.urban.tijobackend.service.MenuService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class MenuServiceTests {

    @MockBean
    private MenuRepository menuRepository;

    @Autowired
    private MenuService menuService;

    @Test
    @DisplayName("Test getRestaurantMenu with empty data returns empty list")
    void getRestaurantMenu_emptyData_returnsEmptyList() {
        // Given
        when(menuRepository.findByRestaurantId(1L)).thenReturn(List.of());

        // When
        List<Menu> result = menuService.getRestaurantMenu(1L);

        // Then
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Test findById with existing menu returns menu")
    void givenMenuExists_whenFindById_thenReturnMenu() {
        // Given
        Menu existingMenu = new Menu(1L, "McWrap® Chrupiący Klasyczny", "McWrapy i Sałatki", null, 23.2, null, null, null);
        when(menuRepository.findById(1L)).thenReturn(Optional.of(existingMenu));

        // When
        Menu result = menuService.getMenuById(1L);

        // Then
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("McWrap® Chrupiący Klasyczny", result.getName());
    }

    @Test
    @DisplayName("Test addMenu with valid menu saves successfully")
    void givenValidMenu_whenAddMenu_thenSaveSuccessfully() {
        // Given
        Menu newMenu = new Menu(null, "Chicken Burger", "Burgery", "Chicken, Lettuce, Tomato", 18.5, null, null, null);
        Menu savedMenu = new Menu(4L, "Chicken Burger", "Burgery", "Chicken, Lettuce, Tomato", 18.5, null, null, null);
        when(menuRepository.save(newMenu)).thenReturn(savedMenu);

        // When
        Menu result = menuService.addMenuItem(newMenu);

        // Then
        assertNotNull(result);
        assertEquals(4L, result.getId());
        assertEquals("Chicken Burger", result.getName());
        assertEquals(18.5, result.getPrice());
    }

    @Test
    @DisplayName("Test deleteMenuItem with non-existing menu throws exception")
    void givenMenuDoesNotExist_whenDeleteMenu_thenThrowException() {
        // Given
        when(menuRepository.findById(999L)).thenReturn(Optional.empty());

        // When
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> menuService.deleteMenuItem(999L));

        // Then
        assertEquals("Menu item with id 999 not found.", exception.getMessage());
    }

}