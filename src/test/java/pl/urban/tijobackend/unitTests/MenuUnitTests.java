package pl.urban.tijobackend.unitTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.urban.tijobackend.model.Menu;
import pl.urban.tijobackend.repository.MenuRepository;
import pl.urban.tijobackend.service.MenuService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MenuUnitTests {

    @Mock
    private MenuRepository menuRepository;

    @InjectMocks
    private MenuService menuService;

    @Test
    @DisplayName("Test getRestaurantMenu with empty data returns empty list")
    void shouldReturnEmptyListWhenNoMenuItemsForRestaurant() {
        // Given
        when(menuRepository.findByRestaurantId(1L)).thenReturn(List.of());

        // When
        List<Menu> result = menuService.getRestaurantMenu(1L);

        // Then
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(menuRepository).findByRestaurantId(1L);

    }

    @Test
    @DisplayName("Test findById with existing menu returns menu")
    void shouldFindMenuItemByIdSuccessfully() {
        // Given
        Menu existingMenu = new Menu(1L, "McWrap® Chrupiący Klasyczny", "McWrapy i Sałatki", null, 23.2, null, null, null);
        when(menuRepository.findById(1L)).thenReturn(Optional.of(existingMenu));

        // When
        Menu result = menuService.getMenuById(1L);

        // Then
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("McWrap® Chrupiący Klasyczny", result.getName());
        verify(menuRepository).findById(1L);
    }

    @Test
    @DisplayName("Test addMenu with valid menu saves successfully")
    void shouldAddMenuItemSuccessfully() {
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
    @DisplayName("Test deleteMenuItem with existing menu deletes successfully")
    void shouldDeleteMenuItemSuccessfully() {
        // Given
        Long Id = 1L;
        Menu existingMenu = new Menu(Id, "McWrap® Chrupiący Klasyczny", "McWrapy i Sałatki", null, 23.2, null, null, null);
        when(menuRepository.existsById(Id)).thenReturn(true);

        // When
        menuService.deleteMenuItem(Id);

        // Then
        verify(menuRepository).deleteById(Id);
    }


    @Test
    @DisplayName("Test deleteMenuItem with non-existing menu throws exception")
    void shouldThrowExceptionWhenDeletingNonExistingMenuItem() {
        // Given
        Long Id = 999L;
        lenient().when(menuRepository.findById(Id)).thenReturn(Optional.empty());

        // When
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> menuService.deleteMenuItem(Id));

        // Then
        assertEquals("Menu item with id " + Id + " not found.", exception.getMessage());
    }

}