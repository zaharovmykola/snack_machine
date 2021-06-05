package zakharov.mykola.com.example.snack.unit.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.TestPropertySource;
import zakharov.mykola.com.example.snack.dao.CategoryHibernateDAO;
import zakharov.mykola.com.example.snack.dao.PurchaseHibernateDAO;
import zakharov.mykola.com.example.snack.entity.Category;
import zakharov.mykola.com.example.snack.entity.Purchase;
import zakharov.mykola.com.example.snack.model.ResponseModel;
import zakharov.mykola.com.example.snack.service.PurchaseService;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@TestPropertySource(locations="classpath:application.properties")
public class PurchaseServiceTest {

    @Mock
    private PurchaseHibernateDAO purchaseDAO;

    @Mock
    private CategoryHibernateDAO categoryDAO;

    @InjectMocks
    private PurchaseService purchaseService;

    ArgumentCaptor<Purchase> purchaseArgument =
            ArgumentCaptor.forClass(Purchase.class);
    ArgumentCaptor<Category> categoryArgument =
            ArgumentCaptor.forClass(Category.class);

    @Test
    void shouldPurchaseCategorySuccessfully() {
        doReturn(Category.builder().name("Donut").number(10).build())
                .when(categoryDAO)
                .findCategoryByName("Donut");
        ResponseModel responseModel =
                purchaseService.purchase("Donut", LocalDate.parse("2021-04-14"));
        assertNotNull(responseModel);
        assertEquals(ResponseModel.SUCCESS_STATUS, responseModel.getStatus());
        verify(purchaseDAO, atLeast(1))
                .save(purchaseArgument.capture());
        verify(purchaseDAO, atMost(1))
                .save(purchaseArgument.capture());
        verify(categoryDAO, atLeast(1))
                .save(categoryArgument.capture());
        verify(categoryDAO, atMost(1))
                .save(categoryArgument.capture());
    }

    @Test
    void shouldPurchaseCategoryWithZeroAmountUnsuccessfully() {
        doReturn(Category.builder().name("Cracker").number(0).build())
                .when(categoryDAO)
                .findCategoryByName("Cracker");
        ResponseModel responseModel =
                purchaseService.purchase("Cracker", LocalDate.parse("2021-07-21"));
        assertNotNull(responseModel);
        assertEquals(ResponseModel.FAIL_STATUS, responseModel.getStatus());
        assertEquals("Category Cracker is out of stock", responseModel.getMessage());
    }

    @Test
    void shouldPurchaseNullCategoryUnsuccessfully() {
        doReturn(null)
                .when(categoryDAO)
                .findCategoryByName("Coca");
        ResponseModel responseModel =
                purchaseService.purchase("Coca", LocalDate.parse("2021-09-27"));
        assertNotNull(responseModel);
        assertEquals(ResponseModel.FAIL_STATUS, responseModel.getStatus());
        assertEquals("Category Coca is not found", responseModel.getMessage());
    }

}
